package controls.rishabh.srmerp;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.Parse;
import com.parse.ParseUser;

import java.util.List;


public class TestPerformance extends ListActivity {
    ParseUser parseUser = ParseUser.getCurrentUser();
    ListView listView;
    String tp[] = {"Maths:   "+parseUser.get("Maths"), "Data Structure:    "+parseUser.get("Data_Struct")
                ,"Computer Organization:     "+parseUser.get("COA"), "French:     "+parseUser.get("French"),
                "Aptitude:       "+parseUser.get("Aptitude")};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_performance);
        listView = getListView();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tp);
        listView.setAdapter(adapter);
    }
}
