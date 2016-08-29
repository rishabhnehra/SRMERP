package controls.rishabh.srmerp;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseUser;

public class WelcomeActivity extends ListActivity {
    ProgressDialog progressDialog;
    String userName, cgpa;
    TextView textView;
    ListView listView;
    ParseUser parseUser = ParseUser.getCurrentUser();
    String welcome[] = {"Attendance", "Student Subject List", "Test Performance",
            "Feekart", "Feedback", "SRM Alumni", "Semester Time Table", "About Us", "CGPA", "Logout"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        textView = (TextView) findViewById(R.id.userName);
        listView = getListView();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, welcome);
        listView.setAdapter(adapter);
        ParseUser parseUser = ParseUser.getCurrentUser();
        userName = parseUser.get("Full_Name").toString();
        textView.setText(userName);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        TextView t = (TextView) v;
        Intent i;
        if(t.getText() == welcome[0]){
            i = new Intent(WelcomeActivity.this, Attendence.class);
            startActivity(i);
            Toast.makeText(WelcomeActivity.this, "Attendence", Toast.LENGTH_SHORT).show();
        }
        else if(t.getText() == welcome[1]){
           i = new Intent(WelcomeActivity.this, StudentSubjectList.class);
           startActivity(i);
            Toast.makeText(WelcomeActivity.this, "Student Subject List", Toast.LENGTH_SHORT).show();
        }
        else if (t.getText() == welcome[2]){
            i = new Intent(WelcomeActivity.this, TestPerformance.class);
            startActivity(i);
            Toast.makeText(WelcomeActivity.this, "Test Performance", Toast.LENGTH_SHORT).show();
        }
        else if(t.getText() == welcome[3]){
            i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("http://feekart.srmuniv.ac.in/srmopp/"));
            startActivity(i);
            Toast.makeText(WelcomeActivity.this, "Feekart", Toast.LENGTH_SHORT).show();
        }
        else if(t.getText() == welcome[4]){
            i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("http://mysrm.srmuniv.ac.in/mysrm/content/feedback"));
            startActivity(i);
            Toast.makeText(WelcomeActivity.this, "Feedback", Toast.LENGTH_SHORT).show();
        }
        else if(t.getText() == welcome[5]){
            i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("http://www.srmalumni.com/srmalumni/"));
            startActivity(i);
            Toast.makeText(WelcomeActivity.this, "SRM Alumni", Toast.LENGTH_SHORT).show();
        }

        else if(t.getText() == welcome[6]){
            i = new Intent(WelcomeActivity.this, Semtime.class);
            startActivity(i);
            Toast.makeText(WelcomeActivity.this, "Semester Time-Table", Toast.LENGTH_SHORT).show();
        }
        else if(t.getText() == welcome[7]){
            i = new Intent(WelcomeActivity.this, AboutUs.class);
            startActivity(i);
            Toast.makeText(WelcomeActivity.this, "About Us", Toast.LENGTH_SHORT).show();
        }
        else if (t.getText() == welcome[8]){
            cgpa = parseUser.get("CGPA").toString();
            Toast.makeText(WelcomeActivity.this, cgpa, Toast.LENGTH_LONG).show();
        }
        else if(t.getText() == welcome[9]){
            progressDialog = ProgressDialog.show(WelcomeActivity.this,"", "Logging out . . . . .", true, true);
            parseUser.logOut();
            i = new Intent(WelcomeActivity.this, LoginScreenActivity.class);
            startActivity(i);
            progressDialog.dismiss();
        }
    }
}
