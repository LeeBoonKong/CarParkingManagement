package unimyiw.carparkingmanagement2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class HomeScreen extends AppCompatActivity {

    DatabaseReference mUserRef =  FirebaseDatabase.getInstance().getReference("users");
    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();

    TextView credit;
    TextView phoneNo;
    TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        userName = (TextView) findViewById(R.id.userName);
        phoneNo = (TextView) findViewById(R.id.phoneNumber);
        credit = (TextView) findViewById(R.id.credit);


        mUserRef.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        User user = dataSnapshot.child(currentFirebaseUser.getUid()).getValue(User.class);
                        userName.setText(user.getName());
                        phoneNo.setText(user.getPhoneNo());
                        credit.setText(user.getCredit());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate menu
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { switch(item.getItemId()) {
        case R.id.qrCodeButton:
            // Start QRCode.class
            Intent qrCode = new Intent(HomeScreen.this,QRCode.class);
            startActivity(qrCode);
            return true;
        case R.id.topUpButton:
            Intent topUp = new Intent(HomeScreen.this, TopUp.class);
            startActivity(topUp);
            return true;
        case R.id.mallButton:
            Intent mallStatus = new Intent(HomeScreen.this, MallStatus.class);
            startActivity(mallStatus);
            return true;
        case R.id.signOutButton:
            signOut();
            return true;
    }
        return(super.onOptionsItemSelected(item));
    }

    private void signOut() {
        AuthUI.getInstance().signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        startActivity(new Intent(HomeScreen.this, MainActivity.class));
                        finish();
                    }
                });
    }
}
