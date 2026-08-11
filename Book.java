abstract class Book
{
    private String title;
    private String author;
    private float price;

    Book(String title, String author, float price)
    {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    Book()
    {
        title = null;
        author = null;
        price = 0.0f;
    }

    void display()
    {
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price : " + price);
    }

    void setPrice(float p)
    {
        if (p < 0)
        {
            throw new IllegalArgumentException("Please enter a valid price.");
        }

        this.price = p;
    }

    float getPrice()
    {
        return price;
    }

    void setAuthor(String author)
    {
        this.author = author;
    }

    String getAuthor()
    {
        return author;
    }

    void setTitle(String title)
    {
        this.title = title;
    }

    String getTitle()
    {
        return title;
    }
}
