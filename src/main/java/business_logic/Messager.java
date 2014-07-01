package business_logic;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Богдан on 25.06.2014.
 */
public class Messager {

    private static Messager instance;
    public static int MAX_NUMBER_OF_MESSAGES = 100;
    private int messageCounter = 0;
    private StringBuilder allMessages = new StringBuilder();
    public static String MESSAGE_SEPARATOR = "<br>";

    public static Messager getInstance() {
        if (instance == null) {
            instance = new Messager();
        }
        return instance;
    }

    public String getMessages() {
        return allMessages.toString();
    }

    public String getCurrentTime() {
        Calendar cal = Calendar.getInstance();
        cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println(sdf.format(cal.getTime()));
        String time = sdf.format(cal.getTime()).toString();
        return time;
    }

    public void addMessageByUser(String message, String user) {
        String formatedMsg = formatMessage(message, user);
        if (messageCounter > MAX_NUMBER_OF_MESSAGES) {
            allMessages.delete(0, allMessages.indexOf(MESSAGE_SEPARATOR) + MESSAGE_SEPARATOR.length());
        }
        allMessages.append(formatedMsg);
        messageCounter++;
    }

    private String formatMessage(String msg, String user) {
        return "[" + getCurrentTime() + "]" + user + ": " + msg + MESSAGE_SEPARATOR;
    }
}
