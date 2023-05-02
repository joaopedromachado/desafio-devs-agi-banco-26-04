package br.com.agi.devsagi.joao;

import java.math.BigDecimal;
import java.util.Scanner;

public class MenuInteractionService implements UserNavigationMenu{

    CheckingAccount checkingAccount;
    SavingsAccountImpl savingsAccount;
    Scanner scanner = new Scanner(System.in);
    int opMenu, accountUserNumber, typeAccount;
    BigDecimal depositAmount, withdrawAmount, transferAmount, previousBalance;

    public void runApplication() throws InsufficientFundsException {
        do{
            printUserMenu();
            switch (opMenu){
                case 1:
                    userCreateCheckingAccount();
                    break;
                case 2:
                    userCreateSavingsAccount();
                    break;
                case 3:
                    userDepositMenu();
                    break;
                case 4:
                    userWithdrawMenu();
                    break;
                case 5:
                    userTransferMenu();
                    break;
                case 6:
                    userApplyInterestSavingsAccountMenu();
                    break;
                case 7:
                    userQueryBalanceMenu();
                    break;
            }
        }while(opMenu != 0);

        System.out.println("\n\nOBRIGADO POR UTILIZAR O BANCO AGI!\n\n");
    }

    @Override
    public void userQueryBalanceMenu() {
        printAccountTypeMenu();
        switch (typeAccount) {
            case 1:
                if (checkingAccount == null){
                    System.out.println("Conta corrente não existe ou não foi encontrada.");
                } else {
                    System.out.println(checkingAccount);
                }
                break;
            case 2:
                if (savingsAccount == null){
                    System.out.println("Conta poupança não existe ou não foi encontrada.");
                } else {
                    System.out.println(savingsAccount);
                }
                break;
        }
    }

    @Override
    public void userApplyInterestSavingsAccountMenu() {
        savingsAccount.applyInterest();
        System.out.println(savingsAccount);
    }

    @Override
    public void userTransferMenu() throws InsufficientFundsException {
        printAccountTypeMenu();
        switch (typeAccount) {
            case 1:
                System.out.print("\nQuantidade que deseja transferir: ");
                transferAmount = scanner.nextBigDecimal();
                checkingAccount.transfer(savingsAccount, transferAmount);
                System.out.printf("%n%nTransferência realizada com sucesso! Valor transferido: %.2f%n%n", transferAmount);
                break;
            case 2:
                System.out.print("\nQuantidade que deseja transferir: ");
                transferAmount = scanner.nextBigDecimal();
                savingsAccount.transfer(checkingAccount, transferAmount);
                System.out.printf("%n%nTransferência realizada com sucesso! Valor transferido: %.2f%n%n", transferAmount);
                break;
        }
    }

    @Override
    public void userWithdrawMenu() throws InsufficientFundsException {
        printAccountTypeMenu();
        switch (typeAccount) {
            case 1:
                System.out.print("\nQuantidade que deseja sacar: ");
                withdrawAmount = scanner.nextBigDecimal();
                checkingAccount.withdraw(withdrawAmount);
                System.out.print("\nSaque realizado com sucesso.\n\n");
                break;
            case 2:
                System.out.print("\nQuantidade que deseja sacar: ");
                withdrawAmount = scanner.nextBigDecimal();
                savingsAccount.withdraw(withdrawAmount);
                System.out.print("\nSaque realizado com sucesso.\n\n");
                break;
        }
    }

    @Override
    public void userDepositMenu() throws InsufficientFundsException {
        printAccountTypeMenu();
            switch (typeAccount) {
                case 1:
                    depositTransactionCheckingAccount();
                    break;
                case 2:
                    depositTransactionSavingsAccount();
                    break;
            }
    }

    @Override
    public void userCreateCheckingAccount() {
        System.out.print("\nDigite o número da conta do usuário: ");
        accountUserNumber = scanner.nextInt();
        checkingAccount = new CheckingAccount(accountUserNumber, new BigDecimal(0));
        System.out.printf("%n%nConta corrente N°%d, criada com sucesso!%n%n", accountUserNumber);
    }

    @Override
    public void userCreateSavingsAccount() {
        System.out.print("\nDigite o número da conta do usuário: ");
        accountUserNumber = scanner.nextInt();
        savingsAccount = new SavingsAccountImpl(accountUserNumber, new BigDecimal(0));
        System.out.printf("%n%nConta poupança N°%d, criada com sucesso!%n%n", accountUserNumber);
    }

    @Override
    public void printUserMenu() {
        System.out.print(" ---------------------------------------- \n " +
                "| MENU: 	                            |\n " +
                "|                                      |\n " +
                "|  1 - Criar conta corrente            |\n " +
                "|  2 - Criar conta poupança            |\n " +
                "|  3 - Depositar                       |\n " +
                "|  4 - Sacar                           |\n " +
                "|  5 - Transferir                      |\n " +
                "|  6 - Aplicar juros (conta poupança)  |\n " +
                "|  7 - Consultar saldo da conta        |\n " +
                "|  0 - Sair                            |\n " +
                "----------------------------------------\n\n" +
                "Escolha uma opção: ");
        opMenu = scanner.nextInt();
    }

    public void printAccountTypeMenu(){
        System.out.print("\n\nDigite o tipo da conta para realizar a operação:\n1 - Conta Corrente\n2 - Conta Poupança\nDigite aqui: ");
        typeAccount = scanner.nextInt();
    }

    public void depositTransactionCheckingAccount() throws InsufficientFundsException {
        System.out.print("\nQuantidade que deseja depositar: ");
        depositAmount = scanner.nextBigDecimal();
        checkingAccount.deposit(depositAmount);
    }

    public void depositTransactionSavingsAccount() throws InsufficientFundsException {
        System.out.print("\nQuantidade que deseja depositar: ");
        depositAmount = scanner.nextBigDecimal();
        savingsAccount.deposit(depositAmount);
    }
}
