package org.example.services;

import org.example.models.Seance;
import org.example.repositories.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeanceService {

    @Autowired
    private SeanceRepository seanceRepository;

    public Seance saveSeance(Seance seance) {
        return seanceRepository.save(seance);
    }

    public Optional<Seance> getSeanceById(Long id) {
        return seanceRepository.findById(id);
    }

    public List<Seance> getSeancesByProgrammeId(Long programmeId) {
        return seanceRepository.findByProgrammeId(programmeId);
    }

    public void deleteSeance(Long id) {
        seanceRepository.deleteById(id);
    }

}
