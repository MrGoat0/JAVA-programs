package account;

import java.time.LocalDate;
import java.time.Period;

public abstract class Account implements ActionsAccount {
    protected String number;
    protected LocalDate dateOpen;
    protected double balance;

    public Account(String number, LocalDate dateOpen, double balance){
        this.balance=balance;
        this.dateOpen=dateOpen;
        this.number=number;
    }
    public String getNumber() {
        return number;
    }
    public LocalDate getDateOpen() {
        return dateOpen;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }



    public double getBalance() {
        return balance;
    }


    public void setDateOpen(LocalDate dateOpen) {
        this.dateOpen = dateOpen;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", dateOpen=" + dateOpen +
                ", balance=" + balance +
                '}';
    }

    @Override
    public void deposit(double value) {
        balance+= value;
    }


    @Override
    public int getAge() {
        Period period = Period.between(dateOpen, LocalDate.now());

        return period.getYears();
    }
}
