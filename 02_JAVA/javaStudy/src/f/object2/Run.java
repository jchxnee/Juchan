package f.object2;

public class Run {

	public static void main(String[] args) {
//		BankAccount ref1 = new BankAccount();
//		BankAccount ref2 = ref1;
//		
//		ref1.deposit(3000);
//		ref2.deposit(2000);
//		
//		ref1.checkMyBalance(1000);
//		ref2.checkMyBalance(0);
		
		BankAccount ref1 = new BankAccount();
		BankAccount ref2 = new BankAccount();
		
		ref1.deposit(10000);
		ref1.withdraw(2000);
			
		ref2.checkMyBalance(ref1);
		
		ref1.checkMyBalance();
		ref2.checkMyBalance();
	}

}
