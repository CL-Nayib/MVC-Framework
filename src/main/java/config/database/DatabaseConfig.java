package config.database;

import config.Configuration;

import java.util.Objects;

public class DatabaseConfig extends Configuration {
    private final String id;
    private final String url;
    private final String user;
    private final String password;

    public DatabaseConfig(String id, String url, String user, String password) {
        this.id = id;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DatabaseConfig)) return false;

        boolean isSameId = Objects.equals(id, ((DatabaseConfig) obj).id);
        boolean isSameUrl = Objects.equals(url, ((DatabaseConfig) obj).url);
        boolean isSameUser = Objects.equals(user, ((DatabaseConfig) obj).user);
        boolean isSamePassword = Objects.equals(password, ((DatabaseConfig) obj).password);

        return isSameId && isSameUrl && isSameUser && isSamePassword;
    }
}
