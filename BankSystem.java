// 2. Banking System with Inheritance and Polymorphism

abstract class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    abstract void withdraw(double amount);

    abstract void calculateInterest();

    void showBalance() {
        System.out.println("Account " + accountNumber + " Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate = 0.04;

    SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance in savings account.");
        }
    }

    @Override
    void calculateInterest() {
        balance += balance * interestRate;
    }
}

class CheckingAccount extends BankAccount {
    double overdraftLimit = 500.0;

    CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
        } else {
            System.out.println("Overdraft limit exceeded in checking account.");
        }
    }

    @Override
    void calculateInterest() {
        // No interest for checking account
    }
}

public class BankSystem {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("SA123", 1000);
        BankAccount checking = new CheckingAccount("CA123", 500);

        savings.deposit(200);
        savings.withdraw(100);
        savings.calculateInterest();
        savings.showBalance();

        checking.deposit(100);
        checking.withdraw(700);
        checking.calculateInterest();
        checking.showBalance();
    }
}
