package com.groupeisi.crudetudiant.controller;

import com.groupeisi.crudetudiant.dto.EtudiantDto;
import com.groupeisi.crudetudiant.service.EtudiantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    private final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping
    public ResponseEntity<List<EtudiantDto>> getAllEtudiants() {
        List<EtudiantDto> etudiants = etudiantService.getAllEtudiants();
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtudiantDto> getEtudiantById(@PathVariable Long id) {
        EtudiantDto etudiant = etudiantService.getEtudiantById(id);
        if (etudiant != null) {
            return new ResponseEntity<>(etudiant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<EtudiantDto> createEtudiant(@RequestBody EtudiantDto etudiantDto) {
        EtudiantDto createdEtudiant = etudiantService.createEtudiant(etudiantDto);
        return new ResponseEntity<>(createdEtudiant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtudiantDto> updateEtudiant(@PathVariable Long id, @RequestBody EtudiantDto etudiantDto) {
        EtudiantDto updatedEtudiant = etudiantService.updateEtudiant(id, etudiantDto);
        if (updatedEtudiant != null) {
            return new ResponseEntity<>(updatedEtudiant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
