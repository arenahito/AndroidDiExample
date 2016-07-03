package example.androiddiexample.presentation.views.activities;

import android.os.Bundle;

import example.androiddiexample.R;
import example.androiddiexample.presentation.di.components.MainActivityComponent;

public class MainActivity extends BaseActivity implements ComponentHoldable<MainActivityComponent> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public MainActivityComponent getComponent() {
        return getBaseActivityComponent().mainActivityComponent();
    }
}
