package com.example.petmatchlab.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.petmatchlab.model.Pet;

@Repository
public class InMemoryPetRepository {

    private final List<Pet> pets = new ArrayList<>(Arrays.asList(
        new Pet(1L, "Luna", "Perro", 3, "Disfruta los paseos y los juegos."),
        new Pet(2L, "Milo", "Gato", 2, "Prefiere lugares tranquilos."),
        new Pet(3L, "Nube", "Conejo", 1, "Es curioso y le gusta explorar.")
    ));

    public List<Pet> findAll() {
        return pets;
    }

    public Optional<Pet> findById(long id) {
        for (Pet pet : pets) {
            if (pet.getId() == id) {
                return Optional.of(pet);
            }
        }
        return Optional.empty();
    }
}