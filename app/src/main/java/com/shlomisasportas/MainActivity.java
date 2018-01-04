package com.shlomisasportas;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Post> allUsers;
    private ProgressDialog dialog;
    ImageView search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new ProgressDialog(this);

        dialog.setMessage("Loading...");
        dialog.show();
        dialog.setCancelable(false);

        search = (ImageView) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainActivity.this, SearchActivity.class);
                startActivity(i);
            }
        });
        allUsers = new ArrayList<>();

        FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference =    mFirebaseDatabase.getReference("allUsers");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
                    Log.v("Database",""+ childDataSnapshot.getKey()); //displays the key for the node
                    //Log.v("Database",""+ childDataSnapshot.child("firstName").getValue());   //gives the value for given keyname
                    Post post = new Post();
                    post.setFirstName(""+childDataSnapshot.child("firstName").getValue());
                    post.setLastName(""+childDataSnapshot.child("lastName").getValue());
                    post.setAge(""+childDataSnapshot.child("age").getValue());
                    post.setDateOfBirth(""+childDataSnapshot.child("dateOfBirth").getValue());
                    post.setDeathLocation(""+childDataSnapshot.child("deathLocation").getValue());
                    post.setDateOfDeath(""+childDataSnapshot.child("dateOfDeath").getValue());
                    post.setMomName(""+childDataSnapshot.child("momName").getValue());
                    post.setDadName(""+childDataSnapshot.child("dadName").getValue());
                    allUsers.add(post);
                }

                dialog.dismiss();

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //addData("Jasson", "Roy", "01/01/1991", "25", "01/01/2017", "India", "Jannifer", "Roy" );

    }

    public void addData(String firstName,String lastName,String dayOfBirth,String Age,String DateOfDeath,
                        String deathLocation,String momsName,String dadName){
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference posts = database.getReference("allUsers");
        //this code for keep posts even app offline until the app online again
        posts.keepSynced(true);

        Post post = new Post();
        post.setFirstName(firstName);
        post.setLastName(lastName);
        post.setAge(Age);
        post.setDateOfBirth(dayOfBirth);
        post.setDadName(dadName);
        post.setMomName(momsName);
        post.setDateOfDeath(DateOfDeath);
        post.setDeathLocation(deathLocation);

        posts.push().setValue(post);
    }
}




