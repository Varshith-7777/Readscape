package model;

public abstract class Book
{
    private String title;
    private String author;
    private float price;

    public Book(String title, String author, float price)
    {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Book()
    {
        title = null;
        author = null;
        price = 0.0f;
    }

    public void display()
    {
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price : " + price);
    }

    public void setPrice(float p)
    {
        if (p < 0)
        {
            throw new IllegalArgumentException("Please enter a valid price.");
        }

        this.price = p;
    }

    public float getPrice()
    {
        return price;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
}
