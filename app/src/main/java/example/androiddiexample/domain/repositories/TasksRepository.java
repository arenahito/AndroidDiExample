package example.androiddiexample.domain.repositories;

import java.util.List;

import example.androiddiexample.data.entities.Task;


public interface TasksRepository extends Repository {

    List<Task> findAll();

    Task find(int id);

    void insert(Task task);

    void update(Task task);

    void delete(int id);

}
