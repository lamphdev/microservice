package lamph11.microservice.category.service;

import lamph11.microservice.category.domain.Property;
import lamph11.microservice.category.repository.PropertyRepository;
import lamph11.microservice.category.resource.request.CreatePropertyRequest;
import lamph11.microservice.common.utils.CodeUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class PropertyService {

    private final PropertyRepository propertyRepository;


    /**
     * create new property
     *
     * @param request request payload
     * @return saved property
     */
    public Mono<Property> create(CreatePropertyRequest request) {
        Property property = new Property();
        property.setCode(CodeUtils.fromRawString(request.getName()));
        property.setName(request.getName());
        property.setDescription(request.getDescription());
        property.setStatus(request.getStatus());
        return Mono.just(propertyRepository.save(property));
    }

}
