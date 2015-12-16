package javase02.t03;

public class OfficeGoods{
    protected int price;

    public OfficeGoods(int price){
        this.price = price;
    }

    public OfficeGoods(){
        price = 0;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }


    @Override
    public String toString() {
        return "OfficeGoods{" +
                "price=" + price +
                '}';
    }
}
