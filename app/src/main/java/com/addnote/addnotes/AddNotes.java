package com.addnote.addnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNotes extends AppCompatActivity {

    EditText title,description;
    Button addNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        addNote = findViewById(R.id.addNote);

        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(title.getText().toString().isEmpty() ) {
                    Toast.makeText(AddNotes.this, "Both fields Required!!", Toast.LENGTH_SHORT).show();
                    return;

                }
                if(description.getText().toString().isEmpty()) {
                    Toast.makeText(AddNotes.this, "Both fields Required!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{

                    DatabaseClass db = new DatabaseClass(AddNotes.this);
                    db.addNotes(title.getText().toString(),description.getText().toString());

                    Intent intent = new Intent(AddNotes.this , MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();

                }

            }
        });

    }
}