package entità;

public class Videogiochi extends Articolo {

	String titolo;

	public Videogiochi(String nome, String codice, String categoria, String titolo) {
		super(nome, codice, categoria);
		setCategoria();
		setTitolo(titolo);
	}
	//---------------------------------------------------------------------------------------------------
	public String getTitolo() {
		return titolo;
	}
	//---------------------------------------------------------------------------------------------------
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	//---------------------------------------------------------------------------------------------------
	public void setCategoria() {
		categoria = "intrattenimento";
	}
	//---------------------------------------------------------------------------------------------------
	@Override
	public String toString() {
		return "videogioco con codice: " + this.getCodice() + " e titolo: " + this.getTitolo();
	}
}
