package com.rodtech.myprecioustransacaoapi.utils;

import com.rodtech.myprecioustransacaoapi.enums.TipoTransacao;
import com.rodtech.myprecioustransacaoapi.model.Saldo;
import com.rodtech.myprecioustransacaoapi.model.SaldoDia;
import com.rodtech.myprecioustransacaoapi.model.Transacao;

import java.math.BigDecimal;

public class CalculadorUtil {

    public static void calcularSaldoDia(SaldoDia saldoDia, Saldo saldo){

        BigDecimal totalDespesasDia = saldoDia.getTransacoes().stream()
                .filter(p-> p.getTipo().equals(TipoTransacao.DESPESA))
                .map(Transacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalReceitasDia = saldoDia.getTransacoes().stream()
                .filter(p-> p.getTipo().equals(TipoTransacao.RECEITA))
                .map(Transacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        //fórmula (saldo + receitas) - despesas
        saldoDia.setValor(saldo.getValor().add(totalReceitasDia).subtract(totalDespesasDia));

    }
}
