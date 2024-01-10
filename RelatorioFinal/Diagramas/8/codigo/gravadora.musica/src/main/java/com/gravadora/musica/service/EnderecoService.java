package com.gravadora.musica.service;
import org.springframework.beans.factory.annotation.Autowired;
import com.gravadora.musica.model.Endereco;
import com.gravadora.musica.repository.EnderecoRepository;

public class EnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    public void cadastrarEndereco(String rua, String bairro, int numero, String cidade, 
    String complemento, String estado, String cep) {

        // verifica se o endereco ja existe no banco de dados
        Endereco enderecoExistente = enderecoRepository.findByCep(cep);

        // se o endereco ja existe, lanca uma excecao
        if (enderecoExistente != null) {
            throw new RuntimeException("Endereco já existe");
        }

        // Cria a instancia de Endereco
        Endereco endereco = new Endereco(rua, bairro, numero, cidade, complemento, estado, cep);

        // Salva o endereco no banco de dados
        enderecoRepository.save(endereco.getId(), endereco.getRua(), endereco.getNumero(), 
        endereco.getBairro(), endereco.getCidade(), endereco.getEstado(), endereco.getCep());
    }

    // verifica se o endereco ja existe no banco de dados
    public boolean verificaExistencia(String cep) {
        Endereco enderecoExistente = enderecoRepository.findByCep(cep);
        if (enderecoExistente != null) {
            return true;
        }
        return false;
    }

    // retorna o endereco pelo cep
    public Endereco findByCep(String cep) {
        return enderecoRepository.findByCep(cep);
    }
}
