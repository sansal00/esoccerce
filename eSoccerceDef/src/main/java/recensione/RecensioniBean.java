package recensione;

import java.io.Serializable;

public class RecensioniBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int numero;
	private String nomeprodotto;
	private String descrizione;
	private int stelle;
	private String email;
	
	public RecensioniBean() {
		
	}
	public RecensioniBean(int numero, String nomeprodotto, String descrizione, int stelle, String email) {
		this.numero = numero;
		this.nomeprodotto = nomeprodotto;
		this.descrizione = descrizione;
		this.stelle = stelle;
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNomeProdotto() {
		return this.nomeprodotto;
	}
	
	public void setNomeProdotto(String nomeprodotto) {
		this.nomeprodotto = nomeprodotto;
	}
	
	public String getDescrizione() {
		return this.descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public int getStelle() {
		return this.stelle;
	}
	
	public void setStelle(int stelle) {
		this.stelle = stelle;
	}

}
