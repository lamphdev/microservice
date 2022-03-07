package lamph11.microservice.category.resource;

import lamph11.microservice.category.resource.request.CreatePropertyRequest;
import lamph11.microservice.category.resource.request.FindPropertyRequest;
import lamph11.microservice.category.resource.request.UpdatePropertyRequest;
import lamph11.microservice.category.service.PropertyService;
import lamph11.microservice.category.service.dto.PropertyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/properties")
@RequiredArgsConstructor
public class PropertyResource {

    private final PropertyService propertyService;

    @GetMapping
    public Mono<ResponseEntity<Page<PropertyDTO>>> find(@Valid @ModelAttribute FindPropertyRequest request) {
        return propertyService.find(request).map(ResponseEntity::ok);
    }

    @PostMapping
    public Mono<ResponseEntity<PropertyDTO>> createProperty(@Valid @RequestBody CreatePropertyRequest request) {
        return propertyService.create(request).map(ResponseEntity::ok);
    }


    @PutMapping
    public Mono<ResponseEntity<PropertyDTO>> updateProperty(@Valid @RequestBody UpdatePropertyRequest request) {
        return propertyService.update(request).map(ResponseEntity::ok);
    }


}
