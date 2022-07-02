package account;

import java.time.LocalDate;

public class Controll {
    private ManagentAccount mngAccount;

    public Controll(){
        mngAccount = new ManagentAccount();
    }
    public boolean deposit(String numberAccount, double value){
        Account account = mngAccount.findAccount(numberAccount);
        if (account != null){
            account.deposit(value);
            return true;
        }
        return false;
    }
    public Object[] findAccount(String numberAccount){
        Account account = mngAccount.findAccount( numberAccount );
        if (account != null){
            if (account instanceof AccountDeposit){
                Object[] output = {account.getNumber(), account.getDateOpen(), account.getBalance(), ((AccountDeposit) account).getInterestRate(), ((AccountDeposit) account).isExcent()};
                return output;
            }
            else {
                Object[] output = {account.getNumber(), account.getDateOpen(), account.getBalance(), ((AccountCurrent)account).getOverDraft()};
                return output;
            }
        }
        return null;
    }
    public boolean addAccount(String numberAccount, LocalDate dateOpen, double balance, double interestRate, boolean excent){
        if (mngAccount.findAccount( numberAccount ) == null){
            AccountDeposit account = new AccountDeposit(numberAccount,dateOpen, balance, interestRate, excent);
            mngAccount.addAccount( account );
            return true;
        }
        return false;
    }
    public boolean addAccount(String numberAccount, LocalDate dateOpen, double balance, double overDraft){
        if (mngAccount.findAccount( numberAccount ) == null){
            AccountCurrent account = new AccountCurrent(numberAccount,dateOpen, balance, overDraft);
            mngAccount.addAccount( account );
            return true;
        }
        return false;
    }
    public boolean withDraw(String numberAccount, double value) throws Exception {
        Account account = mngAccount.findAccount( numberAccount );
        if (account != null){
            return mngAccount.withDraw(account, value);
        }
        throw new Exception("No existe la cuenta");
    }
    public boolean transferAccount(String sourceAccount, String targetAccount, double value){
        Account source = mngAccount.findAccount( sourceAccount );
        Account target = mngAccount.findAccount( targetAccount );
        if (value < source.getBalance()){
            mngAccount.transferAccount((AccountDeposit) source, (AccountDeposit) target, value);
        }
        return false;
    }
}
