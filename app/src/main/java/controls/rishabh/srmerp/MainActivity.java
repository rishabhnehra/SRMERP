package controls.rishabh.srmerp;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParsePush;
import com.parse.SaveCallback;

public class MainActivity extends ListActivity implements CompoundButton.OnCheckedChangeListener{
    RelativeLayout r;
    ToggleButton t;
    String mainScreen[] = {"Student Login", "Student Registration", "About SRM University Delhi NCR"};
    ListView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "YZ01tl6rnSNuLiw8tTUVSfkgWo3uwYLvPxiCsDt4", "ceGwtN7qiqXF54FTHxG8MYxU0RyhWXWMfvvN01XL");
        ParsePush.subscribeInBackground("", new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Log.d("com.parse.push", "successfully subscribed to the broadcast channel.");
                } else {
                    Log.e("com.parse.push", "failed to subscribe for push", e);
                }
            }
        });
        r = (RelativeLayout) findViewById(R.id.relativelayout);
        l = getListView();
        t = (ToggleButton) findViewById(R.id.toggleButton);
        t.setOnCheckedChangeListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mainScreen);
        l.setAdapter(adapter);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        TextView textView = (TextView) v;
        if(textView.getText() == mainScreen[0]){
            Intent i = new Intent(this, LoginScreenActivity.class);
            startActivity(i);
        }
        else if(textView.getText() == mainScreen[1]){
            Intent i = new Intent(this, RegisterActivity.class);
            startActivity(i);
        }
        else if(textView.getText() == mainScreen[2]){
            Intent i =new Intent(this, AboutSRM.class);
            startActivity(i);
        }
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            r.setBackgroundColor(Color.DKGRAY);
        }
        else{
            r.setBackgroundColor(Color.WHITE);
        }
    }
}
