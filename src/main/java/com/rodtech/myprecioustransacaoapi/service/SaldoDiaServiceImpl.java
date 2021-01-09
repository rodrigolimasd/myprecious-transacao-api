package com.rodtech.myprecioustransacaoapi.service;

import com.rodtech.myprecioustransacaoapi.model.Saldo;
import com.rodtech.myprecioustransacaoapi.model.SaldoDia;
import com.rodtech.myprecioustransacaoapi.repository.SaldoDiaRepository;
import com.rodtech.myprecioustransacaoapi.utils.CalculadorUtil;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SaldoDiaServiceImpl extends BaseCrudServiceImpl<SaldoDia, String, SaldoDiaRepository> implements SaldoDiaService {

    private final SaldoService saldoService;

    public SaldoDiaServiceImpl(SaldoDiaRepository repositorio, SaldoService saldoService) {
        super(repositorio);
        this.saldoService = saldoService;
    }

    @Override
    public List<SaldoDia> buscarTodos(Pageable pageable) {
        return repositorio.findAllByOrderByData();
    }

    @Override
    public SaldoDia incluir(SaldoDia entity) {
        //calcularSaldoDoDIa(entity);
        validar(entity);
        return super.incluir(entity);
    }

    @Override
    public SaldoDia atualizar(SaldoDia entity) {
        //calcularSaldoDoDIa(entity);
        return super.atualizar(entity);
    }

    private void calcularSaldoDoDIa(SaldoDia entity){
        Saldo saldo = saldoService.buscarSaldo();
        CalculadorUtil.calcularSaldoDia(entity, saldo);
    }

    private void validar(SaldoDia entity){
        if(repositorio.findFirstByData(entity.getData()).isPresent()){
            throw new RuntimeException("Já existe um lançamento para a data " + entity.getData().toString());
        }
    }
}
