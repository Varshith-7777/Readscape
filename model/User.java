package model;

public class User 
{
    private int id;
    private String username;
    private String password;
    private String role;



    User()
    {

    }
    User(int id,String username,String password,String role)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    User(String username,String password,String role)
    {
        this.username = username;
        this.password = password;
        this.role = role;
    }


    public void setId(int id)
    {
        this.id = id;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public int getId()
    {
        return id;
    }

    public String getUser()
    {
        return username;
    }
    
    public String getRole()
    {
        return role;
    }
    
    public String getPassword()
    {
        return password;
    }
}
