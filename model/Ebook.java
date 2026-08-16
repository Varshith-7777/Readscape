package model;


public class Ebook extends Book implements Downloadable
{
    private double fileSize;
    private int pageNums;
    private String filePath;

    public Ebook(int id,String title, String author, double price, double fileSize,int pageNums,String filePath, String ambient_track, String description, String coverImage, String category) 
    {
        super(id,title, author, price, coverImage, description, ambient_track,category);
        this.fileSize = fileSize;
        this.pageNums = pageNums;
        this.filePath = filePath;
    }

    public Ebook(String title, String author, String category, double price, double fileSize,int pageNums,String filePath, String coverImage, String description, String ambient_track) 
    {
        super(title, author, price, coverImage, description, ambient_track,category);
        this.fileSize = fileSize;
        this.pageNums = pageNums;
        this.filePath = filePath;
    }
    
    public Ebook()
    {
    }

    public void setFilesize(float fileSize)
    {
        this.fileSize = fileSize;
    }

    public void setPageNums(int pageNums)
    {
        this.pageNums = pageNums;
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    public int getPageNums()
    {
        return pageNums;
    }

    public String getFilePath()
    {
        return filePath;
    }   


    public double getFilesize()
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
