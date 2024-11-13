package br.com.aula.conexao;
import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	public class LerDados {
		//Método para listar os alunos no Banco de Dados
	    public void listarAlunos() {
	        String sql = "SELECT * FROM alunos";

	        try (Connection conexao = ConexaoDB.conectar();
	             PreparedStatement stmt = conexao.prepareStatement(sql);
	             ResultSet rs = stmt.executeQuery()) {

	        	//Resultado e exibição dos alunos com id, nome e idade no Banco de Dados
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String nome = rs.getString("nome");
	                int idade = rs.getInt("idade");

	                System.out.println("ID: " + id + ", Nome: " + nome + ", Idade: " + idade);
	            }
	        } catch (SQLException e) {
	        	//Mensagem caso ocorra um erro no programa
	            System.out.println("Erro ao ler dados dos alunos: " + e.getMessage());
	        }
	    }
	}