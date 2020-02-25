package com.ad.exam1.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ad.exam1.R;
import com.ad.exam1.adapters.EmojiAdapter;
import com.ad.exam1.data.EmojisRetriever;
import com.ad.exam1.models.Emoji;
import com.google.gson.Gson;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
   private List<String> things = new ArrayList<>(Arrays.asList("hey", "test"));
    private ListView listView;
    private List<Emoji> emojis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emojis = EmojisRetriever.getInstance().getEmojiList(getApplicationContext());

        bindViews();
        listView.setAdapter((ArrayAdapter)getAdapter());
/*
        //List<Emoji> emojis = EmojisRetriever.getInstance().getEmojiList(getApplicationContext());
       Toast t = Toast.makeText(getApplicationContext(), emojis.get(5).getName(), Toast.LENGTH_LONG);
        t.show();
*/

    }

    private Adapter getAdapter() {
        return new EmojiAdapter(getApplicationContext(), emojis);
    }



private void bindViews() {
    listView = findViewById(R.id.listView);
}
}
