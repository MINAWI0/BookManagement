package Dao;
import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
        private static Connection connection;
        static {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection
                        ("jdbc:mysql://mysql-3aa7b79c-minaouimh-855e.a.aivencloud.com:19060/defaultdb" ,"avnadmin","AVNS_D_FFEj0TqAorH2Cfe06" );
            }catch (Exception e){e.printStackTrace();}
        }
        public static Connection getConnection(){
            return connection;
        }
    }

