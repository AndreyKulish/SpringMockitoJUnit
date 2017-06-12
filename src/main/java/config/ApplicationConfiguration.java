package config;

import DAO.People;
import javafx.beans.NamedArg;
import model.DataWorkImpl;
import model.DataWorkStubImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import view.ViewShow;
import java.util.ArrayList;
import java.util.List;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

/**
 * Created by hitek on 12.06.2017.
 */
@Configuration
@ComponentScan(basePackages = {"config", "DAO", "model", "view"})
public class ApplicationConfiguration {


    @Bean
    @Scope("prototype")
    public People newPeople(){
        return new People();
    }

    @Bean
    @Qualifier("getDataWorkImpl")
    @Scope("singleton")
    public DataWorkImpl getDataWorkImpl(){
        return new DataWorkImpl(new ArrayList<>());
    }

    @Bean
    @Scope("singleton")
    @Qualifier("getDataWorkStubImpl")
    public DataWorkStubImpl getDataWorkStubImpl(){
        return new DataWorkStubImpl(new ArrayList<>());
    }

    @Bean
    @Scope("singleton")
    public ViewShow getViewShow(){
        return new ViewShow();
    }



}
