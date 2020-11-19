package HomeWorks.Nasledovanie.Test.Sold;

public class Main {

    public static void main(String[] args) {

        AbstractItem[] market = new AbstractItem[10];


        Saw saw1 = new Saw("Пила Bosch", 3500, 12.3, 3, 35000,
                true, false);
        Saw saw2 = new Saw("Пила Gorenje", 4200, 11.5, 2,
                30000, true, true);
        Drill drill1 = new Drill("Дрель Bosch", 2000, 0.5, 5,
                5000, true);
        Drill drill2 = new Drill("Дрель Electrolux", 2500, 2.5, 8,
                7000, false);
        JigSaw jigSaw1 = new JigSaw("Лобзик Supra", 2000, 0.5, 12,
                5000);
        JigSaw jigSaw2 = new JigSaw("Лобзик Электроника", 2500, 2.5, 1,
                7000);
        Notebook note1 = new Notebook("Ноутбук Lenovo", 3, 13, 25, 4096,
                15, 8, 50000, true, true);
        Notebook note2 = new Notebook("Ноутбук ASUS", 5, 17, 30, 4096,
                25, 12, 75000, true, false);
        Monoblock mblock1 = new Monoblock("Моноблок Apple", 3,
                4096, 27, 8, 100000);
        Monoblock mbloсk2 = new Monoblock("Моноблок Samsung", 2,
                4096, 32, 12, 70000);


            market[0] = saw1;
            market[1] = saw2;
            market[2] = drill1;
            market[3] = drill2;
            market[4] = jigSaw1;
            market[5] = jigSaw2;
            market[6] = note1;
            market[7] = note2;
            market[8] = mblock1;
            market[9] = mbloсk2;


        Solution.showInfo(market);

        System.out.println("\n\t\t\t\t\t\t\tВсего товара в магазине: "
                + AbstractItem.getCount() + " единиц\n");

        System.out.println(Solution.maxPowerConsumption(market));
        System.out.println(Solution.sumAll(market));
        System.out.println(Solution.sumHDD(market));
        Solution.showReturnable(market);

    }


}
