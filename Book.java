public class Book {
    private int id;
    private String title;
    private String author;
    private float price;
    private float fileSize;
    private int pageNums;

    // Constructor for creating books in app
    public Book(String title, String author, float price, float fileSize, int pageNums) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.fileSize = fileSize;
        this.pageNums = pageNums;
    }

    // Constructor with ID (for reading from database)
    public Book(int id, String title, String author, float price, float fileSize, int pageNums) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.fileSize = fileSize;
        this.pageNums = pageNums;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public float getPrice() { return price; }
    public float getFileSize() { return fileSize; }
    public int getPageNums() { return pageNums; }
}
