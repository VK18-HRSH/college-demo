package Project;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.*;

import java.sql.*;

public class Employee {
    static int id, age, we;
    static double GP, cgpa;
    static String name, email, pass, ws, jt, cn, pr1, pr2, pr3, path, phoPath, co;

    static int j = 0;

    static void getData() throws Exception {
        Scanner sc = new Scanner(System.in);
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobPortal", "root", "");
        System.out.print("Enter Name : ");
        name = sc.nextLine();
        System.out.print("Enter your age: ");
        age = sc.nextInt();
        System.out.print("Enter your email address: ");
        email = sc.next();
        System.out.print("Make your password(Note: your password must contain one symbol,number,Alphabet): ");
        pass = sc.next();
        System.out.print("Re-Enter Passworrd :");
        String re_enter_pass = sc.next();
        if (pass.equals(re_enter_pass)) {
            System.out.print("Enter Final CGPA : ");
            cgpa = sc.nextDouble();
            System.out.print("Work Sector : ");
            ws = sc.next();
            System.out.print("Job Tittle : ");
            jt = sc.next();
            System.out.print("Enter Your Collage Name : ");
            cn = sc.next();

            if (cgpa >= 6 && cgpa < 7) {
                GP += 1;
            } else if (cgpa >= 7 && cgpa < 8) {
                GP += 1.5;
            } else if (cgpa >= 8 && cgpa < 9) {
                GP += 2;
            } else if (cgpa >= 9 && cgpa <= 10) {
                GP += 2.5;
            }

            System.out.print("Enter Your Work Experience : ");
            we = sc.nextInt();
            // sc.next();
            if (we == 0) {
                GP += 0;
            } else if (we == 1) {
                GP += 0.5;
            } else if (we == 2) {
                GP += 1;
            } else if (we == 3) {
                GP += 1.5;
            } else if (we == 4) {
                GP += 2;
            } else {
                GP += 2.5;
            }
            System.out.print(
                    "how many project you want to insert(Note:You can insert min 1 project OR maximum 3 project:) : ");
            int project = sc.nextInt();
            String[] pr = new String[3];
            for (int i = 0; i < project; i++) {
                System.out.print("Enter project-" + (i + 1) + " name:");
                pr[i] = sc.next();
                GP += 0.83;
            }
            pr1 = pr[0];
            pr2 = pr[1];
            pr3 = pr[2];
            System.out.print("Enter your projects file link: ");
            path = sc.next();
            System.out.print("Upload your photo: ");
            phoPath = sc.next();
            FileReader fr = new FileReader("C://DS_In_Bio//" + path + ".txt");
            FileInputStream fis = new FileInputStream("C://DS_In_Bio//" + phoPath + ".jpeg");
            System.out.print("Enter your best experiensed privious company name: ");
            co = sc.next();
            int rp = 0;
            String sql1 = "select reputation_point from company_info where company_name=?";
            PreparedStatement pst1 = con.prepareStatement(sql1);
            pst1.setString(1, co);
            ResultSet rs = pst1.executeQuery();
            while (rs.next()) {
                rp = rs.getInt(1);

            }
            if (rp == 1)
                GP += 0.5;
            else if (rp == 2)
                GP += 1;
            else if (rp == 3)
                GP += 1.5;
            else if (rp == 4)
                GP += 2;
            else if (rp == 5)
                GP += 2.5;
            // Employee emp = new Employee(j++,0, 0, GP, GP, name, email, re_enter_pass,
            // re_enter_pass, re_enter_pass, re_enter_pass, re_enter_pass, name, email,
            // pass, re_enter_pass);
            String sql = "insert into employee_info(name,email,pass,work_s,job_t,collegename,cgpa,age,work_e,project1,project2,project3,pro_file,photo,p_company,gradepoint) values('"
                    + name + "','" + email + "','" + pass + "','" + ws + "','" + jt + "','" + cn + "'," + cgpa + ","
                    + age + "," + we + ",'" + pr1 + "','" + pr2 + "','" + pr3 + "',?,?,'" + co + "'," + GP + ")";



                  
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setCharacterStream(1, fr);
            pst.setBinaryStream(2, fis);
            int i = pst.executeUpdate();
            if (i > 0) {
                System.out.println("Employee details inserted successfully");
            } else {
                System.out.println("Error in insertion of details");
            }

        } else {
            System.out.println("!! Wrong Password !!");
            System.out.println("Please Enter same Passeword ");
            getData();

        }
        sc.close();
    }
    public static void searchJobs() {
        Scanner scx = new Scanner(System.in);
        System.out.println("Search jobs by:");
        System.out.println("1. Job Title");
        System.out.println("2. Company Name");
        System.out.println("3. Location");
        System.out.println("4. Salary Range");

        int choice = scx.nextInt();
        scx.nextLine();  

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal", "root", "");
            String query = "";
            PreparedStatement stmt = null;
            ResultSet rs = null;

            switch (choice) {
                case 1:
                    System.out.print("Enter Job Title: ");
                    String jobTitle = scx.nextLine();
                    query = "SELECT * FROM Jobs WHERE job_title LIKE ?";
                    stmt = conn.prepareStatement(query);
                    stmt.setString(1, "%" + jobTitle + "%");
                    break;

                case 2:
                    System.out.print("Enter Company Name: ");
                    String companyName = scx.nextLine();
                    query = "SELECT * FROM Jobs WHERE company_name LIKE ?";
                    stmt = conn.prepareStatement(query);
                    stmt.setString(1, "%" + companyName + "%");
                    break;

                case 3:
                    System.out.print("Enter Location: ");
                    String location = scx.nextLine();
                    query = "SELECT * FROM Jobs WHERE location LIKE ?";
                    stmt = conn.prepareStatement(query);
                    stmt.setString(1, "%" + location + "%");
                    break;

                case 4:
                    System.out.print("Enter Minimum Salary: ");
                    double minSalary = scx.nextDouble();
                    System.out.print("Enter Maximum Salary: ");
                    double maxSalary = scx.nextDouble();
                    query = "SELECT * FROM Jobs WHERE salary BETWEEN ? AND ?";
                    stmt = conn.prepareStatement(query);
                    stmt.setDouble(1, minSalary);
                    stmt.setDouble(2, maxSalary);
                    break;

                default:
                    System.out.println("Invalid choice!");
                    return;
            }

            rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("Job Title: " + rs.getString("job_title"));
                System.out.println("Company Name: " + rs.getString("company_name"));
                System.out.println("Location: " + rs.getString("location"));
                System.out.println("Salary: $" + rs.getDouble("salary"));
                System.out.println("--------------------------------------");
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        scx.close();
    }

    static String recEmppass, companyname, emppass;

    public static void getLogin() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 for Candidate Details  ");
        System.out.println("Press 2 for Search Job vacancy  ");
        int chp=sc.nextInt();
        switch(chp)
        {
            case 1:
            System.out.println();
            System.out.print("Enter email address:");
            String email = sc.next();
            System.out.print("Enter password:");
            String pas = sc.next();
    
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jobportal", "root", "");
    
            String sql = "SELECT pass, companyname FROM rec_emp WHERE email=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
    
            if (rs.next()) {
                recEmppass = rs.getString("pass");
                companyname = rs.getString("companyname");
    
                if (pas.equals(recEmppass)) {
                    System.out.println();
                    System.out.println("Congratulations! You found a job from " + companyname);
                } else {
                    System.out.println("Wrong password......!");
                    
                    JobPortal.jobp();
                }
            } else {
                String sql1 = "SELECT pass FROM employee_info WHERE email=?";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                pst1.setString(1, email);
                ResultSet rs1 = pst1.executeQuery();
    
                if (rs1.next()) {
                    emppass = rs1.getString("pass");
    
                    if (pas.equals(emppass)) {
                        System.out.println();
                        System.out.println("You didn't find any job. Check again sometime.");
                        System.out.println();

    
                    } else {
                        System.out.println("Wrong password......!");
                        JobPortal.jobp();
                    }
                } else {
                    System.out.println("No user found with this email address.");
                    JobPortal.jobp();
                }
            }
            break;
            
            case 2:
            Employee.searchJobs();
            break;

            default :
            System.exit(0);
            break;
        }
        sc.close();
    }
}