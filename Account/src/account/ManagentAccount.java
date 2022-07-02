package account;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManagentAccount {
    private ArrayList<Account> accounts;

    public ManagentAccount(){accounts = new ArrayList<>();}

    public Account findAccount(String number) {
        for (Account account:
             accounts) {
            if (account.getNumber().equals(number)){
                return account;
            }
        }
        return null;
    }

    public void addAccount(Account account){
        accounts.add( account );
    }

    public void deposit(Account account, double value){
        account.deposit( value );
    }
    public boolean withDraw( Account account, double value){
        return  account.withDraw( value );
    }
    public boolean transferAccount(AccountDeposit source, AccountDeposit target, double value){
        return source.transferAccount( target, value);
    }
    public ArrayList<Account>getAccounts(){
        return (ArrayList<Account>) accounts.clone();
    }
}
