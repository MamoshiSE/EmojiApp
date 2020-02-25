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
    private Uri imageURL;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emoji);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String imgURL = intent.getStringExtra("image");

        emojis = EmojisRetriever.getInstance().getEmojiList(getApplicationContext());



        if (name !=null) {

            Emoji newEmoji = new Emoji(name,"url");
            imageURL = Uri.parse(imgURL);
            emojis.add(0,newEmoji);
            bindViews();
            listView.setAdapter((ArrayAdapter)getAdapter());

            addNewEmoji();

            Toast toast = Toast.makeText(this, imgURL, Toast.LENGTH_LONG);
            toast.show();
        } else {
            bindViews();
            listView.setAdapter((ArrayAdapter)getAdapter());

            addNewEmoji();
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
