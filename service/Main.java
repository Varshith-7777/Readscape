package service;
import config.DatabaseHelper;
import model.*;
import dao.BookManager;
import java.util.*;
import ui.BookConsoleUI;

public class Main
{
    public static void main(String args[])
        {
            BookConsoleUI start = new BookConsoleUI();
            start.start();
        }
    
}