import java.sql.*;
import java.util.*;
import DAO.*;
import entità.*;

public class _Driver {

	Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		Connection con = null;
		_Driver driver = new _Driver();
		String tabella = "articolo";
		String querySel = "SELECT * FROM " + tabella;
		String queryIns = "INSERT INTO " + tabella + "(nome, codice, categoria, titolo) VALUES( ?, ?, ?, ?);";
		String queryDel = "DELETE FROM " + tabella + " WHERE codice = ?";
		String codice;
		ArrayList<Articolo> inventario = new ArrayList();
		int menu;

		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost/Esercizio10-12-2019", "postgres", "1234");
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		}
		DBDAO db = new DBDAOimp(con);

		System.out.println("Benvenuto!");
		do{
			driver.stampaMenu();
			menu = driver.in.nextInt();
			driver.in = new Scanner(System.in);
			switch(menu) {
			case 1:
				driver.inserimento(tabella, db, queryIns, inventario);
				break;
			case 2:
				System.out.print("Inserire il codice dell'articolo da eliminare: ");
				codice = driver.in.nextLine();
				db.queryDel(queryDel, codice);
				break;
			case 3:
				db.querySelect(tabella, querySel);
				break;
			}
		}while(menu != 0);
		System.out.println("Arrivederci, e torna a trovarci!");
		try {
			Class.forName("org.postgresql.Driver");
		}
		catch(Exception e) {
			System.err.println(e);
		}


	}
	//------------------------------------------------------------------------------
	public void stampaMenu() {
		System.out.println("Inserire un numero tra le seguenti opzioni:");
		System.out.println("1: Inserimento nel database.");
		System.out.println("2: Eliminazione dal database.");
		System.out.println("3: Stampa del database.");
		System.out.println("0: Chiusura programma.");
	}
	//-----------------------------------------------------------------------------------
	public void inserimento(String tabella, DBDAO db, String query, ArrayList<Articolo> inventario) {
		int scelta;
		String titolo;
		String categoria;
		System.out.println("Cosa si desidera inserire?\n1: articolo generico.\n2: videogioco.");
		scelta = in.nextInt();
		in = new Scanner(System.in);
		switch(scelta) {
		case 1:
			Articolo articolo = new Articolo();
			insParametri(articolo);
			System.out.println("Inserire categoria: ");
			categoria = in.nextLine();
			articolo.setCategoria(categoria);
			System.out.println(articolo.toString());
			db.queryInsert(tabella, query, articolo);
			inventario.add(articolo);
			break;

		case 2:
			System.out.println("Inserire il titolo: ");
			titolo = in.nextLine();
			Videogiochi vid = new Videogiochi("", "", "", titolo);
			insParametri(vid);
			System.out.println(vid.toString());
			db.queryInsert(tabella, query, vid);
			inventario.add(vid);
		}

	}
	//------------------------------------------------------------------------------------
	public void insParametri(Articolo art) {
		String nome;
		String codice;

		System.out.println("Inserire nome: ");
		nome = in.nextLine();
		art.setNome(nome);
		System.out.println("Inserire codice: ");
		codice = in.nextLine();
		art.setCodice(codice);
	}
}
