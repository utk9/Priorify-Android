package utk.com.pri;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    }
}
