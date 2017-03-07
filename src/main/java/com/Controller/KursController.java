package com.Controller;

import com.Service.KursService;
import com.View.KursView;

/**
 * Created by Piotrek on 2017-03-07.
 */
public class KursController {

    private KursService kursService;
    private KursView kursView;

    public KursController(){};

    public KursController(KursService kursService, KursView kursView){

        this.kursService=kursService;
        this.kursView=kursView;
    }


}
