package unimyiw.carparkingmanagement2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.String;
import java.sql.Array;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthProvider;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_LOGIN= 1000;

    EditText input;
    String phoneNo;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button doneButton = (Button)findViewById(R.id.doneButton);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser() != null) {

            //If already logged in
            if (!FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().isEmpty()) {
                startActivity(new Intent(this, HomeScreen.class)
                        .putExtra("phone", FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().isEmpty())
                );
                finish();
            }
        }
        else{
            startActivityForResult(AuthUI.getInstance()
                .createSignInIntentBuilder().setAvailableProviders(Arrays.asList(
                                new AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build()
                        )).build(),REQUEST_LOGIN);
            }
    }

        //Activity for doneButton
        /*doneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                phoneNo = input.getText().toString();

                // Start NewActivity.class
                    Intent myIntent = new Intent(MainActivity.this,
                            SMSVerify.class);
                    startActivity(myIntent);
            }
        });*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_LOGIN){
            IdpResponse response = IdpResponse.fromResultIntent(data);

            //Successfully signed in
            if(resultCode == RESULT_OK){
                if(!FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().isEmpty()){
                    startActivity(new Intent(this,HomeScreen.class).putExtra("phone",FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber()));
                    finish();
                    return;
                }
                else{
                    //sign in failed
                    if(response == null) {
                        Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (response.getErrorCode() == ErrorCodes.NO_NETWORK) {
                        Toast.makeText(this, "No Internet", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (response.getErrorCode() == ErrorCodes.UNKNOWN_ERROR) {
                        Toast.makeText(this, "Unknown Error", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                Toast.makeText(this,"Unknown Sign Error!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}