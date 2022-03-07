package lamph11.microservice.category.resource;

import lamph11.microservice.category.domain.Property;
import lamph11.microservice.category.resource.request.CreatePropertyRequest;
import lamph11.microservice.category.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/properties")
@RequiredArgsConstructor
public class PropertyResource {

    private final PropertyService propertyService;

    @PostMapping
    public Mono<ResponseEntity<Property>> createProperty(@Valid @RequestBody CreatePropertyRequest request) {
        return propertyService.create(request).map(ResponseEntity::ok);
    }

}
