package orm.model.actions;

import orm.model.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class BuscaPorLetra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a primeira letra do nome: ");
        String letra = scanner.nextLine();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();

        TypedQuery<Aluno> query = manager.createQuery("SELECT a FROM Aluno a WHERE a.nome LIKE :letra", Aluno.class);
        query.setParameter("letra", letra + "%");
        List<Aluno> alunos = query.getResultList();

        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno encontrado com a letra: " + letra);
        } else {
            for (Aluno aluno : alunos) {
                System.out.println("ID: " + aluno.getId());
                System.out.println("CPF: " + aluno.getCpf());
                System.out.println("Data de Nascimento: " + aluno.getDtnascimento());
                System.out.println("Email: " + aluno.getEmail());
                System.out.println("Endereço: " + aluno.getEndereco());
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Naturalidade: " + aluno.getNaturalidade());
                System.out.println("------------------------------");
            }
        }

        manager.close();
        factory.close();
        scanner.close();
    }
}
