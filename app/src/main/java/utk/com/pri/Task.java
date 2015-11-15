package utk.com.pri;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by utk on 15-11-14.
 */
public class Task implements Comparable<Task>{
    private String name;
    private int imp;
    private int difficulty;
    private int timeRange;
    private String dueDate;

    private int finishRange; //1 if 0-2, 2 if 2-4, 3 if 4+ hours
    private Calendar completeBy;

    /////

    public static final Comparator<Task> FINISH_ORDER = new FinishOrder();
    public static final Comparator <Task> DIFF_ORDER = new DiffOrder();

    ////

    public int getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(int timeRange) {
        this.timeRange = timeRange;
    }

    public Task(String name, int imp, int difficulty, int timeRange, String dueDate){
        this.name = name;

        this.imp = imp;
        this.difficulty = difficulty;
        this.timeRange = timeRange;
        this.dueDate = dueDate;
        finishRange = timeRange;

        this.completeBy = Calendar.getInstance();
        this.completeBy.set(Integer.parseInt(dueDate.substring(6)),
                Integer.parseInt (dueDate.substring(0, 2)) - 1,
                Integer.parseInt(dueDate.substring(3, 5)), 0, 0);

    }


    public int getImp() {
        return imp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImp(int imp) {
        this.imp = imp;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
/*
    public static void random (ArrayList<Task> tasks) {

        int i;

        //By time to finish
        for (i = 0; i < tasks.size() - 1;)
        {
            int n = i;
            while (n < tasks.size() - 1 && tasks.get(n).getImp() == tasks.get(n + 1).getImp())
                n++;

            if (n > i) {
                ArrayList <Task> temp = new ArrayList <Task> (tasks.subList(i, n + 1));
                for (int j = 0; j <= n - i; j++)
                    tasks.remove(i);

                Collections.sort(temp, Task.FINISH_ORDER);

                for (int j = temp.size() - 1; j >= 0; j--)
                    tasks.add(i, temp.get (j));

                i = n + 1;
            }
            else
                i++;
            //System.out.println(" " + i);

        }

        //By difficulty
        for (i = 0; i < tasks.size() - 1;)
        {
            int n = i;

            while (n < tasks.size() - 1 && tasks.get(n).getFinishRange() == tasks.get(n + 1).getFinishRange())
                n++;

            if (n > i) {
                ArrayList <Task> temp = new ArrayList <Task> (tasks.subList(i, n + 1));
                for (int j = 0; j <= n - i; j++)
                    tasks.remove(i);

                Collections.sort(temp, Task.DIFF_ORDER);
                for (int j = temp.size() - 1; j >= 0; j--)
                    tasks.add(i, temp.get (j));

                i = n + 1;
            }
            else i++;

            //System.out.println(i);
        }
    }*/
public static void random (ArrayList <Task> tasks) {

    int i;

    //By time to finish
    for (i = 0; i < tasks.size() - 1;)
    {

        int n = i;
        while (n < tasks.size() - 1 && tasks.get(n).getImp() == tasks.get(n + 1).getImp())
            n++;

        if (n > i) {
            ArrayList <Task> temp = new ArrayList <Task> (tasks.subList(i, n + 1));
            for (int j = 0; j <= n - i; j++)
                tasks.remove(i);

            Collections.sort(temp, Task.FINISH_ORDER);

            for (int j = temp.size() - 1; j >= 0; j--)
                tasks.add(i, temp.get (j));

            i = n + 1;
        }
        else
            i++;
    }

    //By difficulty
    for (i = 0; i < tasks.size() - 1;)
    {
        int n = i;

        while (n < tasks.size() - 1 && tasks.get(n).getFinishRange() == tasks.get(n + 1).getFinishRange() && tasks.get(n).getImp() == tasks.get(n + 1).getImp())
            n++;

        if (n > i) {
            ArrayList <Task> temp = new ArrayList <Task> (tasks.subList(i, n + 1));
            for (int j = 0; j <= n - i; j++)
                tasks.remove(i);

            Collections.sort(temp, Task.DIFF_ORDER);
            for (int j = temp.size() - 1; j >= 0; j--)
                tasks.add(i, temp.get (j));

            i = n + 1;
        }
        else i++;

    }
}

    public static ArrayList <Task> priorify (ArrayList <Task> tasks) {

        int i;

        ArrayList <Task> first = new ArrayList <Task> ();
        ArrayList <Task> second = new ArrayList <Task> ();

        //Code for finding the time remaining for each activity
        Calendar currentDate = Calendar.getInstance();
        long currentTime = currentDate.getTimeInMillis();
        double [] dueTimes = new double [tasks.size()]; //Track the time remaining for each task
        for (i = 0; i < tasks.size(); i++) {
            long taskTime = tasks.get(i).getCompleteDate().getTimeInMillis();
            long difference = taskTime - currentTime;
            dueTimes [i] = difference / 3600000.0;

            //If a task is due in 5 or less hours, they are top priority
            if (dueTimes [i] <= 5.0) {
                first.add(tasks.get(i));
            }
        }

        //The prioritized array has all tasks that are due within 5 hours
        //Sort all tasks due within 4 hours in descending importance values. Then sort them by time to finish and difficulty
        Collections.sort(first);
        random (first);

        //Do the same for all tasks that are due after 5 hours
        for (i = 0; i < tasks.size(); i++)
            if (dueTimes [i] > 5.0)
                second.add(tasks.get(i));

        Collections.sort(second);
        random (second);

        //Merge the two halves
        for (Task task : second)
            first.add(task);

        return first;
    }

    private static class FinishOrder implements Comparator <Task> {

        public int compare (Task first, Task second) {
            if (first.finishRange < second.finishRange)
                return -1;
            else if (first.finishRange > second.finishRange)
                return 1;
            else
                return 0;
        }
    }

    private static class DiffOrder implements Comparator <Task> {

        public int compare (Task first, Task second) {
            if (first.difficulty < second.difficulty)
                return -1;
            else if (first.difficulty > second.difficulty)
                return 1;
            else
                return 0;
        }
    }

    public int getFinishRange () {
        return finishRange;
    }

    public Calendar getCompleteDate () {
        return completeBy;
    }

    public String toString () {
        return String.format("%d %d %d %d/%d/%d", imp, difficulty, finishRange, completeBy.get(Calendar.MONTH) + 1, completeBy.get(Calendar.DATE), completeBy.get(Calendar.YEAR));
    }

    public int compareTo (Task other) {
        return other.imp - this.imp;
    }

}
