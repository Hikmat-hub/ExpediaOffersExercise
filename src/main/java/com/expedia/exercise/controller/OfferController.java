package com.expedia.exercise.controller;

import com.expedia.exercise.pojo.request.OffersRequest;
import com.expedia.exercise.pojo.response.OffersResponse;
import com.expedia.exercise.service.offer.IOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;


@Controller
public class OfferController {

    @Autowired
    private IOfferService offerService;

    @GetMapping(path = {"/","/filter"})
    public String submitForm(@Valid OffersRequest offersRequest,
                             BindingResult result, Model m) {
        if(result.hasErrors() || offersRequest == null) {
            return "offerHome";
        }
        final OffersResponse resultOfferResponse = offerService.filter(offersRequest);
        m.addAttribute("offersResponse", resultOfferResponse);
        return "offerHome";
    }

}
