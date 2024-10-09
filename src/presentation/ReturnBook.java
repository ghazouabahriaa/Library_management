package presentation;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Dao.ILibrary;
import Dao.LibraryImpl;
import metier.entity.Student;


public class ReturnBook extends JFrame {

	ILibrary lib = new LibraryImpl();
	TableModeleIssue tm= new TableModeleIssue(lib.getAllIssued());
    JTable tableBooks=new JTable(tm);
	JScrollPane jsp=new JScrollPane(tableBooks);
	JFrame frame = new JFrame("JTable Test Display");
	JPanel panel = new JPanel();
	JPanel contentPane = new JPanel();


	
	JButton delete = new JButton( "Return Book" ,new ImageIcon("img/returnbook.png"));
	int numrow =-1 ;



	public ReturnBook() {
		
		

		
		this.setTitle("Issue List");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.setVisible(true);
		tm.charger(lib.getAllIssued());
		contentPane.add(jsp, BorderLayout.CENTER);
		frame.getContentPane().add(contentPane);
		
		
		
		delete.setBounds(217, 256, 194, 33);
		contentPane.add(delete);
		
		
		this.add(contentPane);
		this.pack();
		
		
		
		 delete.addActionListener(e->{
	  			if(numrow==-1)
	  				JOptionPane.showMessageDialog(this, "Select a row");
	  			else
	  			{
	  				int id=(int)tm.getValueAt(numrow, 0);
	  				lib.DeleteIssue(id);
	  				JOptionPane.showMessageDialog(null,"Book Reuturned"); 
	  				tm.charger(lib.getAllIssued());
	  				numrow=-1;
	  				lib.UpdateStudent1(id);
	  			}	
	  		});
		 
		 
			tableBooks.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					numrow=tableBooks.getSelectedRow();
				}
			});
}



}
