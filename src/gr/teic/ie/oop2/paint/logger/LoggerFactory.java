package gr.teic.ie.oop2.paint.logger;

/**
 *
 * @author labuser
 */
public class LoggerFactory {
    public static MyLogger createLogger(){
        return new DatabaseLogger();
    }
}
