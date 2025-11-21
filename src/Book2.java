public class Book2 {
    
    private String title;
    private String author;
    private String isbn;
    private int year;
    
    public Book2(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }
    
    // Getters
    public String getTitle() {
        return this.title;
    }
    
    public String getAuthor() {
        return this.author;
    }
    
    public String getIsbn() {
        return this.isbn;
    }
    
    public int getYear() {
        return this.year;
    }
    
    // Setters
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    // Override toString() for readable output
    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " (" + year + ") [ISBN: " + isbn + "]";
    }
    
    // Override equals() - two books are equal if they have the same ISBN
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Book2 other = (Book2) obj;
        return this.isbn.equals(other.isbn);
    }
    
    // Helper method
    public boolean isSameEdition(Book2 other) {
        return this.title.equals(other.title) && 
               this.author.equals(other.author) && 
               this.year == other.year;
    }
}
