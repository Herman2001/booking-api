package se.herman.booking_api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InstanceController {

    private final String instanceName;

    public InstanceController(@Value("${instance.name}") String instanceName) {
        this.instanceName = instanceName;
    }

    @GetMapping("/instance")
    public Map<String, String> getInstance() {
        return Map.of("instance", instanceName);
    }
}
