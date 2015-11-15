package utk.com.priorify;

/**
 * Created by utk on 15-11-14.
 */
public class Task {
    private int imp;
    private int category;
    private int difficulty;

    public Task (int imp, int category, int difficulty){
        this.imp = imp;
        this.category = category;


        this.difficulty = difficulty;
    }

    public int getImp() {
        return imp;
    }

    public void setImp(int imp) {
        this.imp = imp;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
