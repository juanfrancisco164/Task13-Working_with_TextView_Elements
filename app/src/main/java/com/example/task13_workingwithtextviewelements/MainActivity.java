package com.example.task13_workingwithtextviewelements;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView comments;
    private Button buttoncomment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comments = findViewById(R.id.comments);
        buttoncomment = findViewById(R.id.buttoncomment);

        buttoncomment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showComment();
            }
        });
    }

    private void showComment() {
        final EditText editTextComment = new EditText(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Comment");
        builder.setView(editTextComment);
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String comment = editTextComment.getText().toString().trim();

                addTextToArticle(comment);
            }
        });
        builder.setNegativeButton("Cancel", null);

        builder.create().show();
    }

    private void addTextToArticle(String comment) {
        if (!comment.isEmpty()) {
            String currentArticleText = comments.getText().toString();
            String newArticleText = currentArticleText + "\n" + comment;
            comments.setText(newArticleText);
        }
    }
}
