import java.sql.*;
import java.util.Scanner;


public class Input {

    private static final int INSTALLATION = 5000;


    public static void createTables() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/TyresShop",
                        "postgres", "mypass");
        connection.setAutoCommit(false);
        System.out.println("Opened database successfully");

        Statement statement = connection.createStatement();
        String sql = "CREATE TABLE \"Customers\" " +
                "(id INTEGER PRIMARY KEY, " +
                "name VARCHAR(120) NOT NULL, " +
                "phone VARCHAR(20) NOT NULL UNIQUE, " +
                "discount INTEGER NOT NULL); " +

                "CREATE TABLE \"Tyres\" " +
                "(id INTEGER PRIMARY KEY, " +
                "heigth INTEGER NOT NULL, " +
                "width INTEGER NOT NULL, " +
                "radius INTEGER NOT NULL, " +
                "model VARCHAR(255) NOT NULL, " +
                "type VARCHAR(100) NOT NULL, " +
                "price INTEGER NOT NULL); " +

                "CREATE TABLE \"Transactions\" " +
                "(id INTEGER PRIMARY KEY NOT NULL, " +
                "customerId INTEGER NOT NULL, " +
                "tyresId INTEGER NOT NULL, " +
                "quantity INTEGER NOT NULL, " +
                "installation BOOLEAN DEFAULT FALSE, " +
                "sum INTEGER NOT NULL, " +
                "FOREIGN KEY (customerId) REFERENCES \"Customers\" (id), " +
                "FOREIGN KEY (tyresId) REFERENCES \"Tyres\" (id));";

        statement.executeUpdate(sql);
        connection.commit();

    }

    public static void fulfillCustomers(int id, String name, String phone, int discount) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/TyresShop",
                        "postgres", "mypass");
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();
        String sql = "INSERT INTO \"Customers\" (ID,NAME,PHONE,DISCOUNT) "
                + "VALUES (" + id + ", '" + name + "', '" + phone + "', " + discount + ");";
        statement.executeUpdate(sql);
        connection.commit();

    }

    public static void fulfillTyres(int id, int heigth, int width, int radius, String model, String type, int price)
            throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/TyresShop",
                        "postgres", "mypass");
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();
        String sql = "INSERT INTO \"Tyres\" (ID,HEIGTH,WIDTH,RADIUS,MODEL,TYPE,PRICE) "
                + "VALUES (" + id + ", " + heigth + ", " + width + ", " + radius + ", '" + model + "', '" + type + "', " + price + ");";
        statement.executeUpdate(sql);
        connection.commit();

    }

    public static void transactions(int id, int customerId, int tyresId, int quantity, String answer) throws ClassNotFoundException, SQLException {
        boolean install = "yes".equals(answer);
        int discount = 0;
        int price = 0;
        int sum = 0;

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/TyresShop",
                        "postgres", "mypass");
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();

        ResultSet resultSetCustomerId = statement.executeQuery("SELECT DISCOUNT FROM \"Customers\" WHERE ID = " + customerId + ";");
        while (resultSetCustomerId.next()) {
            discount = resultSetCustomerId.getInt("discount");
        }
        ResultSet resultSetTyresId = statement.executeQuery("SELECT PRICE FROM \"Tyres\" WHERE ID = " + tyresId + ";");
        while (resultSetTyresId.next()) {
            price = resultSetTyresId.getInt("price");

        }
        
        if (quantity > 4) {
            sum = price + ((price / 4) * (quantity - 4));
            sum -= (sum / 100 * discount);
        } else if (quantity < 4) {
            sum = price - ((price / 4) * (4 - quantity));
            sum -= (sum / 100 * discount);
        } else { // if quantity == 4 (whole package)
            sum = price - ((price / 100) * discount);
        }

        if (install) {
            sum += (INSTALLATION - (INSTALLATION / 100) * discount);
        }

        String sql = "INSERT INTO \"Transactions\" (ID,CUSTOMERID,TYRESID,QUANTITY,INSTALLATION,SUM) "
                + "VALUES (" + id + ", " + customerId + ", " + tyresId + ", " + quantity + ", " + install + ", " + sum + ");";
        statement.executeUpdate(sql);
        connection.commit();
    }

    public static String userInput() {
        String input;

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nВаши действия: ");
        input = scanner.nextLine();

        return input;
    }

}

//                stmt = c.createStatement();
//                String sql = "UPDATE COMPANY set ADDRESS = 'Perm' where ID = 1;";
//                stmt.executeUpdate(sql);
//                c.commit();
//
//                stmt = c.createStatement();
//                sql= "DELETE from COMPANY where ID = 1;";
//                stmt.executeUpdate(sql);
//                c.commit();
//                stmt.executeUpdate(sql);