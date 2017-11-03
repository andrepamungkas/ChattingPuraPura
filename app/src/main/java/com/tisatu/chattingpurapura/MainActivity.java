package com.tisatu.chattingpurapura;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String PREF = "pref";
    public static final String PREF_CHAT = "chat";

    SharedPreferences mPrefs;
    ChatAdapter adapter;

    RecyclerView recyclerChat;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerChat = (RecyclerView) findViewById(R.id.recycler_chat);

        mPrefs = getSharedPreferences(PREF, MODE_PRIVATE);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerChat.setLayoutManager(layoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Gson gson = new Gson();
        List<ChatItem> daftarChat = new ArrayList<>();
        if (mPrefs.contains(PREF_CHAT)) {
            ChatModel chat = gson.fromJson(mPrefs.getString(PREF_CHAT, ""), ChatModel.class);
            if (chat != null) {
                daftarChat = chat.getItem();
                adapter = new ChatAdapter(this, daftarChat);
                recyclerChat.setAdapter(adapter);
            }
        }
    }

    public void onTambahClick(View view) {
        startActivity(TambahChatActivity.getStartIntent(this));
    }
}
