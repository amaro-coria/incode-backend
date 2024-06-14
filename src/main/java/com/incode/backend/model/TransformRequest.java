package com.incode.backend.model;

import lombok.Data;
import java.util.List;

@Data
public class TransformRequest {
    private List<Element> elements;
}
