// FeedAdapter.java

package com.example.kitsune;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.PostViewHolder> {

    private List<Post> postList;

    public FeedAdapter(List<Post> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sn_item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = postList.get(position);

        // Bind data to views in the PostViewHolder
        holder.userProfilePicture.setImageResource(post.getUserProfilePicture());
        holder.userName.setText(post.getUserName());
        holder.postTimestamp.setText(post.getPostTimestamp());
        holder.postCaption.setText(post.getPostCaption());
        holder.postImage.setImageResource(post.getPostImage());
        holder.likeCount.setText(String.valueOf(post.getLikeCount()));
        holder.commentCount.setText(String.valueOf(post.getCommentCount()));
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        ImageView userProfilePicture;
        TextView userName, postTimestamp, postCaption, likeCount, commentCount;
        ImageView postImage;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            userProfilePicture = itemView.findViewById(R.id.profile_picture);
            userName = itemView.findViewById(R.id.user_name);
            postTimestamp = itemView.findViewById(R.id.post_timestamp);
            postCaption = itemView.findViewById(R.id.post_caption);
            postImage = itemView.findViewById(R.id.post_image);
            likeCount = itemView.findViewById(R.id.like_count);
            commentCount = itemView.findViewById(R.id.comment_count);
        }
    }
}

