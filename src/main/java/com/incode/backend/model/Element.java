package com.incode.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class Element {
    private String value;
    private List<Transformer> transformers;
}