package br.com.aula.conexao;
import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	public class AtualizarDados {
		//Método para atualizar os alunos com id, nome e idade no Banco de Dados
	    public void atualizarAluno(int id, String novoNome, int novaIdade) {
	        String sql = "UPDATE alunos SET nome = ?, idade = ? WHERE id = ?";

	        try (Connection conexao = ConexaoDB.conectar();
	             PreparedStatement stmt = conexao.prepareStatement(sql)) {

	        	//Define os métodos de nome, nova idade e id no SQL
	            stmt.setString(1, novoNome);
	            stmt.setInt(2, novaIdade);
	            stmt.setInt(3, id);

	            //Verificção se o aluno foi atualizado
	            int rowsAffected = stmt.executeUpdate();
	            if (rowsAffected > 0) {
	                System.out.println("Aluno atualizado com sucesso!");
	            } else {
	                System.out.println("Nenhum aluno encontrado com o ID informado.");
	            }
	        } catch (SQLException e) {
	            System.out.println("Erro ao atualizar aluno: " + e.getMessage());
	        }
	    }
	}