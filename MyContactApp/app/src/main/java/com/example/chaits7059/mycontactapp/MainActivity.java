package com.example.chaits7059.mycontactapp;

import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName;
    EditText editAge;
    EditText editAddress;
    Button btnAddData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        editName = (EditText) findViewById(R.id.editText_name);
        editAge = (EditText) findViewById(R.id.editText_age);
        editAddress = (EditText) findViewById(R.id.editText_address);
    }

    public void addData(View v) {
        boolean isInserted = myDb.insertData(editName.getText().toString(), editAge.getText().toString(), editAddress.getText().toString());
        if (isInserted == true) {
            Log.d("MyContactt", "Data insertion successful");
            Toast.makeText(MainActivity.this, "SUCCESS: Your Data Has Been Inserted",
                    Toast.LENGTH_LONG).show();
        }

        else {
            Log.d("MyContactt", "Data insertion NOT successful");
            Toast.makeText(MainActivity.this, "FAILURE: Your Data Has Not Been Inserted",
                    Toast.LENGTH_LONG).show();
        }

    }

    public void viewData(View v){
        Cursor res = myDb.getAllData();
        if (res.getCount() == 0) {
            showMessage("Error", "No data found in database");
            Log.d("MyContactt", "Error: No data found in database");
            Toast.makeText(MainActivity.this, "ERROR: No Data found in database",
                    Toast.LENGTH_LONG).show();
            return;
        }

        StringBuffer buffer = new StringBuffer();


        //set up a loop with Cursor moveToNext Method
        //    append each COL to buffer
        //use the getString method

        showMessage("Data", buffer.toString());


    }

    private void showMessage(String error, String s) {

    }

}
