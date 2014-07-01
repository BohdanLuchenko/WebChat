package business_logic;

import java.util.ArrayList;

/**
 * Created by Богдан on 25.06.2014.
 */
public class Team {

    private static Team instance;
    private ArrayList<Person> listOfPersonsOnline = new ArrayList<Person>();

    public static Team getInstance() {
        if (instance == null) {
            instance = new Team();
        }
        return instance;
    }

    public void addPersonToTeam(Person person) {
        listOfPersonsOnline.add(person);
    }

    public void removePersonFromTeam(String nameOfPerson) {
        for (int i = 0; i < listOfPersonsOnline.size(); i++) {
            if (listOfPersonsOnline.get(i).getName().equals(nameOfPerson)) {
                listOfPersonsOnline.remove(i);
                break;
            }
        }

    }

    public ArrayList<Person> getListOfPersonsOnline() {
        return listOfPersonsOnline;
    }

}
