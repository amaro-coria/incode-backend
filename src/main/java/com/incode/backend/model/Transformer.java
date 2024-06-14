package com.incode.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transformer {
    private String group;
    private String transformerId;
    private String[] parameters;
}