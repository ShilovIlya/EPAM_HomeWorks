package javase02.t03;

public class Pen extends Writer {
    protected String type;

    public Pen(int price, String color, String type) {
        super(price, color);
        this.type = type;
    }

    public Pen(int price, String type) {
        super(price);
        this.type = type;
    }

    public Pen(String color, String type) {
        super(color);
        this.type = type;
    }

    public Pen(String type) {
        this.type = type;
    }

    public Pen(){
        super();
        type = "BALLPOINT";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return s + " - Pen{" +
                "type='" + type + '\'' +
                '}';
    }
}
