package presentation;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import metier.entity.Book;



public class TableModele extends AbstractTableModel{

	private List<Book> liste = new ArrayList<>();
	private String titres[]= {"id","name","genre","price"};
	
	public TableModele(List<Book> allEtudiant) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return liste.size();
	}

	@Override
	public int getColumnCount() {
		return titres.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex)
		{case 0:return liste.get(rowIndex).getId();
		case 1:return liste.get(rowIndex).getName();
		case 2:return liste.get(rowIndex).getGenre();
		case 3:return liste.get(rowIndex).getPrice();
		}
		return null;
	}
	public String getColumnName (int column) {
		return titres[column];
	}
	public void charger(List<Book> liste) {
		this.liste=liste;
		fireTableDataChanged();
		
	}
	
}
