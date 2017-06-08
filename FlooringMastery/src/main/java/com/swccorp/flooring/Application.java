package com.swccorp.flooring;

import com.swccorp.flooring.controller.FlooringMasteryController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        FlooringMasteryController controller = applicationContext.getBean(FlooringMasteryController.class);
        controller.startApplication();
    }
}
