package view;

import DAO.People;
import model.DataWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by hitek on 12.06.2017.
 */

public class ViewShow {

    @Autowired
    @Qualifier(value = "getDataWorkStubImpl")
    DataWork dataWork;

    public ViewShow(DataWork dataWork){
        this.dataWork = dataWork;
    }

    public ViewShow(){

    }

    public void showListPeople(){
        for (People people: dataWork.getListPeople()) {
            System.out.println(
                    people.getID() + " " +
                    people.getName() + " " +
                    people.getSerName() + " " +
                    people.getAge()
            );
        }
    }

}
