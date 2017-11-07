package unimyiw.carparkingmanagement2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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
            Intent myIntent = new Intent(HomeScreen.this,QRCode.class);
            startActivity(myIntent);
        case R.id.topUpButton:
            // Start QRCode.class
    }
        return(super.onOptionsItemSelected(item));
    }
}
