package com.rodtech.myprecioustransacaoapi.controller;

import com.rodtech.myprecioustransacaoapi.model.SaldoDia;
import com.rodtech.myprecioustransacaoapi.service.SaldoDiaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/saldo-dias")
public class SaldoDiaController extends BaseController<SaldoDia, String, SaldoDiaService> {
    public SaldoDiaController(SaldoDiaService service) {
        super(service);
    }

    @PutMapping("/lote")
    public ResponseEntity<?> salvaLote(@RequestBody @Valid List<SaldoDia> lote){
        service.salvaLote(lote);
        return ResponseEntity.noContent().build();
    }
}
