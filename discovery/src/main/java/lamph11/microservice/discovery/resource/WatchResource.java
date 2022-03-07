package lamph11.microservice.discovery.resource;

import com.netflix.discovery.shared.Application;
import lamph11.microservice.discovery.service.InstanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/api/watch")
@RequiredArgsConstructor
public class WatchResource {

    private final InstanceService instanceService;

    @GetMapping(value = "/instance", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<List<Application>> watchInstance() {
        return Flux.interval(Duration.ofSeconds(2)).map(s -> instanceService.watchServiceAvaiable());
    }

}
