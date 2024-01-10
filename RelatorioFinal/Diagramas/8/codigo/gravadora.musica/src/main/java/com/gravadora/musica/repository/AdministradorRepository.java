package com.gravadora.musica.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gravadora.musica.model.Administrador;
import com.gravadora.musica.model.Endereco;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    // query que vai salvar um administrador ou um musico no banco de dados
    @Query("INSERT INTO administrador (nome, cpf, telefone, celular, email, endereco) VALUES (:nome, :cpf, :telefone, :celular, :email, :endereco)")
    void saveAdministrador(@Param("id") Long id ,@Param("nome") String nome, @Param("cpf") String cpf, @Param("telefone") 
        String telefone, @Param("celular") String celular, @Param("email") String email, @Param("endereco") Endereco endereco);
    
    // query que vai salvar um musico no banco de dados
    @Query("INSERT INTO musico (nome, cpf, telefone, celular, email, endereco) VALUES (:nome, :cpf, :telefone, :celular, :email, :endereco)")
    void saveMusico(@Param("id") Long id ,@Param("nome") String nome, @Param("cpf") String cpf, @Param("telefone") String telefone, 
        @Param("celular") String celular, @Param("email") String email, @Param("endereco") Endereco endereco);

    // query que vai buscar uma pessoa pelo cpf
    @Query("SELECT p FROM pessoa p WHERE p.cpf = :cpf")
    Administrador findByCpf(@Param("cpf") String cpf);
}
