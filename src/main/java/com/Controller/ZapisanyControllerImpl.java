package com.Controller;

import com.Model.Entity.Zapisany;
import com.Service.ZapisanyService;
import com.View.ZapisanyView;

/**
 * Created by Piotrek on 2017-03-07.
 */
public class ZapisanyControllerImpl {

    private ZapisanyService zapisanyService;
    private ZapisanyView zapisanyView;

    public ZapisanyControllerImpl(){};
    public ZapisanyControllerImpl(ZapisanyService zapisanyService, ZapisanyView zapisanyView){

        this.zapisanyService=zapisanyService;
        this.zapisanyView=zapisanyView;
    }
}
