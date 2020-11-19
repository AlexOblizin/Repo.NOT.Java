public abstract class Client {
    private String type;
    private String name;
    private int amount;

    Client(String type, String name, int amount) {
        this.type = type;
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public abstract void showInfo();

    public abstract void replenish(int amount);

    public abstract void withDraw(int amount);


}
