package javase02.t03;

public class Paper extends OfficeGoods{

    protected int pageCount;

    public Paper(int price, int count) {
        super(price);
        this.pageCount = count;
    }

    public Paper(){
        super();
        pageCount = 1;
    }

    public int getCount() {
        return pageCount;
    }

    public void setCount(int count) {
        this.pageCount = count;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return s + " - Paper{" +
                "pageCount=" + pageCount +
                '}';
    }
}
