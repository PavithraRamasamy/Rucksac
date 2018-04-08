package com.hackoverflow.signinanddatabase.signinanddatabase;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class chat extends AppCompatActivity {
    ArrayList<String> emails = new ArrayList<String>();

    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ;

        DatabaseReference usersRef = rootRef.child("user");
        Map<String, Object> users = new HashMap<>();
        String emailModified = getIntent().getExtras().getString("email");
        if(usersRef.child(emailModified.replace(".","_dot_"))==null) {
            users.put(emailModified.replace(".", "_dot_"), new User(getIntent().getExtras().getString("username")));
            usersRef.updateChildren(users);
        }else{
            System.out.println("USER EXISTS*********************************************************************");
        }
        Common.currentToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("TOKEN***********************",Common.currentToken);
    }
}
