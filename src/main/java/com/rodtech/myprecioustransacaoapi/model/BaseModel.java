package com.rodtech.myprecioustransacaoapi.model;

import com.rodtech.myprecioustransacaoapi.utils.EntidadeUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel extends BaseModelAPI {
    @Id
    private String id;
    @CreatedDate
    private LocalDateTime criacao;
    @LastModifiedDate
    private LocalDateTime edicao;

    public void copiarPropriedades(Object origem) {
        EntidadeUtils.copiarPropriedades(this, origem);
    }
}
