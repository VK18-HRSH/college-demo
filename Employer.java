package Project;

import java.sql.*;
import java.util.*;


public class Employer {

    class node {

        String email, pass, companyname,sector;
        node next, pre;

        node(String email, String pass, String companyname,String sector) {
            this.email = email;
            this.pass = pass;
            this.companyname = companyname;
            this.sector=sector;
            this.next = null;
            this.pre = null;
        }
    }

    node first = null;

    void insertEmployer(String email, String pass, String cn,String sector) {

        node n = new node(email, pass, cn,sector);
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
                System.out.print(temp.companyname + " "+temp.email+" "+temp.pass+" ");
                temp = temp.next; 
                System.out.println();
            }
        }
    }
    

    String login(String mail) {
        if(first == null)
        {
           System.out.println("Employer not exists");
           return null;
        }
        else
        {
                node current = first;
                while (current != null) {
                    if (current.email.equals(mail)) {
                        return current.pass;
                        
                    }
                    current = current.next;
                }
                return null;  // Email not found, return null 
        }
    }
        String getSector(String pass) {
        if(first == null)
        {
           System.out.println("Employer not exists");
           return null;
        }
        else
        {
                node current = first;
                while (current != null) {
                    if (current.pass.equals(pass)) {
                        return current.sector;
                        
                    }
                    current = current.next;
                }
                return null; // Email not found, return null 
        }
    }
    String getCompany(String pass) {
        if(first == null)
        {
           System.out.println("Employer not exists");
           return null;
        }
        else
        {
                node current = first;
                while (current != null) {
                    if (current.pass.equals(pass)) {
                        return current.companyname;
                        
                    }
                    current = current.next;
                }
                return null; // Email not found, return null 
        }
    }

    public static void employer() throws Exception {
        Scanner sc = new Scanner(System.in);
        Employer a = new Employer();
        a.insertEmployer("rb123@gmail.com", "rb123@", "Rkt","IT1");
        a.insertEmployer("kcpatel12@gmail.com", "kc32@", "Partyplex","Mechanical");
        a.insertEmployer("ub34@gmail.com", "Ub67@", "google","IT");
        a.insertEmployer("rd67@gmail.com", "rd@56g", "TCS","IT");
        while (true) {
            System.out.println(
                    "\n1 : LOGIN\n2 : SIGNUP\n3 : EXIT");
            int c = sc.nextInt();
            switch (c) {
                case 1:
                    System.out.println();
                    System.out.println("Enter emailid:");
                    String email = sc.next();
                    System.out.println("Enter password:");
                    String pass = sc.next();
                    String passCheck=a.login(email);
                    String sector = a.getSector(pass);
                    String com = a.getCompany(passCheck);
                    if(pass.equals(passCheck))
                    {
                        Es.fatchData(sector,com);
                    }
                    else
                    {
                        System.out.println("Wrong password......!");
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println();
                 //  showEmp.showEmployeesAppliedToCompany("HK");
                    break;
                case 2:
                    System.out.println();
                    System.out.print("Enter your company name:");
                    String cn = sc.next();
                    System.out.print("In which sector your comapny works:(Note:Please fill this in cap letters only):");
                    String sec = sc.next();
                    System.out.print("Enter your email-id :");
                    String mail = sc.next();
                    System.out.print("Make password:");
                    String pas = sc.next();
                    a.insertEmployer(mail,pas,cn,sec);
                    break;
                case 3:
                    JobPortal.jobp();
                    break;
                default:
                    System.out.println("Enter an valid choice:");
            }
        }
    }
}

class showEmp
{
    public static void showEmployeesAppliedToCompany(String companyName) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal", "root", "");
    
        // Query to fetch employee details who applied to the given company
        String sql = "SELECT e.id, e.name FROM employee_info e " +
                     "JOIN applications a ON e.id = a.employee_id " +
                     "WHERE a.company_name = ?";
        
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, companyName);
        ResultSet rs = pst.executeQuery();
    
        System.out.println("Employees who have applied to " + companyName + ":");
    
        // Print the employee IDs and names
        while (rs.next()) {
            int employeeId = rs.getInt("id");
            String employeeName = rs.getString("name");
            System.out.println("Employee ID: " + employeeId + " | Name: " + employeeName);
        }
    
        // Closing resources
        rs.close();
        pst.close();
        con.close();
    }
}