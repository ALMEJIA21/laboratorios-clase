package com.example.petmatchlab.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class PetControllerIntegrationTests {

    private static final String ADMIN = "admin@example.com";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldRenderCreateForm() throws Exception {
        mockMvc.perform(get("/pets/new")
                .with(user(ADMIN).roles("ADMIN")))
            .andExpect(status().isOk())
            .andExpect(view().name("pets/form"))
            .andExpect(model().attributeExists("petForm"));
    }

    @Test
    void shouldRejectInvalidPetFormWithoutRedirect() throws Exception {
        mockMvc.perform(post("/pets")
                .with(user(ADMIN).roles("ADMIN"))
                .with(csrf())
                .param("name", "")
                .param("species", "   ")
                .param("age", "-1")
                .param("description", "Prueba"))
            .andExpect(status().isOk())
            .andExpect(view().name("pets/form"))
            .andExpect(model().attributeHasFieldErrors(
                "petForm", "name", "species", "age"));
    }

    @Test
    void shouldRedirectAfterValidCreation() throws Exception {
        mockMvc.perform(post("/pets")
                .with(user(ADMIN).roles("ADMIN"))
                .with(csrf())
                .param("name", "Kira")
                .param("species", "Perro")
                .param("age", "4")
                .param("description", "Juguetona"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrlPattern("/pets/*"));
    }

    @Test
    void shouldReturnNotFoundWhenEditingMissingPet() throws Exception {
        mockMvc.perform(get("/pets/999999/edit")
                .with(user(ADMIN).roles("ADMIN")))
            .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturnNotFoundWhenDeletingMissingPet() throws Exception {
        mockMvc.perform(post("/pets/999999/delete")
                .with(user(ADMIN).roles("ADMIN"))
                .with(csrf()))
            .andExpect(status().isNotFound());
    }

    @Test
    void shouldListPetsForAuthenticatedUser() throws Exception {
        mockMvc.perform(get("/pets")
                .with(user("ana@example.com").roles("USER")))
            .andExpect(status().isOk())
            .andExpect(view().name("pets/list"));
    }
}
