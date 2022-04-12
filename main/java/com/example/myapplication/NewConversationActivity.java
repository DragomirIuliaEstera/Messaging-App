package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class NewConversationActivity extends AppCompatActivity {
public static final String TAG = "NewConversationActivity";
public static final String EXTRA_TEXT ="com.example.myapplication.EXTRA_TEXT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_conversation);

        Button startNewConversation = findViewById(R.id.buttonStartNewConversation);
        startNewConversation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextPhoneNo = findViewById(R.id.editTextTypePhoneNo);
                String phoneNumber = editTextPhoneNo.getText().toString();
                Intent intent = new Intent(NewConversationActivity.this,MessagesConversation.class);
                intent.putExtra(EXTRA_TEXT, phoneNumber);
                startActivity(intent);
            }
        });
    }

}