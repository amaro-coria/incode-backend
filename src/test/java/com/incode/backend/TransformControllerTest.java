package com.incode.backend;

import com.incode.backend.business.impl.CyrillicGreekToLatinTransformer;
import com.incode.backend.business.impl.RegexRemoveTransformer;
import com.incode.backend.business.impl.RegexReplaceTransformer;
import com.incode.backend.controller.TransformController;
import com.incode.backend.model.Element;
import com.incode.backend.model.TransformRequest;
import com.incode.backend.model.Transformer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransformControllerTest {

    @Mock
    private ApplicationContext context;

    @InjectMocks
    private TransformController controller;

    @BeforeEach
    void setUp() {
        when(context.getBean("group1_t1")).thenReturn(new RegexRemoveTransformer());
        when(context.getBean("group1_t2")).thenReturn(new RegexReplaceTransformer());
        when(context.getBean("group1_t3")).thenReturn(new CyrillicGreekToLatinTransformer());
    }

    @Test
    public void testTransformEndpoint() {
        TransformRequest request = getTransformRequest();

        Map<String, List<Map<String, String>>> responseBody = controller.transformElements(request);

        assertEquals(2, responseBody.get("elements").size());
        assertEquals("This is some Replaced Text ", responseBody.get("elements").get(0).get("transformed"));
        assertEquals("Example with Greek: ABG and Cyrillic: ABV", responseBody.get("elements").get(1).get("transformed"));
    }

    private static TransformRequest getTransformRequest() {
        TransformRequest request = new TransformRequest();
        request.setElements(List.of(
                new Element("This is some Random Text 123", List.of(
                        new Transformer("group1", "t1", new String[]{"\\d+"}),
                        new Transformer("group1", "t2", new String[]{"Random", "Replaced"})
                )),
                new Element("Example with Greek: ΑΒΓ and Cyrillic: АБВ", List.of(
                        new Transformer("group1", "t3", new String[]{})
                ))
        ));
        return request;
    }
}
