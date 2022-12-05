package connection_pool;

import com.mysql.jdbc.Driver;
import config.database.DatabaseConfig;

public class MySQLPool extends ConnectionPool{

    private static MySQLPool pool;

    public static MySQLPool getInstance(DatabaseConfig databaseConfig, int poolSize) {
        if (pool == null) {
            //TODO: Read configurations and create pool instance
        }
        return pool;
    }

    private MySQLPool(DatabaseConfig databaseConfigInfo, int poolSize) {
        super(databaseConfigInfo, poolSize);
    }

    @Override
    protected String getDriverClassName() {
        return Driver.class.toString();
    }
}
