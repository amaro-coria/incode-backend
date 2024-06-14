package com.incode.backend.business.impl;

import com.incode.backend.business.TransformerService;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service("group1_t2")
public class RegexReplaceTransformer implements TransformerService {
    @Override
    public String transform(String value, String[] parameters) {
        String regex = parameters[0];
        String replacement = parameters[1];
        return value.replaceAll(regex, replacement);
    }
}
