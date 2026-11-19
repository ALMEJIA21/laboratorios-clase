package com.example.petmatchlab.model;

public enum SupportType {
    WALK("Paseo"),
    FEEDING("Alimentación"),
    COMPANY("Compañía");

    private final String label;

    SupportType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
