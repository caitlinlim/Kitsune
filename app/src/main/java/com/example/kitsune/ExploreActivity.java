package com.example.kitsune;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ExploreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sn_explore);

        RecyclerView recommendedTrainersRecyclerView = findViewById(R.id.recommended_trainers_recycler_view);
        recommendedTrainersRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Trainer> trainerList = generateSampleTrainers();
        TrainerAdapter trainerAdapter = new TrainerAdapter(trainerList);
        recommendedTrainersRecyclerView.setAdapter(trainerAdapter);

        RecyclerView recommendedPostsRecyclerView = findViewById(R.id.recommended_posts_recycler_view);
        recommendedPostsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Post> postList = generateSamplePosts();
        PostAdapter postAdapter = new PostAdapter(postList);
        recommendedPostsRecyclerView.setAdapter(postAdapter);
    }

    private List<Trainer> generateSampleTrainers() {
        List<Trainer> trainerList = new ArrayList<>();
        // Add sample trainers here
        trainerList.add(new Trainer("Leah Davis", "New York, USA", R.drawable.default_profile_picture));
        trainerList.add(new Trainer("Sam Patel", "San Francisco, USA", R.drawable.default_profile_picture));
        trainerList.add(new Trainer("Michael Smith", "New York, USA", R.drawable.default_profile_picture));
        return trainerList;
    }

    private List<Post> generateSamplePosts() {
        List<Post> postList = new ArrayList<>();
        // Add sample posts here
        postList.add(new Post(R.drawable.profile_pic_3, "Rachel Kaj", "July 30, 2023", "30 days of yoga almost complete!", R.drawable.sample_post_image, 42, 12));
        postList.add(new Post(R.drawable.default_profile_picture, "Alex Long", "July 29, 2023", "Just finished a new workout today :)", R.drawable.sample_post_image, 31, 8));
        return postList;
    }

    private static class TrainerAdapter extends RecyclerView.Adapter<TrainerAdapter.TrainerViewHolder> {

        private List<Trainer> trainerList;

        public TrainerAdapter(List<Trainer> trainerList) {
            this.trainerList = trainerList;
        }

        @NonNull
        @Override
        public TrainerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sn_item_trainer, parent, false);
            return new TrainerViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull TrainerViewHolder holder, int position) {
            Trainer trainer = trainerList.get(position);
            holder.trainerNameTextView.setText(trainer.getName());
            holder.trainerLocationTextView.setText(trainer.getLocation());
            holder.trainerProfileImageView.setImageResource(trainer.getProfileImageResId());
        }

        @Override
        public int getItemCount() {
            return trainerList.size();
        }

        static class TrainerViewHolder extends RecyclerView.ViewHolder {
            ImageView trainerProfileImageView;
            TextView trainerNameTextView;
            TextView trainerLocationTextView;

            public TrainerViewHolder(@NonNull View itemView) {
                super(itemView);
                trainerProfileImageView = itemView.findViewById(R.id.trainer_profile_image);
                trainerNameTextView = itemView.findViewById(R.id.trainer_name);
                trainerLocationTextView = itemView.findViewById(R.id.trainer_location);
            }
        }
    }

    public static class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

        private List<Post> postList;

        public PostAdapter(List<Post> postList) {
            this.postList = postList;
        }

        @NonNull
        @Override
        public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sn_rec_item_post, parent, false);
            return new PostViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
            Post post = postList.get(position);
            holder.userProfileImageView.setImageResource(post.getUserProfilePicture());
            holder.userNameTextView.setText(post.getUserName());
            holder.postTimestampTextView.setText(post.getPostTimestamp());
            holder.postCaptionTextView.setText(post.getPostCaption());
            holder.postImageView.setImageResource(post.getPostImage());
            holder.likeCountTextView.setText(String.valueOf(post.getLikeCount()));
            holder.commentCountTextView.setText(String.valueOf(post.getCommentCount()));
        }

        @Override
        public int getItemCount() {
            return postList.size();
        }

        static class PostViewHolder extends RecyclerView.ViewHolder {
            ImageView userProfileImageView;
            TextView userNameTextView;
            TextView postTimestampTextView;
            TextView postCaptionTextView;
            ImageView postImageView;
            TextView likeCountTextView;
            TextView commentCountTextView;

            public PostViewHolder(@NonNull View itemView) {
                super(itemView);
                userProfileImageView = itemView.findViewById(R.id.profile_picture);
                userNameTextView = itemView.findViewById(R.id.user_name);
                postTimestampTextView = itemView.findViewById(R.id.post_timestamp);
                postCaptionTextView = itemView.findViewById(R.id.post_caption);
                postImageView = itemView.findViewById(R.id.post_image);
                likeCountTextView = itemView.findViewById(R.id.like_count);
                commentCountTextView = itemView.findViewById(R.id.comment_count);
            }
        }
    }

}

