package br.com.aula.conexao;
import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	

	public class DeletarDados {
		//Método para deletar alunos do Banco de Dados
	    public void deletarAluno(int id) {
	        String sql = "DELETE FROM alunos WHERE id = ?";

	        try (Connection conexao = ConexaoDB.conectar();
	             PreparedStatement stmt = conexao.prepareStatement(sql)) {

	        	//Método para deletar do SQL
	            stmt.setInt(1, id);

	            //Verifica se o aluno foi deletado com sucesso ou se deu algum erro
	            int rowsAffected = stmt.executeUpdate();
	            if (rowsAffected > 0) {
	                System.out.println("Aluno deletado com sucesso!");
	            } else {
	                System.out.println("Nenhum aluno encontrado com o ID informado.");
	            }
	        } catch (SQLException e) {
	            System.out.println("Erro ao deletar aluno: " + e.getMessage());
	        }
	    }
	}