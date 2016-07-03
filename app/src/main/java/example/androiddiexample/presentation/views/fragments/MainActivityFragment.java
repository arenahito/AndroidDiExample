package example.androiddiexample.presentation.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import example.androiddiexample.R;
import example.androiddiexample.data.entities.Task;
import example.androiddiexample.domain.usecases.TasksUseCase;
import example.androiddiexample.presentation.di.components.MainActivityComponent;
import example.androiddiexample.presentation.presenters.MainActivityFragmentPresenter;

public class MainActivityFragment extends BaseFragment {

    @Inject
    protected TasksUseCase tasksUseCase;

    protected MainActivityFragmentPresenter presenter;

    @BindView(R.id.taskListView)
    protected ListView taskListView;

    @BindView(R.id.newTaskText)
    protected EditText newTaskText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getActivityComponent(MainActivityComponent.class).inject(this);
        presenter = new MainActivityFragmentPresenter(this, tasksUseCase);

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        registerForContextMenu(taskListView);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter.fetchTasks();
    }

    @OnClick(R.id.addButton)
    public void onClickAddTask(View v) {
        presenter.addTask(newTaskText.getText().toString());
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add("DELETE");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo
                = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        presenter.deleteTask(menuInfo.position);

        return super.onContextItemSelected(item);
    }

    public void renderTasks(List<Task> tasks) {
        taskListView.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, tasks));
    }

    public void clearNewTaskText() {
        newTaskText.setText("");
    }

}
