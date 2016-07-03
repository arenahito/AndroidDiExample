package example.androiddiexample.presentation.views.activities;

import android.support.v7.app.AppCompatActivity;

import example.androiddiexample.presentation.DiExampleApplication;
import example.androiddiexample.presentation.di.components.ActivityComponent;

public class BaseActivity extends AppCompatActivity {

    public ActivityComponent getBaseActivityComponent() {
        return ((DiExampleApplication) getApplication())
                .getApplicationComponent()
                .activityComponent();
    }

}
