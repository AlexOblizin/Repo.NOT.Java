public class BankAccount {
    private String name;
    private int amount;

    public BankAccount(String name, int amount) {

        this.name = name;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getAccountName() {
        return name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean withdraw(int money) {
        int amountTmp = getAmount();
        if (amountTmp >= money) {
            amountTmp -= money;
            setAmount(amountTmp);
            return true;
        } else {
            System.out.println("Операция не может быть выполнена! Не достаточно средств!");
            return false;
        }
    }

    public boolean replenish(int money) {
        int moneyTmp = getAmount();
        moneyTmp += money;
        setAmount(moneyTmp);
        return true;

    }

    public boolean send(BankAccount account, int amount) {

            if (withdraw(amount)) {

                account.replenish(amount);

                return true;

            }

            return false;

        }


}





