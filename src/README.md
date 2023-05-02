# Desafio POO (26/04)

Você deve criar um sistema de contas bancárias para uma instituição financeira. A instituição oferece dois tipos de contas: conta corrente e conta poupança. Ambas as contas devem ter as funcionalidades básicas de depósito, saque e consulta de saldo. No entanto, a conta poupança deve ter uma funcionalidade adicional que é a aplicação de juros sobre o saldo.

Para implementar esse sistema, você deve seguir as seguintes especificações:

## Classe abstrata "Account":

Atributos:

int accountNumber;

double balance;

Métodos abstratos:

public abstract void deposit(double value);

public abstract void withdraw(double value);

public abstract double getBalance();

## Classe "CheckingAccount":

Deve herdar da classe "Account";

Implementar os métodos abstratos "deposit", "withdraw" e "getBalance" da classe "Account";

Regras dos métodos:

O método "deposit" deve receber um parâmetro "value" do tipo double, verificar se o valor é maior que 0, e se for, adicionar o valor ao saldo;

O método "withdraw" deve receber um parâmetro "value" do tipo double, verificar se o valor é maior que 0 e se o valor é menor ou igual ao saldo disponível, e se for, subtrair o valor do saldo;

O método "getBalance" deve retornar o saldo atual da conta.

## Interface "SavingsAccount":

Métodos:

public void applyInterest();

Classe "SavingsAccountImpl":

Deve herdar da classe "Account";

Implementar os métodos abstratos "deposit", "withdraw" e "getBalance" da classe "Account";

Implementar o método "applyInterest" da interface "SavingsAccount";

Regras dos métodos:

O método "deposit" deve receber um parâmetro "value" do tipo double, verificar se o valor é maior que 0, e se for, adicionar o valor ao saldo;

O método "withdraw" deve receber um parâmetro "value" do tipo double, verificar se o valor é maior que 0 e se o valor é menor ou igual ao saldo disponível, e se for, subtrair o valor do saldo;

O método "getBalance" deve retornar o saldo atual da conta;

O método "applyInterest" deve adicionar 1% de juros sobre o saldo da conta poupança.

## Classe "Main":

Deve conter o método "main" para executar o programa;

Deve criar um menu para que o usuário possa escolher entre criar uma conta corrente ou uma conta poupança, realizar depósitos, saques e aplicação de juros (no caso da conta poupança). 

O menu pode ser implementado utilizando a classe "Scanner" para ler a entrada do usuário.