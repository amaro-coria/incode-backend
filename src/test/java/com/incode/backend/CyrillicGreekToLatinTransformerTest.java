package com.incode.backend;

import com.incode.backend.business.impl.CyrillicGreekToLatinTransformer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CyrillicGreekToLatinTransformerTest {

    private final CyrillicGreekToLatinTransformer transformer = new CyrillicGreekToLatinTransformer();

    @Test
    public void testCyrillicToLatin() {
        String input = "АБВГДЕ";
        String expected = "ABVGDE";
        String result = transformer.transform(input, new String[]{});
        assertEquals(expected, result);
    }

    @Test
    public void testGreekToLatin() {
        String input = "ΑΒΓΔΕΖ";
        String expected = "ABGDEZ";
        String result = transformer.transform(input, new String[]{});
        assertEquals(expected, result);
    }

    @Test
    public void testMixedToLatin() {
        String input = "Example with Greek: ΑΒΓ and Cyrillic: АБВ";
        String expected = "Example with Greek: ABG and Cyrillic: ABV";
        String result = transformer.transform(input, new String[]{});
        assertEquals(expected, result);
    }
}
