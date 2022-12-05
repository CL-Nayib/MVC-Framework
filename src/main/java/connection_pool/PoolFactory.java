package connection_pool;

import config.database.DatabaseConfig;
import config.database.DatabaseConfigReader;
import config.exceptions.JsonAttributeException;
import config.pool.PoolConfig;
import config.pool.PoolConfigReader;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class PoolFactory {
    public Set<ConnectionPool> getPools() {

        Set<ConnectionPool> pools = new HashSet<>();

        try {
            PoolConfig[] poolConfigurations = getPoolConfigurations();
            DatabaseConfig[] databaseConfigurations = getDatabaseConfigurations();

            if (poolConfigurations.length != databaseConfigurations.length) {
                throw new IndexOutOfBoundsException("Pool configuration and database configuration should be same size");
            }

            for (int i = 0; i < poolConfigurations.length; i++) {

                String type = poolConfigurations[i].getDatabaseType().toLowerCase();
                int size = poolConfigurations[i].getSize();

                if (type.equals("mysql")) pools.add(MySQLPool.getInstance(databaseConfigurations[i], size));
                if (type.equals("mariadb")) pools.add(MariaDBPool.getInstance(databaseConfigurations[i], size));
                if (type.equals("oracle")) pools.add(OraclePool.getInstance(databaseConfigurations[i], size));
            }

        } catch (IndexOutOfBoundsException | JsonAttributeException | FileNotFoundException e) {
            System.err.println(e.getMessage());
        }

        return pools;
    }

    private PoolConfig[] getPoolConfigurations() throws JsonAttributeException, FileNotFoundException {
        PoolConfigReader reader = new PoolConfigReader("config/poolConfig.json");
        return reader.getConfigurations();
    }

    private DatabaseConfig[] getDatabaseConfigurations() throws JsonAttributeException, FileNotFoundException {
        DatabaseConfigReader reader = new DatabaseConfigReader("config/databaseConfig.json");
        return reader.getConfigurations();
    }
}
