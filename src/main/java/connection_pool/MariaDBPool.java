package connection_pool;

import config.database.DatabaseConfig;
import org.mariadb.jdbc.Driver;

public class MariaDBPool extends ConnectionPool{

    private static MariaDBPool pool;

    public static MariaDBPool getInstance(DatabaseConfig databaseConfig, int poolSize) {
        if (pool == null) {
            //TODO: Read configurations and create pool instance
        }
        return pool;
    }

    private MariaDBPool(DatabaseConfig databaseConfigInfo, int poolSize) {
        super(databaseConfigInfo, poolSize);
    }

    @Override
    protected String getDriverClassName() {
        return Driver.class.toString();
    }
}
