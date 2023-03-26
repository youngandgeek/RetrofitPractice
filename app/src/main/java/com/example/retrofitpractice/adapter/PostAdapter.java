package com.example.retrofitpractice.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitpractice.PostDetail;
import com.example.retrofitpractice.R;
import com.example.retrofitpractice.model.PostModel;

import java.util.List;

import retrofit2.Callback;

public class PostAdapter extends  RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    Context context;
    List<PostModel> postModelList;
private static RecyclerViewOnItemClick recyclerViewOnItemClick;

    public PostAdapter(Context context, List<PostModel> postModelList, RecyclerViewOnItemClick recyclerViewOnItemClick) {
        this.context =  context;
        this.postModelList = postModelList;
        this.recyclerViewOnItemClick=recyclerViewOnItemClick;

    }

 /**   public PostAdapter(Context context, List<PostModel> postModelList) {
        this.context =  context;
        this.postModelList = postModelList;
    }
**/
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout(post_item)
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item,parent,false);
               return new PostViewHolder(view);
    }

    public void setPostModelList(List<PostModel> postModelList) {
        this.postModelList = postModelList;
        notifyDataSetChanged();
    }



    public static final class PostViewHolder extends RecyclerView.ViewHolder{
        /*Declare the view of the post_item layout here(just give the views an object
        we will define them in the constructor (public postView holder(itemView).
        */
        TextView userIdTv , idTv , titleTv,bodyTv;  // the textViews in post_item layout.
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            /*An ItemView in Android can be described as a single row item in a list.
              It references an item from where we find the view from its layout file.*/
            //userId and other TextViews are the object we created in postViewHolder class
         userIdTv=itemView.findViewById(R.id.user_id_tv);
         idTv=itemView.findViewById(R.id.id_tv);
         titleTv=itemView.findViewById(R.id.title_tv);
         bodyTv=itemView.findViewById(R.id.body_tv);
         itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 recyclerViewOnItemClick.onItemClick(getAdapterPosition());
             }
         });
        }
    }



    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
   /**called by RecyclerView to display the data at the specified position.
     *This method is used to update the contents of the itemView to reflect the item at the given position.
     * holder.TextViewObj.setText(List.get(position).getMethod());
    */
        /**  PostModel postData=(PostModel) postModelList.get(position);
       holder.userIdTv.setText(Integer.parseInt(String.valueOf(postList.get(position).getUserId()))); //postList is the list we created in post Adapter class
**/
        holder.userIdTv.setText(Integer.toString(postModelList.get(position).getUserId()).toString());
        holder.idTv.setText(Integer.toString(postModelList.get(position).getId()).toString());
       /**holder.idTv.setText(Integer.toString(postModelList.get(position).getId()));
       * holder.idTv.setText(Integer.toString(postData.getId()));//getId from the getter method in PostModel class
        */
        holder.titleTv.setText(postModelList.get(position).getTitle().toString());
        holder.bodyTv.setText(postModelList.get(position).getBody().toString());



    }


    @Override
    public int getItemCount() {
        return postModelList.size();
    }
public interface RecyclerViewOnItemClick{
        void onItemClick(int position);

}
}