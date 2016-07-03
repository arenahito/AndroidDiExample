package example.androiddiexample.presentation.di.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import example.androiddiexample.data.repositories.impl.TasksRepositoryImpl;
import example.androiddiexample.domain.repositories.TasksRepository;

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application= application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    public TasksRepository provideTasksRepository() {
        return new TasksRepositoryImpl();
    }


}
