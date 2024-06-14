package com.incode.backend.model;

import lombok.Data;
import java.util.List;

@Data
public class Element {
    private String value;
    private List<Transformer> transformers;
}
