public class SelfEmployed extends Client{
    private static final double COMMISSION001 = 0.01;
    private static final double COMMISSION0005 = 0.005;


    public SelfEmployed(String name, int amount) {

        super("ИП: ", name, amount);
        showInfo();
    }

    @Override
    public void showInfo() {
        System.out.print(getType() + getName() + " => " + getAmount() + "\t");
        System.out.println("(Пополнение " +
                "с комиссией 1%, если сумма меньше 1000 рублей. " +
                "с комиссией 0,5%, если сумма больше либо равна 1000 рублей)");
    }

    @Override
    public void replenish(int amount) {
        System.out.print("После пополнения счёта на " + amount + " рублей: ");
        int amount001Tmp = (int) (amount * COMMISSION001) + amount;
        int amount0005Tmp = (int) (amount * COMMISSION0005) + amount;

        if (amount < 1000) {
            setAmount(getAmount() + amount001Tmp);
            System.out.println(getName() + " => " + getAmount() + " рублей.");
        } else {
            setAmount(getAmount() + amount0005Tmp);
            System.out.println(getName() + " => " + getAmount() + " рублей.");
        }

    }

    @Override
    public void withDraw(int amount) {
        System.out.print("После снятия " + amount + " рублей: ");
        if (getAmount() >= amount) {

            setAmount(getAmount() - amount);
            System.out.println(getName() + " => " + getAmount() + " рублей.");

        } else {
            System.out.println("Недостаточно средств");
            System.out.println(getName() + " => " + getAmount() + " рублей.");
        }
    }
}
