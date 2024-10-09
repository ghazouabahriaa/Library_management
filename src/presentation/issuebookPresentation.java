package presentation;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import Dao.ILibrary;
import Dao.LibraryImpl;
import metier.entity.Book;
import metier.entity.Issue;
import metier.entity.Student;


public class issuebookPresentation extends JFrame {

	Object donnees[][]= {};
	String colonne[] = {"student","book","returndate"};
	ILibrary lib = new LibraryImpl();
	
	
	JPanel  contentPane= new JPanel();
	JLabel s_id = new JLabel("Student Id");
	JLabel b_id = new JLabel("Book Id");
	JLabel returndate = new JLabel("Return Date");
	JPanel pbutton= new JPanel(new GridLayout(1,2));

	JButton issue = new JButton("Issue Book");

	JTextField tissuedate = new JTextField();
	JLabel issuebook = new JLabel("Issue Book");
	JComboBox<Student> csid = new JComboBox();
	JComboBox<Book> cbid = new JComboBox();

	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	JFormattedTextField redate = new JFormattedTextField(df);
	
	
	
	

	public issuebookPresentation() {
		
		
	
		this.setTitle("Issue Book");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.setVisible(true);
	

		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		


		issuebook.setFont(new Font("Tahoma", Font.BOLD, 16));
		issuebook.setHorizontalAlignment(SwingConstants.CENTER);
		issuebook.setBounds(10, 11, 414, 34);
		contentPane.add(issuebook);
		
		s_id.setFont(new Font("Tahoma", Font.PLAIN, 11));
		s_id.setBounds(10, 72, 124, 14);
		contentPane.add(s_id);
		

		
		b_id.setFont(new Font("Tahoma", Font.PLAIN, 11));
		b_id.setBounds(10, 118, 124, 14);
		contentPane.add(b_id);
		

		
		csid=remplirCombo(lib.getAllStudents());
		cbid=remplirCombo1(lib.getAllBooks());
		
		csid.setBounds(144, 69, 254, 20);

		contentPane.add(csid);
		cbid.setBounds(144, 115, 254, 20);

		contentPane.add(cbid);
		
		returndate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		returndate.setBounds(10, 163, 135, 14);
		contentPane.add(returndate);
		
		redate.setBounds(144, 160, 254, 20);
		contentPane.add(redate);

		issue.setBounds(86, 213, 89, 23);
		contentPane.add(issue);
		
		
		
		redate .addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		      char c = e.getKeyChar();
		      if (!((c >= '0') && (c <= '9') ||
		         (c == KeyEvent.VK_BACK_SPACE) ||
		         (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH)))        
		      {
		        JOptionPane.showMessageDialog(null, "Please Enter Valid");
		        e.consume();
		      }
		    }
		  });
		
		
		issue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				try {
					Object student =csid.getSelectedItem();
					int sid= ((Student) student).getId();
					
					int stud = sid;
					
					Object book =cbid.getSelectedItem();
					int bid= ((Book) book).getId();
					
					int boo = bid;
					String date=redate.getText();
					

					Issue i = new Issue(stud,boo,date); 
					
					int b_id= ((Book) book).getId();

					try {
						
					lib.AddIssue(i);
					 ((Student) student).setId_book(bid);
					 lib.UpdateStudent((Student) csid.getSelectedItem());
					JOptionPane.showMessageDialog(null,"Book Issued");
					}
					catch(Exception ee) {
						System.out.println("Error");
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Error in typing ");
				}
			}
			
			
			
		});
		
		
}
	
	
	public JComboBox<Book> remplirCombo1(List<Book>l)
	{
		JComboBox<Book>c=new JComboBox<>();
		
		for(Book book:l)
			c.addItem(book);
		return c;
		
	}
	
	
	public JComboBox<Student> remplirCombo(List<Student>l)
	{
		JComboBox<Student>c=new JComboBox<>();
		
		for(Student student:l)
			c.addItem(student);
		return c;
		
	}
}

