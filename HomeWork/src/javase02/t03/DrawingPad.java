package javase02.t03;


public class DrawingPad extends Paper {
    protected String someInfo;

    public DrawingPad(int price, int count, String someInfo) {
        super(price, count);
        this.someInfo = someInfo;
    }

    public DrawingPad(String someInfo) {
        this.someInfo = someInfo;
    }

    public String getSomeInfo() {
        return someInfo;
    }

    public void setSomeInfo(String someInfo) {
        this.someInfo = someInfo;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return s + " - DrawingPad{" +
                "someInfo='" + someInfo + '\'' +
                '}';
    }
}
