package org.br.com.mobile.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.PageFactory;
import org.br.com.mobile.hooks.Hooks;

import java.time.Duration;

@Slf4j
public class MasterPageFactory {

    public static <T> T getPage(Class<T> cls){
        T page;

        try {
            page = cls.getDeclaredConstructor().newInstance();
            if (Hooks.getDriver() == null) {
                throw new IllegalStateException("Driver não está inicializado! Verifique o ciclo de vida do driver e a ordem de criação dos Page Objects.");
            }
            PageFactory.initElements(new AppiumFieldDecorator(Hooks.getDriver(), Duration.ofSeconds(10)), page);

        }catch (Exception e){
            log.error("Error on page instantiation", e);
            throw new RuntimeException(e);
        }

        return page;
    }

}