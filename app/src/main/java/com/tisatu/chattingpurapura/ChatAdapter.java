package com.tisatu.chattingpurapura;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by andre on 11/3/2017.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    private Context context;
    private List<ChatItem> daftarChat;

    public ChatAdapter(Context context, List<ChatItem> daftarChat) {
        this.context = context;
        this.daftarChat = daftarChat;
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {
        ImageView imageFoto;
        TextView pengirim;
        TextView content;
        TextView waktu;

        public ChatViewHolder(View view) {
            super(view);
            imageFoto = (ImageView) view.findViewById(R.id.image_foto);
            pengirim = (TextView) view.findViewById(R.id.text_pengirim);
            content = (TextView) view.findViewById(R.id.text_konten);
            waktu = (TextView) view.findViewById(R.id.text_waktu);
        }
    }

    @Override
    public ChatAdapter.ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatAdapter.ChatViewHolder holder, int position) {
        holder.imageFoto.setImageResource(daftarChat.get(position).getFoto());
        holder.pengirim.setText(daftarChat.get(position).getPengirim());
        holder.content.setText(daftarChat.get(position).getContent());
        holder.waktu.setText(daftarChat.get(position).getWaktu());
    }

    @Override
    public int getItemCount() {
        return daftarChat.size();
    }
}
