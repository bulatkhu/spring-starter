package startproject.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import startproject.demo.entity.TodoEntity;
import startproject.demo.entity.UserEntity;
import startproject.demo.repository.TodoRepo;
import startproject.demo.repository.UserRepo;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public TodoEntity createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return todoRepo.save(todo);
    }

    public TodoEntity complete(Long id) {
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setComplieted(!todo.getComplieted());
        return todoRepo.save(todo);
    }
}
