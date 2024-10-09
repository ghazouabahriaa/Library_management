package presentation;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import metier.entity.Student;



public class TableModeleStudent extends AbstractTableModel{

	private List<Student> listestudent = new ArrayList<>();
	private String titres[]= {"id","name","firstname","gender","grade","id_book"};
	
	public TableModeleStudent(List<Student> allStudent) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listestudent.size();
	}

	@Override
	public int getColumnCount() {
		return titres.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex)
		{case 0:return listestudent.get(rowIndex).getId();
		case 1:return listestudent.get(rowIndex).getName();
		case 2:return listestudent.get(rowIndex).getFirstname();
		case 3:return listestudent.get(rowIndex).getGender();
		case 4:return listestudent.get(rowIndex).getGrade();
		case 5:return listestudent.get(rowIndex).getId_book();


		}
		return null;
	}
	public String getColumnName (int column) {
		return titres[column];
	}
	public void charger(List<Student> liste) {
		this.listestudent=liste;
		fireTableDataChanged();
		
	}
	
}

