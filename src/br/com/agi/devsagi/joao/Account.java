package br.com.agi.devsagi.joao;


import java.math.BigDecimal;

public abstract class Account {
    protected int accountNumber;
    protected BigDecimal balance;

    public Account(int accountNumber, BigDecimal balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void transfer(Account destination, BigDecimal value) throws InsufficientFundsException{
        if(value.compareTo(BigDecimal.ZERO)  <= 0){
            throw new InsufficientFundsException(String.format("Saldo: %.2f Valor: %.2f%n >> O valor para transferência é inválido. <<", this.balance, value));
        }

        if(this.balance.compareTo(value) < 0){
            throw new InsufficientFundsException(String.format("Saldo: %.2f Valor do saque: %.2f%n >> SALDO INSUFICIENTE!!! << ", this.balance, value));
        }

        this.balance = this.balance.subtract(value);
        destination.deposit(value);
    }
    public void deposit(BigDecimal value) throws InsufficientFundsException {
        if (value.compareTo(BigDecimal.ZERO) > 0){
            this.balance = balance.add(value);
        } else {
            throw new InsufficientFundsException(String.format("Saldo: %.2f Valor: %.2f%n >> O VALOR DO DEPOSITO DEVE SER MAIOR QUE ZERO <<", this.balance, value));
        }
    }

    public void withdraw(BigDecimal value) throws InsufficientFundsException {
        if(value.compareTo(this.balance) <= 0 && value.compareTo(BigDecimal.ZERO) > 0){
            this.balance = balance.subtract(value);
        } else {
            throw new InsufficientFundsException(String.format("Saldo: %.2f Valor do saque: %.2f%n >> SALDO INSUFICIENTE!!! << ", this.balance, value));
        }
    }

    public BigDecimal getBalance(){
        return this.balance;
    }

}
