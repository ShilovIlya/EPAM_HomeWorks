package javase02.t01;

/**
 * Created with IntelliJ IDEA.
 * User: Ilya
 * Date: 03.12.15
 * Time: 21:10
 * To change this template use File | Settings | File Templates.
 */
public class Pen {

    private String type;
    private int price;
    private String color;


    public Pen(String type, int price, String color) {
        this.type = type;
        this.price = price;
        this.color = color;
    }
    public Pen() {
        this("BALLPOINT", 50, "BLACK");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        if (price != pen.price) return false;
        if (!color.equals(pen.color)) return false;
        if (type != pen.type) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + price;
        result = 31 * result + color.hashCode();
        return result;
    }


    @Override
    public String toString() {
        return "Pen{" +
                "type=" + type +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }

}
