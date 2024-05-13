package org.example.controllers;

import org.example.models.Objectif;
import org.example.services.ObjectifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objectifs")
public class ObjectifController {

    @Autowired
    private ObjectifService objectifService;

    @PostMapping
    public ResponseEntity<Objectif> createObjectif(@RequestBody Objectif objectif) {
        return ResponseEntity.ok(objectifService.saveObjectif(objectif));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Objectif> getObjectifById(@PathVariable Long id) {
        return objectifService.getObjectifById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/achieved")
    public ResponseEntity<List<Objectif>> getObjectifsByAchieved(@RequestParam boolean achieved) {
        return ResponseEntity.ok(objectifService.getObjectifsByAchieved(achieved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteObjectif(@PathVariable Long id) {
        objectifService.deleteObjectif(id);
        return ResponseEntity.ok().build();
    }
}
