package com.example.petmatchlab.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.example.petmatchlab.model.SupportType;

public record SupportRequestRequest(
    @NotNull(message = "A support type is required")
    SupportType type,

    @NotBlank(message = "A description is required")
    @Size(max = 500,
          message = "The description must have at most 500 characters")
    String description
) {
}
