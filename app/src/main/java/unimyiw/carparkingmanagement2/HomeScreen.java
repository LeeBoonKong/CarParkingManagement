package unimyiw.carparkingmanagement2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
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
            //
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
