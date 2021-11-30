package com.davernonapp.davernonapp.service.mindSet;

import com.davernonapp.davernonapp.entity.MindSet;
import com.davernonapp.davernonapp.exception.BadRequestException;
import com.davernonapp.davernonapp.exception.NotFoundException;
import com.davernonapp.davernonapp.repository.mindSet.MindSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MindSetService {

    @Autowired
    MindSetRepository repository;

    public List<MindSet> getAll() {
        return repository.findAll();
    }

    public MindSet create(MindSet mindSet) {
        if (mindSet.getName() == null ||
                mindSet.getDescription() == null) {
            throw new BadRequestException("L'une des valeurs obligatoire est nulle.");
        }
        MindSet newMindSet = mindSet;
        repository.save(newMindSet);
        return newMindSet;
    }

    public MindSet getMindSet(Integer id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Cette carte n'existe pas"));
    }


    public MindSet editMindSet(Integer id, MindSet mindSet) throws NotFoundException {
        if (mindSet.getName() == null || mindSet.getName().isEmpty()) {
            throw new BadRequestException("Input values can't be empty");
        }
        MindSet modifiedMindSet = repository.findById(id).orElseThrow(() -> new NotFoundException("Cette carte n'existe pas"));

        modifiedMindSet.setName(mindSet.getName());
        modifiedMindSet.setDescription(mindSet.getDescription());
        repository.save(modifiedMindSet);
        return modifiedMindSet;
    }


    public ResponseEntity<String> deleteMindSet(Integer id) throws NotFoundException {
        MindSet mindSet = this.getMindSet(id);
        repository.delete(mindSet);
        return ResponseEntity.status(HttpStatus.OK).body("La carte " + mindSet.getName() + " a bien été supprimé");
    }


}
