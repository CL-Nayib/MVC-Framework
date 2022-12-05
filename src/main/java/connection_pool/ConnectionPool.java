package connection_pool;

import config.database.DatabaseConfig;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class ConnectionPool {
    protected abstract String getDriverClassName();

    protected BasicDataSource basicDataSource;

    protected ConnectionPool(DatabaseConfig databaseConfigInfo, int poolSize) {
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(getDriverClassName());
        basicDataSource.setUsername(databaseConfigInfo.getUser());
        basicDataSource.setPassword(databaseConfigInfo.getPassword());
        basicDataSource.setUrl(databaseConfigInfo.getUrl());
        basicDataSource.setMaxTotal(poolSize);
        basicDataSource.setMaxWaitMillis(-1);
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = basicDataSource.getConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return connection;
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public void increasePoolSize(int increase) {
        int newTotal = basicDataSource.getMaxTotal() + increase;
        if (newTotal < 1) {
            System.err.println("Invalid pool size");
        } else {
            basicDataSource.setMaxTotal(basicDataSource.getMaxTotal() + increase);
        }
    }

    public void reducePoolSize(int reduce) {
        int newTotal = basicDataSource.getMaxTotal() - reduce;
        if (newTotal < 1) {
            System.err.println("Cannot reduce the pool lower than 0");
        } else {
            basicDataSource.setMaxTotal(newTotal);
        }
    }
}