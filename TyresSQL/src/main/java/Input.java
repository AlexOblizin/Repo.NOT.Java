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
        String sql = "CREATE TABLE \"customers\" " +
                "(id SERIAL PRIMARY KEY NOT NULL, " +
                "name VARCHAR(255) NOT NULL, " +
                "phone VARCHAR(255) NOT NULL UNIQUE, " +
                "password VARCHAR(255) NOT NULL, "+
                "discount INTEGER NOT NULL); " +

                "CREATE TABLE \"tyres\" " +
                "(id SERIAL PRIMARY KEY NOT NULL, " +
                "heigth INTEGER NOT NULL, " +
                "width INTEGER NOT NULL, " +
                "radius INTEGER NOT NULL, " +
                "model VARCHAR(255) NOT NULL, " +
                "type VARCHAR(255) NOT NULL, " +
                "price INTEGER NOT NULL); " +

                "CREATE TABLE \"transactions\" " +
                "(id SERIAL PRIMARY KEY NOT NULL, " +
                "customerId INTEGER NOT NULL, " +
                "tyresId INTEGER NOT NULL, " +
                "quantity INTEGER NOT NULL, " +
                "installation BOOLEAN DEFAULT FALSE, " +
                "sum INTEGER NOT NULL, " +
                "FOREIGN KEY (customerId) REFERENCES \"customers\" (id), " +
                "FOREIGN KEY (tyresId) REFERENCES \"tyres\" (id));";

        statement.executeUpdate(sql);
        connection.commit();

    }

    public static void fulfillCustomers(String name, String phone, String password, int discount) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/TyresShop",
                        "postgres", "mypass");
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();
        String sql = "INSERT INTO \"customers\" (NAME,PHONE,PASSWORD,DISCOUNT) "
                + "VALUES ('" + name + "', '" + phone + "', '" + password + "', " + discount + ");";
        statement.executeUpdate(sql);
        connection.commit();

    }

    public static void fulfillTyres(int heigth, int width, int radius, String model, String type, int price)
            throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/TyresShop",
                        "postgres", "mypass");
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();
        String sql = "INSERT INTO \"tyres\" (HEIGTH,WIDTH,RADIUS,MODEL,TYPE,PRICE) "
                + "VALUES (" + heigth + ", " + width + ", " + radius + ", '" + model + "', '" + type + "', " + price + ");";
        statement.executeUpdate(sql);
        connection.commit();

    }

    public static void transactions(int customerId, int tyresId, int quantity, String answer) throws ClassNotFoundException, SQLException {
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

        ResultSet resultSetCustomerId = statement.executeQuery("SELECT DISCOUNT FROM \"customers\" WHERE ID = " + customerId + ";");
        while (resultSetCustomerId.next()) {
            discount = resultSetCustomerId.getInt("discount");
        }
        ResultSet resultSetTyresId = statement.executeQuery("SELECT PRICE FROM \"tyres\" WHERE ID = " + tyresId + ";");
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

        String sql = "INSERT INTO \"transactions\" (CUSTOMERID,TYRESID,QUANTITY,INSTALLATION,SUM) "
                + "VALUES (" + customerId + ", " + tyresId + ", " + quantity + ", " + install + ", " + sum + ");";
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