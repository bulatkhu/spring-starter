package startproject.demo.service;

import org.hibernate.mapping.Any;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import startproject.demo.entity.UserEntity;
import startproject.demo.exeption.UserAlreadyExistException;
import startproject.demo.exeption.UserNotFoundException;
import startproject.demo.model.User;
import startproject.demo.repository.UserRepo;

import java.util.Iterator;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("User with the same username is already exist");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("User with " + id + " not found");
        }
        return User.toModel(user);
    }

    public Iterator<UserEntity> getAllUsers() {
        Iterator<UserEntity> users = userRepo.findAll().iterator();
        // UserEntity newUserData = [];
        // for (int i = 0; i<users.length; i++) {
        //
        // }
        System.out.println(users);
        return users;
    }

    public Long deleteUser(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
