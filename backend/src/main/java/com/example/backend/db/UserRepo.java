package com.example.backend.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.backend.models.User;

public class UserRepo implements UserRepoInterface {

    @Override
    public User login(User user) {
        try(Connection conn = DB.source().getConnection();
            PreparedStatement stmt = conn.prepareStatement("select * from users where username = ? and password = ?")) {
                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getPassword());

                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    User u = new User(
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("password"),
                        rs.getString("username"),
                        rs.getString("type"),
                        rs.getString("address"),
                        rs.getString("subscription"),
                        rs.getString("mail"));

                    System.out.println(u.toString());
                    return u;
                }
                
             } catch(SQLException e){
                e.printStackTrace();
             }

             return null;

    }

    @Override
    public User register(User user) {
        try(Connection conn = DB.source().getConnection();
            PreparedStatement stmt = conn.prepareStatement("select * from users where username = ?")) {
                stmt.setString(1, user.getUsername());
                ResultSet res = stmt.executeQuery();
                if(!res.next()){
                    try(PreparedStatement stm = conn.prepareStatement("INSERT INTO users (firstname, lastname, password, username, type, address, subscription, mail) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")){

                        stm.setString(1, user.getFirstname());
                        stm.setString(2, user.getLastname());
                        stm.setString(3, user.getPassword());
                        stm.setString(4, user.getUsername());
                        stm.setString(5, user.getType());
                        stm.setString(6, user.getAddress());
                        stm.setString(7, user.getSubscription());
                        stm.setString(8, user.getMail());

                        stm.executeUpdate();

                        return user;
                    } catch(SQLException e){
                        e.printStackTrace();
                    }
                }  
            }

        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int changePassword(User user) {
        try(Connection conn = DB.source().getConnection();
            PreparedStatement stmt = conn.prepareStatement("update users set password = ? where username = ?")){
                stmt.setString(1, user.getPassword());
                stmt.setString(2, user.getUsername());
                return stmt.executeUpdate();


        } catch(SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
