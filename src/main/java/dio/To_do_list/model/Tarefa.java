package dio.To_do_list.model;

public class Tarefa {
	private Long id;
	private String titulo;
	private String descricao;
	private boolean feita;
	
	public Tarefa(Long id, String titulo, String descricao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.feita = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isFeita() {
		return feita;
	}

	public void setFeita(boolean feita) {
		this.feita = feita;
	}
	
	
	
	
}
