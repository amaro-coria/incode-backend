package com.incode.backend.controller;

import com.incode.backend.business.TransformerService;
import com.incode.backend.model.Element;
import com.incode.backend.model.TransformRequest;
import com.incode.backend.model.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/transform")
public class TransformController {

    private final ApplicationContext context;

    public TransformController(ApplicationContext context) {
        this.context = context;
    }

    @PostMapping
    public Map<String, List<Map<String, String>>> transformElements(@RequestBody TransformRequest request) {
        Map<String, List<Map<String, String>>> response = new HashMap<>();

        for (Element element : request.getElements()) {
            String originalValue = element.getValue();
            String transformedValue = originalValue;

            for (Transformer transformer : element.getTransformers()) {
                String beanName = transformer.getGroup() + "_" + transformer.getTransformerId();
                TransformerService transformerService = (TransformerService) context.getBean(beanName);
                transformedValue = transformerService.transform(transformedValue, transformer.getParameters());
            }

            response.computeIfAbsent("elements", k -> new ArrayList<>())
                    .add(Map.of("original", originalValue, "transformed", transformedValue));
        }

        return response;
    }
}
