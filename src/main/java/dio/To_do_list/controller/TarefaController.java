package dio.To_do_list.controller;

import dio.To_do_list.Factory.TarefaFactory;
import dio.To_do_list.model.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tarefas")
public class TarefaController {

	@Autowired
	private TarefaFactory tarefaFactory;
	
	@PostMapping
	public Tarefa criarTarefa(@RequestBody Tarefa tarefaRequest) {
		return tarefaFactory.criarTarefa(tarefaRequest.getTitulo(),tarefaRequest.getDescricao());	
	}
	
	@GetMapping
	public List<Tarefa> getAllTarefas(){
		return tarefaFactory.getAllTarefas();
	}
	
	@GetMapping("/{id}")
	public Tarefa getTarefaId(@PathVariable Long id) {
		return tarefaFactory.getTarefaId(id);
	}
	
	@PutMapping("/{id}/completa")
	public String marcarTarefaFeita(@PathVariable Long id) {
		Tarefa tarefa = tarefaFactory.getTarefaId(id);
		if (tarefa != null) {
			tarefaFactory.marcarCompleta(id);
			return "Tarefa concluida";
		}
		
		return "Tarefa nao encontrada";
	}
	
	@DeleteMapping("/{id}")
	public String deletarTarefa(@PathVariable Long id) {
		Tarefa tarefa = tarefaFactory.getTarefaId(id);
		if(tarefa != null) {
			tarefaFactory.deletarTarefa(id);
			return "Tarefa deletada";
		}
		return "Tarefa nao encontrada";
	}
}
