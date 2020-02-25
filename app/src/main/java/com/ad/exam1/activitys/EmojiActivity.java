package com.ad.exam1.activitys;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ad.exam1.R;
import com.ad.exam1.adapters.EmojiAdapter;
import com.ad.exam1.data.EmojisRetriever;
import com.ad.exam1.models.Emoji;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmojiActivity extends AppCompatActivity {
    //private List<String> things = new ArrayList<>(Arrays.asList("hey", "test"));
    private ListView listView;
    private List<Emoji> emojis;
    private String imgURL;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emoji);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");


        emojis = EmojisRetriever.getInstance().getEmojiList(getApplicationContext());
        bindViews();
        addNewEmoji();

        if (name !=null) {
            String imgURL = "file:"+intent.getStringExtra("image");

            Emoji newEmoji = new Emoji(name,imgURL);
            emojis.add(0,newEmoji);
            listView.setAdapter((ArrayAdapter)getAdapter());

        } else {

            listView.setAdapter((ArrayAdapter)getAdapter());

        }




    }

    private void addNewEmoji() {
        FloatingActionButton fab = findViewById(R.id.addEmoji);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CameraActivity.class);
                startActivity(intent);
            }
        });
    }

    private Adapter getAdapter() {
        return new EmojiAdapter(getApplicationContext(), emojis);
    }



    private void bindViews() {
        listView = findViewById(R.id.listView);
    }



}
