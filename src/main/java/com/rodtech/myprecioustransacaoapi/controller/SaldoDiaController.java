package com.rodtech.myprecioustransacaoapi.controller;

import com.rodtech.myprecioustransacaoapi.model.SaldoDia;
import com.rodtech.myprecioustransacaoapi.service.SaldoDiaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saldo-dias")
public class SaldoDiaController extends BaseController<SaldoDia, String, SaldoDiaService> {
    public SaldoDiaController(SaldoDiaService service) {
        super(service);
    }
}
