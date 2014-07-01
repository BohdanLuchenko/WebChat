package tere;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

/**
 * Created by Богдан on 25.06.2014.
 */
public class Messager {


    private static Messager instance;

    public static  Messager getInstance() {
        if (instance == null) {
            instance = new Messager();
        }
        return instance;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessages() {
        return allMessages.toString();
    }

    private String messages = "";
    ArrayList last100Messages = new ArrayList();



    public String getCurrentTime() {
        Calendar cal = Calendar.getInstance();
        cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println( sdf.format(cal.getTime()) );
        String time = sdf.format(cal.getTime()).toString();
        return time;
    }





        private StringBuilder allMessages = new StringBuilder();


    public void addMessageByUser(String message, String user){
        String formatedMsg = formatMessage(message, user);
        allMessages.append(formatedMsg);
    }

    private String formatMessage(String msg, String user){
        return "["+ getCurrentTime() + "]" +user +": "+ msg + "<br>";
    }



    /*public String addMessageByUser(String message, String user){
        if (message.equals("undefined")){
            return messages;
        }
        if (last100Messages.size() > 10){
            last100Messages.remove(0);
            last100Messages.add(message);
        }else {
            last100Messages.add(message);
        }
        for (int i = 0; i<last100Messages.size(); i++){
            messages = messages + "["+ getCurrentTime() + "]" + user + ": " + last100Messages.get(i) + " <br>";
        }
        return messages;
    }*/
}
