package model;

import DAO.People;

import java.util.List;

/**
 * Created by hitek on 12.06.2017.
 */
public interface DataWork {

    public List<People> getListPeople();
    public People getByID(int ID);
    public boolean deleteByID(int ID);
    public boolean addNewPeople(People people);
    public boolean deleteAll();

}
