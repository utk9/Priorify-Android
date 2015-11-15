package utk.com.priorify;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by utk on 15-11-14.
 */
public class ItemDetailsActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemdetailsactivity_layout);
        final Spinner spinner = (Spinner) findViewById(R.id.categorySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.category_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        getFragmentManager()
                  .beginTransaction().add(R.id.fragment, new DependentDetailsFragment()).commit();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                String s = (String) item;
                if (s.equals("Academic")) {
                    getFragmentManager().beginTransaction().
                            replace(R.id.fragment, new DependentDetailsFragment()).commit();

                } else {
                    if (s.equals("Side Project")) {
                        getFragmentManager().beginTransaction().
                                replace(R.id.fragment, new DependentDetailsFragment2()).commit();
                    }
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        final EditText taskNameText= (EditText) findViewById (R.id.taskName);
        //if (taskNameText == null) Log.e("dfdfd", taskNameText.getText());



        final Button addNewButton = (Button) findViewById(R.id.addTaskButton);
        //if (addNewButton== null) Log.e("ll", "button is null");
        addNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), TaskListActivity.class);
                i.putExtra("name", taskNameText.getText().toString());
                i.putExtra("diff", 0);
                i.putExtra("cat", 0);
                i.putExtra("imp", 0);
                i.putExtra("howLong", 0);
                startActivity(i);

            }
        });

    }
}
