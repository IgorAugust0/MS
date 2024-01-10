package com.gravadora.musica.controller;
import java.util.List;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gravadora.musica.model.Instrumento;
import com.gravadora.musica.model.Musico;
import com.gravadora.musica.service.AdministradorService;
import com.gravadora.musica.service.EnderecoService;
import com.gravadora.musica.service.MusicaService;
import com.gravadora.musica.service.MusicoService;

@RestController
@ResponseBody
public class Controller {

    @Autowired
    AdministradorService administradorService;

    @Autowired
    EnderecoService enderecoService;

    @Autowired
    MusicaService musicaService;

    @Autowired
    MusicoService musicoService;

    // Recebe os dados necessarios para cadastrar uma pessoa
    @RequestMapping(value = "/cadastrarPessoa", method = RequestMethod.POST)
    public ResponseEntity<String> cadastrarPessoa(@RequestParam("nome") String nome, @RequestParam("cpf") String cpf, 
        @RequestParam("telefone") String telefone, @RequestParam("celular") String celular, @RequestParam("email") String email, 
            @RequestParam("rua") String rua, @RequestParam("bairro") String bairro, @RequestParam("numero") int numero, 
                @RequestParam("cidade") String cidade, @RequestParam("complemento") String complemento, 
                    @RequestParam("estado") String estado, @RequestParam("cep") String cep, @RequestParam("tipo") String tipo) {

        try {
            // verifica se o endereco ja existe no banco de dados
            boolean enderecoExistente = enderecoService.verificaExistencia(cep);

            // se o endereco nao existe, cadastra o endereco
            if (!enderecoExistente) {
                enderecoService.cadastrarEndereco(rua, bairro, numero, cidade, complemento, estado, cep);
            }

            // cadastra a pessoa
            administradorService.cadastrarPessoa(nome, cpf, telefone, celular, email, enderecoService.findByCep(cep), tipo);

            return new ResponseEntity<>("Pessoa cadastrada com sucesso", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Erro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro no banco de dados: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Recebe os dados necessarios para gravar uma musica
    @RequestMapping(value = "/gravarMusica", method = RequestMethod.POST)
    public ResponseEntity<String> cadastrarMusica(@RequestParam("id_estiloMusical") Long id_estiloMusical, @RequestParam("nome") String nome,
         @RequestParam("duracao") String duracao, @RequestParam("data_Criacao") String data_Criacao, @RequestParam("autores_letra") String autores_letra,
             @RequestParam("autores_musica") String autores_musica, @RequestParam("instrumentos") String instrumentos, 
                @RequestParam("produtor") String produtor, @RequestParam("musicoQueGravou") String musicoQueGravou, 
                    @RequestParam("id_banda") String id_banda) {

        // transforma os parametros em listas
        List<Instrumento> listaInstrumentos = musicaService.transformaInstrumentoLista(instrumentos);
        List<Musico> listaAutoresLetra = musicaService.transformaMusicoLista(autores_letra);
        List<Musico> listaAutoresMusica = musicaService.transformaMusicoLista(autores_musica);
        Map<Long, Long> listaMusicoQueGravou = musicaService.transformaMap(musicoQueGravou);

        // faz a verificação se os musicos ja estao associados ao instrumento
        // verifica o id do musico e o id do instrumento presentes em listaMusicoQueGravou
        for (Map.Entry<Long, Long> entry : listaMusicoQueGravou.entrySet()) {
            Long idMusico = entry.getKey();
            Long idInstrumento = entry.getValue();

            // verifica se o musico ja esta associado ao instrumento
            boolean musicoAssociado = musicoService.verificaInstrumento(idMusico, idInstrumento);

            // se o musico nao esta associado ao instrumento, cadastra a associacao
            if (!musicoAssociado) {
                musicoService.associarInstrumento(idMusico, idInstrumento);
            }
        }

        try {
            // cadastra a musica
            musicaService.gravarMusica(id_estiloMusical, nome, duracao, data_Criacao, listaAutoresLetra, listaAutoresMusica, 
                listaInstrumentos, produtor, listaMusicoQueGravou, id_banda);

            return new ResponseEntity<>("Musica cadastrada com sucesso", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Erro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro no banco de dados: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}

