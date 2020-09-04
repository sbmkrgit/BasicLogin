package com.example.basiclogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userName,pass;
    Button btn1;
    TextView txt2;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText userName = (EditText)findViewById(R.id.userName);
        final EditText pass = (EditText)findViewById(R.id.pass);
        final Button btn1 = (Button)findViewById(R.id.btn1);
        final TextView txt2 = (TextView)findViewById(R.id.txt2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userName.length()==0)
                {
                    userName.requestFocus();
                    userName.setError("Please enter user name !");
                }
                else if(pass.length()==0){
                    pass.requestFocus();
                    pass.setError("Please enter password !");
                }
                else if(userName.getText().toString().equals("admin") &&
                        pass.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Login Successful",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                    counter--;
                    txt2.setText(Integer.toString(counter));

                    if (counter == 0) {
                        btn1.setEnabled(false);
                    }
                }
            }
        });
    }
}