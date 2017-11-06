package unimyiw.carparkingmanagement2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SMSVerify extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsverify);

        Button verifyButton = (Button)findViewById(R.id.verifyButton);

        verifyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Start NewActivity.class
                Intent myIntent = new Intent(SMSVerify.this,
                        HomeScreen.class);
                startActivity(myIntent);
            }
        });
    }
}
