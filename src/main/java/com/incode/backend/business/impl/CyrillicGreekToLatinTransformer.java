package com.incode.backend.business.impl;

import com.incode.backend.business.TransformerService;
import org.springframework.stereotype.Service;

@Service("group1_t3")
public class CyrillicGreekToLatinTransformer implements TransformerService {
    @Override
    public String transform(String value, String[] parameters) {
        StringBuilder result = new StringBuilder();
        for (char ch : value.toCharArray()) {
            if (Character.UnicodeBlock.of(ch) == Character.UnicodeBlock.CYRILLIC ||
                    Character.UnicodeBlock.of(ch) == Character.UnicodeBlock.GREEK) {
                result.append((char)(ch - 848));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
