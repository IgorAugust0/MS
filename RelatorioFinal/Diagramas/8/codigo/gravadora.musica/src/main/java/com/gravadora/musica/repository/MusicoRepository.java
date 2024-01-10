package com.gravadora.musica.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gravadora.musica.model.Musico;

public interface MusicoRepository extends JpaRepository<Musico, Long>{

}
