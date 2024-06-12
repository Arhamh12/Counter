package app;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {

    private static final String DATABASE = "jdbc:sqlite:database/Facts.db";

    public JDBCConnection() {
    }

    public ArrayList<facts> getFacts(int number) {

        ArrayList<facts> fact = new ArrayList<facts>();

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "select * from facts where Number="+number+";";

            ResultSet results = statement.executeQuery(query);

            while (results.next()) {

                int numFacts = results.getInt("Number");
                String bFacts = results.getString("Facts");
                String sFacts = results.getString("Sfacts");
                System.out.println(bFacts);
                System.out.println(numFacts);
                System.out.println(sFacts);
                facts facts = new facts(numFacts, bFacts, sFacts);

                fact.add(facts);
            }

            statement.close();
        } catch (SQLException e) {

            System.err.println(e.getMessage());
        } finally {

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {

                System.err.println(e.getMessage());
            }
        }

        return fact;
    }

}
