package connection_pool;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class ConnectionPool {
    protected abstract String getDriverClassName();
    public abstract Connection getConnection();

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}