package com.example.petmatchlab.api.controller;

import java.net.URI;
import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.petmatchlab.api.dto.PetRequest;
import com.example.petmatchlab.api.dto.PetResponse;
import com.example.petmatchlab.api.mapper.PetApiMapper;
import com.example.petmatchlab.exception.ResourceNotFoundException;
import com.example.petmatchlab.model.Pet;
import com.example.petmatchlab.service.PetService;

@RestController
@RequestMapping(
    path = "/api/v1/pets",
    produces = MediaType.APPLICATION_JSON_VALUE
)
public class PetRestController {

    private final PetService petService;
    private final PetApiMapper mapper;

    public PetRestController(PetService petService, PetApiMapper mapper) {
        this.petService = petService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<PetResponse> list() {
        return petService.findAll().stream()
            .map(mapper::toResponse)
            .toList();
    }

    @GetMapping("/{petId}")
    public PetResponse detail(@PathVariable("petId") long petId) {
        Pet pet = petService.findById(petId)
            .orElseThrow(() -> new ResourceNotFoundException(
                "Pet not found"
            ));

        return mapper.toResponse(pet);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PetResponse> create(
        @Valid @RequestBody PetRequest request
    ) {
        Pet created = petService.create(mapper.toForm(request));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{petId}")
            .buildAndExpand(created.getId())
            .toUri();

        return ResponseEntity.created(location)
            .body(mapper.toResponse(created));
    }

    @PutMapping(
        path = "/{petId}",
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public PetResponse update(
        @PathVariable("petId") long petId,
        @Valid @RequestBody PetRequest request
    ) {
        Pet updated = petService.update(petId, mapper.toForm(request))
            .orElseThrow(() -> new ResourceNotFoundException(
                "Pet not found"
            ));

        return mapper.toResponse(updated);
    }

    @DeleteMapping("/{petId}")
    public ResponseEntity<Void> delete(@PathVariable("petId") long petId) {
        if (!petService.delete(petId)) {
            throw new ResourceNotFoundException("Pet not found");
        }

        return ResponseEntity.noContent().build();
    }
}
