package utk.com.priorify;

/**
 * Created by utk on 15-11-14.
 */
public class Task {
    private String name;
    private int imp;
    private int category;
    private int difficulty;
    private int howLong;

    public Task (String name, int imp, int category, int difficulty, int howLong){
        this.name  = name;
        this.imp = imp;
        this.category = category;
        this.howLong = howLong;
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

    public int getHowLong() {
        return howLong;
    }

    public void setHowLong(int howLong) {
        this.howLong = howLong;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
