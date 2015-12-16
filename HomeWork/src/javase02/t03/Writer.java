package javase02.t03;

public class Writer extends OfficeGoods {

    protected String color;

    public Writer(int price, String color) {
        super(price);
        this.color = color;
    }

    public Writer(int price){
        this(price, "BLACK");
    }

    public  Writer(String color){
        super();
        this.color = color;
    }

    public Writer() {
        super();
        color = "BLACK";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return s + " - Writer{" +
                "color='" + color + '\'' +
                '}';
    }
}

