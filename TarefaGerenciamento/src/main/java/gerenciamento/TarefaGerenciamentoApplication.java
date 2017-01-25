package gerenciamento;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import gerenciamento.model.Prioridade;
import gerenciamento.model.Tarefa;
import gerenciamento.model.Usuario;
import gerenciamento.repo.TarefaRepositorio;
import gerenciamento.repo.UsuarioRepositorio;



@SpringBootApplication
public class TarefaGerenciamentoApplication implements CommandLineRunner {
    	
	@Autowired
    TarefaRepositorio tarefaRepositorio;
	
	@Autowired
    UsuarioRepositorio usuarioRepositorio;
	
	public static void main(String[] args) {
		SpringApplication.run(TarefaGerenciamentoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		
		List<Tarefa> tarefas = new LinkedList<Tarefa>();
		List<Usuario> usuarios = new LinkedList<Usuario>();
		
		tarefas.add(new Tarefa("Aprender StringBoot", "Estudar sobre o funcionamento do Spring Boot", "Estudo", "media"));
		tarefas.add(new Tarefa("Atividade de lógica", "Fazer a lista de exercício de lógica", "Trabalho", "Alta"));
		tarefas.add(new Tarefa("Inventar a roda", "Fazer um projeto de roda revolucionária", "Estudo", "Baixa"));
		
		usuarios.add(new Usuario("Ana Paula Barros", "ana.barros@ccc.ufcg.edu.br", "https://github.com/anapaulabarros"));
		
		tarefaRepositorio.save(tarefas);
		usuarioRepositorio.save(usuarios);
	}
	
}
