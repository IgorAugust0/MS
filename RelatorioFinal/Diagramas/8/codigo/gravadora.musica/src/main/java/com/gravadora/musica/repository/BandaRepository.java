package com.gravadora.musica.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gravadora.musica.model.Banda;

public interface BandaRepository extends JpaRepository<Banda, Long>{
    
}
