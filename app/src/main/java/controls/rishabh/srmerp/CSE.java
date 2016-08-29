package controls.rishabh.srmerp;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class CSE extends ListActivity {
    ListView listView;
    TextView textView;
    String timetable[] = {"06.05.2015       PD1004","08.05.2015     LE1008/LE1009","11.05.2015      MA1004","13.05.2015         EC1006","15.05.2015         CS1004","18.05.2015         CS1006","20.05.2015         CS1008","22.05.2015     CS1101/CS1120"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse);
        listView = getListView();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timetable);
        listView.setAdapter(adapter);
    }
}
