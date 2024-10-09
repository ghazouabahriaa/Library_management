package metier.entity;

public class Book implements Comparable<Book>{
	
	private int id,price;
	private String name, genre;
	private static int nb=1;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Book(int id, String name, String genre, int price) {
		super();
		id = ++nb;
		this.price = price;
		this.name = name;
		this.genre = genre;
	}
	public Book() {
		super();
		id = ++nb;

	}
	
	public Book(String name, String genre,int price) {
		super();
		id = nb++;
		this.price = price;
		this.name = name;
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", price=" + price + ", name=" + name + ", genre=" + genre + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return id == other.id;
	}
	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	}

