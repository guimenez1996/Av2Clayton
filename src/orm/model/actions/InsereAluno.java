package orm.model.actions;

import orm.model.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class InsereAluno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Aluno aluno = new Aluno();

        System.out.print("Digite o CPF: ");
        aluno.setCpf(scanner.nextLine());

        System.out.print("Digite a data de nascimento (dd/MM/yyyy): ");
        aluno.setDtnascimento(scanner.nextLine());

        System.out.print("Digite o email: ");
        aluno.setEmail(scanner.nextLine());

        System.out.print("Digite o endereço: ");
        aluno.setEndereco(scanner.nextLine());

        System.out.print("Digite o nome: ");
        aluno.setNome(scanner.nextLine());

        System.out.print("Digite a naturalidade: ");
        aluno.setNaturalidade(scanner.nextLine());

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(aluno);
        manager.getTransaction().commit();

        System.out.println("Aluno com o ID: " + aluno.getId() + " foi inserido.");
        manager.close();
        factory.close();

        scanner.close();
    }
}

