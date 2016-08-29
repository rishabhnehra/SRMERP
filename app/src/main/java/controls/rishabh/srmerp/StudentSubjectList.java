package controls.rishabh.srmerp;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class StudentSubjectList extends ListActivity {
    String subjectlist [] = {"French Phase II", "German Phase II","Aptitude II","Probability And Queuing Theory","Electron Devices",
                "Data Structures & Algorithms Design","Computer Networks","Computer Organization & Architecture", "Computer Skills",
            "Data Structures & Algorithms", "Computer Networks Lab"};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_subject_list);
        listView = getListView();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, subjectlist);
        listView.setAdapter(adapter);
    }
}
