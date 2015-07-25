package tests;

import contracts.DepositAccount;
import development.Bank;
import development.Model;

@SuppressWarnings("serial")
public class DepositAccountTest extends Model {

	public DepositAccountTest(long seed) {
		super(seed);
		bank = new Bank();
		household1 = new DepositAccount.Owner();
		household2 = new DepositAccount.Owner();
		bank.openAccount(household1);
		bank.openAccount(household2);
	}

	public void start() {
    	bank.endowmentAccount.transfer(household1.defaultAccount(), 100);
    	bank.endowmentAccount.transfer(household2.defaultAccount(), 55);
    	
    	System.out.println("Household 1 = "+household1.defaultAccount().balance);
    	System.out.println("Household 2 = "+household2.defaultAccount().balance);
    	System.out.println("Total Endowment = "+bank.endowmentAccount.balance);

	}
	
    public static void main(String[] args) {
    	DepositAccountTest myModel = new DepositAccountTest(1);
    	myModel.start();
    }
	
	Bank					bank;
	DepositAccount.Owner 	household1;
	DepositAccount.Owner 	household2;
}