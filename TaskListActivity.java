package utk.com.priorify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by utk on 15-11-14.
 */
public class TaskListActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasklist_activity);
        final Button addNewButton = (Button) findViewById(R.id.addNewButton);
        final Button priorifyButton = (Button) findViewById(R.id.priorifyButton);

        addNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ItemDetailsActivity.class);
                startActivity(i);

            }
        });
        priorifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });



        if (getIntent().getExtras() == null){
            Log.e("lll", "intents are null");
        }
        else {
            Intent i = getIntent();

            DataClass.taskList.add (new Task (i.getStringExtra("name"), i.getIntExtra("diff", 0), i.getIntExtra("cat", 0),
                    i.getIntExtra("imp", 0), i.getIntExtra("howLong", 0)));
            DataClass.listOfNames.add(new String(i.getStringExtra("name")));

            Log.e("the size of the arrat", DataClass.listOfNames.size()+ "");


        }

        ListView listview = (ListView) findViewById(R.id.list_view);


        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, DataClass.listOfNames);
        listview.setAdapter(itemsAdapter);



    }
}
