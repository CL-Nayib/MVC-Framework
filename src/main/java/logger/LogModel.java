package logger;


import config.Configuration;

public class LogModel extends Configuration {

    private final boolean active;
    private final int maxFileSize;
    private final int maxFiles;

    public LogModel(boolean active, int maxFileSize, int maxFiles) {
        this.active = active;
        this.maxFileSize = maxFileSize;
        this.maxFiles = maxFiles;
    }

    public boolean isActive() {
        return active;
    }

    public int getMaxFileSize() {
        return maxFileSize;
    }

    public int getMaxFiles() {
        return maxFiles;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LogModel)) return false;
        boolean isSameActive = active == ((LogModel) obj).active;
        boolean isSameMaxFileSize = maxFileSize == ((LogModel) obj).maxFileSize;
        boolean isSameMaxFiles = maxFiles == ((LogModel) obj).maxFiles;

        return isSameActive && isSameMaxFileSize && isSameMaxFiles;
    }

}