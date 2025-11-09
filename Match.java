package Project;

import java.sql.*;

public class Match {
    class node {

        String name, empname;
        node next, pre;

        node(String name, String empname) {
            this.name = name;
            this.empname = empname;
            this.next = null;
            this.pre = null;
        }
    }

    node first = null;

    void insertMatch(String name, String empname) {

        node n = new node(name, empname);
        if (first == null) {
            first = n;
        } else {
            node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
            n.pre = temp;
        }

    }

    void display() {
        if (first == null) {
            System.out.println("empty");
        } else {
            node temp = first;
            while (temp != null) {
                System.out.print(temp.name + " hire " + temp.empname);
                temp = temp.next;
                System.out.println();
            }
        }
    }

    static String pass, email, name, comnam;
    static int i;

    public static void getMatch(int id, String comname) throws Exception {
        comnam = comname;
        i = id;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal", "root", "");
        String sql = "select pass,name,email from employee_info where id=" + id;
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            pass = rs.getString(1);
            name = rs.getString(2);
            email = rs.getString(3);
        }
        insertDetails();
        Match m = new Match();
        m.insertMatch(comnam, name);
        m.display();

    }

    public static void insertDetails() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal", "root", "");

        String sql1 = "INSERT INTO `rec_emp`(`companyname`, `pass`, `email`) VALUES(?,?,?)";
        PreparedStatement pst1 = con1.prepareStatement(sql1);
        // pst1.setInt(1, i);
        pst1.setString(1, comnam);
        pst1.setString(2, pass);
        pst1.setString(3, email);
        int r = pst1.executeUpdate();
        if (r > 0) {
            System.out.println("Employee get informed for job");
            String sql2 = "delete from employee_info where id=" + i;
            PreparedStatement pst2 = con1.prepareStatement(sql2);
            pst2.executeUpdate();
        }
    }

}
