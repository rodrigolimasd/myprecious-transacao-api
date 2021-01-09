package com.rodtech.myprecioustransacaoapi.model;

import com.rodtech.myprecioustransacaoapi.enums.TipoTransacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transacao extends BaseModelAPI {

    private LocalDateTime dataEfetivacao;
    @NotNull
    @Positive
    private BigDecimal valor;
    @NotNull
    private TipoTransacao tipo;
    private String descricao;
}
