package Models;

public class ExtraService {
   private String extraServiceName;
   private double price;
   private String unit;

    public ExtraService(String extraServiceName, double price, String unit) {
        this.extraServiceName = extraServiceName;
        this.price = price;
        this.unit = unit;
    }

    public String getExtraServiceName() {
        return extraServiceName;
    }

    public void setExtraServiceName(String extraServiceName) {
        this.extraServiceName = extraServiceName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "ExtraService{" +
                "extraServiceName='" + extraServiceName + '\'' +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                '}' +super.toString();
    }
}
