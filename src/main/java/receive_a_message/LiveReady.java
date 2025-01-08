package main.java.receive_a_message;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LiveReady {

    @GetMapping("/live")
    public Map<String, String> live() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "live");
        return response;
    }

    @GetMapping("/ready")
    public Map<String, String> ready() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "ready");
        return response;
    }
}
