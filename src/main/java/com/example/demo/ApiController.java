package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ApiController {

    @RequestMapping("/hello")
	ResponseEntity<String> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {        
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/json")
                .body("Hello " + name);
    }

    @RequestMapping("/info")
	ResponseEntity<HashMap<String, Object>> information(HttpServletRequest request) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("time", java.time.ZonedDateTime.now().format(java.time.format.DateTimeFormatter.ISO_INSTANT));
        response.put("client_address", request.getRemoteAddr());
        response.put("host_name", request.getLocalName());

        HashMap<String, String> headers = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.put(headerName, request.getHeader(headerName));
        }

        response.put("header", headers);

        return ResponseEntity
            .ok()
            .header("Content-Type", "application/json")
            .body(response);
    }
}
