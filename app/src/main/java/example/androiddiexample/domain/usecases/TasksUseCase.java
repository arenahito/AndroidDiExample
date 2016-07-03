package example.androiddiexample.domain.usecases;

import java.util.List;

import example.androiddiexample.data.entities.Task;

public interface TasksUseCase extends UseCase {

    List<Task> findAll();

    void save(Task task);

    void delete(int id);

}
