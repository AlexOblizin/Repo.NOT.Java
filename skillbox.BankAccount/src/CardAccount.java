public class CardAccount extends BankAccount {
    public static final double COMMISSION = 0.01;

    public CardAccount(String name, int amount) {
        super(name, amount);
    }

    @Override
    public boolean withdraw(int money) {
        int amountTmp = getAmount();
        int comissionAmount = (int) (money * COMMISSION);
        int mPlusCmsn = money + comissionAmount;
        if (amountTmp >= mPlusCmsn) {
            amountTmp -= mPlusCmsn;
            setAmount(amountTmp);

            System.out.println("Размер комиссии за снятие денег: " + comissionAmount + " руб.");
            return true;
        } else {

            System.out.println("Операция не может быть выполнена! Не достаточно средств!");

            return false;
        }
    }

}
