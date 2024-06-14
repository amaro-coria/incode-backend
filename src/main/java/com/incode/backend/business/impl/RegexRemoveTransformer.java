package com.incode.backend.business.impl;

import com.incode.backend.business.TransformerService;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service("group1_t1")
public class RegexRemoveTransformer implements TransformerService {
    @Override
    public String transform(String value, String[] parameters) {
        String regex = parameters[0];
        return value.replaceAll(regex, "");
    }
}
