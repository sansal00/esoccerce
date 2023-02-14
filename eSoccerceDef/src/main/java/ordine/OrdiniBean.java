package ordine;

import java.io.Serializable;


public class OrdiniBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private int totale;
	private String numerocarta;
	private int cvc;
	private String datascadenza;
	private String nomeintestatario;
	private String cognomeintestatario;
	private String dataordine;
	private String spedizione;
	private String email;
	
	public OrdiniBean (int id, int totale, String numerocarta, int cvc, String datascadenza, String nomeintestatario, String cognomeintestatario, String dataordine, String spedizione, String email) {
		this.id = id;
		this.totale = totale;
		this.numerocarta = numerocarta;
		this.cvc = cvc;
		this.datascadenza = datascadenza;
		this.nomeintestatario = nomeintestatario;
		this.cognomeintestatario = cognomeintestatario;
		this.dataordine = dataordine;
		this.spedizione = spedizione;
		this.email = email;
	}
	
	public OrdiniBean() {
		id = totale = cvc = 0;
		nomeintestatario = cognomeintestatario = email = datascadenza = numerocarta = "";
		dataordine = null;
		
	}
	
	public int getID() {
		return this.id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public int getTotale() {
		return this.totale;
	}
	
	public void setTotale(int totale) {
		this.totale = totale;
	}
	
	public String getNumeroCarta() {
		return this.numerocarta;
	}
	
	public void setNumeroCarta(String numerocarta) {
		this.numerocarta = numerocarta;
	}
	
	public int getCVC() {
		return this.cvc;
	}
	
	public void setCVC(int cvc) {
		this.cvc = cvc;
	}
	
	public String getDataScadenza() {
		return this.datascadenza;
	}
	
	public void setDataScadenza(String datascadenza) {
		this.datascadenza = datascadenza;
	}
	
	
	public String getNomeIntestatario() {
		return this.nomeintestatario;
	}
	
	public void setNomeIntestatario(String nomeintestatario) {
		this.nomeintestatario = nomeintestatario;
	}
	
	public String getCognomeIntestatario() {
		return this.cognomeintestatario;
	}
	
	public void setCognomeIntestatario(String cognomeintestatario) {
		this.cognomeintestatario = cognomeintestatario;
	}
	
	public String getDataOrdine() {
		return this.dataordine;
	}
	
	public void setDataOrdine(String dataordine) {
		this.dataordine = dataordine;
	}
	
	public String getSpedizione() {
		return this.spedizione;
	}
	
	public void setSpedizione(String spedizione) {
		this.spedizione = spedizione;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
