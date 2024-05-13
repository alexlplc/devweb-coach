package org.example.controllers;

import org.example.models.Seance;
import org.example.services.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seances")
public class SeanceController {

    @Autowired
    private SeanceService seanceService;

    @PostMapping
    public ResponseEntity<Seance> createSeance(@RequestBody Seance seance) {
        return ResponseEntity.ok(seanceService.saveSeance(seance));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seance> getSeanceById(@PathVariable Long id) {
        return seanceService.getSeanceById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/byProgramme/{programmeId}")
    public ResponseEntity<List<Seance>> getSeancesByProgrammeId(@PathVariable Long programmeId) {
        return ResponseEntity.ok(seanceService.getSeancesByProgrammeId(programmeId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeance(@PathVariable Long id) {
        seanceService.deleteSeance(id);
        return ResponseEntity.ok().build();
    }
}
