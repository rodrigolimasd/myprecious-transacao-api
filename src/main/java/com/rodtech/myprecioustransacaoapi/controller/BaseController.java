package com.rodtech.myprecioustransacaoapi.controller;

import com.rodtech.myprecioustransacaoapi.model.BaseModel;
import com.rodtech.myprecioustransacaoapi.service.BaseCrudService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

public class BaseController<T extends BaseModel, ID, S extends BaseCrudService<T, ID>> {

    public final S service;

    public BaseController(S service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable ID id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<?> buscarTodos(Pageable pageable){
        return ResponseEntity.ok(service.buscarTodos(pageable));
    }

    @PostMapping
    public ResponseEntity<?> incluir(@RequestBody @Valid T entity){
        T novo = service.incluir(entity);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(novo.getId())
                .toUri();

        return ResponseEntity.created(uri).body(novo);
    }

    @PutMapping
    public ResponseEntity<?> atualizar(@RequestBody @Valid T entity){
        service.atualizar(entity);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable ID id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
