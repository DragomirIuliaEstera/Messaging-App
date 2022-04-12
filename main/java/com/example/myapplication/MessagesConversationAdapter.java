package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessagesConversationAdapter extends RecyclerView.Adapter<MessagesConversationAdapter.MyViewHolder> {
    public MessagesConversationAdapter(List<String> messages) {
        this.messagesList = messages;
    }
    public void setMessagesList(List<String> messages) {
        this.messagesList = messages;
    }

    List<String> messagesList;
    //Action<String> onContinentSelected;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.messages_item, parent, false);
        /*view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onContinentSelected.perform((String) v.getTag(R.id.item));
            }
        });*/
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.msg.setText(messagesList.get(position));
    }

    @Override
    public int getItemCount() {
        if(messagesList != null)
            return messagesList.size();
        return -1;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView msg;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            msg = itemView.findViewById(R.id.message);
        }
    }
}
