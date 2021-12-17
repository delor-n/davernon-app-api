package com.davernonapp.davernonapp.controller.MindSet;

import com.davernonapp.davernonapp.entity.MindSet;
import com.davernonapp.davernonapp.exception.NotFoundException;
import com.davernonapp.davernonapp.service.mindSet.MindSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mindSet")
public class MindSetController {


    @Autowired
    private MindSetService mindSetService;

    @GetMapping
    public List<MindSet> getAll() {
        return mindSetService.getAll();
    }

    @GetMapping("/{id}")
    public MindSet getById(@PathVariable("id") Integer id) throws NotFoundException {
        return mindSetService.getById(id);
    }

    @PostMapping
    public MindSet create(@RequestBody MindSet mindSet) {
        return mindSetService.create(mindSet);
    }

    @PutMapping(path = "{id}")
    public MindSet update(@PathVariable Integer id, @RequestBody MindSet mindSet) throws NotFoundException {
        return mindSetService.editMindSet(id, mindSet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) throws NotFoundException {
        return mindSetService.delete(id);
    }

}
