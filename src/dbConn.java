import java.sql.*;
import java.util.Scanner;

public class dbConn {

    private Connection connection;

    private String url = "jdbc:mysql://localhost:3306/testDb";
    private String user = "root";
    private String password = "rootpasssvftBP92";


    public void connect() {
        Connection conn = null;

            try {
                conn = DriverManager.getConnection(url, user, password);
                Statement mystmt = conn.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        this.connection = conn;
    }

    public void createTable() {
        String query = "CREATE TABLE Clients(id INT NOT NULL AUTO_INCREMENT, Name VARCHAR(60) NOT NULL, " +
                "Email VARCHAR(60) NOT NULL, Tel VARCHAR(20) NOT NULL, PRIMARY KEY (ID))";

        try {
            this.connection.createStatement().execute(query);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insertClient(Client client)throws SQLException {
        String ins = "INSERT INTO Clients (Name,Email,Tel) VALUES (?,?,?)";
        PreparedStatement pstmt;
        pstmt = this.connection.prepareStatement(ins);
        pstmt.setString(1, client.getName());
        pstmt.setString(2, client.getEmail());
        pstmt.setString(3, client.getPhoneN());

        int a = pstmt.executeUpdate();
        if(a>0){
            System.out.println("success");
        }
    }

    public void removeRow(int id) {
        String del = "DELETE FROM Clients WHERE id = ?";
        PreparedStatement pstmt;


        try {
            pstmt = this.connection.prepareStatement(del);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void update(String name, String email, String tel, int id) {
        String sql = "UPDATE Clients SET Name=?, Email=?, Tel=? WHERE id=?";
        PreparedStatement pstmt;

        try {
            pstmt = this.connection.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, tel);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }






}
