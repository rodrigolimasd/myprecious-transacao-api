package com.rodtech.myprecioustransacaoapi.service;

import com.rodtech.myprecioustransacaoapi.model.BaseModel;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseCrudService<T extends BaseModel, ID> {
    T buscarPorId(ID id);
    List<T> buscarTodos(Pageable pageable);
    T incluir(T entity);
    T atualizar(T entity);
    List<T> salvaLote(List<T> lote);
    void excluir(ID id);
}
