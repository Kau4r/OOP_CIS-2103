package Bank;

import java.util.*;

public class Account {
    private int AccNum, ContactNum;
    private double AccBal;
    private String Name, Email;
    Scanner input = new Scanner(System.in);

    public Account() {

    }

    public Account(int accNum, double accBal, int contactNum, String name, String email) {
        this.AccNum = accNum;
        this.AccBal = accBal;
        this.ContactNum = contactNum;
        this.Name = name;
        this.Email = email;
    }

    public void newAccount() {
        System.out.println("Name: ");
        this.Name = input.nextLine();

        System.out.println("Email: ");
        this.Email = input.nextLine();

        System.out.println("Account No: ");
        this.AccNum = input.nextInt();

        System.out.println("Contact No: ");
        this.ContactNum = input.nextInt();
        deposit();

    }

    public int getAccNum() {
        return AccNum;
    }

    public void setAccNum(int accNum) {
        AccNum = accNum;
    }

    public int getContactNum() {
        return ContactNum;
    }

    public void setContactNum(int contactNum) {
        ContactNum = contactNum;
    }

    public double getAccBal() {
        return AccBal;
    }

    public void setAccBal(double accBal) {
        AccBal = accBal;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public void deposit() {
        boolean valid = false;
        while (!valid) {
            System.out.println("Enter deposit amount:");
            int deposit = input.nextInt();
            if (deposit > 0) {
                this.AccBal += deposit;
                valid = true;
            } else {
                System.out.println("Invalid Amount Please Try Again");
            }
        }
    }

    public void withdraw() {
        boolean valid = false;
        while (!valid) {
            System.out.println("Enter amount to withdraw:");
            int withdraw = input.nextInt();

            if (withdraw <= this.AccBal && withdraw > 0) {
                this.AccBal -= withdraw;
                valid = true;
            } else {
                System.out.println("Invalid Amount Please Try Again");
            }
        }
    }

    public void showAcc() {
        System.out.println("Account Details:");
        System.out.println("Name: " + this.Name);
        System.out.println("Account Number: " + this.AccNum);
        System.out.println("Email: " + this.Email);
        System.out.println("Contact #: " + this.ContactNum);
        System.out.println("Current Bal: " + this.AccBal);
    }

    @Override
    public String toString() {
        return String.format("Account Details: \nName: %s\nAcc #: %d\nEmail: %s\nContact #: %d\nCurrent Bal: %f",this.Name,this.AccNum,this.Email,this.ContactNum,this.AccBal);
    }
    
}
