package lamph11.microservice.category.service;

import lamph11.microservice.category.domain.PropertyValue;
import lamph11.microservice.category.repository.PropertyValueRepository;
import lamph11.microservice.category.resource.request.FindPropertyValueRequest;
import lamph11.microservice.category.service.dto.PropertyValueDTO;
import lamph11.microservice.category.service.mapper.PropertyValueMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
public class PropertyValueService {

    private final PropertyValueMapper propertyValueMapper;
    private final PropertyValueRepository propertyValueRepository;

    @Transactional(readOnly = true)
    public Mono<Page<PropertyValueDTO>> find(FindPropertyValueRequest request) {
        Specification<PropertyValue> specification = Specification.where(null);
        if (!StringUtils.isEmpty(request.getProperty()))
            specification = specification.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(
                    root.get("property").get("code"),
                    request.getProperty()
            ));

        if (!StringUtils.isEmpty(request.getKeyword()))
            specification = specification.and((root, query, criteriaBuilder) -> criteriaBuilder.or(
                    criteriaBuilder.like(root.get("code"), request.getKeyword()),
                    criteriaBuilder.like(root.get("name"), request.getKeyword()),
                    criteriaBuilder.like(root.get("description"), request.getKeyword())
            ));

        Page<PropertyValueDTO> page = propertyValueRepository.findAll(specification, request.getPage())
                .map(propertyValueMapper::toDTO);
        return Mono.just(page);
    }

}
