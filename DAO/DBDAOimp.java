package DAO;
import java.sql.*;
import entità.*;
//---------------------------------------------------------------------------
public class DBDAOimp implements DBDAO {

	Connection con;
	Videogiochi vid;

	public DBDAOimp(Connection con) {
		this.con = con;
	}
	//----------------------------------------------------------------------------
	public void querySelect(String tabella, String query) {

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			System.out.println("nome\t| codice\t| categoria\t|\n");
			System.out.println("_________________________________________________\n");
			while(rs.next()) {
				System.out.println(rs.getString(1) + "\t|  " + rs.getString(2) + "\t| " + rs.getString(3) + "\t| " + rs.getString(4));
				System.out.println("-------------------------------------------\n");
			}
		} catch (SQLException sql) {
			System.err.println(sql);		
		}
	}
	//-----------------------------------------------------------------------------
	public void queryInsert(String tabella, String query, Articolo art) {
		PreparedStatement s;
		String nome = art.getNome();
		String codice = art.getCodice();
		String categoria = art.getCategoria();
		//INIZIO-------------------------------------------------------------------
		try {
			s = con.prepareStatement(query);
			if(art instanceof Videogiochi) {
				String titolo = ((Videogiochi) art).getTitolo();
				s.setString(1, nome);
				s.setString(2, codice);
				s.setString(3, "intrattenimento");
				s.setString(4, titolo);
			}
			else {
				s.setString(1, nome);
				s.setString(2, codice);
				s.setString(3, categoria);	
				s.setString(4, null);	
			}
			s.execute();
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		}		
	}
	//-------------------------------------------------------------------------------
	public void queryDel(String query, String codice) {
		PreparedStatement s;
		try {
			s = con.prepareStatement(query);
			s.setString(1, codice);
			s.execute();
			System.out.println("Articolo con codice " + codice + "eliminato");
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		}
	}
}
