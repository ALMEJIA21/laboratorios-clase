package com.example.petmatchlab.api.mapper;

import org.springframework.stereotype.Component;

import com.example.petmatchlab.api.dto.PetRequest;
import com.example.petmatchlab.api.dto.PetResponse;
import com.example.petmatchlab.dto.PetForm;
import com.example.petmatchlab.model.Pet;

@Component
public class PetApiMapper {

    public PetForm toForm(PetRequest request) {
        PetForm form = new PetForm();
        form.setName(request.name());
        form.setSpecies(request.species());
        form.setAge(request.age());
        form.setDescription(request.description());
        return form;
    }

    public PetResponse toResponse(Pet pet) {
        return new PetResponse(
            pet.getId(),
            pet.getName(),
            pet.getSpecies(),
            pet.getAge(),
            pet.getDescription()
        );
    }
}
