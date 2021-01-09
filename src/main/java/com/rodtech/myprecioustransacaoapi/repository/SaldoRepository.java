package com.rodtech.myprecioustransacaoapi.repository;

import com.rodtech.myprecioustransacaoapi.model.Saldo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaldoRepository extends MongoRepository<Saldo, String> {

}
