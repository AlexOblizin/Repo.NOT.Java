import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

public class TyresSQLClient {


    public static void main(String args[]) {
    try {
        Input.createTables();

        Input.fulfillCustomers("Alexey", "+79877897887", "sss",15);
        Input.fulfillCustomers("Irina", "+79502581779", "sss",5);
        Input.fulfillCustomers("Sergey", "+79264561937", "sss",7);

        Input.fulfillTyres(75, 275, 21, "NOKIAN", "all seasons", 75000);
        Input.fulfillTyres(55, 230, 16, "BRIDGESTONE", "winter", 50000);
        Input.fulfillTyres(60, 255, 17, "MICHELIN", "summer", 60000);

        Input.transactions(1,2,4,"yes");
        Input.transactions(2,1,4,"no");
        Input.transactions(3,3,4,"yes");

        Input.transactions(1,2,2,"no");
        Input.transactions(2,1,6,"yes");
        Input.transactions(3,3,8,"no");


        while (true) {
            String input = Input.userInput();
            if (Output.listCustomers(input)) {
                Output.outputCustomers();
            }else if (Output.listTyres(input)) {
                Output.outputTyres();
            }else if (Output.listTransactions(input)) {
                Output.outputTransactions();
            }else if (Output.exit(input)) {
                break;
            }
        }
    } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
   }
}

