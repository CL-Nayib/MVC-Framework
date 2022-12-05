package connection_pool;

import config.database.DatabaseConfig;
import oracle.jdbc.OracleDriver;

public class OraclePool extends ConnectionPool{

    private static OraclePool pool;

    public static OraclePool getInstance(DatabaseConfig databaseConfig, int poolSize) {
        if (pool == null) {
            //TODO: Read configurations and create pool instance
        }
        return pool;
    }

    private OraclePool(DatabaseConfig databaseConfigInfo, int poolSize) {
        super(databaseConfigInfo, poolSize);
    }

    @Override
    protected String getDriverClassName() {
        return OracleDriver.class.toString();
    }
}
