package com.Controller;

import com.Model.Entity.Zapisany;
import com.Service.ZapisanyService;
import com.View.ZapisanyView;

/**
 * Created by Piotrek on 2017-03-07.
 */
public class ZapisanyController {

    private ZapisanyService zapisanyService;
    private ZapisanyView zapisanyView;

    public ZapisanyController(){};
    public ZapisanyController(ZapisanyService zapisanyService, ZapisanyView zapisanyView){

        this.zapisanyService=zapisanyService;
        this.zapisanyView=zapisanyView;
    }
}
