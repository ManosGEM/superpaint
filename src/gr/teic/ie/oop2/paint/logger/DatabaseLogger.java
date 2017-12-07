/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teic.ie.oop2.paint.logger;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author labuser
 */
public class DatabaseLogger implements MyLogger {

    private Connection connect = null;
    private Statement statement = null;

    @Override
    public void writeLog(String text) {
        try {
            //String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connect =  DriverManager.getConnection("jdbc:derby://localhost:1527/logsdb");
            PreparedStatement statement = connect.prepareStatement("insert into LOGS (timestamp_ ,value) values (?,?)");

            statement.setTimestamp(1, new java.sql.Timestamp(new java.util.Date().getTime() ));
            statement.setString(2, text);
            statement.executeUpdate();
            connect.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (Exception e) {

            }
        }
    }

}
