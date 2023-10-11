package int101.work03;

import int101.work1.Utilitor;
import int101.work2.Person;

public class Account {

    private static long nextNo = 1_000_000_000;

    private long no;
    private double balance;

    private Person owner;

    public Account(Person owner) {
        if(owner == null) throw new NullPointerException("Owner is null");

        this.no = Utilitor.computeIsbn10(nextNo += 10);
        this.balance = 0;
        this.owner = owner;
    }

    public double deposit(double amount) {
        Utilitor.testPositive(amount);

        return balance += amount;
    }

    public double withdraw(double amount) {
        Utilitor.testPositive(amount);

        double newBalance = Utilitor.testPositive(balance - amount);

        return newBalance;
    }

    public void transfer(double amount, Account account) {
        if(account == null) throw new IllegalArgumentException("The target account is null");

        //Check case but no necessary
        amount = Utilitor.testPositive(amount);

        account.deposit(amount);
    }

    public long getNo() {
        return no;
    }

    public double getBalance() {
        return balance;
    }

    public Person getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return new StringBuilder("Account(")
                .append(no + ",")
                .append(balance + ")")
                .toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Account)) return false;

        Account account = (Account) obj;

        if(account.getNo() == getNo()) return true;

        return false;
    }
}
