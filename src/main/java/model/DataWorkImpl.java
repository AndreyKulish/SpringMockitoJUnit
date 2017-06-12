package model;

import DAO.People;
import config.ApplicationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by hitek on 12.06.2017.
 */

public class DataWorkImpl implements DataWork{


    private People people;
    private List<People> listOfPeople;

    public DataWorkImpl(ArrayList<People> arrayList){
        for (int i = 0; i < 10; i++) {
            listOfPeople = arrayList;
            people = new People();
            people.setID(i);
            people.setName(randomString());
            people.setSerName(randomString());
            people.setAge(new Random().nextInt(50)+15);
            listOfPeople.add(people);
        }
    }

    @Override
    public List getListPeople() {
        return listOfPeople;
    }

    @Override
    public People getByID(int ID) {
        for (People people1: listOfPeople) {
            if(ID == people1.getID()){
                return people1;
            }
        }
        return null;
    }

    @Override
    public boolean deleteByID(int ID) {
        boolean flag = false;
        for (People people1: listOfPeople) {
            if(ID == people1.getID()){
                listOfPeople.remove(people1);
                flag = true;
            }else{
                flag = false;
            }
        };
        return flag;
    }

    @Override
    public boolean addNewPeople(People people) {
        listOfPeople.add(people);
        return true;
    }

    @Override
    public boolean deleteAll() {
        listOfPeople.clear();
        return true;
    }

    private String randomString(){
        StringBuffer bf = new StringBuffer(10);
        for (int i = 0; i < 10; i++) {
                bf.append((char)(new Random().nextInt(25) + 65));
        }
        return bf.toString();
    }

}
