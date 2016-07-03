package example.androiddiexample.data.datastores;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import example.androiddiexample.data.entities.Task;

public class InMemoryTasksDataStore {

    private ArrayList<Task> tasks = new ArrayList<>(Arrays.asList(
            new Task(0, "Sample Task 1"),
            new Task(1, "Sample Task 2"),
            new Task(2, "Sample Task 3")
    ));

    private int nextId = tasks.size();

    @SuppressWarnings("unchecked")
    public List<Task> findAll() {
        return (List) tasks.clone();
    }

    public @Nullable
    Task find(int id) {
        int index = getTaskIndex(id);
        if (index >= 0) {
            return tasks.get(index);
        } else {
            return null;
        }
    }

    public void insert(Task task) {
        task.setId(nextId);
        tasks.add(task);
        nextId++;
    }

    public void update(Task task) {
        int index = getTaskIndex(task.getId());
        if (index >= 0) {
            tasks.set(index, task.clone());
        }
    }

    public void delete(int id) {
        tasks.remove(getTaskIndex(id));
    }

    private int getTaskIndex(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
