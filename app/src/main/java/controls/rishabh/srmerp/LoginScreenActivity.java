package controls.rishabh.srmerp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;


public class LoginScreenActivity extends Activity {
    ProgressDialog progressDialog;
    Button loginbutton;
    EditText password, registrationno;
    String registrationnos, passwords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        registrationno = (EditText) findViewById(R.id.login_registration_no);
        password = (EditText) findViewById(R.id.login_password);
        loginbutton = (Button) findViewById(R.id.login_button);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = ProgressDialog.show(LoginScreenActivity.this,"","Please Wait . . . . .",true);
                registrationnos = registrationno.getText().toString();
                passwords = password.getText().toString();
                if(registrationno.equals("") && passwords.equals("")){
                    Toast.makeText(LoginScreenActivity.this, "Please enter Registration No. and Password", Toast.LENGTH_SHORT).show();
                }
                else{
                ParseUser.logInInBackground(registrationnos, passwords, new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        if(parseUser != null){
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(),"Successfully Logged In", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(LoginScreenActivity.this, WelcomeActivity.class);
                            startActivity(i);
                        }
                        else{
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }}
        });
    }
}
