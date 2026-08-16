package model;

public class Book
{
    private String title;
    private String author;
    private double price;
    private String ambient_track;
    private int id;
    private String coverImage;
    private String description;
    private String category;
  


    public Book(int id,String title, String author, double price, String coverImage, String description ,String ambient_track, String category) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.ambient_track = ambient_track;
        this.id = id;
        this.category = category;
        this.coverImage = coverImage;
        this.description = description;
    }

    public Book(String title, String author, double price, String coverImage, String description ,String ambient_track, String category) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.ambient_track = ambient_track;
        this.category = category;
        this.coverImage = coverImage;
        this.description = description;
    }


    public Book()
    {
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

    public double getPrice()
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

    public void setAmbient_track(String ambient_track) {
        this.ambient_track = ambient_track;
    }

    public String getAmbient_track()
    {
        return ambient_track;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getCategory()
    {
        return category;
    }


   
    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setCoverImage(String coverImage)
    {
        this.coverImage = coverImage;
    }

    public String getCoverImage()
    {
        return coverImage;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }


}
