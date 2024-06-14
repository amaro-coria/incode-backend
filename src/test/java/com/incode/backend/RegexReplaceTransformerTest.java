package com.incode.backend;

import com.incode.backend.business.impl.RegexReplaceTransformer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RegexReplaceTransformerTest {

    private final RegexReplaceTransformer transformer = new RegexReplaceTransformer();

    @Test
    public void testReplaceRandomWithReplaced() {
        String input = "This is some Random Text";
        String expected = "This is some Replaced Text";
        String result = transformer.transform(input, new String[]{"Random", "Replaced"});
        assertEquals(expected, result);
    }
}
