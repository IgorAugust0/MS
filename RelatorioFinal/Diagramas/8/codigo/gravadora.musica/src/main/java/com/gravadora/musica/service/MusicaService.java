package com.gravadora.musica.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.gravadora.musica.model.Instrumento;
import com.gravadora.musica.model.Musica;
import com.gravadora.musica.model.Musico;
import com.gravadora.musica.repository.MusicaRepository;

public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepository;

    public boolean gravarMusica(Long id_estiloMusical, String nome, String duracao, String data_Criacao, List<Musico> autores_letra, List<Musico> autores_musica, List<Instrumento> instrumentos, String produtor, Map<Long, Long> musicoQueGravou, String id_banda){

        Musica musica = new Musica(id_estiloMusical, nome, duracao, data_Criacao, autores_letra, autores_musica, instrumentos, produtor, musicoQueGravou, id_banda);

        musicaRepository.save(musica);

        return true;
    }

    public List<Instrumento> transformaInstrumentoLista(String instrumentos){

        List<Instrumento> lista = new ArrayList<Instrumento>();
        // implementa a transformação da string em lista de instrumentos
        return lista;
    }

    public List<Musico> transformaMusicoLista(String musicos){

        List<Musico> lista = new ArrayList<Musico>();
        // implementa a transformação da string em lista de musicos
        return lista;
    }

    public Map<Long, Long> transformaMap(String musicoQueGravou){

        Map<Long, Long> map = new HashMap<>();
        // implementa a transformação da string em map
        return map;
    }
    
}
