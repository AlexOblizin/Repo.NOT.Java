public class Potato implements Vegetables{

    private String name;
    private int quantity;

    public Potato() {
        this.name = "Картофель";
        this.quantity = 1;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
