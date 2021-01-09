package com.rodtech.myprecioustransacaoapi.controller;

import com.rodtech.myprecioustransacaoapi.model.Saldo;
import com.rodtech.myprecioustransacaoapi.service.SaldoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/saldo")
public class SaldoController extends BaseController<Saldo, String, SaldoService> {
    public SaldoController(SaldoService service) {
        super(service);
    }
}
