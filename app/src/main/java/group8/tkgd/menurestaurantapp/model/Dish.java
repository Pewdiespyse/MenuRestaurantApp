package group8.tkgd.menurestaurantapp.model;

public class Dish {

    private String name;
    private int price;
    private int image;
    private String description;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Dish(String name, int price, int image, String description) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
    }
}
