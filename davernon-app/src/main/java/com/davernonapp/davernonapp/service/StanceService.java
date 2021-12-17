package com.davernonapp.davernonapp.service;

import com.davernonapp.davernonapp.entity.Stance;
import com.davernonapp.davernonapp.exception.BadRequestException;
import com.davernonapp.davernonapp.exception.NotFoundException;
import com.davernonapp.davernonapp.repository.StanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StanceService {

    @Autowired
    StanceRepository repository;

    public List<Stance> getAll() {
        return repository.findAll();
    }

    public Stance create(Stance stance) {
        if (stance.getName() == null) {
            throw new BadRequestException("L'une des valeurs obligatoire est nulle.");
        }

        repository.save(stance);
        return stance;
    }

    public Stance getById(Integer id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Cette carte n'existe pas"));
    }


    public Stance update(Integer id, Stance stance) throws NotFoundException {
        if (stance.getName() == null) {
            throw new BadRequestException("Input values can't be empty");
        }
        Stance modifiedStance = repository.findById(id).orElseThrow(() -> new NotFoundException("Cette carte n'existe pas"));

        modifiedStance.setName(stance.getName());
        repository.save(modifiedStance);
        return modifiedStance;
    }


    public ResponseEntity<String> delete(Integer id) throws NotFoundException {
        Stance stance = this.getById(id);
        repository.delete(stance);
        return ResponseEntity.status(HttpStatus.OK).body("L'utilisateur " + stance.getName() + " a bien été supprimé");
    }


}
