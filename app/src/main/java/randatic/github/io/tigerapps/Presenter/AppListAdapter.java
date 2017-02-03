package randatic.github.io.tigerapps.Presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import randatic.github.io.tigerapps.Model.App;
import randatic.github.io.tigerapps.R;

/**
 * Created by Randy Bruner on 1/31/2017.
 */

public class AppListAdapter extends ArrayAdapter<App> {

    public AppListAdapter(Context context, List<App> apps) {
        super(context, 0, apps);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_app, null);
        }

        App app = getItem(position);

        TextView nameTextView = (TextView) convertView.findViewById(R.id.itemApp_textView_name);
        TextView descriptionTextView = (TextView) convertView.findViewById(R.id.itemApp_textView_description);
        TextView ratingTextView = (TextView) convertView.findViewById(R.id.itemApp_textView_rating);

        nameTextView.setText(app.getName());
        descriptionTextView.setText(app.getBriefDescription());
        ratingTextView.setText(""+app.getRating());

        return convertView;
    }
}
