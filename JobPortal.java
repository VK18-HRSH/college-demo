package Project;

import java.util.*;

class JobPortal {
    public static void main(String[] args) throws Exception {
        jobp();
    }

    public static void jobp() throws Exception {
        Scanner sx = new Scanner(System.in);
        int x;

        while (true) {
            System.out.println("\n1.Find a Job \n2.Hire Now  \n3.Exit ");
            System.out.print("Enter Your Preference: ");
            x = sx.nextInt();
            switch (x) {
                case 1:
                        System.out.println();
                        System.out.println(
                                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Enter choice from below~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println(
                                "                   1.LOGIN                 2.SIGNUP       ");
                        System.out.println("                                   ENTER");
                        sx.nextLine();
                        int choice = sx.nextInt();
                        switch (choice) {

                            case 1:
                                Employee.getLogin();
                                break;
                            case 2:
                                Employee.getData();
                                break;

                            default :
                            System.out.println("exit");
                            break;
                        }
                        // if (choice == 3) {
                        //     break;
                        // }
                    //break;

                case 2:
                    Employer.employer();
                    break;

                case 3:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please Enter Valid Choice");
                    break;

            }
            sx.close();   
        }
    }
}

 

    
