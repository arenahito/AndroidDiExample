package example.androiddiexample.presentation.presenters;

import java.util.List;

import example.androiddiexample.data.entities.Task;
import example.androiddiexample.domain.usecases.TasksUseCase;
import example.androiddiexample.presentation.views.fragments.MainActivityFragment;

public class MainActivityFragmentPresenter extends Presenter {

    private MainActivityFragment view;

    private TasksUseCase tasksUseCase;

    private List<Task> tasks;

    public MainActivityFragmentPresenter(MainActivityFragment view, TasksUseCase tasksUseCase) {
        this.view = view;
        this.tasksUseCase = tasksUseCase;
    }

    public void fetchTasks() {
        tasks = tasksUseCase.findAll();
        view.renderTasks(tasks);
    }

    public void addTask(String text) {
        tasksUseCase.save(new Task(text));
        view.clearNewTaskText();
        fetchTasks();
    }

    public void deleteTask(int index) {
        tasksUseCase.delete(tasks.get(index).getId());
        fetchTasks();
    }

}
