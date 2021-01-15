package com.workabee.cloud.magician.console.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * author: chunxing
 * date: 2021/1/15 00:27
 * description:
 */
@SpringBootTest
public class TushareTest {


    String path = "http://api.waditu.com";

    @Test
    public void pull() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> data = new HashMap<>();
        data.put("api_name", "stock_basic");
        data.put("token", "5090e2018921fde5346e761d7479d16e99161791b9cfd118467df4af");
        data.put("params", new HashMap<>());
        data.put("fields", "ts_code,name");
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(data, headers);
        ResponseEntity<String> response = restTemplate.exchange(path, HttpMethod.POST, entity, String.class);
    }

}
