package unimyiw.carparkingmanagement2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

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
}
