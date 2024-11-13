package br.com.aula.conexao;
import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.util.Scanner;

	//Classe contrutora responsável por inserir dados no Banco de Dados
	public class InserirDados {
		//Método utilizado para inserir nome e idade da pessoa no Banco de Dados
	    public void inserirAluno(String nome, int idade) {
	        String sql = "INSERT INTO alunos (nome, idade) VALUES (?, ?)";

	
	        try (Connection conexao = ConexaoDB.conectar();
	             PreparedStatement stmt = conexao.prepareStatement(sql)) {

	        	//Define os métodos dos comandos do SQL, como o nome e idade da pessoa
	            stmt.setString(1, nome);
	            stmt.setInt(2, idade);
	            stmt.executeUpdate();
	            //Mostra se o aluno foi inserido ou se deu algum tipo de erro 
	            System.out.println("Aluno inserido com sucesso!");
	        } catch (SQLException e) {
	            System.out.println("Erro ao inserir aluno: " + e.getMessage());
	        }
	    }

	    public static void main(String[] args) {
	    	//Instanciando um objeto Scanner para rodar o programa
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Nome do aluno: ");
	        String nome = scanner.nextLine();
	        System.out.print("Idade do aluno: ");
	        int idade = scanner.nextInt();

	        InserirDados inserirDados = new InserirDados();
	        inserirDados.inserirAluno(nome, idade);

	        scanner.close();
	    }
	}
    
