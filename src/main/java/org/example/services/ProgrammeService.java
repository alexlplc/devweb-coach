package org.example.services;

import org.example.models.Programme;
import org.example.repositories.ProgrammeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgrammeService {

    @Autowired
    private ProgrammeRepository programmeRepository;

    public Programme saveProgramme(Programme programme) {
        return programmeRepository.save(programme);
    }

    public Optional<Programme> getProgrammeById(Long id) {
        return programmeRepository.findById(id);
    }

    public List<Programme> getAllProgrammes() {
        return programmeRepository.findAll();
    }

    public void deleteProgramme(Long id) {
        programmeRepository.deleteById(id);
    }

}
