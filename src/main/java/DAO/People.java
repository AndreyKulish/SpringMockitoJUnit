package DAO;

import org.springframework.stereotype.Component;
import sun.management.Agent;

/**
 * Created by hitek on 12.06.2017.
 */

public class People {

    private int ID;
    private String Name;
    private String SerName;
    private int Age;

    public People() {
    }

    public People(int ID, String name, String serName, int age) {
        this.ID = ID;
        Name = name;
        SerName = serName;
        Age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSerName() {
        return SerName;
    }

    public void setSerName(String serName) {
        SerName = serName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
}
