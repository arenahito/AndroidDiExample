package example.androiddiexample.presentation.di.modules;

import dagger.Module;
import dagger.Provides;
import example.androiddiexample.domain.repositories.TasksRepository;
import example.androiddiexample.domain.usecases.TasksUseCase;
import example.androiddiexample.domain.usecases.impl.TasksUseCaseImpl;

@Module
public class MainActivityModule {

    @Provides
    public TasksUseCase provideTasksUseCase(TasksRepository repository) {
        return new TasksUseCaseImpl(repository);
    }

}
