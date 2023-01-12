class Thread1{
	int amount=10000;
	synchronized void withdraw(int amount)
	{
		System.out.println("Going to withdraw the amount");
		if(this.amount<amount){
			System.out.println("you have less balance");
			try{wait();}catch(Exception e){}
		}
		this.amount-=amount;
		System.out.println("withdraw completed");
	}
	synchronized void deposit(int amount)
	{
		System.out.println("Going to deposit");
			this.amount+=amount;
			System.out.println("Deposit completed");
			notify();
		}
	}
	class Customer
	{
		public static void main(String...args){
			final Thread1 c=new Thread1();
			new Thread(){
				public void run(){c.withdraw(15000);}
			}.start();
			new Thread(){
				public void run(){c.deposit(10000);}
			}.start();
		
		}
	}

			
			
				
	
			
			

