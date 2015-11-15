package utk.com.pri;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by utk on 15-11-15.
 */
public class TaskList extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_list_layout);

        Button addNewButton = (Button) findViewById(R.id.add_new_button);
        addNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(getApplicationContext(), TaskDetails.class);
                startActivity(i);
            }
        });

        if (getIntent().getExtras() == null){

        }
        else {
            Intent i = getIntent();
            DataClass.taskList.add (new Task (i.getStringExtra("name"),
                    i.getIntExtra("imp", 0), i.getIntExtra("diff", 0), i.getIntExtra("timeRange", 0),
                    i.getStringExtra("dueDate")));
            DataClass.namesList.add(i.getStringExtra("name"));
            i.removeExtra("imp");
            i.removeExtra("diff");
            i.removeExtra("name");
            i.removeExtra("timeRange");
            i.removeExtra("dueDate");
        }
        ListView list = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, DataClass.namesList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final Dialog dialog = new Dialog(TaskList.this);
                dialog.setContentView(R.layout.dialog_layout);


                Spinner spinner = (Spinner) dialog.findViewById(R.id._spinner);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),
                        R.array.category_array, R.layout.spinner_item_layout);
                adapter.setDropDownViewResource(R.layout.spinner_item_layout);
                spinner.setAdapter(adapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        //put something in here
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

                spinner.setSelection(DataClass.taskList.get(position).getTimeRange());

                final EditText name = (EditText) dialog.findViewById(R.id._task_name_editText);
                name.setText(DataClass.taskList.get(position).getName());

                final EditText dueDate = (EditText) dialog.findViewById(R.id._due_date_editText);
                dueDate.setText(DataClass.taskList.get(position).getDueDate());

                final SeekBar sk1 = (SeekBar) dialog.findViewById(R.id._seekBar);
                sk1.setProgress(DataClass.taskList.get(position).getImp());

                final SeekBar sk2 = (SeekBar) dialog.findViewById(R.id._seekBar2);
                sk2.setProgress(DataClass.taskList.get(position).getDifficulty());

                final Button b = (Button) dialog.findViewById(R.id._add_task_button);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DataClass.taskList.get(position).setName(name.getText().toString());
                        DataClass.taskList.get(position).setImp(sk1.getProgress());
                        DataClass.taskList.get(position).setDifficulty(sk2.getProgress());
                        DataClass.taskList.get(position).setTimeRange(position);
                        DataClass.taskList.get(position).setDueDate(dueDate.getText().toString());
                        dialog.dismiss();
                    }
                });

                final Button b2 = (Button) dialog.findViewById(R.id._delete_button);
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        DataClass.taskList.remove(position);
                        DataClass.namesList.remove(position);
                        dialog.dismiss();
                        recreate();
                    }
                });

                dialog.show();
            }
        });

    }



    public void onBackPressed() {
    }
}
