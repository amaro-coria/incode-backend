package com.incode.backend.business.impl;

import com.incode.backend.business.TransformerService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("group1_t3")
public class CyrillicGreekToLatinTransformer implements TransformerService {
    private static final Map<Character, String> CYRILLIC_TO_LATIN_MAP = new HashMap<>();
    private static final Map<Character, String> GREEK_TO_LATIN_MAP = new HashMap<>();

    static {
        CYRILLIC_TO_LATIN_MAP.put('А', "A");
        CYRILLIC_TO_LATIN_MAP.put('Б', "B");
        CYRILLIC_TO_LATIN_MAP.put('В', "V");
        CYRILLIC_TO_LATIN_MAP.put('Г', "G");
        CYRILLIC_TO_LATIN_MAP.put('Д', "D");
        CYRILLIC_TO_LATIN_MAP.put('Е', "E");
        CYRILLIC_TO_LATIN_MAP.put('Ё', "Yo");
        CYRILLIC_TO_LATIN_MAP.put('Ж', "Zh");
        CYRILLIC_TO_LATIN_MAP.put('З', "Z");
        CYRILLIC_TO_LATIN_MAP.put('И', "I");
        CYRILLIC_TO_LATIN_MAP.put('Й', "Y");
        CYRILLIC_TO_LATIN_MAP.put('К', "K");
        CYRILLIC_TO_LATIN_MAP.put('Л', "L");
        CYRILLIC_TO_LATIN_MAP.put('М', "M");
        CYRILLIC_TO_LATIN_MAP.put('Н', "N");
        CYRILLIC_TO_LATIN_MAP.put('О', "O");
        CYRILLIC_TO_LATIN_MAP.put('П', "P");
        CYRILLIC_TO_LATIN_MAP.put('Р', "R");
        CYRILLIC_TO_LATIN_MAP.put('С', "S");
        CYRILLIC_TO_LATIN_MAP.put('Т', "T");
        CYRILLIC_TO_LATIN_MAP.put('У', "U");
        CYRILLIC_TO_LATIN_MAP.put('Ф', "F");
        CYRILLIC_TO_LATIN_MAP.put('Х', "Kh");
        CYRILLIC_TO_LATIN_MAP.put('Ц', "Ts");
        CYRILLIC_TO_LATIN_MAP.put('Ч', "Ch");
        CYRILLIC_TO_LATIN_MAP.put('Ш', "Sh");
        CYRILLIC_TO_LATIN_MAP.put('Щ', "Shch");
        CYRILLIC_TO_LATIN_MAP.put('Ъ', "");
        CYRILLIC_TO_LATIN_MAP.put('Ы', "Y");
        CYRILLIC_TO_LATIN_MAP.put('Ь', "");
        CYRILLIC_TO_LATIN_MAP.put('Э', "E");
        CYRILLIC_TO_LATIN_MAP.put('Ю', "Yu");
        CYRILLIC_TO_LATIN_MAP.put('Я', "Ya");

        GREEK_TO_LATIN_MAP.put('Α', "A");
        GREEK_TO_LATIN_MAP.put('Β', "B");
        GREEK_TO_LATIN_MAP.put('Γ', "G");
        GREEK_TO_LATIN_MAP.put('Δ', "D");
        GREEK_TO_LATIN_MAP.put('Ε', "E");
        GREEK_TO_LATIN_MAP.put('Ζ', "Z");
        GREEK_TO_LATIN_MAP.put('Η', "H");
        GREEK_TO_LATIN_MAP.put('Θ', "Th");
        GREEK_TO_LATIN_MAP.put('Ι', "I");
        GREEK_TO_LATIN_MAP.put('Κ', "K");
        GREEK_TO_LATIN_MAP.put('Λ', "L");
        GREEK_TO_LATIN_MAP.put('Μ', "M");
        GREEK_TO_LATIN_MAP.put('Ν', "N");
        GREEK_TO_LATIN_MAP.put('Ξ', "X");
        GREEK_TO_LATIN_MAP.put('Ο', "O");
        GREEK_TO_LATIN_MAP.put('Π', "P");
        GREEK_TO_LATIN_MAP.put('Ρ', "R");
        GREEK_TO_LATIN_MAP.put('Σ', "S");
        GREEK_TO_LATIN_MAP.put('Τ', "T");
        GREEK_TO_LATIN_MAP.put('Υ', "Y");
        GREEK_TO_LATIN_MAP.put('Φ', "Ph");
        GREEK_TO_LATIN_MAP.put('Χ', "Ch");
        GREEK_TO_LATIN_MAP.put('Ψ', "Ps");
        GREEK_TO_LATIN_MAP.put('Ω', "O");
    }

    @Override
    public String transform(String value, String[] parameters) {
        StringBuilder result = new StringBuilder();
        for (char ch : value.toCharArray()) {
            if (CYRILLIC_TO_LATIN_MAP.containsKey(ch)) {
                result.append(CYRILLIC_TO_LATIN_MAP.get(ch));
            } else if (GREEK_TO_LATIN_MAP.containsKey(ch)) {
                result.append(GREEK_TO_LATIN_MAP.get(ch));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
