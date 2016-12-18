/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maya.business;

import java.io.Serializable;

/**
 *
 * @author jalpa
 */
public class MayaUser implements Serializable
{
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String passWord;
    
    public MayaUser()
    {
        firstName = "";
        lastName = "";
        email = ""; 
        userName="";
        passWord="";
    }
    
    public MayaUser(String firstName, String lastName, String email, String userName, String passWord) 
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.passWord = passWord;
    }
    
    public String getFirstName() 
    {
        return firstName;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName (String userName)
    {
        this.userName = userName;
    }
    
    public String getPassWord()
    {
        return passWord;
    }
    
    public void setPassWord (String passWord)
    {
        this.passWord = passWord;
    }
}
