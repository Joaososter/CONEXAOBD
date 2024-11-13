package br.com.aula.conexao;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
    	//Utilização de scanner para que o usuário possa interagir no programa
        Scanner scanner = new Scanner(System.in);
        
        // Instâncias das classes de manipulação de dados
        InserirDados inserirDados = new InserirDados();
        AtualizarDados atualizarDados = new AtualizarDados();
        DeletarDados deletarDados = new DeletarDados();
        LerDados lerDados = new LerDados();
        
        int opcao;

        // Loop do menu principal
        do {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Inserir Aluno");
            System.out.println("2. Atualizar Aluno");
            System.out.println("3. Deletar Aluno");
            System.out.println("4. Ler Registros de Alunos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            // Lê a opção do usuário no programa
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    //Coloca um novo aluno
                    System.out.print("Nome do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade do aluno: ");
                    int idade = scanner.nextInt();
                    inserirDados.inserirAluno(nome, idade);
                    break;
                case 2:
                    //Atualiza um aluno já cadastrado
                    System.out.print("ID do aluno a ser atualizado: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    System.out.print("Novo nome do aluno: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Nova idade do aluno: ");
                    int novaIdade = scanner.nextInt();
                    atualizarDados.atualizarAluno(idAtualizar, novoNome, novaIdade);
                    break;
                case 3:
                    //Deleta um aluno
                    System.out.print("ID do aluno a ser deletado: ");
                    int idDeletar = scanner.nextInt();
                    deletarDados.deletarAluno(idDeletar);
                    break;
                case 4:
                    //Lista todos os alunos cadastrados
                    lerDados.listarAlunos();
                    break;
                case 0:
                    //Sair do programa
                    System.out.println("Saindo...");
                    break;
                default:
                    //Opção inválida
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0); 

        scanner.close();
    }
}