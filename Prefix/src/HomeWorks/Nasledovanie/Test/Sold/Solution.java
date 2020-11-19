package HomeWorks.Nasledovanie.Test.Sold;

public class Solution {

    public static void showInfo(AbstractItem[] market) {
        for (AbstractItem ai : market) {
            if (ai instanceof Saw) {
                Saw sawTemp = (Saw) ai;
                System.out.println(ai.getName()
                        + ", количество: " + ai.getQuantity() + ", мощность: "
                        + sawTemp.powerConsumption + ", радиус диска: "
                        + sawTemp.rad + ", цена: " + sawTemp.getPrice() + sawTemp.forReturn());
            } else if (ai instanceof Drill) {
                Drill drillTemp = (Drill) ai;
                System.out.println(ai.getName()
                        + ", количество: " + ai.getQuantity() + ", мощность: "
                        + drillTemp.powerConsumption + ", диаметр сверла: "
                        + drillTemp.maxD + ", цена: " + drillTemp.getPrice() + drillTemp.forReturn());

            } else if (ai instanceof JigSaw) {
                JigSaw jsTemp = (JigSaw) ai;
                System.out.println(ai.getName()
                        + ", количество: " + ai.getQuantity() + ", мощность: "
                        + jsTemp.powerConsumption + ", ширина пропила: "
                        + jsTemp.maxW + ", цена: " + jsTemp.getPrice());
            } else if (ai instanceof Notebook) {
                Notebook nbTemp = (Notebook) ai;
                System.out.println(ai.getName()
                        + ", количество: " + ai.getQuantity() + ", диагональ: "
                        + nbTemp.diag + ", время автономной работы(часов): "
                        + nbTemp.timeWork + ",\n количество памяти: " + nbTemp.memory
                        + ", место на диске: " + nbTemp.hardSpace + ", количество ядер CPU: "
                        + nbTemp.numberCores + ", цена: " + nbTemp.getPrice() + nbTemp.forReturn());
            } else if (ai instanceof Monoblock) {
                Monoblock mbTemp = (Monoblock) ai;
                System.out.println(ai.getName()
                        + ", количество: " + ai.getQuantity() + ", количество памяти: " + mbTemp.memory
                        + ", место на диске: " + mbTemp.hardSpace + ", количество ядер CPU: "
                        + mbTemp.numberCores + ", цена: " + mbTemp.getPrice());
            }

        }

    }

    public static String maxPowerConsumption(AbstractItem[] market) {
        int[] array = new int[6];
        int max = 0;
        for (int i = 0; i < market.length; i++) {
            if (market[i] instanceof Saw) {
                array[i] = ((Saw) market[i]).powerConsumption;

            } else if (market[i] instanceof Drill) {
                array[i] = ((Drill) market[i]).powerConsumption;

            } else if (market[i] instanceof JigSaw) {
                array[i] = ((JigSaw) market[i]).powerConsumption;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {

                max = array[i];

            }
        }

        System.out.print("Максимальная мощность электротоваров: ");

        return max + " ватт";
    }

    public static String sumAll(AbstractItem[] market) {
        int sumAll = 0;

        for (AbstractItem ai : market) {

            sumAll += ai.getQuantity() * ai.getPrice();

        }

        System.out.print("При продаже всех товаров магазин заработает: ");

        return sumAll + " рублей";

    }

    public static String sumHDD(AbstractItem[] market) {

        int sumHDD = 0;

        for (AbstractItem ai : market) {

            if (ai instanceof Monoblock) {

                int hc = ((Monoblock) ai).hardSpace;
                sumHDD += ai.getQuantity() * hc;

            } else if (ai instanceof Notebook) {

                int hc = ((Notebook) ai).hardSpace;
                sumHDD += ai.getQuantity() * hc;

            }

        }

        System.out.print("Сумма всех жестких дисков: ");

        return sumHDD + " Gb";

    }

    public static void showReturnable(AbstractItem[] market) {

        for (AbstractItem ai : market) {
            if (ai instanceof Saw) {
                System.out.print(ai.getName() + ". ");
                System.out.print(((Saw) ai).forReturn());
                System.out.print(" По закону можно вернуть в течение (дней): ");
                System.out.println(((Saw) ai).getDay2Return());

            } else if (ai instanceof Drill) {
                System.out.print(ai.getName() + ". ");
                System.out.print(((Drill) ai).forReturn());
                System.out.print(" По закону можно вернуть в течение (дней): ");
                System.out.println(((Drill) ai).getDay2Return());

            } else if (ai instanceof Notebook) {
                System.out.print(ai.getName() + ". ");
                System.out.print(((Notebook) ai).forReturn());
                System.out.print(" По закону можно вернуть в течение (дней): ");
                System.out.println(((Notebook) ai).getDay2Return());

            }

        }
    }

}
