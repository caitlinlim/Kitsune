// FeedActivity.java

package com.example.kitsune;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class FeedActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sn_feed);

        RecyclerView feedRecyclerView = findViewById(R.id.posts_recycler_view);
        feedRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Post> postList = generateSamplePosts();

        FeedAdapter feedAdapter = new FeedAdapter(postList);
        feedRecyclerView.setAdapter(feedAdapter);
    }

    // Method to generate sample posts for demonstration purposes
    private List<Post> generateSamplePosts() {
        List<Post> postList = new ArrayList<>();
        // Add sample posts here
        postList.add(new Post(R.drawable.user_profile_pic_1, "John Doe", "2023-07-25", "Working on my fitness goals!", R.drawable.post_image_1, 25, 8));
        postList.add(new Post(R.drawable.user_profile_pic_2, "Emily Li", "2023-07-24", "Completed a challenging workout today!", R.drawable.post_image_2, 42, 12));
        return postList;
    }
}


