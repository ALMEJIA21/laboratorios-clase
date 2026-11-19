package com.example.petmatchlab.api.dto;

import com.example.petmatchlab.model.RequestStatus;
import com.example.petmatchlab.model.SupportType;

public record SupportRequestResponse(
    Long id,
    Long petId,
    SupportType type,
    String description,
    RequestStatus status
) {
}
