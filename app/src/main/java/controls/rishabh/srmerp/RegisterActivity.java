package controls.rishabh.srmerp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class RegisterActivity extends Activity {
    ProgressDialog progressDialog;
    Button loginbtn, registerbtn;
    EditText fullname, registerno, phone, email, password, repassword;
    String fullnames, registernos, phones, emasils, passwords, repasswords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fullname = (EditText) findViewById(R.id.register_fullname);
        registerno = (EditText) findViewById(R.id.regiter_registrationno);
        phone = (EditText) findViewById(R.id.register_phone);
        email = (EditText) findViewById(R.id.register_email);
        password = (EditText) findViewById(R.id.register_password);
        repassword = (EditText) findViewById(R.id.register_repassword);
        loginbtn = (Button) findViewById(R.id.register_login);
        registerbtn = (Button) findViewById(R.id.register_register);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginScreenActivity.class);
                startActivity(i);
            }
        });
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullnames = fullname.getText().toString();
                registernos = registerno.getText().toString();
                phones = phone.getText().toString();
                emasils = email.getText().toString();
                passwords = password.getText().toString();
                repasswords = repassword.getText().toString();

                if(registernos.equals("") && passwords.equals("") && repasswords.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please complete the form", Toast.LENGTH_SHORT).show();
                }
                else if(passwords.equals(repasswords)){
                    progressDialog = ProgressDialog.show(RegisterActivity.this,"","Please Wait . . . . . .", true);
                    ParseUser user = new ParseUser();
                    user.put("Full_Name", fullnames);
                    user.setUsername(registernos);
                    user.setPassword(passwords);
                    user.setEmail(emasils);
                    user.put("Phone", phones);
                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if(e == null){
                                progressDialog.dismiss();
                                Toast.makeText(getApplicationContext(),"You're Registered Successfully. Now go to login page for sign in", Toast.LENGTH_SHORT).show();

                            }else
                            {
                                Toast.makeText(getApplicationContext(), e.getMessage().toString(), Toast.LENGTH_LONG).show();
                            }

                        }
                    });
                }
                else{
                    Toast.makeText(getApplicationContext(),"The entered passwords doesn't match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
