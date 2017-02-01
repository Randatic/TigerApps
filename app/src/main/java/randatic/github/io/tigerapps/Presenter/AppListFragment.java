package randatic.github.io.tigerapps.Presenter;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import randatic.github.io.tigerapps.Model.App;

/**
 * Created by Randy Bruner on 1/31/2017.
 */

public class AppListFragment extends ListFragment {
    private List<App> apps;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        apps = new ArrayList<App>();
        populateList();

        AppAdapter adapter = new AppAdapter(getContext(), apps);
        setListAdapter(adapter);

        return rootView;
    }

    private void populateList() {
        apps.add(new App("Orange App", "An Orange App", 4));
        apps.add(new App("Purple App", "A Purple App", 3));
        apps.add(new App("Red App", "A Red App", 5));
        apps.add(new App("Example App", "An Example of an Average App", 4));
        apps.add(new App("App", "Just a boring old 0app", 2));
        apps.add(new App("The App", "The App", 5));
        apps.add(new App("Game App", "A fun addicting game", 5));
    }
}
