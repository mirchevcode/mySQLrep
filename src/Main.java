import javax.swing.plaf.nimbus.State;
import java.sql.SQLException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        dbConn con = new dbConn();
        con.connect();
        Client bob2 = new Client("bob2", "bob@blob.hop", "0987654321");
        try {
            con.insertClient(bob2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        con.update("Hod", "oo@aa.iiiiii", "098764122346", 3);

//        ArrayList<Client> arr = new ArrayList<>();
//        arr.add(bob);
//
//        for (int i = 0; i < arr.size(); i+=2) {
//
//        } {
//            System.out.println(arr);
//        }

//        command line GITHUB!!!








    }

}
