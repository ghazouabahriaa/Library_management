package presentation;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Dao.ILibrary;
import Dao.LibraryImpl;


public class StudentsPresentation extends JFrame {

	ILibrary lib = new LibraryImpl();
	TableModeleStudent tm= new TableModeleStudent(lib.getAllStudents());
    JTable tableStudents=new JTable(tm);
	JScrollPane jsp=new JScrollPane(tableStudents);
	JFrame frame = new JFrame("JTable Test Display");
	JPanel panel = new JPanel();
	JPanel contentPane = new JPanel();


	JButton delete = new JButton( "Delete Student" ,new ImageIcon("img/deletestudent.png"));

	int numrow =-1 ;


	public StudentsPresentation() {
		
	
		
		

		
		this.setTitle("Students List");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.setVisible(true);
		tm.charger(lib.getAllStudents());
		contentPane.add(jsp, BorderLayout.CENTER);
		frame.getContentPane().add(contentPane);
		
	
		delete.setBounds(217, 256, 194, 33);
		contentPane.add(delete);
		
		
		this.add(contentPane);
		this.pack();
		
		
		 delete.addActionListener(e->{
	  			if(numrow==-1)
	  				JOptionPane.showMessageDialog(this, "selectionnez une ligne");
	  			else
	  			{
	  				int id=(int)tm.getValueAt(numrow, 0);
	  				lib.DeleteStudent(id);
	  				JOptionPane.showMessageDialog(null,"Student Deleted!"); 
	  				tm.charger(lib.getAllStudents());
	  				numrow=-1;
	  			}	
	  		});
		 
		 
			tableStudents.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					numrow=tableStudents.getSelectedRow();
				}
			});
		
}
}
