package com.expedia.exercise.config;

import com.expedia.exercise.controller.OfferController;
import com.expedia.exercise.dao.offer.IOffersDao;
import com.expedia.exercise.service.offer.IOfferService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {IOffersDao.class, IOfferService.class, OfferController.class, ExpediaServiceConfig.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
