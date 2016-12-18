/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maya.data;
import Maya.business.MayaUser;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jalpa
 */
public class MayaUserDB 
{
    private static final String MAYA_USER = "MAYA_USER";
    private static List<MayaUser> allUser = null;
    public static long insert (MayaUser user)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query
                = "INSERT INTO " + MAYA_USER 
                + " (FirstName, LastName, Email, UserName, PassWord) "
                + "VALUES (?, ?, ?, ?, ?) ";
        try 
        {
            ps = connection.prepareStatement(query);
            
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getUserName());
            ps.setString(5, user.getPassWord());
            
            return ps.executeUpdate();
        } 
        catch (SQLException e)
        {
            System.out.println(e);
            return 0;
        } 
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int update(MayaUser user)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE " + MAYA_USER + " SET "
                + "FirstName = ? "
                + "LastName = ? "
                + "WHERE Email = ? "
                + "UserName = ? "
                + "PassWord = ? ";
        try
        {
            ps = connection.prepareStatement(query);
            
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getUserName());
            ps.setString(5, user.getPassWord());

            return ps.executeUpdate();
        } 
        catch (SQLException e)
        {
            System.out.println(e);
            return 0;
        } 
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int delete(MayaUser user)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE FROM " + MAYA_USER + " "
                + "WHERE Email = ? ";
        try 
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getEmail());

            return ps.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e);
            return 0;
        } 
        finally 
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static boolean emailExists(String email)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT Email FROM " + MAYA_USER + " "
                + "WHERE Email = ? ";
        try 
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            return rs.next();
        } 
        catch (SQLException e)
        {
            System.out.println(e);
            return false;
        } 
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static boolean validate(String userName, String passWord)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM MAYA_USER WHERE UserName = ? AND PassWord = ?";
        
         try 
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, passWord);
            rs = ps.executeQuery();
            
            System.out.println("Before returning rs");
            
            if(rs.next())
            {
                System.out.println("Fulfilling rs is not null");
                
                rs = ps.executeQuery();
                return rs.next(); 
            }
            //return rs.next();
        } 
        catch (SQLException e)
        {
            System.out.println(e);
            return false;
        } 
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return false;
    }
    
    public static MayaUser selectUser(String email) 
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM " + MAYA_USER + " "
                + "WHERE Email = ? ";
        try 
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            MayaUser user = null;
            
            if (rs.next())
            {
                user = new MayaUser();
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                user.setUserName(rs.getString("UserName"));
                user.setPassWord (rs.getString("PassWord"));
            }
            return user;
        } 
        catch (SQLException e)
        {
            System.out.println(e);
            return null;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static List <MayaUser> selectAllUser()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM " + MAYA_USER;
        try
        {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            allUser = new ArrayList<MayaUser>();
            
            while(rs.next())
            {
                MayaUser mu = new MayaUser();
                mu.setFirstName(rs.getString("FirstName"));
                mu.setLastName(rs.getString("LastName"));
                mu.setEmail(rs.getString("Email"));
                mu.setUserName(rs.getString("UserName"));
                mu.setPassWord (rs.getString("PassWord"));
                allUser.add(mu);
            }
            return allUser;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
