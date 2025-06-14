package org.testes.driver.page;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.PageFactory;
import org.testes.utils.Hooks;
import io.appium.java_client.AppiumDriver;

@Slf4j
public class MasterPageFactory {

    public static <T> T getPage(Class<T> cls){
        T page;
        try {
            page = cls.getDeclaredConstructor(AppiumDriver.class).newInstance(Hooks.getDriver());
            PageFactory.initElements(new AppiumFieldDecorator(Hooks.getDriver()), page);
        }catch (Exception e){
            log.error("Error on page instantiation", e);
            throw new RuntimeException(e);
        }
        return page;
    }
}