package com.weg.MeuSegundoSpring.Controller;

import com.weg.MeuSegundoSpring.Model.Contato;
import com.weg.MeuSegundoSpring.Service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/olamundo")
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping
    public List<Contato> olamundo(){
        try {
            return contatoService.ObterContato();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PostMapping
    public Contato postContato(
            @RequestBody Contato contato
    ){
        return contatoService.salvarContato(contato);
    }


    @PutMapping("/{id}")
    public Contato updateContato(
            @PathVariable int id,
            @RequestBody Contato contato
    ){
        try{
            return contato = contatoService.atualizarContato(contato,id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Contato buscarContatoPorId(
            @PathVariable int id
    ){
        try{
            return contatoService.buscarContatoPorId(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCotato(
            @PathVariable int id
    ){
        try{
            contatoService.deletarPorId(id);
        }catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
