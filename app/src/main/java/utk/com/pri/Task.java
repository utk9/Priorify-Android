package utk.com.pri;
import java.util.Calendar;
/**
 * Created by utk on 15-11-14.
 */
public class Task {
    private String name;
    private int imp;
    private int difficulty;
    private int timeRange;
    private String dueDate;

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
}
