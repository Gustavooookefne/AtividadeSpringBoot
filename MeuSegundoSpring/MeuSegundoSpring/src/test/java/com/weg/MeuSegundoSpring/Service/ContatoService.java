package com.weg.MeuSegundoSpring.Service;

import com.weg.MeuSegundoSpring.Model.Contato;
import com.weg.MeuSegundoSpring.Repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    public List<Contato>ObterContato()throws SQLException{
        return contatoRepository.obterContato();
    }

    public Contato salvarContato (Contato contato, int id)throws SQLException{
               contato.setId(id);
               contatoRepository.atualizarContato(contato);
        return contato;
    }

    public Contato buscarContatoPorId(int id)throws SQLException{
        return contatoRepository.buscarPorId(id);
    }

    public void deletarPorId(int id) throws SQLException{
        if(!contatoRepository.contatoExiste(id)){
            throw new RuntimeException("Contato não existe!");
        }

        contatoRepository.deletarContato(id);
    }

    public Contato atualizarContato(Contato contato, int id) throws SQLException{
        contato.setId(id);
        contatoRepository.atualizarContato(contato);

        return contato;
    }

    public Contato salvarContato(Contato contato) {
        return contato;
    }
}
