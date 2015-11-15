package utk.com.priorify;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by utk on 15-11-14.
 */
public class DataClass extends Application {

    static public ArrayList<String> listOfNames = new ArrayList<String>();
    static public ArrayList<Task> taskList = new ArrayList<Task>();

//    public DataClass (ArrayList<String> list, ArrayList<Task> list2){
//        super();
//        listOfNames = list;
//        taskList = list2;
//    }

    public DataClass (){}

}
