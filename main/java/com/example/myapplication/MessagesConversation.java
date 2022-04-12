package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;
import java.util.List;

import threads.ClientThread;

public class MessagesConversation extends AppCompatActivity {

    public String phoneNo;
    public static final String TAG ="MessagesConversation";
    Toolbar toolbar;
    Button btnSend;
    EditText editMessage;
    EditText txtResult;
    List<String> msgList;
    MessagesConversationAdapter messagesConversationAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages_conversation);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,true));//true ca sa fie de jos in sus
        Helper.setMessagesList(Arrays.asList(new String[]{"a", "b"}));//TODO: get list from server
        msgList = Helper.getMessagesList();
        messagesConversationAdapter =  new MessagesConversationAdapter(msgList);
        recyclerView.setAdapter(messagesConversationAdapter);
                /*, new Action<String>() {
            @Override
            public void perform(String args) {
                Toast.makeText(StudyActivity.this,args, Toast.LENGTH_SHORT).show();
            }
        }));*/
        Intent intent = getIntent();
        phoneNo = intent.getStringExtra(NewConversationActivity.EXTRA_TEXT);
        Log.i(TAG, phoneNo);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(phoneNo);
        setSupportActionBar(toolbar);

        btnSend = findViewById(R.id.buttonSend);
        editMessage = findViewById(R.id.editMessage);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Helper.addToMessagesList(editMessage.getText().toString());
                msgList = Helper.getMessagesList();
                messagesConversationAdapter.setMessagesList(msgList);
                recyclerView.setAdapter(messagesConversationAdapter);
                new ClientThread(Constants.IP, Constants.PORT,editMessage.getText().toString()).start();
            }
        });
    }
}