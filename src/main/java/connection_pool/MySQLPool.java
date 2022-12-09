package connection_pool;

import com.mysql.cj.jdbc.Driver;
import config.database.DatabaseConfig;

public class MySQLPool extends ConnectionPool{

    private static MySQLPool pool;

    public static MySQLPool getInstance(DatabaseConfig databaseConfig, int poolSize) {
        if (pool == null) {
            pool = new MySQLPool(databaseConfig, poolSize);
        } else {
            pool.applyConfiguration(databaseConfig, poolSize);
        }
        return pool;
    }

    private MySQLPool(DatabaseConfig databaseConfigInfo, int poolSize) {
        super(databaseConfigInfo, poolSize);
    }

    @Override
    protected String getDriverClassName() {
        return Driver.class.getName();
    }
}
