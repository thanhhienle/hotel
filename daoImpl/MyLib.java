package daoImpl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TreeMap;

public class MyLib {

    private static Connection con;
    private static String host, user, pass;

    public static Connection getCon() {
        host = "127.0.0.1";
        user = "sa";
        pass = "asdad";
        Read();
        try {
            con = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://" + host + ":1433;database=Hotel";
            con = DriverManager.getConnection(url, "" + user + "", "" + pass + "");
        } catch (ClassNotFoundException ex) {
            System.out.println("Loi nap driver sai!");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Loi ket noi CSDL!");
            ex.printStackTrace();
        }
        return con;
    }

    private static void Read() {


        String fname = System.getProperty("user.dir") + "/lib/" + "cnn.txt";
        TreeMap<String, String> a = new TreeMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String s = null;
            while (br.ready()) {
                s = br.readLine();
                String[] x = null;
                if (s.equals("password=")) {
                    a.put("password", "");
                } else {
                    x = s.split("=");
                    a.put(x[0], x[1]);
                }
            }
            for (String o : a.keySet()) {
                switch (o) {
                    case "host":
                        host = a.get(o);
                        break;
                    case "username":
                        user = a.get(o);
                        break;
                    case "password":
                        pass = a.get(o);
                        break;
                }
            }
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
