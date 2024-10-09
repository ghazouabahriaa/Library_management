package presentation;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Dao.ILibrary;
import Dao.LibraryImpl;


public class BooksPresentation extends JFrame {

	ILibrary lib = new LibraryImpl();
	TableModele tm= new TableModele(lib.getAllBooks());
    JTable tableBooks=new JTable(tm);
	JScrollPane jsp=new JScrollPane(tableBooks);
	JFrame frame = new JFrame("JTable Test Display");
	JPanel panel = new JPanel();
	JPanel contentPane = new JPanel();


	
	JButton delete = new JButton( "Delete book" ,new ImageIcon("img/deletebook.png"));

	int numrow =-1 ;



	public BooksPresentation() {
		
		

		
		this.setTitle("Book List");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.setVisible(true);
		tm.charger(lib.getAllBooks());
		jsp.setBounds(217, 120, 194, 33);

		contentPane.add(jsp);		
		delete.setBounds(217, 160, 194, 33);

		contentPane.add(delete);
		
	
		
		
		this.add(contentPane);
		this.pack();
		
		
		
		 delete.addActionListener(e->{
	  			if(numrow==-1)
	  				JOptionPane.showMessageDialog(this, "Select a book");
	  			else
	  			{
	  				int id=(int)tm.getValueAt(numrow, 0);
	  				lib.DeleteBook(id);
	  				JOptionPane.showMessageDialog(null,"Book deleted!"); 
	  				tm.charger(lib.getAllBooks());
	  				numrow=-1;
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