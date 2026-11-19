package com.example.petmatchlab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.petmatchlab.dto.SupportRequestForm;
import com.example.petmatchlab.exception.BusinessRuleException;
import com.example.petmatchlab.exception.ResourceNotFoundException;
import com.example.petmatchlab.model.Pet;
import com.example.petmatchlab.model.RequestStatus;
import com.example.petmatchlab.model.SupportRequest;
import com.example.petmatchlab.repository.PetRepository;
import com.example.petmatchlab.repository.SupportRequestRepository;

@Service
public class SupportRequestService {

    private final PetRepository petRepository;
    private final SupportRequestRepository requestRepository;

    public SupportRequestService(
        PetRepository petRepository,
        SupportRequestRepository requestRepository
    ) {
        this.petRepository = petRepository;
        this.requestRepository = requestRepository;
    }

    @Transactional(readOnly = true)
    public List<SupportRequest> findAllForPet(long petId) {
        findPet(petId);
        return requestRepository.findByPet_IdOrderByIdDesc(petId);
    }

    @Transactional(readOnly = true)
    public SupportRequest findOneForPet(long petId, long requestId) {
        return findRequest(petId, requestId);
    }

    @Transactional
    public SupportRequest create(long petId, SupportRequestForm form) {
        validateForm(form);
        Pet pet = findPet(petId);

        if (requestRepository.existsByPet_IdAndStatus(
            petId, RequestStatus.OPEN
        )) {
            throw new BusinessRuleException(
                "Esta mascota ya tiene una solicitud abierta."
            );
        }

        SupportRequest request = new SupportRequest(
            pet,
            form.getType(),
            form.getDescription().strip()
        );

        return requestRepository.save(request);
    }

    @Transactional
    public void complete(long petId, long requestId) {
        SupportRequest request = findRequest(petId, requestId);
        request.complete();
    }

    @Transactional
    public void cancel(long petId, long requestId) {
        SupportRequest request = findRequest(petId, requestId);
        request.cancel();
    }

    @Transactional
    public SupportRequest replace(
        long petId,
        long requestId,
        SupportRequestForm form
    ) {
        validateForm(form);
        Pet pet = findPet(petId);
        SupportRequest previous = findRequest(petId, requestId);

        previous.cancel();

        SupportRequest replacement = new SupportRequest(
            pet,
            form.getType(),
            form.getDescription().strip()
        );

        return requestRepository.save(replacement);
    }

    private Pet findPet(long petId) {
        return petRepository.findById(petId)
            .orElseThrow(() -> new ResourceNotFoundException(
                "No existe la mascota indicada."
            ));
    }

    private SupportRequest findRequest(long petId, long requestId) {
        return requestRepository.findByIdAndPet_Id(requestId, petId)
            .orElseThrow(() -> new ResourceNotFoundException(
                "No existe esa solicitud para la mascota indicada."
            ));
    }

    private void validateForm(SupportRequestForm form) {
        if (form == null || form.getType() == null
            || form.getDescription() == null
            || form.getDescription().isBlank()
            || form.getDescription().length() > 500) {
            throw new IllegalArgumentException("Invalid support request form");
        }
    }
}
