package com.tisatu.chattingpurapura;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TambahChatActivity extends AppCompatActivity {

    ChatModel chat;
    SharedPreferences mPrefs;

    EditText inputNama;
    EditText inputKonten;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, TambahChatActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_chat);

        mPrefs = getSharedPreferences(MainActivity.PREF, MODE_PRIVATE);

        inputNama = (EditText) findViewById(R.id.input_nama);
        inputKonten = (EditText) findViewById(R.id.input_konten);
    }

    public void onKirimClick(View view) {
        Gson gson = new Gson();
        List<ChatItem> daftarChat = new ArrayList<>();

        String nama = inputNama.getText().toString();
        String konten = inputKonten.getText().toString();

        if (!nama.isEmpty() || konten.isEmpty()) {
            if (mPrefs.contains(MainActivity.PREF_CHAT)) {
                chat = gson.fromJson(mPrefs.getString(MainActivity.PREF_CHAT, ""), ChatModel.class);
                if (chat != null) {
                    daftarChat = chat.getItem();
                }
            }
            daftarChat.add(new ChatItem(nama, konten, new SimpleDateFormat("dd MMM yy", Locale.US).format(new Date()), R.drawable.profile));
            chat = new ChatModel();
            chat.setItem(daftarChat);
            String json = gson.toJson(chat);

            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putString(MainActivity.PREF_CHAT, json);
            editor.apply();

            startActivity(MainActivity.getStartIntent(this));
        }
    }
}
