package com.br.bandtec.avaliacaocontinuada.repositorio;

import com.br.bandtec.avaliacaocontinuada.dominio.Lutador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LutadorRepository extends JpaRepository<Lutador, Integer> {


    List<Lutador> findAllOrderByforcaGolpeDesc(Double forcaGolpe);
    List<Lutador> findByVivoTrue();
    List<Lutador> findByVivoFalse();

    int countByVivo(boolean s);


}
