public class Book {
    protected String title;
    protected String author;
    protected int pages;
    protected boolean isAvailable;


    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isAvailable = true;
    }


    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println(title + " has been returned.");
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println("Available: " + isAvailable);
    }


    public String getTitle() { return title; }
    public String getAuthor() {return author;}
    public int getPages() { return pages; }
    public boolean getIsAvailable() { return isAvailable; }
}


class Textbook extends Book {
    private String subject;
    private int edition;


    public Textbook(String title, String author, int pages, String subject, int edition) {
        super(title, author, pages);
        this.subject = subject;
        this.edition = edition;
    }


    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Subject: " + subject);
        System.out.println("Edition: " + edition);
    }


    public String getSubject() { return subject;}
    public int getEdition() { return edition; }
}


 class Library {
    public static void main(String[] args) {
        // Create 2 regular books
        Book b1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 180);
        Book b2 = new Book("1984", "George Orwell", 328);


        Textbook tb1 = new Textbook("Java Programming", "John Doe", 500, "Computer Science", 3);


        b1.borrowBook();
        b1.borrowBook();
        b1.returnBook();


        System.out.println("\n--- Book Details ---");
        b1.displayInfo();
        System.out.println();
        b2.displayInfo();
        System.out.println();
        tb1.displayInfo();
    }

}
