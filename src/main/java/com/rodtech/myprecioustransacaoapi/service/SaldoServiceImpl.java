package com.rodtech.myprecioustransacaoapi.service;

import com.rodtech.myprecioustransacaoapi.model.Saldo;
import com.rodtech.myprecioustransacaoapi.repository.SaldoRepository;
import org.springframework.stereotype.Service;

@Service
public class SaldoServiceImpl extends BaseCrudServiceImpl<Saldo, String, SaldoRepository> implements SaldoService {
    public SaldoServiceImpl(SaldoRepository repositorio) {
        super(repositorio);
    }

    @Override
    public Saldo incluir(Saldo entity) {
        return super.incluir(atualizaSaldo(entity));
    }

    @Override
    public Saldo atualizar(Saldo entity) {
        return super.atualizar(atualizaSaldo(entity));
    }

    @Override
    public void excluir(String s) {
        throw  new RuntimeException("Operação desabilitada");
    }

    private Saldo atualizaSaldo(Saldo entity){
        Saldo saldoDb = repositorio.findAll().stream().findFirst().orElse(entity);
        saldoDb.setValor(entity.getValor());
        return saldoDb;
    }

    public Saldo buscarSaldo(){
        return repositorio.findAll().stream().findFirst().orElse(null);
    }
}
