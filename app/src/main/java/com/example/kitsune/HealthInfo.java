package com.example.kitsune;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class HealthInfo extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    Button submit;

    EditText bmiText, heightText, weightText;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_info);
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String uid = user.getUid();

        Map<String, Object> map = new HashMap<>();

        submit = findViewById(R.id.h_submit);
        weightText = findViewById(R.id.weightText);
        heightText = findViewById(R.id.heightText);
        bmiText = findViewById(R.id.bmiText);



        db.collection("users")
                        .document(uid)
                                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.contains("Weight"))
                            weightText.setText(documentSnapshot.getLong("Weight").toString());

                        if(documentSnapshot.contains("Height"))
                            heightText.setText(documentSnapshot.getLong("Height").toString());

                        if(documentSnapshot.contains("BMI"))
                            bmiText.setText(documentSnapshot.getLong("BMI").toString());
                    }
                });



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String w = weightText.getText().toString();
                String h = heightText.getText().toString();
                String b = bmiText.getText().toString();

                int w1 = Integer.parseInt(w);
                int h1 = Integer.parseInt(h);
                int b1 = Integer.parseInt(b);

                map.put("Weight", w1);
                map.put("Height",h1);
                map.put("BMI",b1);

                db.collection("users")
                        .document(uid)
                        .set(map).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("com.example.kitsune", "Error adding document", e);
                            }
                        });
            }
        });


    }


}

