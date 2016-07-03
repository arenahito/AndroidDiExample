package example.androiddiexample.presentation.views.fragments;

import android.support.v4.app.Fragment;

import example.androiddiexample.presentation.views.activities.ComponentHoldable;

public class BaseFragment extends Fragment {

    public <T> T getActivityComponent(Class<T> componentClass) {
        return componentClass.cast(((ComponentHoldable) getActivity()).getComponent());
    }
}
