public class Book {
    
    private String title;
    private String author;
    private int pages;
    private boolean isAvailable;
    
    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isAvailable = true;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getPages() {
        return pages;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You borrowed: " + title);
        } else {
            System.out.println(title + " is not available.");
        }
    }
    
    public void returnBook() {
        isAvailable = true;
        System.out.println("You returned: " + title);
    }
    
    public boolean isLongBook() {
        return pages > 300;
    }
    
    public void displayInfo() {
        String status = isAvailable ? "Available" : "Borrowed";
        System.out.println(title + " by " + author);
        System.out.println("Pages: " + pages + ", Status: " + status);
    }
}
