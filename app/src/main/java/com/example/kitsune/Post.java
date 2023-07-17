// Post.java
package com.example.kitsune;

public class Post {
    private int userProfilePicture;
    private String userName;
    private String postTimestamp;
    private String postCaption;
    private int postImage;
    private int likeCount;
    private int commentCount;

    public Post(int userProfilePicture, String userName, String postTimestamp, String postCaption, int postImage, int likeCount, int commentCount) {
        this.userProfilePicture = userProfilePicture;
        this.userName = userName;
        this.postTimestamp = postTimestamp;
        this.postCaption = postCaption;
        this.postImage = postImage;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
    }

    public int getUserProfilePicture() {
        return userProfilePicture;
    }

    public String getUserName() {
        return userName;
    }

    public String getPostTimestamp() {
        return postTimestamp;
    }

    public String getPostCaption() {
        return postCaption;
    }

    public int getPostImage() {
        return postImage;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

}
