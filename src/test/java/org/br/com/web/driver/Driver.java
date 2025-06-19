package org.br.com.web.driver;

import lombok.Getter;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Getter
public class Driver {

    public static EdgeDriver nav;

    public static WebDriver getDriver() {
        return nav;
    }

    public static void abrirNav() {
        nav = new EdgeDriver();
        nav.get("https://orizon.com.br/");
        nav.manage().window().maximize();
    }

    public static void fecharNav() {
        if (nav != null) {
            nav.quit();
        }
    }

    public static Capabilities caps() {
        return nav != null ? nav.getCapabilities() : null;
    }
}
