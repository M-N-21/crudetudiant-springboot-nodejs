package com.groupeisi.crudetudiant.service;

import com.groupeisi.crudetudiant.dto.EtudiantDto;
import com.groupeisi.crudetudiant.entity.Etudiant;
import com.groupeisi.crudetudiant.mapper.EtudiantMapper;
import com.groupeisi.crudetudiant.repository.EtudiantRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;
    private final EtudiantMapper etudiantMapper;

    public EtudiantService(EtudiantRepository etudiantRepository, EtudiantMapper etudiantMapper) {
        this.etudiantRepository = etudiantRepository;
        this.etudiantMapper = etudiantMapper;
    }

    public List<EtudiantDto> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        return etudiants.stream()
                .map(etudiantMapper::etudiantToEtudiantDto)
                .collect(Collectors.toList());
    }

    public EtudiantDto getEtudiantById(Long id) {
        Optional<Etudiant> etudiantOptional = etudiantRepository.findById(id);
        return etudiantOptional.map(etudiantMapper::etudiantToEtudiantDto).orElse(null);
    }

    public EtudiantDto createEtudiant(EtudiantDto etudiantDto) {
        Etudiant etudiant = etudiantMapper.etudiantDtoToEtudiant(etudiantDto);
        Etudiant savedEtudiant = etudiantRepository.save(etudiant);
        return etudiantMapper.etudiantToEtudiantDto(savedEtudiant);
    }

    public EtudiantDto updateEtudiant(Long id, EtudiantDto etudiantDto) {
        Optional<Etudiant> etudiantOptional = etudiantRepository.findById(id);
        if (etudiantOptional.isPresent()) {
            Etudiant etudiant = etudiantOptional.get();
            etudiant.setNom(etudiantDto.getNom());
            etudiant.setPrenom(etudiantDto.getPrenom());
            etudiant.setTelephone(etudiantDto.getTelephone());
            Etudiant updatedEtudiant = etudiantRepository.save(etudiant);
            return etudiantMapper.etudiantToEtudiantDto(updatedEtudiant);
        }
        return null;
    }

    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }
}
