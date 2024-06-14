package DAL;

import Models.Person;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date; 
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonDAO extends DBContext {

    public Vector<Person> getAllUser() {
        String sql = "SELECT * FROM dbo.Person";
        Vector<Person> vector = new Vector<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String Pid = rs.getString("Pid");
                String name = rs.getString("name");
                String passWord = rs.getString("passWord");
                Date dob = rs.getDate("dob");
                String phoneNumber = rs.getString("phoneNumber");
                int role = rs.getInt("role");
                Person p = new Person(Pid, name, passWord, new java.util.Date(dob.getTime()), phoneNumber, role);
                vector.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return vector;
    }

    public void removePerson(String Pid) {
        String sql = "DELETE FROM dbo.Person WHERE Pid = ?";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, Pid);
            int rowsAffected = stm.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Delete successful");
            } else {
                System.out.println("No rows deleted. User with ID " + Pid + " not found.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Person getUser(String userL, String passL) {
        String sql = "SELECT * FROM dbo.Person WHERE [name] = ? AND passWord = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, userL);
            st.setString(2, passL);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String Pid = rs.getString("Pid");
                String name = rs.getString("name");
                String passWord = rs.getString("passWord");
                Date dob = rs.getDate("dob");
                String phoneNumber = rs.getString("phoneNumber");
                int role = rs.getInt("role");
                return new Person(Pid, name, passWord, new java.util.Date(dob.getTime()), phoneNumber, role);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Person checkUser(String userL) {
        String sql = "SELECT * FROM dbo.Person WHERE [name] = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, userL);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String Pid = rs.getString("Pid");
                String name = rs.getString("name");
                String passWord = rs.getString("passWord");
                Date dob = rs.getDate("dob");
                String phoneNumber = rs.getString("phoneNumber");
                int role = rs.getInt("role");
                return new Person(Pid, name, passWord, new java.util.Date(dob.getTime()), phoneNumber, role);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void insert(Person person) {
        String sql = "INSERT INTO dbo.Person (Pid, name, passWord, dob, phoneNumber, role) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, person.getPid());
            stm.setString(2, person.getName());
            stm.setString(3, person.getPassWord());
            stm.setDate(4, new Date(person.getDob().getTime()));
            stm.setString(5, person.getPhoneNumber());
            stm.setInt(6, person.getRole());
            stm.executeUpdate();
            System.out.println("Insert OK");
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        PersonDAO d = new PersonDAO();
        Vector<Person> p = d.getAllUser();
        PersonDAO userDao = new PersonDAO();
        Person user = userDao.getUser("sa", "123456");
        System.out.println(user);
    }
}
