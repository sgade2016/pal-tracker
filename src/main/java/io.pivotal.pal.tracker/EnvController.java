package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String port;
    private String memoryLimit;
    private String cfIndex;
    private String cfAddress;

    public EnvController(@Value("${PORT:NOT SET}") String port, @Value("${MEMORY_LIMIT:NOT SET}") String memoryLimit, @Value("${CF_INSTANCE_INDEX:NOT SET}") String cfIndex, @Value("${CF_INSTANCE_ADDR:NOT SET}") String cfAddress) {
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.cfIndex = cfIndex;
        this.cfAddress = cfAddress;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> env = new HashMap<>();

        env.put("PORT",this.port);
        env.put("MEMORY_LIMIT",this.memoryLimit);
        env.put("CF_INSTANCE_INDEX",this.cfIndex);
        env.put("CF_INSTANCE_ADDR",this.cfAddress);

        return env;
    }

}
