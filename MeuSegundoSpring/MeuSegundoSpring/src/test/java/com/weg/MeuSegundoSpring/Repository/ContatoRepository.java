package com.weg.MeuSegundoSpring.Repository;

import com.weg.MeuSegundoSpring.Conexao.Conexao;
import com.weg.MeuSegundoSpring.Model.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoRepository {

    public Contato save(Contato contato)throws SQLException{
        String sql = """
                INSERT INTO Contato
                (nome , numero) 
                VALUES
                (?,?)
                """;

        try (Connection conn = Conexao.connection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

             ps.setInt(1,contato.getId());
             ps.setString(2,contato.getNome());
             ps.setInt(3,contato.getNumero());

             ps.executeUpdate();
             ResultSet rs = ps.getGeneratedKeys();
             if(rs.next()){
                contato.setId(rs.getInt(1));
                return contato;
            }
            throw new RuntimeException("Não foi possivel salvar");
        }

    }

    public List<Contato> obterContato()throws SQLException{
           List<Contato>contatos = new ArrayList<>();

           String sql = """
                   SELECT contatos
                   nome,
                   numero,
                   FROM contatos
                   """;

           try (Connection conn = Conexao.connection();
           PreparedStatement psList = conn.prepareStatement(sql)){
               ResultSet rs = psList.executeQuery();
               while (rs.next()){
                   Contato contato = new Contato();
                   contato.setId(rs.getInt("id"));
                   contato.setNome(rs.getString("nome"));
                   contato.setNumero(rs.getInt("numero"));
                   contatos.add(contato);
               }
           }

        return contatos;
    }

    public Contato buscarPorId(int id)throws SQLException{
        Contato contato = null;
        String sql = """
                SELECT contato 
                nome,
                numero,
                FROM contato
                WHERE id = ?
                """;

        try (Connection conn = Conexao.connection();
        PreparedStatement psId = conn.prepareStatement(sql)){
            psId.setInt(1,id);
            try (ResultSet rs = psId.executeQuery()){
                contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setNumero(rs.getInt("numero"));
            }


        }

        return contato;
    }

    public void atualizarContato (Contato contato)throws SQLException{
        String slq = """
                UPDATE contato
                SET 
                nome = ?
                numero = ?
                WHERE id = ?
                """;

        try (Connection conn = Conexao.connection();
        PreparedStatement psUPD = conn.prepareStatement(slq)){
            psUPD.setString(1,contato.getNome());
            psUPD.setInt(2,contato.getNumero());
            psUPD.setInt(3,contato.getId());
            psUPD.executeUpdate();
        }

    }

    public void deletarContato(int id)throws SQLException{
        String sql = """
                DELETE FROM contato
                WHERE id = ?
                """;

        try (Connection conn = Conexao.connection();
        PreparedStatement psDEL = conn.prepareStatement(sql)){

            psDEL.setInt(1,id);
            psDEL.executeUpdate();
        }

    }

    public boolean contatoExiste(int id) {
        return false;
    }
}
