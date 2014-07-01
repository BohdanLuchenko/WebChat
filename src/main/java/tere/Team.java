package tere;

import java.util.ArrayList;

/**
 * Created by Богдан on 25.06.2014.
 */
public class Team {

    private static Team instance;

    public static  Team getInstance() {
        if (instance == null) {
            instance = new Team();
        }
        return instance;
    }




    public ArrayList<Person> listOfPersonsOnline = new ArrayList<Person>();

    public ArrayList<Person> getListOfPersonsOnline() {

        return listOfPersonsOnline;
    }

}
