package prjFuncional;

public class Usuario {
	
	public Usuario() {
		this.nome = "**";
		this.sexo = "M";
	}
	
	public Usuario(String nome, String sexo) {
		this.nome = nome;
		this.sexo = sexo;
	}
	
	private String nome;
	private String sexo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", sexo=" + sexo + "]";
	}
}
