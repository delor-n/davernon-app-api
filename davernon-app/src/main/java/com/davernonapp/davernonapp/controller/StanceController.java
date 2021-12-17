package com.davernonapp.davernonapp.controller;

import com.davernonapp.davernonapp.entity.Stance;
import com.davernonapp.davernonapp.exception.NotFoundException;
import com.davernonapp.davernonapp.service.StanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stance")
public class StanceController {


    @Autowired
    private StanceService stanceService;

    @GetMapping
    public List<Stance> getAll() {
        return stanceService.getAll();
    }

    @GetMapping("/{id}")
    public Stance getById(@PathVariable("id") Integer id) throws NotFoundException {
        return stanceService.getById(id);
    }

    @PostMapping
    public Stance create(@RequestBody Stance stance) {
        return stanceService.create(stance);
    }

    @PutMapping(path = "{id}")
    public Stance update(@PathVariable Integer id, @RequestBody Stance stance) throws NotFoundException {
        return stanceService.update(id, stance);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) throws NotFoundException {
        return stanceService.delete(id);
    }

}
