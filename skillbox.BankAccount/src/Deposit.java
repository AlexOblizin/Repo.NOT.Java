import java.time.Duration;
import java.time.LocalDateTime;

public class Deposit extends BankAccount {

    private LocalDateTime withdrawDate;
    private LocalDateTime replenishDate;


    public Deposit(String name, int amount) {
        super(name, amount);
    }


    @Override
    public boolean withdraw(int money) {
        this.withdrawDate = LocalDateTime.now();
        Duration duration = Duration.between(withdrawDate, replenishDate);
        long diff = Math.abs(duration.toSeconds());

        int amountTmp = getAmount();
        if (amountTmp >= money && diff >= 30) {
            amountTmp -= money;
            setAmount(amountTmp);

            return true;
        } else if (diff < 30 && getAmount() >= money) {
            System.out.println("Операция не может быть выполнена! "
                    + "Должно пройти не менее 30-ти секунд с момента пополнения счёта, "
                    + "а прошло " + diff + " сек.");
            return false;
        }
        else {

                System.out.println("Операция не может быть выполнена! Не достаточно средств!");
             }
            return false;
        }

    @Override
    public boolean replenish(int money) {
        this.replenishDate = LocalDateTime.now();
        int moneyTmp = getAmount();
        moneyTmp += money;
        setAmount(moneyTmp);
        return true;

    }

}
