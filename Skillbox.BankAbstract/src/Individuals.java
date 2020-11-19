public class Individuals extends Client {

    public Individuals(String name, int amount) {
        super("частное лицо: ", name, amount);
        showInfo();
    }

    @Override
    public void showInfo() {

        System.out.print(getType() + getName() + " => " + getAmount() + "\t");
        System.out.println("(Пополнение и снятие денег со счёта происходит без комиссии)");
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
        if (getAmount() >= amount) {

            setAmount(getAmount() - amount);
            System.out.println(getName() + " => " + getAmount() + " рублей.");

        } else {
            System.out.println("Недостаточно средств");
            System.out.println(getName() + " => " + getAmount() + " рублей.");

        }

    }
}
