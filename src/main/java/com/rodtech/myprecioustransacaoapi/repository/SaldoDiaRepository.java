package com.rodtech.myprecioustransacaoapi.repository;

import com.rodtech.myprecioustransacaoapi.model.SaldoDia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface SaldoDiaRepository extends MongoRepository<SaldoDia, String> {

    Optional<SaldoDia> findFirstByData(LocalDate data);

}
