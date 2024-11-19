package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LerDados {

    public void listarAlunos() {
        // Conexão com o banco de dados
        Connection conexao = ConexaoBD.conectar();
        
        if (conexao != null) {
            String sql = "SELECT id, nome, idade FROM alunos";
            
            try {
                PreparedStatement stmt = conexao.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                System.out.println("\n=== Lista de Alunos ===");

                boolean encontrouRegistros = false;

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    int idade = rs.getInt("idade");

                    System.out.println("ID: " + id + " | Nome: " + nome + " | Idade: " + idade);
                    encontrouRegistros = true;
                }

                if (!encontrouRegistros) {
                    System.out.println("Nenhum registro encontrado.");
                }

                // Fecha o ResultSet e o PreparedStatement
                rs.close();
                stmt.close();

            } catch (SQLException e) {
                System.err.println("Erro ao listar alunos: " + e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        } else {
            System.err.println("Não foi possível conectar ao banco de dados.");
        }
    }
}
