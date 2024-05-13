package org.example.controllers;

import org.example.models.Programme;
import org.example.services.ProgrammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programmes")
public class ProgrammeController {

    @Autowired
    private ProgrammeService programmeService;

    @PostMapping
    public ResponseEntity<Programme> createProgramme(@RequestBody Programme programme) {
        return ResponseEntity.ok(programmeService.saveProgramme(programme));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Programme> getProgrammeById(@PathVariable Long id) {
        return programmeService.getProgrammeById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Programme>> getAllProgrammes() {
        return ResponseEntity.ok(programmeService.getAllProgrammes());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Programme> updateProgramme(@PathVariable Long id, @RequestBody Programme programme) {
        programme.setId(id);
        return ResponseEntity.ok(programmeService.saveProgramme(programme));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgramme(@PathVariable Long id) {
        programmeService.deleteProgramme(id);
        return ResponseEntity.ok().build();
    }
}
