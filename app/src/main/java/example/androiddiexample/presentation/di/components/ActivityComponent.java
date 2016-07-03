package example.androiddiexample.presentation.di.components;

import dagger.Subcomponent;
import example.androiddiexample.presentation.di.PerActivity;
import example.androiddiexample.presentation.di.modules.ActivityModule;

@Subcomponent(modules = ActivityModule.class)
@PerActivity
public interface ActivityComponent {

    MainActivityComponent mainActivityComponent();

}
