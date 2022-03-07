package lamph11.microservice.category.resource;

import lamph11.microservice.category.resource.request.FindPropertyValueRequest;
import lamph11.microservice.category.service.PropertyValueService;
import lamph11.microservice.category.service.dto.PropertyValueDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/property-values")
public class PropertyValueResource {

    private final PropertyValueService propertyValueService;

    @GetMapping
    public Mono<ResponseEntity<Page<PropertyValueDTO>>> find(
            @Valid @ModelAttribute FindPropertyValueRequest request) {
        return propertyValueService.find(request).map(ResponseEntity::ok);
    }

}
