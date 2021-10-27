package com.eltmobile.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ThreadLocalRandom;
public class MainActivity extends AppCompatActivity {
    /**
     * A simple app that demonstrate (CRUD) persistent storage
     * using shared preference
     * by Godswill Okon
     *
     * */

    Button buttonCreate, buttonRead, buttonUpdate, buttonDelete;
    EditText mEditText;
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setting members variable
        buttonCreate = (Button) findViewById(R.id.buttonCreate);
        buttonRead   = (Button) findViewById(R.id.buttonRead);
        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);

        mEditText = (EditText)  findViewById(R.id.edittextValue);
        mTextView = (TextView)  findViewById(R.id.textView);

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedEditText(editTextString());
                editTextSetText();
            }
        });

        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String myString = SharedPref.getAllPreference(getApplicationContext());
            mTextView.setText(myString);
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.setStringPreference(getApplicationContext(), editTextString(),"Updated");
                Toast.makeText(getApplicationContext(), getString(R.string.Data_updated),
                Toast.LENGTH_LONG).show();
                editTextSetText();

            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.deleteFromPreference(getApplicationContext(), editTextString());
                Toast.makeText(getApplicationContext(), getString(R.string.data_deleted),
                        Toast.LENGTH_LONG).show();
                editTextSetText();

            }
        });

     }

        public void sharedEditText(String editTextString){
            //generating random numbers for key
            int random = ThreadLocalRandom.current().nextInt(1, 50);
            String intString = String.valueOf(random);
            //calling shared preference
            SharedPref.setStringPreference(getApplicationContext(), intString, editTextString);
            Toast.makeText(getApplicationContext(), getString(R.string.sharedinfo) +" "+ intString,
            Toast.LENGTH_LONG).show();
       }

        public String editTextString(){
        return mEditText.getText().toString();
     }

        public void editTextSetText(){
        mEditText.setText("");
    }

 }