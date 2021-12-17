package com.davernonapp.davernonapp.controller;

import com.davernonapp.davernonapp.entity.Privilege;
import com.davernonapp.davernonapp.exception.NotFoundException;
import com.davernonapp.davernonapp.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/privilege")
public class PrivilegeController {


    @Autowired
    private PrivilegeService privilegeService;

    @GetMapping
    public List<Privilege> getAll() {
        return privilegeService.getAll();
    }

    @GetMapping("/{id}")
    public Privilege getById(@PathVariable("id") Integer id) throws NotFoundException {
        return privilegeService.getById(id);
    }

    @PostMapping
    public Privilege create(@RequestBody Privilege privilege) {
        return privilegeService.create(privilege);
    }

    @PutMapping(path = "{id}")
    public Privilege update(@PathVariable Integer id, @RequestBody Privilege privilege) throws NotFoundException {
        return privilegeService.update(id, privilege);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) throws NotFoundException {
        return privilegeService.delete(id);
    }

}
