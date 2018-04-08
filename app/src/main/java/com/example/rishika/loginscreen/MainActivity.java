package com.example.rishika.loginscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username , password ;
    Button submit , reset ;
    TextView attempts;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        submit = (Button)findViewById(R.id.submit);
        reset = (Button)findViewById(R.id.reset);
        attempts = (TextView)findViewById(R.id.attempts);

        submit.setOnClickListener((View.OnClickListener) this);
        reset.setOnClickListener((View.OnClickListener) this);

    }

    public void onClick(View v) {
        if(v.getId() == R.id.submit)
        {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            if(user.equals("Rishika") && pass.equalsIgnoreCase( "Rishika"))
            {
                Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();

                counter = 3;
                attempts.setVisibility(TextView.INVISIBLE);
            }
            else
            {
                attempts.setVisibility(TextView.VISIBLE);
                attempts.setText("Attempts Remaining : "+(--counter));
                if(counter == 0)
                {
                    submit.setEnabled(false);
                }
            }
        }
        if(v.getId()==R.id.reset)
        {
            username.setText("");
            password.setText("");
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

