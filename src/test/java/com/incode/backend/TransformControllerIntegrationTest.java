package com.incode.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransformControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testTransformEndpoint() {
        String requestBody = """
                {
                    "elements": [
                        {
                            "value": "This is some Random Text 123",
                            "transformers": [
                                {
                                    "group": "group1",
                                    "transformerId": "t1",
                                    "parameters": ["\\\\d+"]
                                },
                                {
                                    "group": "group1",
                                    "transformerId": "t2",
                                    "parameters": ["Random", "Replaced"]
                                }
                            ]
                        },
                        {
                            "value": "Example with Greek: ΑΒΓ and Cyrillic: АБВ",
                            "transformers": [
                                {
                                    "group": "group1",
                                    "transformerId": "t3",
                                    "parameters": []
                                }
                            ]
                        }
                    ]
                }
                """;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.exchange("/transform", HttpMethod.POST, request, Map.class);

        Map<String, List<Map<String, String>>> responseBody = (Map<String, List<Map<String, String>>>) response.getBody();
        assertEquals(2, responseBody.get("elements").size());
        assertEquals("This is some Replaced Text ", responseBody.get("elements").get(0).get("transformed"));
        assertEquals("Example with Greek: ABG and Cyrillic: ABV", responseBody.get("elements").get(1).get("transformed"));
    }
}
