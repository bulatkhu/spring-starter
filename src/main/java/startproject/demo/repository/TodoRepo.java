package startproject.demo.repository;

import org.springframework.data.repository.CrudRepository;
import startproject.demo.entity.TodoEntity;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}
