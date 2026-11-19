package com.example.petmatchlab.api.mapper;

import org.springframework.stereotype.Component;

import com.example.petmatchlab.api.dto.SupportRequestRequest;
import com.example.petmatchlab.api.dto.SupportRequestResponse;
import com.example.petmatchlab.dto.SupportRequestForm;
import com.example.petmatchlab.model.SupportRequest;

@Component
public class SupportRequestApiMapper {

    public SupportRequestForm toForm(SupportRequestRequest request) {
        SupportRequestForm form = new SupportRequestForm();
        form.setType(request.type());
        form.setDescription(request.description());
        return form;
    }

    public SupportRequestResponse toResponse(
        SupportRequest request,
        long petId
    ) {
        return new SupportRequestResponse(
            request.getId(),
            petId,
            request.getType(),
            request.getDescription(),
            request.getStatus()
        );
    }
}
