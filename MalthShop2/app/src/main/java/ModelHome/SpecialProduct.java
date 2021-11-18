package ModelHome;

public class SpecialProduct {
    private int id;
    private String img;
    private double percentSale;
    private double price;
    private int status;

    public SpecialProduct(int id, String img, double percentSale, double price, int status) {
        this.id = id;
        this.img = img;
        this.percentSale = percentSale;
        this.price = price;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getSale() {
        return percentSale;
    }

    public void setSale(double percentSale) {
        this.percentSale = percentSale;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
