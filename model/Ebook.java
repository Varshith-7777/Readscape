package model;


public class Ebook extends Book implements Downloadable
{
    private float fileSize;
    private int pageNums;

    public Ebook(String title, String author, float price, float fileSize,int pageNums)
    {
        super(title, author, price);
        this.fileSize = fileSize;
        this.pageNums = pageNums;
    }

    public Ebook()
    {
    }

    void setFilesize(float fileSize)
    {
        this.fileSize = fileSize;
    }

    float getFilesize()
    {
        return fileSize;
    }

    @Override
    public void display()
    {
        super.display();
        System.out.println("File Size : " +fileSize + " KB");
        System.out.println("Page No : " + pageNums );

    }

    @Override
    public void download()
    {
        System.out.println(getTitle() + " PDF book is downloading...");
    }
}
