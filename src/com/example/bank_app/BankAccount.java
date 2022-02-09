package com.example.bank_app;

public class BankAccount {
    private double checkingBalance = 0.00;
    private double savingsBalance = 0.00;
    final private double checkingOpeningDeposit;
    final private double savingsOpeningDeposit;

    public BankAccount(double checkingOpeningDeposit, double savingsOpeningDeposit){
        this.checkingOpeningDeposit = checkingOpeningDeposit;
        this.savingsOpeningDeposit = savingsOpeningDeposit;
        checkingBalance += checkingOpeningDeposit;
        savingsBalance += savingsOpeningDeposit;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void checkingWithdrawal(double withdrawalAmount) {
        if (checkingBalance < withdrawalAmount ) {
            System.out.println("Your account balance is insufficient for this transaction.");
            if (savingsBalance > withdrawalAmount) {
                System.out.println("You need to complete a balance transfer first.");
            }
        } else if (checkingBalance > withdrawalAmount){
            checkingBalance -= withdrawalAmount;
        }
    }

    public void savingsWithdrawal(double withdrawalAmount) {
        if (savingsBalance < withdrawalAmount ) {
            System.out.println("Your account balance is insufficient for this transaction.");
            if (checkingBalance > withdrawalAmount) {
                System.out.println("You need to complete a balance transfer first.");
            }
        } else if (savingsBalance > withdrawalAmount){
            savingsBalance -= withdrawalAmount;
        }
    }

    public void transferToChecking(double transferAmount){
        if(savingsBalance > transferAmount){
            savingsBalance -= transferAmount;
            checkingBalance += transferAmount;
            System.out.println("Your transaction has been completed.");
            System.out.println("Your current savings balance is: " + getSavingsBalance());
            System.out.println("Your current checking balance is: " + getCheckingBalance());
        } else if (savingsBalance < transferAmount){
            System.out.println("Your account balance is insufficient for this transaction.");
        }
    }

    public void transferToSavings(double transferAmount){
        if(checkingBalance > transferAmount){
            checkingBalance -= transferAmount;
            savingsBalance += transferAmount;
            System.out.println("Your transaction has been completed.");
            System.out.println("Your current checking balance is: " + getCheckingBalance());
            System.out.println("Your current savings balance is: " + getSavingsBalance());
        } else if (checkingBalance < transferAmount){
            System.out.println("Your account balance is insufficient for this transaction.");
        }
    }

    public void checkingDeposit(double depositAmount) {
        checkingBalance += depositAmount;
        System.out.println("Your current checking balance is: " + getCheckingBalance());
    }

    public void savingsDeposit(double depositAmount) {
        savingsBalance += depositAmount;
        System.out.println("Your current savings balance is: " + getSavingsBalance());
    }
}
