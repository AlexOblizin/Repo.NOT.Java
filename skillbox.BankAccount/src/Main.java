
public class Main {
    public static void main(String[] args) {

        BankAccount[] bankAccount = new BankAccount[3];

        bankAccount[0] = new BankAccount("Банковский счёт", 0);
        bankAccount[1] = new Deposit("Депозит", 0);
        bankAccount[2] = new CardAccount("Карточный счёт", 0);

        System.out.println("Ключевые команды: acc, card, depo, getcard, getdepo," +
                " getacc, acc send depo, balance. Пример: acc 12345");
        while (true) {
            int tmp;
            String s = UserInputBnkAcc.userInput();
            if (UserInputBnkAcc.acc(s)) {
                tmp = Integer.parseInt(s.replaceAll("\\D", ""));
                bankAccount[0].replenish(tmp);
            }
            if (UserInputBnkAcc.depo(s)) {
                tmp = Integer.parseInt(s.replaceAll("\\D", ""));
                bankAccount[1].replenish(tmp);
            }
            if (UserInputBnkAcc.card(s)) {
                tmp = Integer.parseInt(s.replaceAll("\\D", ""));
                bankAccount[2].replenish(tmp);
            }
            if (UserInputBnkAcc.getDepo(s)) {
                tmp = Integer.parseInt(s.replaceAll("\\D", ""));

                    bankAccount[1].withdraw(tmp);

            }
            if (UserInputBnkAcc.getCard(s)) {

                tmp = Integer.parseInt(s.replaceAll("\\D", ""));
                bankAccount[2].withdraw(tmp);

            }
            if (UserInputBnkAcc.getAcc(s)) {
                tmp = Integer.parseInt(s.replaceAll("\\D", ""));
                bankAccount[0].withdraw(tmp);

            }

            if (UserInputBnkAcc.acc2depo(s)) {
                tmp = Integer.parseInt(s.replaceAll("\\D", ""));
                bankAccount[0].send(bankAccount[1],tmp);

            }if (UserInputBnkAcc.acc2card(s)) {
                tmp = Integer.parseInt(s.replaceAll("\\D", ""));
                bankAccount[0].send(bankAccount[2],tmp);

            }if (UserInputBnkAcc.depo2acc(s)) {
                tmp = Integer.parseInt(s.replaceAll("\\D", ""));
                bankAccount[1].send(bankAccount[0],tmp);

            }if (UserInputBnkAcc.depo2card(s)) {
                tmp = Integer.parseInt(s.replaceAll("\\D", ""));
                bankAccount[1].send(bankAccount[2],tmp);

            }if (UserInputBnkAcc.card2acc(s)) {
                tmp = Integer.parseInt(s.replaceAll("\\D", ""));
                bankAccount[2].send(bankAccount[0],tmp);

            }if (UserInputBnkAcc.card2depo(s)) {
                tmp = Integer.parseInt(s.replaceAll("\\D", ""));
                bankAccount[2].send(bankAccount[1],tmp);

            }

            if (UserInputBnkAcc.balance(s)) {
                System.out.println(bankAccount[0].getAccountName()
                        + ": " + bankAccount[0].getAmount() + " рублей.");
                System.out.println(bankAccount[1].getAccountName()
                        + ": " + bankAccount[1].getAmount() + " рублей.");
                System.out.println(bankAccount[2].getAccountName()
                        + ": " + bankAccount[2].getAmount() + " рублей.");
            }
            if (UserInputBnkAcc.exit(s)) {
                break;
            }


        }

    }

}
