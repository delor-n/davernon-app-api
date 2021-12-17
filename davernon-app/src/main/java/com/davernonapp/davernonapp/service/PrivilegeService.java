package com.davernonapp.davernonapp.service;

import com.davernonapp.davernonapp.entity.Privilege;
import com.davernonapp.davernonapp.exception.BadRequestException;
import com.davernonapp.davernonapp.exception.NotFoundException;
import com.davernonapp.davernonapp.repository.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivilegeService {

    @Autowired
    PrivilegeRepository repository;

    public List<Privilege> getAll() {
        return repository.findAll();
    }

    public Privilege create(Privilege privilege) {
        if (privilege.getName() == null) {
            throw new BadRequestException("L'une des valeurs obligatoire est nulle.");
        }

        repository.save(privilege);
        return privilege;
    }

    public Privilege getById(Integer id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Cette carte n'existe pas"));
    }


    public Privilege update(Integer id, Privilege privilege) throws NotFoundException {
        if (privilege.getName() == null) {
            throw new BadRequestException("Input values can't be empty");
        }
        Privilege modifiedPrivilege = repository.findById(id).orElseThrow(() -> new NotFoundException("Cette carte n'existe pas"));

        modifiedPrivilege.setName(privilege.getName());
        repository.save(modifiedPrivilege);
        return modifiedPrivilege;
    }


    public ResponseEntity<String> delete(Integer id) throws NotFoundException {
        Privilege privilege = this.getById(id);
        repository.delete(privilege);
        return ResponseEntity.status(HttpStatus.OK).body("L'utilisateur " + privilege.getName() + " a bien été supprimé");
    }


}
