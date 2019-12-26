package DAO;

import entità.*;

public interface DBDAO {

	public void querySelect(String tab, String query);
	public void queryInsert(String tab, String query , Articolo art);
	public void queryDel(String query, String codice);
}
