package example.androiddiexample.domain.usecases.impl;

import java.util.List;

import javax.inject.Inject;

import example.androiddiexample.data.entities.Task;
import example.androiddiexample.domain.repositories.TasksRepository;
import example.androiddiexample.domain.usecases.TasksUseCase;

public class TasksUseCaseImpl implements TasksUseCase {

    private TasksRepository repository;

    @Inject
    public TasksUseCaseImpl(TasksRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Task> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Task task) {
        Task existingTask = repository.find(task.getId());
        if (existingTask == null) {
            repository.insert(task);
        } else {
            repository.update(task);
        }
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}
