package com.ad.exam1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ad.exam1.R;
import com.ad.exam1.data.EmojisRetriever;
import com.ad.exam1.models.Emoji;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EmojiAdapter extends ArrayAdapter<List> {

    private final Context context;
    private List<Emoji> values;


    public EmojiAdapter(Context context, List values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
        ;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_layout, parent, false);
        TextView txt = rowView.findViewById(R.id.textView);
        ImageView img = rowView.findViewById(R.id.imageView);

        txt.setText(values.get(position).getName());
        Picasso.get().load(values.get(position).getUrl()).resize(200, 200).into(img);


        return rowView;
    }


}

