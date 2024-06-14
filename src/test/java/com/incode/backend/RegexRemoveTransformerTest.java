package com.incode.backend;

import com.incode.backend.business.impl.RegexRemoveTransformer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RegexRemoveTransformerTest {

    private final RegexRemoveTransformer transformer = new RegexRemoveTransformer();

    @Test
    public void testRemoveDigits() {
        String input = "This is some Random Text 123";
        String expected = "This is some Random Text ";
        String result = transformer.transform(input, new String[]{"\\d+"});
        assertEquals(expected, result);
    }
}

