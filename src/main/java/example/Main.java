package example;

import config.mvc.TransactionConfig;
import config.mvc.TransactionMVC;
import config.mvc.TransactionPool;
import connection_pool.ConnectionPool;
import connection_pool.MySQLPool;
import connection_pool.PoolFactory;
import config.mvc.controller.Controller;
import config.logger.LoggerConfig;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.init("src/main/java/example/mvcConfig.json", "src/main/java/example/logConfig.json");
    }

    public void init(String mvcConfigFile, String loggerConfigFile) {
        LoggerConfig.readConfigFile(loggerConfigFile);
        Logger logger = LoggerConfig.createLogger(this.getClass());

        logger.fatal("nOOOooOOoo");

        try {
            TransactionConfig transactionConfig = new TransactionConfig();
            transactionConfig.readConfigFile(mvcConfigFile);
            TransactionPool pool = transactionConfig.getTransactionPool();

            TransactionMVC mvc = pool.getTransaction("example");
            Controller controller = mvc.getController();
            controller.processPetition("Daniel");
            controller.processPetition("Gabo");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Set<ConnectionPool> pools = new PoolFactory().getPools();

        try {
            for (ConnectionPool pool : pools) {
                if (pool instanceof MySQLPool) {
                    Connection con = pool.getConnection();
                    Statement statement = con.createStatement();
                    ResultSet result = statement.executeQuery("SELECT * FROM alumnos");
                    while (result.next()) {
                        int studentID = result.getInt(1);
                        int careerID = result.getInt(2);
                        String name = result.getString(3);
                        double average = result.getDouble(4);

                        System.out.println(studentID + ", " + careerID + ", " + name + ", " + average);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }


    }
}
