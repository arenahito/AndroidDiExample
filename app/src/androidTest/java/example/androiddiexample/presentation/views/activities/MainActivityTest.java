package example.androiddiexample.presentation.views.activities;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.DataInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import example.androiddiexample.R;
import example.androiddiexample.data.entities.Task;
import example.androiddiexample.domain.usecases.TasksUseCase;
import example.androiddiexample.presentation.DiExampleApplication;
import example.androiddiexample.presentation.di.PerActivity;
import example.androiddiexample.presentation.di.components.ActivityComponent;
import example.androiddiexample.presentation.di.components.ApplicationComponent;
import example.androiddiexample.presentation.di.components.MainActivityComponent;
import example.androiddiexample.presentation.di.modules.ActivityModule;
import example.androiddiexample.presentation.di.modules.ApplicationModule;
import example.androiddiexample.presentation.views.fragments.MainActivityFragment;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testInitialTasks() {
        TasksUseCase testTasksUseCase = new TasksUseCase() {
            @Override
            public List<Task> findAll() {
                return new ArrayList<>(Arrays.asList(
                        new Task(0, "Test001"),
                        new Task(1, "Test002"),
                        new Task(2, "Test003")
                ));
            }

            @Override
            public void save(Task task) {

            }

            @Override
            public void delete(int id) {

            }
        };

        getApplication().setComponent(
                DaggerMainActivityTest_TestApplicationComponent
                        .builder()
                        .applicationModule(new ApplicationModule(getApplication()))
                        .testMainActivityModule(new TestMainActivityModule(testTasksUseCase))
                        .build()
        );

        activityRule.launchActivity(new Intent());

        DataInteraction taskListView = onData(anything()).inAdapterView(withId(R.id.taskListView));
        taskListView.atPosition(0).check(matches(withText("id=0, text=Test001")));
        taskListView.atPosition(1).check(matches(withText("id=1, text=Test002")));
        taskListView.atPosition(2).check(matches(withText("id=2, text=Test003")));
    }

    private DiExampleApplication getApplication() {
        return (DiExampleApplication) InstrumentationRegistry
                .getInstrumentation()
                .getTargetContext()
                .getApplicationContext();
    }

    @Component(modules = {ApplicationModule.class, TestMainActivityModule.class})
    @Singleton
    public interface TestApplicationComponent extends ApplicationComponent {

        @Override
        TestActivityComponent activityComponent();

    }

    @Subcomponent(modules = ActivityModule.class)
    @PerActivity
    public interface TestActivityComponent extends ActivityComponent {

        @Override
        TestMainActivityComponent mainActivityComponent();

    }

    @Subcomponent(modules = TestMainActivityModule.class)
    @PerActivity
    public interface TestMainActivityComponent extends MainActivityComponent {

        void inject(MainActivityFragment mainActivityFragment);

    }

    @Module
    public class TestMainActivityModule {

        private TasksUseCase tasksUseCase;

        public TestMainActivityModule(TasksUseCase tasksUseCase) {
            this.tasksUseCase = tasksUseCase;
        }

        @Provides
        public TasksUseCase provideTasksUseCase() {
            return tasksUseCase;
        }

    }

}