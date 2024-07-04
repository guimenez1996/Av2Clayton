package orm.model.actions;

import orm.model.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class RemoveAluno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID do aluno a ser removido: ");
        Long id = scanner.nextLong();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();

        Aluno aluno = manager.find(Aluno.class, id);
        if (aluno != null) {
            manager.getTransaction().begin();
            manager.remove(aluno);
            manager.getTransaction().commit();
            System.out.println("Aluno com o ID: " + id + " foi removido.");
        } else {
            System.out.println("Aluno com o ID: " + id + " não encontrado.");
        }

        manager.close();
        factory.close();
        scanner.close();
    }
}
