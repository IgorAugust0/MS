package com.gravadora.musica.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.gravadora.musica.model.Banda;
import com.gravadora.musica.model.Musico;
import com.gravadora.musica.repository.BandaRepository;

public class BandaService {

    @Autowired
    private BandaRepository bandaRepository;

    // salvar banda -> recebe os dados da banda, cria e salva no banco de dados atraves do repository
    public void cadastrarBanda(String nome, String descricao, String data_criacao, List<Musico> musicos) {
        Banda banda = new Banda(nome, descricao, data_criacao, musicos);
        bandaRepository.save(banda);
    }

}
