package example.androiddiexample.data.repositories.impl;

import android.support.annotation.Nullable;

import java.util.List;

import example.androiddiexample.data.datastores.InMemoryTasksDataStore;
import example.androiddiexample.data.entities.Task;
import example.androiddiexample.domain.repositories.TasksRepository;

public class TasksRepositoryImpl implements TasksRepository {

    private static InMemoryTasksDataStore dataStore = new InMemoryTasksDataStore();

    @Override
    @SuppressWarnings("unchecked")
    public List<Task> findAll() {
        return dataStore.findAll();
    }

    @Override
    public @Nullable Task find(int id) {
        return dataStore.find(id);
    }

    @Override
    public void insert(Task task) {
        dataStore.insert(task);
    }

    @Override
    public void update(Task task) {
        dataStore.update(task);
    }

    @Override
    public void delete(int id) {
        dataStore.delete(id);
    }

}
