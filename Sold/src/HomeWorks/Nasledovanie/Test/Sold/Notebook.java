package HomeWorks.Nasledovanie.Test.Sold;

public class Notebook extends Computer implements Returnable {
    int diag;
    int timeWork;
    boolean order;
    boolean passport;

    public Notebook(String name, int quantity, int diag, int timeWork, int memory,
                    int hardSpace, int numberCores, int price, boolean order, boolean passport) {
        super(name, quantity, memory, hardSpace, numberCores, price);
        this.diag = diag;
        this.timeWork = timeWork;
        this.order = order;
        this.passport = passport;
    }

    public String forReturn() {

        if (order && passport) {

            return " Документы на возврат есть. Нужен чек и паспорт.";

        } else {

            return " Документов на возврат на данный момент нет.";

        }

    }

    public int getDay2Return() {

        return days2Return * 2;

    }

}
