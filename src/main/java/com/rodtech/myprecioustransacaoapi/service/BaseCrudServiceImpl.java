package com.rodtech.myprecioustransacaoapi.service;

import com.rodtech.myprecioustransacaoapi.model.BaseModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public abstract class BaseCrudServiceImpl<T extends BaseModel, ID, R extends MongoRepository<T, ID>> implements BaseCrudService<T, ID> {

    public final R repositorio;

    public BaseCrudServiceImpl(R repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public T buscarPorId(ID id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
    }

    @Override
    public List<T> buscarTodos(Pageable pageable) {
        return repositorio.findAll(pageable)
                .getContent();
    }

    @Override
    public T incluir(T entity) {
        return repositorio.save(entity);
    }

    @Override
    public T atualizar(T entity) {
        T entityDb = buscarPorId((ID)entity.getId());
        entityDb.copiarPropriedades(entity);
        return repositorio.save(entityDb);
    }

    @Override
    public void excluir(ID id) {
        T entityDb = buscarPorId(id);
        repositorio.delete(entityDb);
    }
}
