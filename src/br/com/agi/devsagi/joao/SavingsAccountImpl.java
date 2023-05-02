package br.com.agi.devsagi.joao;

import java.math.BigDecimal;

public class SavingsAccountImpl extends Account implements SavingsAccount {

    public SavingsAccountImpl(int accountNumber, BigDecimal balance) {
        super(accountNumber, balance);
    }
    @Override
    public void applyInterest() {
        BigDecimal interestRate = new BigDecimal("0.01");
        BigDecimal interest = balance.multiply(interestRate);
        this.balance = this.balance.add(interest);
    }

    @Override
    public String toString() {
        return String.format("%n%nNúmero da conta: %d%nSaldo da conta: %.2f%n%n", accountNumber, balance);
    }
}
