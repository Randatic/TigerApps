package randatic.github.io.tigerapps.Presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import randatic.github.io.tigerapps.R;

/**
 * Created by Randy Bruner on 2/2/2017.
 */

public class AppFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View rootView = inflater.inflate(R.layout.fragment_app, container, false);

        //wire widgets

        //get info from model

        //put info into view

        return rootView;
    }
}
