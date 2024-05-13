package org.example.services;

import org.example.models.Objectif;
import org.example.repositories.ObjectifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjectifService {

    @Autowired
    private ObjectifRepository objectifRepository;

    public Objectif saveObjectif(Objectif objectif) {
        return objectifRepository.save(objectif);
    }

    public Optional<Objectif> getObjectifById(Long id) {
        return objectifRepository.findById(id);
    }

    public List<Objectif> getObjectifsByAchieved(boolean achieved) {
        return objectifRepository.findByAchieved(achieved);
    }

    public void deleteObjectif(Long id) {
        objectifRepository.deleteById(id);
    }

}
