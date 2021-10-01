package advanced.codelab02;

import java.util.logging.Logger;

public class LoggingExample {
    private static Logger log = Logger.getLogger("codelab08.LoggingExample");

    public String helloExample() {
        log.severe("This is a severe log message. It should be used to log severe or unexpected failures.");
        log.warning("This is a warning log message. It should be used to log non-severe failures or exceptional conditions that are expected.");
        log.info("This is an info log message. It should be used to log informative messages that are appropriate for production or customer use.");
        return "<h1>`System.out.println();` is forbidden!</h1><p>Logging for the win!</p>";
    }

    public static void main(String[] args) {
        new LoggingExample().helloExample();
    }
}
