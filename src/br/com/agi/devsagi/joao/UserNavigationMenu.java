package br.com.agi.devsagi.joao;

public interface UserNavigationMenu {

    void userQueryBalanceMenu();
    void userApplyInterestSavingsAccountMenu();
    void userTransferMenu() throws InsufficientFundsException;
    void userWithdrawMenu() throws InsufficientFundsException;
    void userDepositMenu() throws InsufficientFundsException;
    void userCreateCheckingAccount();
    void userCreateSavingsAccount();
    void printUserMenu();
}
