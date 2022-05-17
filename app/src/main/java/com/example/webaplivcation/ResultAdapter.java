package com.example.webaplivcation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ResultAdapter extends ArrayAdapter<UserResult> {

    private LayoutInflater inflater;
    private int layout;
    private List<UserResult> userResults;

    public ResultAdapter(Context context, int resource, List<UserResult> userResults) {
        super(context, resource, userResults);
        this.userResults = userResults;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        ImageView flagView = view.findViewById(R.id.flag);
        TextView nameView = view.findViewById(R.id.name);
        TextView resultView = view.findViewById(R.id.result);

        UserResult userResult = userResults.get(position);

        flagView.setImageResource(userResult.getFlagResource());
        nameView.setText(userResult.getName());
        resultView.setText(userResult.getResult());

        return view;
    }
}