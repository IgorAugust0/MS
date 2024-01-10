package com.gravadora.musica.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gravadora.musica.model.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long>{

}
