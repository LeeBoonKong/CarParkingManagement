package unimyiw.carparkingmanagement2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TopUp extends AppCompatActivity {
    DatabaseReference mUserRef = FirebaseDatabase.getInstance().getReference("users");
    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();


    Button topUpTen;
    Button topUpTwenty;
    Button topUpThirty;
    Button topUpForty;
    Button topUpFifty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        topUpTen = (Button) findViewById(R.id.topUpTen);
        topUpTwenty = (Button) findViewById(R.id.topUpTwenty);
        topUpThirty = (Button) findViewById(R.id.topUpThirty);
        topUpForty = (Button) findViewById(R.id.topUpForty);
        topUpFifty = (Button) findViewById(R.id.topUpFifty);

        topUpTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserRef.addListenerForSingleValueEvent(
                        new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                User user = dataSnapshot.child(currentFirebaseUser.getUid()).getValue(User.class);
                                double credit = Double.parseDouble(user.getCredit());
                                credit += 10.00;
                                mUserRef.child(currentFirebaseUser.getUid()).child("credit").setValue(Double.toString(credit));
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

            }
        });

        topUpTwenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserRef.addListenerForSingleValueEvent(
                        new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                User user = dataSnapshot.child(currentFirebaseUser.getUid()).getValue(User.class);
                                double credit = Double.parseDouble(user.getCredit());
                                credit += 20.00;
                                mUserRef.child(currentFirebaseUser.getUid()).child("credit").setValue(Double.toString(credit));
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

            }
        });

        topUpThirty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserRef.addListenerForSingleValueEvent(
                        new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                User user = dataSnapshot.child(currentFirebaseUser.getUid()).getValue(User.class);
                                double credit = Double.parseDouble(user.getCredit());
                                credit += 30.00;
                                mUserRef.child(currentFirebaseUser.getUid()).child("credit").setValue(Double.toString(credit));
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

            }
        });

        topUpForty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserRef.addListenerForSingleValueEvent(
                        new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                User user = dataSnapshot.child(currentFirebaseUser.getUid()).getValue(User.class);
                                double credit = Double.parseDouble(user.getCredit());
                                credit += 40.00;
                                mUserRef.child(currentFirebaseUser.getUid()).child("credit").setValue(Double.toString(credit));
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

            }
        });

        topUpFifty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserRef.addListenerForSingleValueEvent(
                        new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                User user = dataSnapshot.child(currentFirebaseUser.getUid()).getValue(User.class);
                                double credit = Double.parseDouble(user.getCredit());
                                credit += 50.00;
                                mUserRef.child(currentFirebaseUser.getUid()).child("credit").setValue(Double.toString(credit));
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

            }
        });

    }
}
