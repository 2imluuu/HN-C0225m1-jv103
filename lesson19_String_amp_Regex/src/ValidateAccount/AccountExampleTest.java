package ValidateAccount;

import java.util.Scanner;

public class AccountExampleTest {
    public static void main(String[] args) {
        boolean i = false;
        while(!i){
        System.out.println("Enter your Account:");
        Scanner sc = new Scanner(System.in);
        String account = sc.nextLine();
        AccountExample accountExample = new AccountExample();
        boolean valid = accountExample.validate(account);
        if(valid){
            System.out.println("Account is valid");
            i=true;
        } else  {
            System.out.println("Account is not valid");
        }}
    }
}
