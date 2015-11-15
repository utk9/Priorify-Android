package utk.com.pri;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by utk on 15-11-15.
 */
public class TaskDetails extends Activity {
    int imp;
    int diff;
    int timeRange;

    @Nullable
    @Override
    public View onCreatePanelView(int featureId) {
        return super.onCreatePanelView(featureId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_details_layout);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.category_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                timeRange = (pos);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


            final EditText taskNameBox = (EditText) findViewById(R.id.task_name_editText);

            final SeekBar impSeekBar = (SeekBar) findViewById(R.id.seekBar);

            impSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                    imp = progresValue;
                    Log.e("dfd", imp+"");
                }

                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
        final SeekBar diffSeekBar = (SeekBar) findViewById(R.id.seekBar2);

        diffSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                diff = progresValue;
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });


        final Button addNewButton = (Button) findViewById(R.id.add_task_button);
        addNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), TaskList.class);
                i.putExtra("name", taskNameBox.getText().toString());
                i.putExtra("diff", diff);
                i.putExtra("imp", imp);
                i.putExtra("timeRange", timeRange);
                startActivity(i);
            }

            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }
        });


    }
}
