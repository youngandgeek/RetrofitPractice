package com.example.retrofitpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.retrofitpractice.adapter.PostAdapter;
import com.example.retrofitpractice.model.ApiInterface;
import com.example.retrofitpractice.model.PostModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//using this fake api https://jsonplaceholder.typicode.com
public class MainActivity extends AppCompatActivity implements PostAdapter.RecyclerViewOnItemClick {

    //declare the recyclerView and recyclerViewAdapter class and List of ModelClass Object

    RecyclerView postRecyclerView;
    PostAdapter postAdapter;
    List<PostModel> postModelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postModelList = new ArrayList<>();
        postRecyclerView = (RecyclerView) findViewById(R.id.posts_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        postRecyclerView.setLayoutManager(layoutManager);
        postAdapter = new PostAdapter(getApplicationContext(), postModelList,this);
        postRecyclerView.setAdapter(postAdapter);

        //consume the REST web service. In Our MainActivity.Java, First, need to initialize the ApiClient.
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        /** After the initialization, we to call the getPosts() method in interface and implement the CallBacks.
         * the Implementation we need to override the onResponse() and onFailure().
         */

        //  Call<List<ModelClass>> getMethod() in the ApiInterface;
        Call<List<PostModel>> call = apiService.getPosts();
        call.enqueue(new Callback<List<PostModel>>() {
            //If the request succeeds the callback will come into onResponse(), show the incoming data in a recyclerview
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                postModelList = response.body();
                Log.d("TAG", "Response = " + postModelList);
                postAdapter.setPostModelList(postModelList);
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                //If any error in the request the callback will go into onFailure() method.
                Log.d("TAG", "Response = " + t.toString());
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Intent postDetailIntent=new Intent(MainActivity.this,PostDetail.class);
        postDetailIntent.putExtra("post_user",Integer.toString(postModelList.get(position).getUserId()).toString());
        postDetailIntent.putExtra("post_id",Integer.toString(postModelList.get(position).getId()).toString());
        postDetailIntent.putExtra("post_title",postModelList.get(position).getTitle());
        postDetailIntent.putExtra("post_body",postModelList.get(position).getBody());
        startActivity(postDetailIntent);
    }
}
