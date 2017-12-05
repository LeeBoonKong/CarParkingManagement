package unimyiw.carparkingmanagement2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MallStatus extends AppCompatActivity implements Spinner.OnItemSelectedListener {

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mMallRef = FirebaseDatabase.getInstance().getReference("Mall");
    
    TextView spaces;
    TextView textViewxt;
    TextView rate1;
    TextView rate2;
    TextView rate3;

    //List<Mall> mallList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall_status);

        //mallList = new ArrayList<>();

        //all the fields
        spaces = (TextView) findViewById(R.id.spaces);
        rate1 = (TextView) findViewById(R.id.rate1);
        rate2 = (TextView) findViewById(R.id.rate2);
        rate3 = (TextView) findViewById(R.id.rate3);

        //Items in spinner (incomplete) // REQUIRES FURTHER WORK
        mMallRef.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        final List<String> categories = new ArrayList<String>();//stuff inside spinner
                        for (DataSnapshot mallSnapshot: dataSnapshot.getChildren()) {
                            String mall = mallSnapshot.child("name").getValue(String.class);
                            categories.add(mall);
                        }
                        //Spinner Element
                        Spinner spinner=(Spinner) findViewById(R.id.spinner);

                        //Spinner click listener
                        spinner.setOnItemSelectedListener(MallStatus.this);
                        //Adapter for spinner
                        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(MallStatus.this,android.R.layout.simple_spinner_item,categories);

                        //Drop down layout style, list view with radio button
                        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        //attaching data adapter to spinner
                        spinner.setAdapter(dataAdapter);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                }
        );
    }

    @Override
    protected void onStart(){super.onStart();}

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //On selecting a spinner item
        final String item = parent.getItemAtPosition(position).toString();

        mMallRef.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String remainingSpaces= dataSnapshot.child(item).child("remainingSpace").getValue(String.class);
                        String firstHour= dataSnapshot.child(item).child("firstHour").getValue(String.class);
                        String perHour= dataSnapshot.child(item).child("perHour").getValue(String.class);
                        String publicHoliday= dataSnapshot.child(item).child("publicHoliday").getValue(String.class);
                        spaces.setText(remainingSpaces);
                        rate1.setText(firstHour);
                        rate2.setText(perHour);
                        rate3.setText(publicHoliday);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                }
        );

        //Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected:" + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0){

    }
}
