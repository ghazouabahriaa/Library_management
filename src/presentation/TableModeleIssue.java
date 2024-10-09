package presentation;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import metier.entity.Issue;



public class TableModeleIssue extends AbstractTableModel{

	private List<Issue> liste = new ArrayList<>();
	private String titres[]= {"student","book","returndate"};
	
	public TableModeleIssue(List<Issue> allIssue) {
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
		{case 0:return liste.get(rowIndex).getStudent();
		case 1:return liste.get(rowIndex).getBook();
		case 2:return liste.get(rowIndex).getReturndate();
		}
		return null;
	}
	public String getColumnName (int column) {
		return titres[column];
	}
	public void charger(List<Issue> liste) {
		this.liste=liste;
		fireTableDataChanged();
		
	}
	
}
