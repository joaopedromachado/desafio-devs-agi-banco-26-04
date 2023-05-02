package br.com.agi.devsagi.joao;


import java.math.BigDecimal;

public class CheckingAccount extends Account{
    public CheckingAccount(int accountNumber, BigDecimal balance) {
        super(accountNumber, balance);
    }

    @Override
    public String toString() {
        return String.format("%n%nNúmero da conta: %d%nSaldo da conta: %.2f%n%n", accountNumber, balance);
    }
}
