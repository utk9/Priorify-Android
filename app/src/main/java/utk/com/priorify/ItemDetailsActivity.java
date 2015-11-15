package utk.com.priorify;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

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
                    Log.e("aaa", "academic selected");
                } else {
                    if (s.equals("Side Project")){
                        getFragmentManager().beginTransaction().
                                replace(R.id.fragment, new DependentDetailsFragment2()).commit();
                        Log.e("aaa", "side project selected");
                    }
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

//        if (savedInstanceState == null) {
//            getFragmentManager()
//                    .beginTransaction()
//                    .add(R.id.fragment, new DependentDetailsFragment())
//                    .commit();
//        }
    }
}
