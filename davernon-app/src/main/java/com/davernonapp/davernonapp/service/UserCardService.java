package com.davernonapp.davernonapp.service;

import com.davernonapp.davernonapp.entity.UserCard;
import com.davernonapp.davernonapp.exception.BadRequestException;
import com.davernonapp.davernonapp.exception.NotFoundException;
import com.davernonapp.davernonapp.repository.UserCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCardService {

    @Autowired
    UserCardRepository repository;

    public List<UserCard> getAll() {
        return repository.findAll();
    }

    public UserCard create(UserCard userCard) {
        checkCreateUpdate(userCard);

        repository.save(userCard);
        return userCard;
    }

    public UserCard getById(Integer id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Cet utilisateur n'existe pas"));
    }


    public UserCard update(Integer id, UserCard userCard) throws NotFoundException {
        checkCreateUpdate(userCard);
        UserCard modifiedUser = repository.findById(id).orElseThrow(() -> new NotFoundException("Cette carte n'existe pas"));

        modifiedUser.setUsername(userCard.getUsername());
        modifiedUser.setPassword(userCard.getPassword());

        repository.save(modifiedUser);
        return modifiedUser;
    }


    public ResponseEntity<String> deleteUser(Integer id) throws NotFoundException {
        UserCard userCard = this.getById(id);
        repository.delete(userCard);
        return ResponseEntity.status(HttpStatus.OK).body("L'utilisateur " + userCard.getUsername() + " a bien été supprimé");
    }


    public void checkCreateUpdate(UserCard userCard) {
        if (userCard.getUsername() == null ||
                userCard.getPassword() == null ||
                userCard.getEmail() == null) {
            throw new BadRequestException("L'une des valeurs obligatoires est nulle.");
        }
    }
}
