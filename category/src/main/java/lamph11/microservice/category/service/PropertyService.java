package lamph11.microservice.category.service;

import lamph11.microservice.category.domain.Property;
import lamph11.microservice.category.repository.PropertyRepository;
import lamph11.microservice.category.resource.request.CreatePropertyRequest;
import lamph11.microservice.category.resource.request.FindPropertyRequest;
import lamph11.microservice.category.service.dto.PropertyDTO;
import lamph11.microservice.category.resource.request.UpdatePropertyRequest;
import lamph11.microservice.category.service.mapper.PropertyMapper;
import lamph11.microservice.common.utils.CodeUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PropertyService {

    private final PropertyMapper propertyMapper;
    private final PropertyRepository propertyRepository;

    @Transactional(readOnly = true)
    public Mono<Page<PropertyDTO>> find(FindPropertyRequest request) {

        Specification<Property> specification = Specification.where(null);

        if (request.getIn() != null && !request.getIn().isEmpty())
            specification = specification.and(
                    (root, query, criteriaBuilder) -> root.get("code").in(request.getIn()));

        if (request.getStatus() != null) {
            specification = specification.and(
                    (root, query, criteriaBuilder) -> criteriaBuilder.equal(
                            root.get("status"),
                            request.getStatus()
                    ));
        }

        Page<PropertyDTO> page = propertyRepository.findAll(specification, request.getPage())
                .map(propertyMapper::toDTO);
        return Mono.just(page);
    }

    /**
     * create new property
     *
     * @param request request payload
     * @return saved property
     */
    public Mono<PropertyDTO> create(CreatePropertyRequest request) {
        Property property = new Property();
        property.setCode(CodeUtils.fromRawString(request.getName()));
        property.setName(request.getName());
        property.setDescription(request.getDescription());
        property.setStatus(request.getStatus());
        return Mono.just(propertyRepository.save(property)).map(propertyMapper::toDTO);
    }


    /**
     * update existed property
     *
     * @param request request payload
     * @return updated property
     */
    public Mono<PropertyDTO> update(UpdatePropertyRequest request) {
        Optional<Property> optionalProperty = propertyRepository.findById(request.getCode());
        if (optionalProperty.isEmpty())
            return Mono.error(new RuntimeException("Property Not found: " + request.getCode()));

        Property property = optionalProperty.get();
        property.setName(request.getName());
        property.setDescription(request.getDescription());
        property.setStatus(request.getStatus());
        propertyRepository.save(property);
        return Mono.just(property).map(propertyMapper::toDTO);
    }

}
