package Main.Execute;

import Bank.Account;

public class Bankmain {
    public static void main(String[] args) {
        Account Julz= new Account();
        Julz.newAccount();
        Julz.withdraw();
        Julz.showAcc();
    }
}
