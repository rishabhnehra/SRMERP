package controls.rishabh.srmerp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class Semtime extends ListActivity {
    ListView listView;
    String branch[] = {"CSE", "Aerospace", "Civil", "Automobile", "IT", "ECE", "EEE"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semtime);
        listView = getListView();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 ,branch);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        TextView textView = (TextView) v;
        Intent intent;
        if(textView.getText() == branch[0]){
            intent = new Intent(getApplicationContext(), CSE.class);
            startActivity(intent);
        }
        else if(textView.getText() == branch[1]){
            intent = new Intent(getApplicationContext(), Aerospace.class);
            startActivity(intent);
        }
        else if(textView.getText() == branch[2]){
            intent = new Intent(getApplicationContext(), Civil.class);
            startActivity(intent);
        }
        else if(textView.getText() == branch[3]){
            intent = new Intent(getApplicationContext(), Automobile.class);
            startActivity(intent);
        }
        else if(textView.getText() == branch[4]){
            intent = new Intent(getApplicationContext(), IT.class);
            startActivity(intent);
        }
        else if(textView.getText() == branch[5]){
            intent = new Intent(getApplicationContext(), ECE.class);
            startActivity(intent);
        }
        else if(textView.getText() == branch[6]){
            intent = new Intent(getApplicationContext(), EEE.class);
            startActivity(intent);
        }
    }
}
