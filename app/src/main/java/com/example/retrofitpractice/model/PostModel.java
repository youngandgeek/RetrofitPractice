package com.example.retrofitpractice.model;

public class PostModel {
    //add the var name exactly as in the api

    private int userId, id;
    private String title, body;

    /**  public PostModel(int userId, int id, String title, String body) {
     this.userId = userId;
     this.id = id;
     this.title = title;
     this.body = body;
     }
     **/

/**
 public void setUserId(int userId) {

 this.userId = userId;
 }
 public void setId(int id) {
 this.id = id;
 }

 public void setTitle(String title) {
 this.title = title;
 }

 public void setBody(String body) {
 this.body = body;
 }
 */

    /**
     * if u want to change the name of var existed in api add ->
     *
     * @SerializedName("add the var name in json")
     * private String text;
     */
    //only getter methods
    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
