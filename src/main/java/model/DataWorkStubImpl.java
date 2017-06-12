package model;

import DAO.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hitek on 12.06.2017.
 */

public class DataWorkStubImpl implements DataWork {

    private List<People> listOfPeople;

    public DataWorkStubImpl(ArrayList<People> arrayList){
        listOfPeople = arrayList;
        addToList();
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

    private void addToList(){
        listOfPeople.add(new People(20,"Wow","Test",100500));
        listOfPeople.add(new People(19,"Wow","Test",100500));
        listOfPeople.add(new People(18,"Wow","Test",100500));
        listOfPeople.add(new People(17,"Wow","Test",100500));
        listOfPeople.add(new People(16,"Wow","Test",100500));
        listOfPeople.add(new People(15,"Wow","Test",100500));
        listOfPeople.add(new People(14,"Wow","Test",100500));
        listOfPeople.add(new People(13,"Wow","Test",100500));
        listOfPeople.add(new People(12,"Wow","Test",100500));
        listOfPeople.add(new People(11,"Wow","Test",100500));
    }
}
