package lamph11.microservice.discovery.service;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class InstanceService {

    private final EurekaClient discoveryClient;

    public List<Application> watchServiceAvaiable() {
        List<Application> applications = discoveryClient.getApplications().getRegisteredApplications();
        return applications;
    }

}
