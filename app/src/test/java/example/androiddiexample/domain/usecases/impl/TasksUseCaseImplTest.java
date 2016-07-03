package example.androiddiexample.domain.usecases.impl;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import example.androiddiexample.data.entities.Task;
import example.androiddiexample.domain.repositories.TasksRepository;

public class TasksUseCaseImplTest {

    @Test
    public void testFindAll() {
        TasksUseCaseImpl useCase = new TasksUseCaseImpl(new TasksRepository() {
            @Override
            public List<Task> findAll() {
                return new ArrayList<>(Arrays.asList(
                        new Task(0, "Test001"),
                        new Task(1, "Test002"),
                        new Task(2, "Test003")
                ));
            }

            @Override
            public Task find(int id) {
                return null;
            }

            @Override
            public void insert(Task task) {

            }

            @Override
            public void update(Task task) {

            }

            @Override
            public void delete(int id) {

            }
        });

        List<Task> tasks = useCase.findAll();

        assertThat(tasks.size(), is(3));
        assertThat(tasks.get(0), is(new Task(0, "Test001")));
        assertThat(tasks.get(1), is(new Task(1, "Test002")));
        assertThat(tasks.get(2), is(new Task(2, "Test003")));
    }

}
