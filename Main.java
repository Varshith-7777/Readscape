import java.util.*;
import java.io.*;

class Book
{
    String title;
    String author;
    float price;

    Book(String title,String author,float price)
    {
        this.title = title;
        this.author = author;
        this.price = price;


        void display()
        {
            System.out.println("Title of Book :" +title);
            System.out.println("Author of Book :" +author);
            System.out.println("Title of Book :" +price);

        }


    }



}


class Main
{
    public static void main(String args[])
    {
        Book bk1 = new Book("Ikigai","Héctor García and Francesc Miralles",600.0f);
        bk1.display();



    }

}
