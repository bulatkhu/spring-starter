package startproject.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import startproject.demo.entity.UserEntity;
import startproject.demo.exeption.UserAlreadyExistException;
import startproject.demo.exeption.UserNotFoundException;
import startproject.demo.model.User;
import startproject.demo.repository.UserRepo;

import java.util.ArrayList;

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

    public ArrayList<User> getAllUsers() {
        ArrayList<User> publicUsers = new ArrayList<>();

        for (UserEntity userEntity : userRepo.findAll())
            publicUsers.add(User.toModel(userEntity));

        return publicUsers;
    }

    public Long deleteUser(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
