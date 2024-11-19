package br.com.aula.conexao;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        // Utilização de Scanner para que o usuário possa interagir no programa
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
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, insira um número válido.");
                scanner.next(); // Descarta a entrada inválida
            }
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer após o nextInt

            switch (opcao) {
                case 1:
                    // Inserir um novo aluno
                    System.out.print("Nome do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade do aluno: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Por favor, insira uma idade válida.");
                        scanner.next(); // Descarta a entrada inválida
                    }
                    int idade = scanner.nextInt();
                    inserirDados.inserirAluno(nome, idade);
                    break;
                case 2:
                    // Atualizar um aluno existente
                    System.out.print("ID do aluno a ser atualizado: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Por favor, insira um ID válido.");
                        scanner.next(); // Descarta a entrada inválida
                    }
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    System.out.print("Novo nome do aluno: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Nova idade do aluno: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Por favor, insira uma idade válida.");
                        scanner.next(); // Descarta a entrada inválida
                    }
                    int novaIdade = scanner.nextInt();
                    atualizarDados.atualizarAluno(idAtualizar, novoNome, novaIdade);
                    break;
                case 3:
                    // Deletar um aluno
                    System.out.print("ID do aluno a ser deletado: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Por favor, insira um ID válido.");
                        scanner.next(); // Descarta a entrada inválida
                    }
                    int idDeletar = scanner.nextInt();
                    deletarDados.deletarDados(idDeletar);
                    break;
                case 4:
                    // Listar todos os registros de alunos
                    lerDados.listarAlunos();
                    break;
                case 0:
                    // Sair do programa
                    System.out.println("Saindo...");
                    break;
                default:
                    // Opção inválida
                    System.out.println("Opção inválida! Escolha uma opção entre 0 e 4.");
                    break;
            }
        } while (opcao != 0);

        // Fecha o Scanner
        scanner.close();
    }
}
