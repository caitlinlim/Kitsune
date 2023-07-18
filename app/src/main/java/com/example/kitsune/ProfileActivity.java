// ProfileActivity.java

package com.example.kitsune;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sn_profile);

        // Initialize and set up the bottom navigation view
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.inflateMenu(R.menu.bottom_navigation_menu);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_explore:
                        // Handle Explore button click (e.g., navigate to ExploreActivity)
                        // Replace ExploreActivity.class with your Explore activity class.
                        startActivity(new Intent(ProfileActivity.this, ExploreActivity.class));
                        return true;
                    case R.id.menu_feed:
                        // Handle Feed button click (e.g., navigate to FeedActivity)
                        // Replace FeedActivity.class with your Feed activity class.
                        startActivity(new Intent(ProfileActivity.this, FeedActivity.class));
                        return true;
                    case R.id.menu_profile:
                        // Handle Profile button click (e.g., navigate to ProfileActivity)
                        // Replace ProfileActivity.class with your Profile activity class.
                        startActivity(new Intent(ProfileActivity.this, ProfileActivity.class));
                        return true;
                }
                return false;
            }
        });

        // Set up the RecyclerView for achievements
        RecyclerView achievementsRecyclerView = findViewById(R.id.achievements_recycler_view);
        achievementsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> achievementsList = generateAchievements();
        AchievementsAdapter achievementsAdapter = new AchievementsAdapter(achievementsList);
        achievementsRecyclerView.setAdapter(achievementsAdapter);

        // Set up the RecyclerView for progress updates
        RecyclerView progressUpdatesRecyclerView = findViewById(R.id.progress_updates_recycler_view);
        progressUpdatesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Post> progressUpdatesList = generateProgressUpdates();
        ProgressUpdatesAdapter progressUpdatesAdapter = new ProgressUpdatesAdapter(progressUpdatesList);
        progressUpdatesRecyclerView.setAdapter(progressUpdatesAdapter);
    }

    // Method to generate sample achievements for demonstration purposes
    private List<String> generateAchievements() {
        List<String> achievementsList = new ArrayList<>();
        // Add sample achievements here
        achievementsList.add("Completed 5K Run");
        achievementsList.add("100 Days of Yoga!");
        achievementsList.add("Feeling hydrated :)");
        return achievementsList;
    }

    // Method to generate sample progress updates for demonstration purposes
    private List<Post> generateProgressUpdates() {
        List<Post> progressUpdatesList = new ArrayList<>();
        // Add sample progress updates here
        progressUpdatesList.add(new Post(R.drawable.default_profile_picture, "Jane Doe", "July 30, 2023", "Working hard to achieve my fitness goals!", R.drawable.profile_post_image_1, 52, 14));
        progressUpdatesList.add(new Post(R.drawable.default_profile_picture, "Jane Doe", "July 29, 2023", "Feeling great after today's workout!", R.drawable.profile_post_image_2, 18, 10));
        return progressUpdatesList;
    }

    public class AchievementsAdapter extends RecyclerView.Adapter<AchievementsAdapter.AchievementViewHolder> {

        private List<String> achievementsList;

        public AchievementsAdapter(List<String> achievementsList) {
            this.achievementsList = achievementsList;
        }

        @NonNull
        @Override
        public AchievementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sn_item_achievement, parent, false);
            return new AchievementViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull AchievementViewHolder holder, int position) {
            String achievement = achievementsList.get(position);
            holder.achievementTextView.setText(achievement);
        }

        @Override
        public int getItemCount() {
            return achievementsList.size();
        }

        class AchievementViewHolder extends RecyclerView.ViewHolder {
            TextView achievementTextView;

            public AchievementViewHolder(@NonNull View itemView) {
                super(itemView);
                achievementTextView = itemView.findViewById(R.id.achievement_text);
            }
        }
    }

    public static class ProgressUpdatesAdapter extends RecyclerView.Adapter<ProgressUpdatesAdapter.ProgressUpdatesViewHolder> {

        private List<Post> progressUpdatesList;

        public ProgressUpdatesAdapter(List<Post> progressUpdatesList) {
            this.progressUpdatesList = progressUpdatesList;
        }

        @NonNull
        @Override
        public ProgressUpdatesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_progress_update, parent, false);
            return new ProgressUpdatesViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull ProgressUpdatesViewHolder holder, int position) {
            Post progressUpdate = progressUpdatesList.get(position);
            holder.postCaptionTextView.setText(progressUpdate.getPostCaption());
            holder.postImageView.setImageResource(progressUpdate.getPostImage());
            holder.likeCountTextView.setText(String.valueOf(progressUpdate.getLikeCount()));
            holder.commentCountTextView.setText(String.valueOf(progressUpdate.getCommentCount()));
        }

        @Override
        public int getItemCount() {
            return progressUpdatesList.size();
        }

        static class ProgressUpdatesViewHolder extends RecyclerView.ViewHolder {
            TextView postCaptionTextView;
            ImageView postImageView;
            TextView likeCountTextView;
            TextView commentCountTextView;

            public ProgressUpdatesViewHolder(@NonNull View itemView) {
                super(itemView);
                postCaptionTextView = itemView.findViewById(R.id.pu_caption);
                postImageView = itemView.findViewById(R.id.pu_image);
                likeCountTextView = itemView.findViewById(R.id.pu_like_count);
                commentCountTextView = itemView.findViewById(R.id.pu_comment_count);
            }
        }
    }
}

