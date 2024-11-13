package br.com.aula.conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    // Definindo as credenciais de conexão com o banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/aula_java_bd";
    private static final String USUARIO = "root";
    private static final String SENHA = "51736200";  

    // Método para estabelecer conexão com o banco de dados
    public static Connection conectar() {
        Connection conexao = null;
        try {
            // Carregando o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Estabelecendo conexão com o banco de dados
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão realizada com sucesso!");
            
        } catch (ClassNotFoundException e) {
            // Tratamento de erro caso o driver JDBC não seja encontrado
            System.err.println("Driver não encontrado: " + e.getMessage());
            
        } catch (SQLException e) {
            // Tratamento de erro de conexão com o banco de dados
            System.err.println("Erro ao conectar: " + e.getMessage());
        }
        return conexao;
    }

    // Método principal para testar a conexão
    public static void main(String[] args) {
        conectar();
    }
}

