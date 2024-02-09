package com.groupeisi.crudetudiant.mapper;

import com.groupeisi.crudetudiant.dto.EtudiantDto;
import com.groupeisi.crudetudiant.entity.Etudiant;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

@Mapper
@ComponentScan
public interface EtudiantMapper {
    EtudiantDto etudiantToEtudiantDto(Etudiant etudiant);

    Etudiant etudiantDtoToEtudiant(EtudiantDto etudiantDto);
}
