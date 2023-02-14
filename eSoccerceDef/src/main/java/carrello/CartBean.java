package carrello;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;

import prodotto.ProdottoBean;

public class CartBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Collection<ProdottoBean> prodotti = new LinkedList<ProdottoBean>();
	
	
	public void addProdotto(ProdottoBean prodotto) {
		prodotti.add(prodotto);
	}
	
	public void removeProdotto(ProdottoBean prodotto) {
		prodotti.remove(prodotto);
	}
	
	public void svuotaCarrello() {
		prodotti.removeAll(prodotti);
	}
	
	public Collection<ProdottoBean> getProdotti() {
		return this.prodotti;
	}
	
	public boolean checkExistence(ProdottoBean prodotto) {
		for (ProdottoBean p : prodotti) {
			if (p.equals(prodotto)) return true;
		}
		return false;
	}
	
	public int getTotale() {
		int totale = 0;
		for (ProdottoBean prodotto : prodotti) {
			totale += prodotto.getQuantita() * prodotto.getPrezzo();
		}
		return totale;
		}
	
	public int getTotaleProdotti() {
		int totale = 0;
		for (ProdottoBean prodotto: prodotti) {
			totale += prodotto.getQuantita();
		}
		return totale;
	}

}

