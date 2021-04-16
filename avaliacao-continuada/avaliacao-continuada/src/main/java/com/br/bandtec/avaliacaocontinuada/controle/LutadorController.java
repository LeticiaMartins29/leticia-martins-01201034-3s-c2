package com.br.bandtec.avaliacaocontinuada.controle;

import com.br.bandtec.avaliacaocontinuada.dominio.Lutador;
import com.br.bandtec.avaliacaocontinuada.repositorio.LutadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lutadores")
public class LutadorController {

    @Autowired
    private LutadorRepository repository;

    @PostMapping
    public ResponseEntity postLutador(@RequestBody @Valid Lutador novoLutador) {
       if(novoLutador.getVida() > 0) {
           novoLutador.setVivo(true);
       } else{
           novoLutador.setVivo(false);
       }
       repository.save(novoLutador);
       return ResponseEntity.status(200).build();
    }



    @GetMapping
    public ResponseEntity getPorLutador(@RequestParam Double forcaGolpe) {
        return ResponseEntity.status(200).body(repository.findAllOrderByforcaGolpeDesc(forcaGolpe));

    }


    @GetMapping("/contagem-vivos")
    public ResponseEntity getLutadoresVivos() {
        return ResponseEntity.ok().body(repository.countByVivo(true));

    }

    @GetMapping("/mortos")
    public ResponseEntity getMortos() {

        List<Lutador> lutadores = repository.findAll();
        return ResponseEntity.ok(repository.findByVivoFalse());
    }

    @GetMapping("/vivos")
    public ResponseEntity getVivos() {
        List<Lutador> lutadores = repository.findAll();
        return ResponseEntity.ok(repository.findByVivoTrue());
    }

    
}