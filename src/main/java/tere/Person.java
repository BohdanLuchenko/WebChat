package tere;

/**
 * Created by Богдан on 25.06.2014.
 */

//Людина, яка зайшла посидіти в чаті. Якщо пройшла авторизацію - статус = тру
public class Person {

    private String name = null;

    public Person(String name){

        this.name = name;

        System.out.println(this.name);
    }


    public String getName() {
        System.out.println(name);
        return name;
    }
}
