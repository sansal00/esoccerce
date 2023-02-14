package profilo;

import java.io.Serializable;

public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	private String nome;
	private String cognome;
	private String indirizzo;
	private String citt�;
	
	public UserBean() {
		email = null;
		password = null;
		nome = null;
		cognome = null;
		indirizzo = null;
		citt� = null;
		
	}
	
	public UserBean(String email, String password, String nome, String cognome, String indirizzo, String citt�) {
		this.email = email;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.citt� = citt�;
	}
	
	public String getIndirizzo() {
		return this.indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public String getCitt�() {
		return this.citt�;
	}
	
	public void setCitt�(String citt�) {
		this.citt� = citt�;
	}
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	

	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}



	public boolean equals(Object other) {
		return this.email.equals(((UserBean) other).getEmail());
	}

	public String toString() {
		return "UserBean [email = " + this.email + ", password = " + this.password + ", nome = " + this.nome + ", cognome = " + this.cognome + ", indirizzo = " + this.indirizzo + ", citt� = " + this.citt� + "]";
	}
}
