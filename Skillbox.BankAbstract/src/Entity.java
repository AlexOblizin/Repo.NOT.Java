public class Entity extends Client {
    public static final double COMMISSION = 0.01;


    public Entity(String name, int amount) {
        super("юридическое лицо: ", name, amount);
        showInfo();
    }

    @Override
    public void showInfo() {
        System.out.print(getType() + getName() + " => " + getAmount() + "\t");
        System.out.println("(Снятие денег со счёта происходит с комиссией 1%)");
    }

    @Override
    public void replenish(int amount) {
        System.out.print("После пополнения счёта на " + amount + " рублей: ");
        setAmount(getAmount() + amount);
        System.out.println(getName() + " => " + getAmount() + " рублей.");
    }

    @Override
    public void withDraw(int amount) {
        System.out.print("После снятия " + amount + " рублей: ");
        int amountTmp = (int) (amount * COMMISSION) + amount;
        if (getAmount() >= amountTmp) {
            setAmount(getAmount() - amountTmp);
            System.out.println(getName() + " => " + getAmount() + " рублей.");
        } else {
            System.out.println("Недостаточно средств");
            System.out.println(getName() + " => " + getAmount() + " рублей.");

        }
    }



}
