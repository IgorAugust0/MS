package com.gravadora.musica.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.gravadora.musica.repository.MusicoRepository;

public class MusicoService {
    
    @Autowired
    private MusicoRepository musicoRepository;

    public boolean verificaInstrumento(Long id_musico, Long id_instrumento) {

        // verifica no banco de dados se o musico tem aquele instrumento na sua lista de instrumentos
        boolean resposta = musicoRepository.findById(id_musico).get().getInstrumentos().contains(id_instrumento);
        if (resposta) {
            return true;
        } else {
            return false; 
        }
    }

    // associa um instrumento a um musico
    public boolean associarInstrumento(Long id_musico, Long id_instrumento) {
        // verifica se o musico ja tem aquele instrumento
        if (verificaInstrumento(id_musico, id_instrumento)) {
            return false;
        } else {
            // adiciona o instrumento na lista de instrumentos do musico
            musicoRepository.findById(id_musico).get().getInstrumentos().add(id_instrumento);
            return true;
        }
    }
}
