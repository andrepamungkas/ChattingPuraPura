package com.tisatu.chattingpurapura;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andre on 11/3/2017.
 */

public class ChatModel {
    List<ChatItem> item = new ArrayList<>();

    public List<ChatItem> getItem() {
        return item;
    }

    public void setItem(List<ChatItem> item) {
        this.item = item;
    }
}

class ChatItem {
    private String pengirim;
    private String konten;
    private String waktu;
    private int foto;

    public ChatItem(String pengirim, String konten, String waktu, int foto) {
        this.pengirim = pengirim;
        this.konten = konten;
        this.waktu = waktu;
        this.foto = foto;
    }

    public String getPengirim() {
        return pengirim;
    }

    public void setPengirim(String pengirim) {
        this.pengirim = pengirim;
    }

    public String getContent() {
        return konten;
    }

    public void setContent(String konten) {
        this.konten = konten;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}