package config.pool;

import config.Configuration;

import java.util.Objects;

public class PoolConfig extends Configuration {
    private final int size;
    private final int port;
    private final String urlServer;
    private final String databaseType;

    public PoolConfig(int size, int port, String urlServer, String databaseType) {
        this.size = size;
        this.port = port;
        this.urlServer = urlServer;
        this.databaseType = databaseType;
    }

    public int getSize() {
        return size;
    }

    public int getPort() {
        return port;
    }

    public String getUrlServer() {
        return urlServer;
    }

    public String getDatabaseType() {
        return databaseType;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PoolConfig)) return false;

        boolean isSameSize = size == ((PoolConfig) obj).size;
        boolean isSamePort = port == ((PoolConfig) obj).port;
        boolean isSameUrlServer = Objects.equals(urlServer, ((PoolConfig) obj).urlServer);
        boolean isSameDatabaseType = Objects.equals(databaseType, ((PoolConfig) obj).databaseType);

        return isSameSize && isSamePort && isSameUrlServer && isSameDatabaseType;
    }
}
