package org.br.com.web.pages;

import org.br.com.web.driver.Driver;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.PageFactory;

public class MasterPageFactory {

    public static <T> T getPage(Class<T> cls){
        T page;

        try {
            page = cls.getDeclaredConstructor().newInstance();
            PageFactory.initElements(Driver.getDriver(), page);

        }catch (Exception e){
            //log.info("Error on page instantiation", e);
            throw new RuntimeException(e);
        }

        return page;
    }

}