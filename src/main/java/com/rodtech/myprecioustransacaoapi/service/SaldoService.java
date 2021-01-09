package com.rodtech.myprecioustransacaoapi.service;

import com.rodtech.myprecioustransacaoapi.model.Saldo;

public interface SaldoService extends BaseCrudService<Saldo, String> {

    Saldo buscarSaldo();

}
