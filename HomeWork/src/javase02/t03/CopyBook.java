package javase02.t03;


public class CopyBook extends Paper {
    protected String name;

    public CopyBook(int price, int count, String name) {
        super(price, count);
        this.name = name;
    }

    public CopyBook(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        String s = super.toString();
        return s + " - CopyBook{" +
                "name='" + name + '\'' +
                '}';
    }
}
