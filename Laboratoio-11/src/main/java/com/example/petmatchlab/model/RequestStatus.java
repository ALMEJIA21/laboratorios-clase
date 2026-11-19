package com.example.petmatchlab.model;

public enum RequestStatus {
    OPEN("Abierta"),
    COMPLETED("Completada"),
    CANCELLED("Cancelada");

    private final String label;

    RequestStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
