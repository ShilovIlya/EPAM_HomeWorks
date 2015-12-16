package javase02.t03;

public class Pencil extends Writer {
    protected String hardness;

    public Pencil(int price, String color, String hardness) {
        super(price, color);
        this.hardness = hardness;
    }

    public Pencil(int price, String hardness) {
        super(price);
        this.hardness = hardness;
    }

    public Pencil(String color, String hardness) {
        super(color);
        this.hardness = hardness;
    }

    public Pencil(){
        super();
        this.hardness = "B";
    }

    public Pencil(String hardness) {
        this.hardness = hardness;
    }

    public String getType() {
        return hardness;
    }

    public void setType(String hardness) {
        this.hardness = hardness;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return s + " - Pencil{" +
                "hardness='" + hardness + '\'' +
                '}';
    }
}

