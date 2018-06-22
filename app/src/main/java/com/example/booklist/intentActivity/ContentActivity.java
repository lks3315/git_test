package com.example.booklist.intentActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.booklist.R;
import com.example.booklist.model.Book;
import com.example.booklist.videoView.VideoPlay;

public class ContentActivity extends AppCompatActivity implements View.OnClickListener{
    Book book;
    ImageView imageView;
    TextView textView1,textView2,textView3,textView4;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        imageView = (ImageView)findViewById(R.id.imageView);
        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView4 = (TextView)findViewById(R.id.textView4);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);

        Intent fromIntent = getIntent();
        book = (Book)fromIntent.getSerializableExtra("book");
        textView1.setText(book.getSubject());
        textView2.setText(book.getWriter());
        textView3.setText(book.getPublisher());
        textView4.setText(book.getStroy());
        imageView.setImageResource(book.getImage());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, VideoPlay.class);
                startActivity(intent);
                break;
        }
    }
}
