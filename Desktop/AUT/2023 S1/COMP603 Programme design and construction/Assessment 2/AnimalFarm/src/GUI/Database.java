package GUI;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    Connection conn = null;
    String url = "jdbc:derby:CarDB;create=true";
    String username = "pdc";  //your DB username
    String password = "pdc";   //your DB password

    public Database() {
        dbsetup();
    }

    public static void main(String[] args) {
        Database database = new Database();
        System.out.println(database.getConnection());
    }

    public Connection getConnection() {
        return this.conn;
    }
//  initialize the connection between the program and the database
    public void dbsetup() {
        try {
            conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();
            String tableName = "UserInfo";

            if (!checkTableExisting(tableName)) {
                statement.executeUpdate("CREATE TABLE " + tableName + " (userid VARCHAR(12), password VARCHAR(12), coin INT)");
            }
            statement.close();

        } catch (Throwable e) {
            System.out.println("error");
        }
    }
    
    private boolean checkTableExisting(String newTableName) {
        boolean flag = false;
        try {
            System.out.println("check existing tables.... ");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);//types);
            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
                    System.out.println(tableName + "  is there");
                    flag = true;
                }
            }
            if (rsDBMeta != null) {
                rsDBMeta.close();
            }
        } catch (SQLException ex) {
        }
        return flag;
    }
    
//  Check if the table has the username
    public Data checkName(String username, String password) {
        Data data = new Data(); // Initialize an instance of Data.
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT userid, password, coin FROM UserInfo "
                    + "WHERE userid = '" + username + "'");
            if (rs.next()) {
                String pass = rs.getString("password");
                System.out.println("***" + pass);
                System.out.println("found user");

                if (password.compareTo(pass) == 0) {
                    data.coin = rs.getInt("coin");
                } else {
                    System.out.println("Wrong password");
                }
            } else {
                System.out.println("New user created");
                statement.executeUpdate("INSERT INTO UserInfo "
                        + "VALUES('" + username + "', '" + password + "', 0)");
                data.coin = 10;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data; //Back to checkName() of Model.java.
    }

    public void saveGame(int coin, String username) {
        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("UPDATE UserInfo SET coin=" + coin + " WHERE userid='" + username + "'");

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}