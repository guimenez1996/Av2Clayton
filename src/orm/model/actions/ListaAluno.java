package orm.model.actions;

import orm.model.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ListaAluno {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();

        TypedQuery<Aluno> query = manager.createQuery("SELECT a FROM Aluno a", Aluno.class);
        List<Aluno> alunos = query.getResultList();

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

        manager.close();
        factory.close();
    }
}
