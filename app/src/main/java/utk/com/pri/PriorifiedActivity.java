package utk.com.pri;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by melissali on 15-11-15.
 */
public class PriorifiedActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.priorified_data_layout);
        ArrayList <Task> priorifiedList = Task.priorify(DataClass.taskList);
        ArrayList <String> priorifiedNames = new ArrayList<String>();
        for (int i = 0; i< priorifiedList.size(); i++){
            priorifiedNames.add(i, priorifiedList.get(i).getName());
        }
        ListView l = (ListView) findViewById(R.id.priorified_list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, priorifiedNames);
        l.setAdapter(arrayAdapter);
    }
}
