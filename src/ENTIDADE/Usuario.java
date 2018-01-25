package ENTIDADE;

public class Usuario {

	private int cod_usuario;
	private String nome_usuario;
	private String email_login;
	private String cpf;
	private int cod_perfil;
	private String senha;
	private String conf_senha;
	private Perfil perfil;
	
	

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public int getCod_usuario() {
		return cod_usuario;
	}

	public void setCod_usuario(int cod_usuario) {
		this.cod_usuario = cod_usuario;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public String getEmail_login() {
		return email_login;
	}

	public void setEmail_login(String email_login) {
		this.email_login = email_login;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getCod_perfil() {
		return cod_perfil;
	}

	public void setCod_perfil(int cod_perfil) {
		this.cod_perfil = cod_perfil;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConf_senha() {
		return conf_senha;
	}

	public void setConf_senha(String conf_senha) {
		this.conf_senha = conf_senha;
	}

}
