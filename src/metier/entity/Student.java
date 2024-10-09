package metier.entity;


public class Student implements Comparable<Student>{

	private int id , id_book;
	public int getId_book() {
		return id_book;
	}
	public void setId_book(int id_book) {
		this.id_book = id_book;
	}

	private String name,firstname,gender,grade;
	private static int nb=1 ;

	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", firstname=" + firstname + ", gender=" + gender + ", grade="
				+ grade + "]";
	}
	public Student() {
		super();
		this.id = nb++;

		
	}
	public Student(String name, String firstname, String gender, String grade) {
		super();
		this.id = nb++;
		this.name = name;
		this.firstname = firstname;
		this.gender = gender;
		this.grade = grade;
	}
	public Student(int id, String name, String firstname, String gender, String grade) {
		super();
		this.id = nb++;
		this.name = name;
		this.firstname = firstname;
		this.gender = gender;
		this.grade = grade;
	}
	
	public Student(int id, String name, String firstname, String gender, String grade, int id_book) {
		super();
		this.id = nb++;
		this.id_book = id_book;
		this.name = name;
		this.firstname = firstname;
		this.gender = gender;
		this.grade = grade;
	}
	public Student( String name, String firstname, String gender, String grade,int id_book) {
		super();
		this.id = nb++;
		this.id_book = 0;
		this.name = name;
		this.firstname = firstname;
		this.gender = gender;
		this.grade = grade;
	}
	public Student(int id_book) {
		super();
		this.id_book = id_book;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public static int getNb() {
		return nb;
	}
	public static void setNb(int nb) {
		Student.nb = nb;
	}
	
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return id == other.id;
	}
	
}