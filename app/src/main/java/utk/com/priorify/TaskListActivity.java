package utk.com.priorify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                startActivity (i);

            }
        });
        priorifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

    }
}
