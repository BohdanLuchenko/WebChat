package tere;

import java.util.ArrayList;

/**
 * Created by Богдан on 25.06.2014.
 */
public class Manipulator {

    private static Manipulator instance;

    public static  Manipulator getInstance() {
        if (instance == null) {
            instance = new Manipulator();
        }

        return instance;
    }



    Team  team = Team.getInstance();





    public boolean checkAbilityToAddPersonToTeam(Person person){

        ArrayList<Person> newTeam  = team.getListOfPersonsOnline();
        boolean result = true;

        System.out.println("454545" +person.getName());
        for(int i = 0; i< newTeam.size(); i++){
            if(newTeam.get(i).getName().equals(person.getName())){
                result = false;
                break;
            }
            if (" ".equals(person.getName())){
                result = false;
                break;
            }

        }
        return result;
    }

    public void adderPersonToTeam(Person person){
        team.listOfPersonsOnline.add(person);
        System.out.println(person.getName());
        team.getListOfPersonsOnline();
    }

    public void removerPersonFromTheTeam(Person person){
        team.listOfPersonsOnline.remove(person);
    }



}