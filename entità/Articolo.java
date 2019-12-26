package entità;

public class Articolo {

	String nome;
	String codice;
	float prezzo;
	String categoria;

	public Articolo(){}
	//---------------------------------------------------------------------------------------------------
	public Articolo(String nome, String codice, String categoria) {
		setNome(nome);
		setCodice(codice);
		setCategoria(categoria);
	}
	//---------------------------------------------------------------------------------------------------
	@Override
	public String toString() {
		return "Codice articolo = " + this.getCodice() + ".\n";
	}
	//---------------------------------------------------------------------------------------------------
	public String getNome() {
		return nome;
	}
	//---------------------------------------------------------------------------------------------------
	public void setNome(String nome) {
		this.nome = nome;
	}
	//---------------------------------------------------------------------------------------------------
	public String getCodice() {
		return codice;
	}
	//---------------------------------------------------------------------------------------------------
	public void setCodice(String codice) {
		this.codice = codice;
	}
	//---------------------------------------------------------------------------------------------------
	public String getCategoria() {
		return categoria;
	}
	//---------------------------------------------------------------------------------------------------
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
