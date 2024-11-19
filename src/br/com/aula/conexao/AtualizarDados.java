package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizarDados { // Declaração da classe AtualizarDados.
    public static void main(String[] args) { // Método principal, onde a execução do programa começa.
        Connection conexao = ConexaoBD.conectar(); // Estabelece a conexão com o banco de dados usando o método 'conectar' da classe 'ConexaoBD'.

        if (conexao != null) { // Verifica se a conexão foi estabelecida com sucesso.
            String sql = "UPDATE alunos SET nome = ?, idade = ? WHERE id = ?"; // Declara a instrução SQL para atualizar os dados de um aluno com base no ID.
            Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para ler dados do teclado.

            try {
                // Solicita ao usuário o ID do aluno a ser atualizado.
                System.out.print("Digite o ID do aluno que deseja atualizar: ");
                int id = scanner.nextInt(); // Lê o ID do aluno.
                scanner.nextLine(); // Consome a quebra de linha após a leitura do número.

                // Solicita ao usuário o novo nome do aluno.
                System.out.print("Digite o novo nome do aluno: ");
                String nome = scanner.nextLine(); // Lê o novo nome do aluno.

                // Solicita ao usuário a nova idade do aluno.
                System.out.print("Digite a nova idade do aluno: ");
                int idade = scanner.nextInt(); // Lê a nova idade do aluno.

                PreparedStatement stmt = conexao.prepareStatement(sql); // Prepara a consulta SQL.
                stmt.setString(1, nome); // Define o valor do primeiro parâmetro da consulta (novo nome).
                stmt.setInt(2, idade); // Define o valor do segundo parâmetro da consulta (nova idade).
                stmt.setInt(3, id); // Define o valor do terceiro parâmetro da consulta (ID do aluno).

                int rowsUpdated = stmt.executeUpdate(); // Executa a atualização e retorna o número de linhas afetadas.

                // Verifica se algum registro foi atualizado.
                if (rowsUpdated > 0) {
                    System.out.println("Registro atualizado com sucesso!"); // Mensagem de sucesso.
                } else {
                    System.out.println("Nenhum registro encontrado com o ID especificado."); // Mensagem caso o ID não exista.
                }
            } catch (SQLException e) { // Captura exceções relacionadas ao SQL.
                System.err.println("Erro ao atualizar dados: " + e.getMessage()); // Exibe uma mensagem de erro caso ocorra um problema ao atualizar os dados.
            } finally {
                try {
                    if (conexao != null) conexao.close(); // Fecha a conexão com o banco de dados, se ela estiver aberta.
                } catch (SQLException e) { // Captura exceções ao tentar fechar a conexão.
                    System.err.println("Erro ao fechar conexão: " + e.getMessage()); // Exibe uma mensagem de erro caso ocorra um problema ao fechar a conexão.
                }
            }

            scanner.close(); // Fecha o objeto Scanner.
        }
    }

	public void atualizarAluno(int idAtualizar, String novoNome, int novaIdade) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'atualizarAluno'");
	}
}
