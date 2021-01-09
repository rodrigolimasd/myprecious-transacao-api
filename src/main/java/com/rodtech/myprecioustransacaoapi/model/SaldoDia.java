package com.rodtech.myprecioustransacaoapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Document(collection = "saldo_dias")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaldoDia extends BaseModel {

    @NotNull
    private LocalDate data;

    private BigDecimal valor;

    @Valid
    private List<Transacao> transacoes;
}
