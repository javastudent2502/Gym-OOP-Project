package database;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MemberDAO {

    public boolean insertBasicMember(BasicMember member) {
        String sql = "INSERT INTO member " +
                "(name, age, membership_type, role, school_name, has_trainer) " +
                "VALUES (?, ?, ?, 'Basic Member', NULL, NULL)";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, member.getName());
            ps.setInt(2, member.getAge());
            ps.setString(3, member.getMembershipType());

            int rows = ps.executeUpdate();
            ps.close();

            if (rows > 0) {
                System.out.println("Basic Member inserted: " + member.getName());
                return true;
            }

        } catch (SQLException e) {
            System.out.println(" Insert Basic Member failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }

    public boolean insertStudentMember(StudentMember member) {
        String sql = "INSERT INTO member " +
                "(name, age, membership_type, role, school_name, has_trainer) " +
                "VALUES (?, ?, ?, 'Student Member', ?, NULL)";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, member.getName());
            ps.setInt(2, member.getAge());
            ps.setString(3, member.getMembershipType());
            ps.setString(4, member.getSchoolName());

            int rows = ps.executeUpdate();
            ps.close();

            if (rows > 0) {
                System.out.println("Student Member inserted: " + member.getName());
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Insert Student Member failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }

    public boolean insertPremiumMember(PremiumMember member) {
        String sql = "INSERT INTO member " +
                "(name, age, membership_type, role, school_name, has_trainer) " +
                "VALUES (?, ?, ?, 'Premium Member', NULL, ?)";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, member.getName());
            ps.setInt(2, member.getAge());
            ps.setString(3, member.getMembershipType());
            ps.setBoolean(4, member.hasPersonalTrainer());

            int rows = ps.executeUpdate();
            ps.close();

            if (rows > 0) {
                System.out.println(" Premium Member inserted: " + member.getName());
                return true;
            }

        } catch (SQLException e) {
            System.out.println(" Insert Premium Member failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }


    public List<Members> getAllMembers() {
        List<Members> members = new ArrayList<>();
        String sql = "SELECT * FROM member ORDER BY member_id";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return members;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Members m = extractMemberFromResultSet(rs);
                if (m != null) members.add(m);
            }

            rs.close();
            ps.close();

            System.out.println("Retrieved " + members.size() + " members");

        } catch (SQLException e) {
            System.out.println("Get all members failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return members;
    }

    public Members getMemberById(int memberId) {
        String sql = "SELECT * FROM member WHERE member_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return null;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, memberId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Members m = extractMemberFromResultSet(rs);
                rs.close();
                ps.close();

                if (m != null) {
                    System.out.println("Found member with ID:" + memberId);
                }

                return m;
            }
            System.out.println("No member found with ID:" + memberId);

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println(" Get member by ID failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return null;
    }

    public List<StudentMember> getAllStudentMembers(){
        List<StudentMember> sm = new ArrayList<>();
        String sql = "SELECT * FROM member WHERE role = 'Student Member' ORDER BY member_id";

        Connection connection = DatabaseConnection.getConnection();
        if(connection == null) return sm;

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Members m = extractMemberFromResultSet(rs);
                if(m instanceof StudentMember){
                    sm.add((StudentMember) m);
                }
            }
            rs.close();
            ps.close();
            System.out.println("Retrieved " + sm.size() + " students");

        }catch (SQLException e) {
            System.out.println(" Select students failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return sm;
    }

    public List<PremiumMember> getAllPremiumMembers(){
        List<PremiumMember> pm = new ArrayList<>();
        String sql = "SELECT * FROM member WHERE role = 'Premium Member' ORDER BY member_id";

        Connection connection = DatabaseConnection.getConnection();
        if(connection == null) return pm;

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Members m = extractMemberFromResultSet(rs);
                if(m instanceof PremiumMember){
                    pm.add((PremiumMember) m);
                }
            }
            rs.close();
            ps.close();
            System.out.println("Retrieved " + pm.size() + " premium members");

        }catch (SQLException e) {
            System.out.println(" Select premium members failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return pm;
    }



    public boolean updateBasicMember(BasicMember member) {
        String sql = "UPDATE member SET name=?, age=?, membership_type=? " +
                "WHERE member_id=? AND role='Basic Member'";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, member.getName());
            ps.setInt(2, member.getAge());
            ps.setString(3, member.getMembershipType());
            ps.setInt(4, member.getMemberId());

            int rows = ps.executeUpdate();
            ps.close();

            if (rows > 0) {
                System.out.println("Basic member updated: " + member.getName());
                return true;
            } else {
                System.out.println("No basic member found with ID: " + member.getMemberId());
            }

        } catch (SQLException e) {
            System.out.println(" Update Basic Member failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }

    public boolean updateStudentMember(StudentMember member) {
        String sql = "UPDATE member SET name=?, age=?, membership_type=?, school_name=? " +
                "WHERE member_id=? AND role='Student Member'";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, member.getName());
            ps.setInt(2, member.getAge());
            ps.setString(3, member.getMembershipType());
            ps.setString(4, member.getSchoolName());
            ps.setInt(5, member.getMemberId());

            int rows = ps.executeUpdate();
            ps.close();

            if (rows > 0) {
                System.out.println("Student member updated: " + member.getName());
                return true;
            } else {
                System.out.println("No student member found with ID: " + member.getMemberId());
            }

        } catch (SQLException e) {
            System.out.println(" Update Student Member failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }

    public boolean updatePremiumMember(PremiumMember member) {
        String sql = "UPDATE member SET name=?, age=?, membership_type=?, has_trainer=? " +
                "WHERE member_id=? AND role='Premium Member'";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, member.getName());
            ps.setInt(2, member.getAge());
            ps.setString(3, member.getMembershipType());
            ps.setBoolean(4, member.hasPersonalTrainer());
            ps.setInt(5, member.getMemberId());

            int rows = ps.executeUpdate();
            ps.close();

            if (rows > 0) {
                System.out.println("Premium member updated: " + member.getName());
                return true;
            } else {
                System.out.println("No premium member found with ID: " + member.getMemberId());
            }

        } catch (SQLException e) {
            System.out.println(" Update Premium Member failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }


    public boolean deleteMember(int memberId) {
        String sql = "DELETE FROM member WHERE member_id=?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, memberId);

            int rows = ps.executeUpdate();
            ps.close();

            if (rows > 0) {
                System.out.println("Member deleted (ID: " + memberId + ")");
                return true;
            } else {
                System.out.println("No member found with ID: " + memberId);
            }

        } catch (SQLException e) {
            System.out.println("Delete Member failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }


    public List<Members> searchByName(String name) {
        List<Members> list = new ArrayList<>();
        String sql = "SELECT * FROM member WHERE name ILIKE ? ORDER BY name";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return list;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Members m = extractMemberFromResultSet(rs);
                if (m != null) list.add(m);
            }

            rs.close();
            ps.close();

            System.out.println("Found " + list.size() + " member matching '" + name + "'");

        } catch (SQLException e) {
            System.out.println("Search by name failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return list;
    }

    public List<Members> searchByAgeRange(int min, int max) {
        List<Members> list = new ArrayList<>();
        String sql = "SELECT * FROM member WHERE age BETWEEN ? AND ? ORDER BY age DESC";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return list;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, min);
            ps.setInt(2, max);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Members m = extractMemberFromResultSet(rs);
                if (m != null) list.add(m);
            }

            rs.close();
            ps.close();

            System.out.println("Found " + list.size() + " member in age range '" +  min + "-" + max);

        } catch (SQLException e) {
            System.out.println("Search by age range failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return list;
    }

    public List<Members> searchByMinAge(int minAge) {
        List<Members> list = new ArrayList<>();

        String sql = "SELECT * FROM member WHERE age >= ? ORDER BY age DESC";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return list;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, minAge);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Members m = extractMemberFromResultSet(rs);
                if (m != null) {
                    list.add(m);
                }
            }

            rs.close();
            ps.close();

            System.out.println("Found " + list.size() + " members age >= " + minAge);

        } catch (SQLException e) {
            System.out.println("Search by min age failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return list;
    }



    private Members extractMemberFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("member_id");
        String name = rs.getString("name");
        int age = rs.getInt("age");
        String type = rs.getString("membership_type");
        String role = rs.getString("role");

        Members m = null;

        if ("Student Member".equals(role)) {
            return new StudentMember(id, name, age, type, rs.getString("school_name"));
        } else if ("Premium Member".equals(role)) {
            return new PremiumMember(id, name, age, type, rs.getBoolean("has_trainer"));
        } else {
            return new BasicMember(id, name, age, type);
        }
    }

    public void displayAllMembers() {
        List<Members> list = getAllMembers();
        list.forEach(System.out::println);
    }

    public void demonstratePolymorphism() {
        List<Members> members = getAllMembers();

        System.out.println("\n=== POLYMORPHISM DEMO ===");
        for (Members m : members) {
            m.workOut();
        }
    }
}







