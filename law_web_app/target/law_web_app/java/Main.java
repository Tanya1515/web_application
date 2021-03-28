import entities.Client;
import entities.Contract;

import service.Client_serv;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Client_serv serv = new Client_serv();
        Client cl_1 = serv.findClient(1);
        System.out.print(cl_1.getName());
    }
}
