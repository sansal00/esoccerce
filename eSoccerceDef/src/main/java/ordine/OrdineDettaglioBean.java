package ordine;

import java.io.Serializable;

public class OrdineDettaglioBean implements Serializable {
	private int code;
	private String urlimage;
	private String nome;
	private String marca;
	private String descrizione;
	private int prezzo;
	private int quantitaacquistata;
	private String taglia;
	private int numero;
	private String dimensione;
	private String tipo;
	private int id;
	
	private static final long serialVersionUID = 1L;
	
	public OrdineDettaglioBean() {
		this.code = this.prezzo = this.quantitaacquistata = this.numero = this.id = 0;
		this.urlimage = this.nome = this.marca = this.descrizione = this.taglia = this.dimensione = this.tipo = "";
	}
	
	public OrdineDettaglioBean(int code, String urlimage, String nome, String marca, String descrizione, int prezzo, int quantitaacquistata, String taglia, int numero, String dimensione, String tipo, int id) {
		this.code = code;
		this.urlimage = urlimage;
		this.nome = nome;
		this.marca = marca;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.quantitaacquistata = quantitaacquistata;
		this.taglia = taglia;
		this.numero = numero;
		this.dimensione = dimensione;
		this.tipo = tipo;
		this.id = id;
	}
	
	public String getImage() {
		return this.urlimage;
	}
	
	public void setImage(String urlimage) {
		this.urlimage = urlimage;
	}
	
	public String getTaglia() {
		return this.taglia;
	}
	
	public void setTaglia(String taglia) {
		this.taglia = taglia;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getDimensione() {
		return this.dimensione;
	}
	
	public void setDimensione(String dimensione) {
		this.dimensione = dimensione;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMarca() {
		return this.marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescrizione() {
		return this.descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public int getPrezzo() {
		return this.prezzo;
	}
	
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	
	public int getQuantitaAcquistata() {
		return this.quantitaacquistata;
	}
	
	public void setQuantitaAcquistata(int quantitaacquistata) {
		this.quantitaacquistata = quantitaacquistata;
	}
	
	public int getID() {
		return this.id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
}
