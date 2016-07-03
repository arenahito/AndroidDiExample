package example.androiddiexample.presentation.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import example.androiddiexample.domain.repositories.TasksRepository;
import example.androiddiexample.presentation.di.modules.ApplicationModule;

@Component(modules = ApplicationModule.class)
@Singleton
public interface ApplicationComponent {

    ActivityComponent activityComponent();

    Context context();

    TasksRepository tasksRepository();

}
