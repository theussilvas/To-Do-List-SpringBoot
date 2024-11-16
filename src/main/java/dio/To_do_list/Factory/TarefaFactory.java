package dio.To_do_list.Factory;

import dio.To_do_list.model.Tarefa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaFactory {
	private List<Tarefa> tarefas = new ArrayList<>();
	private Long idContador = 1L;
	
	public Tarefa criarTarefa(String titulo, String descricao) {
		Tarefa tarefa = new Tarefa(idContador++, titulo,descricao);
		tarefas.add(tarefa);
		return tarefa;
	}
	
	public List<Tarefa> getAllTarefas(){
		return tarefas;
	}
	
	public Tarefa getTarefaId(Long id) {
		return tarefas.stream().filter(tarefa -> tarefa.getId().equals(id)).findFirst().orElse(null) ;
	}
	
	public void marcarCompleta(Long id) {
		Tarefa tarefa = getTarefaId(id);
		if(tarefa != null) {
			tarefa.setFeita(true);;
		}
	}
	
	public void deletarTarefa(Long id) {
		tarefas.removeIf(tarefa -> tarefa.getId().equals(id));
	}
}
