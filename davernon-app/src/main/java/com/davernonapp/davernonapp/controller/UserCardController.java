package com.davernonapp.davernonapp.controller;

import com.davernonapp.davernonapp.exception.NotFoundException;
import com.davernonapp.davernonapp.entity.UserCard;
import com.davernonapp.davernonapp.service.UserCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserCardController {


    @Autowired
    private UserCardService userCardService;

    @GetMapping
    public List<UserCard> getAll() {
        return userCardService.getAll();
    }

    @GetMapping("/{id}")
    public UserCard getById(@PathVariable("id") Integer id) throws NotFoundException {
        return userCardService.getById(id);
    }

    @PostMapping
    public UserCard create(@RequestBody UserCard userCard) {
        return userCardService.create(userCard);
    }

    @PutMapping(path = "{id}")
    public UserCard update(@PathVariable Integer id, @RequestBody UserCard userCard) throws NotFoundException {
        return userCardService.update(id, userCard);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) throws NotFoundException {
        return userCardService.deleteUser(id);
    }

}
