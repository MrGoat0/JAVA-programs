package account;

import java.time.LocalDate;

public class AccountCurrent extends Account{
    private double overDraft;

    public AccountCurrent(String number, LocalDate dateOpen, double balance, double overDraft) {
        super(number, dateOpen, balance);
        this.overDraft = overDraft;
    }

    @Override
    public boolean withDraw(double value) {
        if (value <= (balance+overDraft)){
            balance-=value;
            return true;
        }
        return false;
    }

    public double getOverDraft() {
        return overDraft;
    }

    public void setOverDraft(double overDraft) {
        this.overDraft = overDraft;
    }
}
