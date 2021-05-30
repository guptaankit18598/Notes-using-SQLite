package com.addnote.addnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateNotes extends AppCompatActivity {

    EditText title , description;
    Button updateNotes;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_notes);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        updateNotes = findViewById(R.id.updateNote);

        Intent intent = getIntent();
        title.setText(intent.getStringExtra("title"));
        description.setText(intent.getStringExtra("description"));
        id = intent.getStringExtra("id");

        updateNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (title.getText().toString().isEmpty()) {
                    Toast.makeText(UpdateNotes.this, "Both fields Required!!", Toast.LENGTH_SHORT).show();
                    return;

                }
                if (description.getText().toString().isEmpty()) {
                    Toast.makeText(UpdateNotes.this, "Both fields Required!!", Toast.LENGTH_SHORT).show();
                    return;
                } else {

                    DatabaseClass db = new DatabaseClass(UpdateNotes.this);
                    db.updateNotes(title.getText().toString(), description.getText().toString(), id);

                    Intent intent = new Intent(UpdateNotes.this , MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
}