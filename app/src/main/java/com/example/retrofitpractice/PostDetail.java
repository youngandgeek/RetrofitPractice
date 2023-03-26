package com.example.retrofitpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PostDetail extends AppCompatActivity {

    TextView userIdTv,idTv,titleTv,bodyTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        userIdTv=findViewById(R.id.user_id_tv);
        idTv=findViewById(R.id.id_tv);
        titleTv=findViewById(R.id.title_tv);
        bodyTv=findViewById(R.id.body_tv);
        Bundle extras=getIntent().getExtras();
        if (extras!=null){

            String userId=Integer.toString(Integer.parseInt(extras.getString("post_user")));
            String postId=Integer.toString(Integer.parseInt(extras.getString("post_id")));
            String postTitle=extras.getString("post_title");
            String postBody=extras.getString("post_body");

            userIdTv.setText(userId);
            idTv.setText(postId);
            titleTv.setText(postTitle);
            bodyTv.setText(postBody);
        }
    }
}