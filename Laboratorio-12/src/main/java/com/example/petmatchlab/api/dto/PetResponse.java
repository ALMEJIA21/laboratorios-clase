package com.example.petmatchlab.api.dto;

public record PetResponse(
    Long id,
    String name,
    String species,
    int age,
    String description
) {
}
