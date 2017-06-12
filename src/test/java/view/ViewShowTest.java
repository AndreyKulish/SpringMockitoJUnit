package view;

import DAO.People;
import config.ApplicationConfiguration;
import model.DataWork;
import model.DataWorkImpl;
import model.DataWorkStubImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by hitek on 12.06.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes  = ApplicationConfiguration.class)
public class ViewShowTest {

    @Mock
    DataWorkStubImpl dataWorkStub;

    @Autowired
    @Qualifier(value = "getDataWorkImpl")
    private DataWork dataWorkSpringAnnotations;

    @Autowired
    ViewShow viewShowSpringAnnotations;

    @InjectMocks
    ViewShow viewShow = new ViewShow();

    @Test//проверка вызова метода
    public void isMockInit() throws Exception {
        viewShow.dataWork.getByID(2);
        verify(dataWorkStub).getByID(anyInt());
    }

    @Test//ручная иннициализация с проверкой
    public void stubByNewInitialization() throws Exception {
        DataWork dataWork = new DataWorkStubImpl(new ArrayList());
        ViewShow viewShow1 = new ViewShow(dataWork);

        assertEquals(dataWork.getListPeople().size(),10);
        viewShow1.showListPeople();
    }

    @Test//ручная иннициализация без стаба
    public void notStubByNewInitialization() throws Exception {
        DataWork dataWork = new DataWorkImpl(new ArrayList());
        ViewShow viewShow1 = new ViewShow(dataWork);

        assertEquals(dataWork.getListPeople().size(),10);
        viewShow1.showListPeople();
    }

    @Test//ручное внедренние листа
    public void whenThen(){
        List<People> list = new ArrayList<>();
        list.add(new People(20,"LOOOOLITA","teeest",100500));
        list.add(new People(19,"LOOOOLITA","teeest",100500));
        list.add(new People(18,"LOOOOLITA","teeest",100500));
        list.add(new People(17,"LOOOOLITA","teeest",100500));
        list.add(new People(16,"LOOOOLITA","teeest",100500));
        list.add(new People(15,"LOOOOLITA","teeest",100500));
        list.add(new People(14,"LOOOOLITA","teeest",100500));
        list.add(new People(13,"LOOOOLITA","teeest",100500));
        list.add(new People(12,"LOOOOLITA","teeest",100500));
        list.add(new People(11,"LOOOOLITA","teeest",100500));

        when(dataWorkStub.getListPeople()).thenReturn(list);
        assertEquals(viewShow.dataWork.getListPeople().size(),list.size());

    }

    @Test
    public void testSpringAnnotations(){
        ViewShow viewShow = new ViewShow(dataWorkSpringAnnotations);
        viewShow.showListPeople();
    }

    @Test
    public void testStupAggain(){
        assertEquals(viewShowSpringAnnotations.dataWork.getByID(12).getAge(),100500);
        ;
    }

}