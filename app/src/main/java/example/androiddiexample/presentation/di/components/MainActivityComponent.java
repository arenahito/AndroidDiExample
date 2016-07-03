package example.androiddiexample.presentation.di.components;

import dagger.Subcomponent;
import example.androiddiexample.presentation.di.PerActivity;
import example.androiddiexample.presentation.di.modules.MainActivityModule;
import example.androiddiexample.presentation.views.fragments.MainActivityFragment;

@Subcomponent(modules = MainActivityModule.class)
@PerActivity
public interface MainActivityComponent {

    void inject(MainActivityFragment mainActivityFragment);

}
