package controls.rishabh.srmerp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.parse.ParseUser;


public class Attendence extends Activity {
    TextView textView;
    String attend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attendence);
        textView = (TextView) findViewById(R.id.textView18);
        ParseUser parseUser = ParseUser.getCurrentUser();
        attend = parseUser.get("Attendence").toString();
        textView.setText(attend+"%");
    }
}
