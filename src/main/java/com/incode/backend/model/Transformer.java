package com.incode.backend.model;

import lombok.Data;

@Data
public class Transformer {
    private String group;
    private String transformerId;
    private String[] parameters;
}
