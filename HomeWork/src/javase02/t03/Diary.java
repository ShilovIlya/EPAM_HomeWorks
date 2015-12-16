package javase02.t03;


public class Diary extends Paper {
    protected String diaryCase;

    public Diary(int price, int count, String diaryCase) {
        super(price, count);
        this.diaryCase = diaryCase;
    }

    public Diary(String diaryCase) {
        this.diaryCase = diaryCase;
    }

    public String getDiaryCase() {
        return diaryCase;
    }

    public void setDiaryCase(String diaryCase) {
        this.diaryCase = diaryCase;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return s + " - Diary{" +
                "diaryCase='" + diaryCase + '\'' +
                '}';
    }
}
