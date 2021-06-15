package model.bean;

public class Product {
//    +	Tên sản phẩm.
//+	Giá.
//+	Số lượng.
//            +	Màu sắc.
//            +	Mô tả.
//            +	Danh mục
 private  int productId;
 private String name;
 private String price;
 private String quantity;
 private String color;
 private String description;
 private String category;

    public Product() {
    }

    public Product(int productId, String name, String price, String quantity, String color, String description, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.category = category;
    }

    public Product(String name, String price, String quantity, String color, String description, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
