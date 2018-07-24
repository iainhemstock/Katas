package com.iainhemstock;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Properties properties = new Properties();
            FileInputStream input = new FileInputStream(".dbconfig");
            properties.load(input);

            String dbserver = properties.getProperty("dbserver");
            String dbname = properties.getProperty("dbname");
            String dbusername = properties.getProperty("dbusername");
            String dbpassword = properties.getProperty("dbpassword");

            String url = dbserver + "/" + dbname;
            Connection connection = DriverManager.getConnection(url, dbusername, dbpassword);
            Statement statement = connection.createStatement();
            String query = "select first_name from account";
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                System.out.println(results.getString("first_name"));
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
