package com.gravadora.musica.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.gravadora.musica.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

    // query que vai salvar um endereco no banco de dados
    @Query("INSERT INTO endereco (rua, numero, bairro, cidade, estado, cep) VALUES (:rua, :numero, :bairro, :cidade, :estado, :cep)")
    void save(@Param("id") Long id ,@Param("rua") String rua, @Param("numero") int numero, @Param("bairro") String bairro, 
        @Param("cidade") String cidade, @Param("estado") String estado, @Param("cep") String cep);

    // query findByRuaAndNumero
    @Query("SELECT e FROM endereco e WHERE e.rua = :rua AND e.numero = :numero")
    Endereco findByRuaAndNumero(String rua, int numero);

    // query findByCep
    @Query("SELECT e FROM endereco e WHERE e.cep = :cep")
    Endereco findByCep(String cep);
}
