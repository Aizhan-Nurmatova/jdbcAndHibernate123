package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static peaksoft.util.Util.connect;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {

        try (Connection conn = Util.connect();
             Statement statement = conn.createStatement()) {
            String SQL = "create table users( " +
                    "id serial primary key," +
                    "name varchar(50) not null," +
                    "last_name varchar(50) not null," +
                    "age int not null )";
            System.out.println("Table is created");
            statement.executeUpdate(SQL);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void dropUsersTable() {

        try (Connection conn = connect();
             Statement statement = conn.createStatement();) {
            String SQl = "drop table users";
            statement.executeUpdate(SQl);
            System.out.println("Table is delete");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String SQl = " insert into users(name,last_name,age) values (?,?,?)";
        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(SQl)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.executeUpdate();
            System.out.println(name+" "+ lastName+ " added");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void removeUserById(long id) {
        String SQL = "delete  from users where  id = ?";
        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(SQL)){
            statement.setInt(1, (int) id);
            statement.executeUpdate();
            System.out.println("User with id:" + id + "  deleted");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<User> getAllUsers() {

        List<User> result = new ArrayList<>();
        String SQl = "select * from users";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQl)) {
            while (rs.next()) {
                result.add(new User(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getByte(4)));
            }
            System.out.println(result.size() + " row founded! ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public void cleanUsersTable() {

        try (Connection conn = connect();
             Statement statement = conn.createStatement()) {
            String SQL = "truncate table users";
            statement.executeUpdate(SQL);
            System.out.println("Table is clear");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


    }
}