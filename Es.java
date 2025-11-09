package Project;
import java.util.*;



import java.sql.*;
public class Es {
        class node {
            String name, email,work_sec,job_type,college,pro1,pro2,pro3,pre_com;
            int id,age,work_exp;
            double cgpa,gp;
            node next, pre;
            public node(String name, String email, String work_sec, String job_type, String college, String pro1,
                    String pro2, String pro3, String pre_com, int id, int age, int work_exp, double cgpa, double gp) {
                this.name = name;
                this.email = email;
                this.work_sec = work_sec;
                this.job_type = job_type;
                this.college = college;
                this.pro1 = pro1;
                this.pro2 = pro2;
                this.pro3 = pro3;
                this.pre_com = pre_com;
                this.id = id;
                this.age = age;
                this.work_exp = work_exp;
                this.cgpa = cgpa;
                this.gp = gp;
                next = null;
                pre = null;
            }
            
        }
        node first =null;
        void insertfromdatabase(String name, String email, String work_sec, String job_type, String college, String pro1,
                    String pro2, String pro3, String pre_com, int id, int age, int work_exp, double cgpa, double gp) {

            node n = new node(name,email,work_sec,job_type,college,pro1,pro2,pro3,pre_com,id,age,work_exp,cgpa,gp);
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
        void display()
        {
            System.out.println();
            System.out.println("Information of vacancy");
            System.out.println();
                if (first == null) {
                    System.out.println("Currently the Required Sector's Vacancy is empty");
                } else {
                    node temp = first;
                    while (temp != null) {
                        System.out.print("ID:"+temp.id + ", NAME:"+temp.name+", EMAIL:"+temp.email+", JOB:"+temp.job_type+", COLLEGE: "+temp.college+", PREVIOUS COM:"+temp.pre_com+", EXPERIENCE:"+temp.work_exp+", AGE:"+temp.age+", CGPA: "+temp.cgpa+", GRADEPOINTS: "+temp.gp);
                        temp = temp.next; 
                        System.out.println();
                    }
                }
            
        }
        void sortingByGp()
        {
            System.out.println();
            System.out.println("~~~~~~~~~~~~~~~ Sort by gradepoint ~~~~~~~~~~~~~~~");
            if (first == null) {
                System.out.println("EMPTY");
                return; // Already sorted or empty list
            }
            else if (first.next == null) {
                System.out.println("there is only a one emp");
                return;
            }
    
            boolean swapped;
            do {
                swapped = false;
                node current = first;
    
                while (current != null && current.next != null) {
                    if (current.gp < current.next.gp) {
                        // Swap the gp values
                        double temp = current.gp;
                        current.gp = current.next.gp;
                        current.next.gp = temp;
    
                        double tempcgpa = current.cgpa;
                        current.cgpa = current.next.cgpa;
                        current.next.cgpa = tempcgpa;
                        // Swap the links
                        String tempname = current.name;
                        current.name = current.next.name;
                        current.next.name = tempname;

                        String tempemail = current.email;
                        current.email = current.next.email;
                        current.next.email = tempemail;

                        String tempws = current.work_sec;
                        current.work_sec = current.next.work_sec;
                        current.next.work_sec = tempws;

                        String tempjob_type = current.job_type;
                        current.job_type = current.next.job_type;
                        current.next.job_type = tempjob_type;

                        String tempcollege = current.college;
                        current.college = current.next.college;
                        current.next.college = tempcollege;

                        String temppro1 = current.pro1;
                        current.pro1 = current.next.pro1;
                        current.next.pro1 = temppro1;

                        String temppro2 = current.pro2;
                        current.pro2 = current.next.pro2;
                        current.next.pro2 = temppro2;

                        String temppro3 = current.pro3;
                        current.pro3 = current.next.pro3;
                        current.next.pro3 = temppro3;

                        String temppc = current.pre_com;
                        current.pre_com = current.next.pre_com;
                        current.next.pre_com = temppc;

                        int tempid = current.id;
                        current.id = current.next.id;
                        current.next.id = tempid;

                        int tempage = current.age;
                        current.age = current.next.age;
                        current.next.age = tempage;

                        int tempwe = current.work_exp;
                        current.work_exp = current.next.work_exp;
                        current.next.work_exp = tempwe;

                        swapped = true;
                    }
    
                    current = current.next;
                }
            } while (swapped);
        
                
                display();
        }

        public void sortingByCgpa()
        {
            System.out.println("~~~~~~~~~~~~~~~~~~ Sort by cgpa ~~~~~~~~~~~~~~~~~~");
            if (first == null) {
                return; // Already sorted or empty list
            }
            else if (first.next == null) {
                System.out.println("there is only one emp ");
                return;
            }
    
            boolean swapped;
            do {
                swapped = false;
                node current = first;
    
                while (current != null && current.next != null) {
                    if (current.cgpa < current.next.cgpa) {
                        // Swap the gp values
                        double tempcgpa = current.cgpa;
                        current.cgpa = current.next.cgpa;
                        current.next.cgpa = tempcgpa;

                        double temp = current.gp;
                        current.gp = current.next.gp;
                        current.next.gp = temp;
                        // Swap the links
                        String tempname = current.name;
                        current.name = current.next.name;
                        current.next.name = tempname;

                        String tempemail = current.email;
                        current.email = current.next.email;
                        current.next.email = tempemail;

                        String tempws = current.work_sec;
                        current.work_sec = current.next.work_sec;
                        current.next.work_sec = tempws;

                        String tempjob_type = current.job_type;
                        current.job_type = current.next.job_type;
                        current.next.job_type = tempjob_type;

                        String tempcollege = current.college;
                        current.college = current.next.college;
                        current.next.college = tempcollege;

                        String temppro1 = current.pro1;
                        current.pro1 = current.next.pro1;
                        current.next.pro1 = temppro1;

                        String temppro2 = current.pro2;
                        current.pro2 = current.next.pro2;
                        current.next.pro2 = temppro2;

                        String temppro3 = current.pro3;
                        current.pro3 = current.next.pro3;
                        current.next.pro3 = temppro3;

                        String temppc = current.pre_com;
                        current.pre_com = current.next.pre_com;
                        current.next.pre_com = temppc;

                        int tempid = current.id;
                        current.id = current.next.id;
                        current.next.id = tempid;

                        int tempage = current.age;
                        current.age = current.next.age;
                        current.next.age = tempage;

                        int tempwe = current.work_exp;
                        current.work_exp = current.next.work_exp;
                        current.next.work_exp = tempwe;

                        swapped = true;
                    }
                    current = current.next;
                }
            } while (swapped);
        
                
                display();
        }
        public void sortingByExp()
        {
            System.out.println("~~~~~~~~~~~~~~~ Sort by experience ~~~~~~~~~~~~~~~");
            if (first == null) {
                return; // Already sorted or empty list
            }
            else if (first.next == null) {
                System.out.println("there is only one emp");
                return;
            }
    
            boolean swapped;
            do {
                swapped = false;
                node current = first;
    
                while (current != null && current.next != null) {
                    if (current.work_exp < current.next.work_exp) {
                        // Swap the gp values
                        int tempwe = current.work_exp;
                        current.work_exp = current.next.work_exp;
                        current.next.work_exp = tempwe;

                        double tempcgpa = current.cgpa;
                        current.cgpa = current.next.cgpa;
                        current.next.cgpa = tempcgpa;
                        
                        double temp = current.gp;
                        current.gp = current.next.gp;
                        current.next.gp = temp;
                        // Swap the links
                        String tempname = current.name;
                        current.name = current.next.name;
                        current.next.name = tempname;

                        String tempemail = current.email;
                        current.email = current.next.email;
                        current.next.email = tempemail;

                        String tempws = current.work_sec;
                        current.work_sec = current.next.work_sec;
                        current.next.work_sec = tempws;

                        String tempjob_type = current.job_type;
                        current.job_type = current.next.job_type;
                        current.next.job_type = tempjob_type;

                        String tempcollege = current.college;
                        current.college = current.next.college;
                        current.next.college = tempcollege;

                        String temppro1 = current.pro1;
                        current.pro1 = current.next.pro1;
                        current.next.pro1 = temppro1;

                        String temppro2 = current.pro2;
                        current.pro2 = current.next.pro2;
                        current.next.pro2 = temppro2;

                        String temppro3 = current.pro3;
                        current.pro3 = current.next.pro3;
                        current.next.pro3 = temppro3;

                        String temppc = current.pre_com;
                        current.pre_com = current.next.pre_com;
                        current.next.pre_com = temppc;

                        int tempid = current.id;
                        current.id = current.next.id;
                        current.next.id = tempid;

                        int tempage = current.age;
                        current.age = current.next.age;
                        current.next.age = tempage;

                        
                        swapped = true;
                    }
    
                    current = current.next;
                }
            } while (swapped);
        
                
                display();
        }
        
        public static void fatchData(String sector, String companyname)throws Exception
        {
            Scanner sc = new Scanner(System.in);
             Es s = new Es();
            String name="", email="",work_sec="",job_type="",college="",pro1="",pro2="",pro3="",pre_com="";
            int id=0,age=0,work_exp=0;
            double cgpa=0,gp=0;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal", "root", "");
            String sql = "select id,name,email,work_s,job_t,collegename,cgpa,age,work_e,project1,project2,project3,p_company,gradepoint from employee_info";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                id=rs.getInt(1);
                name=rs.getString(2);
                email=rs.getString(3);
                work_sec=rs.getString(4);
                job_type=rs.getString(5);
                college = rs.getString(6);
                cgpa = rs.getDouble(7);
                age = rs.getInt(8);
                work_exp=rs.getInt(9);
                pro1=rs.getString(10);
                pro2=rs.getString(11);
                pro3 = rs.getString(12);
                pre_com=rs.getString(13);
                gp=rs.getDouble(14);
                if(work_sec.equals(sector))
                {
                    s.insertfromdatabase(name, email, work_sec, job_type, college, pro1, pro2, pro3, pre_com, id, age, work_exp, cgpa, gp);
                }
            }
            s.display();
            System.out.println();
            int choice;
            do{
                System.out.println();
            System.out.println("Choose options for sorting:");
            System.out.println("1.BY GRADEPOINT\n2.BY CGPA\n3.BY WORK EXPERIENCE\n4.Don't want to sorting\n5.exit ");
            System.out.print("Enter your choice:");
            choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    s.sortingByGp();
                    while(true)
                    {
                        System.out.println();
                    System.out.print("Do you want to hire any employee from above list(yes or no):");
                    String add =sc.next();
                    if(add.equalsIgnoreCase("yes"))
                    {
                        
                        System.out.print("Please enter employee id:");
                        int i = sc.nextInt();
                        Match.getMatch(i, companyname);
                    }
                    else{
                        break;
                    }
                    }
                    break;
                case 2:
                    s.sortingByCgpa();
                    while(true)
                    {
                        System.out.println();
                    System.out.print("Do you want to hire any employee from above list(yes or no):");
                    String add =sc.next();
                    if(add.equalsIgnoreCase("yes"))
                    {
                        System.out.print("Please enter employee id:");
                        int i = sc.nextInt();
                        Match.getMatch(i, companyname);
                    }
                    else{
                        break;
                    }
                    }
                    break;
                case 3:
                    s.sortingByExp();
                    while(true)
                    {
                        System.out.println();
                    System.out.print("Do you want to hire any employee from above list(yes or no):");
                    String add =sc.next();
                    if(add.equalsIgnoreCase("yes"))
                    {
                        System.out.print("Please enter employee id:");
                        int i = sc.nextInt();
                        Match.getMatch(i, companyname);
                    }
                    else{
                        break;
                    }
                    }
                    break;
                case 4:
                    s.display();
                    while(true)
                    {
                        System.out.println();
                    System.out.print("Do you want to hire any employee from above list(yes or no):");
                    String add =sc.next();
                    if(add.equalsIgnoreCase("yes"))
                    {
                        System.out.print("Please enter employee id:");
                        int i = sc.nextInt();
                        Match.getMatch(i, companyname);
                    }
                    else{
                        break;
                    }
                    }
                    break;
                case 5:
                    System.out.println("Exit from system....!");                
            }
        }while(choice != 5);
    }
}
