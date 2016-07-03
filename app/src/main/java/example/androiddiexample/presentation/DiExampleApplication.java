package example.androiddiexample.presentation;

import android.app.Application;

import example.androiddiexample.presentation.di.components.ApplicationComponent;
import example.androiddiexample.presentation.di.components.DaggerApplicationComponent;
import example.androiddiexample.presentation.di.modules.ApplicationModule;

public class DiExampleApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeComponent();
    }

    private void initializeComponent() {
        component = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public void setComponent(ApplicationComponent component) {
        this.component = component;
    }

    public ApplicationComponent getApplicationComponent() {
        return component;
    }

}
