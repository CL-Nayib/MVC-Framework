package config.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

public class LogFactory {

    private static Logger LOG;



    public static Logger createLogger(Class clazz, int maxFileSize, int maxBackupIndex, boolean isActive) {
        try {
            LOG = Logger.getLogger(clazz.getName());
            String logfile = "logs/filelog.";
            Date fecha = new Date();

            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            String fechaAc = formato.format(fecha);
            PatternLayout defaultLayout = new PatternLayout("%d{dd-MM-yyyy HH:mm:ss} %-5p %c{1}:%L: %m%n");
            if (!isActive){
            LOG.setLevel(org.apache.log4j.Level.OFF);}

            RollingFileAppender rollingFileAppender = new RollingFileAppender();
            rollingFileAppender.setFile(logfile + fechaAc + ".log", true, false, 0);
            rollingFileAppender.setMaxFileSize(sizeParser(maxFileSize));
            rollingFileAppender.setMaxBackupIndex(maxBackupIndex);
            rollingFileAppender.setLayout(defaultLayout);

            LOG.removeAllAppenders();
            LOG.addAppender(rollingFileAppender);
            LOG.setAdditivity(true);

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LogModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return LOG;
    }

    private static String sizeParser (int size){
        return Integer.toString(size) + "MB";
    }

}
