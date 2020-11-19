import java.util.*;

public class MainBA {
    public static void main(String[] args) {
        Client ind1 = new Individuals("Алексей", 37000);

        Client se1 = new SelfEmployed("Иванов", 5550000);

        Client ent1 = new Entity("Рога и Копыта", 12500000);

        Set<Client> clientSet = new HashSet<>(3);
        clientSet.add(ind1);
        clientSet.add(se1);
        clientSet.add(ent1);

        System.out.println();
        System.out.println();

        ind1.replenish(50000);
        ind1.withDraw(3000);

        se1.replenish(1000500);
        se1.withDraw(45100);

        ent1.replenish(98700000);
        ent1.withDraw(7800000);

    }
}
