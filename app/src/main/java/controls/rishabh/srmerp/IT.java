package controls.rishabh.srmerp;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class IT extends ListActivity {
    String timetable [] = {"06.05.2015      PD1004","08.05.2015     LE1008/LE1009","11.05.2015      MA1004","13.05.2015     IT1007","15.05.2015     IT1008","18.05.2015     IT1009","20.05.2015     IT1013","22.05.2015     IT1010/IT1011"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it);
        listView = getListView();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timetable);
        listView.setAdapter(adapter);
    }
}
