
import java.util.*;
import java.time.LocalDateTime;
class Account {

	private String acc_no;
	protected double balance,depositamount,withdrawamount,Zakat,transferamount;
	protected int transferTax;
	protected String opendate,opentime,withdrawdate,withdrawtime,depositdate,deposittime,transferdate,transfertime;
	int numOftrans=0;

	
	
	Account(){
		
	}

Account(double amount,String accnum,String date,String time,int tax){  //for deduction from checking account
	acc_no=accnum;
	transferamount=amount;
	transferdate=date;
	transfertime=time;
	transferTax=tax;
}

	
Account(String acc,String depdate,String deptime,double damount){
		acc_no=acc;
		depositdate=depdate;
		deposittime=deptime;
		depositamount=damount;
		
	}
Account(String acc,double wamount,String wdate,String wtime){
	acc_no=acc;
	withdrawdate=wdate;
	withdrawtime=wtime;
	withdrawamount=wamount;
	
}

	Account(String acc,double bal,String odate,String otime,String wdate,String wtime,String depdate,String deptime,double damount,double wamount,int num){
		acc_no=acc;
		balance=bal;
		this.opendate=odate;
		opentime=otime;
		withdrawdate=wdate;
		withdrawtime=wtime;
		depositdate=depdate;
		deposittime=deptime;
		depositamount=damount;
		withdrawamount=wamount;
		numOftrans=num;
	}
	
	public String getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}



Scanner sc=new Scanner(System.in);	
	
	void checkBalance(int choice,String acc_no,String cnic,Customer []cs,Customer []cc,Saving []save,Checking[]check ,int countcheck,int countsave) {
		boolean find=true;
		 
		
		if(choice==1) {
			String waste=sc.nextLine();
			
			  for(int i=0;i<countcheck;i++) {
				  if(check[i].getAcc_no().equals(acc_no)&&cc[i].CNIC.equals(cnic)) {
					  System.out.println("Name : "+cc[i].Name);
						System.out.println("Balance : "+check[i].balance); 
						find=false;
						break;
				  }
			  }
			if(find==true) {
				System.out.println("Account number or CNIC is incorrect!");
			}
		}
		else if(choice==2) {
			String waste=sc.nextLine();
			
			  for(int i=0;i<countsave;i++) {
				  if(save[i].getAcc_no().equals(acc_no)&&cs[i].CNIC.equals(cnic)) {
					  System.out.println("Name : "+cs[i].Name);
						System.out.println("Balance : "+save[i].balance); 
						find=false;
						break;
				  }
			  }
		if(find==true) {
			System.out.println("Account number or CNIC is incorrect!");
		  }
		}
		else {
			System.out.println("WRONG Input!");
		}
	}
	
	
	void makeDeposit(int choice,String acc_no,String cnic,Customer []cs,Customer []cc,Saving []save,Checking[]check ,int countcheck,int countsave,Account []deptranforcheck,Account []deptranforsave,Account []widtranforcheck,Account []widtranforsave) {
		boolean find=true;
		
		if(choice==1) {
			String waste=sc.nextLine();
			
		for(int i=0;i<countcheck;i++) {
			if(cc[i].CNIC.equals(cnic) && check[i].getAcc_no().equals(acc_no)) {
			
			  
			System.out.println("Please enter amount to deposit");
			double money=sc.nextDouble();
			
		    
		    if(check[i].numOftrans>=2) {
		    	System.out.println("Your FREE transactions are Over. You are supposed to pay R.s 10 for this transaction\n"+"1- Deduct from this amount\n"+"2- Pay extra 10 R.s");
		    	int select=sc.nextInt();
		    	if(select==1) {
		    		money=money-10;
		    		System.out.println("Deducted!");
		    	}
		    	else if(select==2) {
		    		System.out.println("Ok!");
		    	}
		    	String ddate=java.time.LocalDateTime.now().getDayOfMonth()+"/"+java.time.LocalDateTime.now().getMonthValue()+"/"+java.time.LocalDateTime.now().getYear();  
		    	String dtime=java.time.LocalDateTime.now().getHour()+":"+java.time.LocalDateTime.now().getMinute()+":"+java.time.LocalDateTime.now().getSecond();
		    	Account obja=new Account(check[i].getAcc_no(),ddate,dtime,money);
		    	deptranforcheck[i]=obja;
		    	numOftrans++;
		    	check[i].balance=check[i].balance+money;
		    	Checking obj=new Checking(check[i].getAcc_no(),check[i].balance,check[i].opendate,check[i].opentime,check[i].withdrawdate,check[i].withdrawtime,check[i].depositdate,check[i].deposittime,check[i].depositamount,check[i].withdrawamount,numOftrans);
		    	check[i]=obj;
		    	if(check[i]!=null) {
			    	System.out.println("You Deposit R.s "+money);
			    System.out.println("Amount Deposited");
			    }
		    }
		    else {
		    	String ddate=java.time.LocalDateTime.now().getDayOfMonth()+"/"+java.time.LocalDateTime.now().getMonthValue()+"/"+java.time.LocalDateTime.now().getYear();
		    	String dtime=java.time.LocalDateTime.now().getHour()+":"+java.time.LocalDateTime.now().getMinute()+":"+java.time.LocalDateTime.now().getSecond();
		    	
		    	numOftrans=check[i].numOftrans;
		    	numOftrans++;
		    	check[i].balance=check[i].balance+money;
		    	 Checking obj=new Checking(check[i].getAcc_no(),check[i].balance,check[i].opendate,check[i].opentime,check[i].withdrawdate,check[i].withdrawtime,ddate,dtime,money,check[i].withdrawamount,numOftrans);
				    check[i]=obj;
				    if(check[i]!=null) {
				    	System.out.println("You Deposit R.s "+money);
				    System.out.println("Amount Deposited");
				    }
		    }
		    	
		   
		    
		    find=false;
		    break;  
			}
			}
			if(find==true) {
				System.out.println("CNIC or Account # is incorrect");
			}
		}
		else if(choice==2) {
			String waste=sc.nextLine();
			
			for(int i=0;i<countsave;i++) {
			if(cs[i].CNIC.equals(cnic) && save[i].getAcc_no().equals(acc_no)) {
					
			System.out.println("Please enter amount to deposit");
			double money=sc.nextDouble();
			
			if(save[i].numOftrans>=2) {
		    	System.out.println("Your FREE transactions are Over. You are supposed to pay R.s 10 for this transaction\n"+"1- Deduct from this amount\n"+"2- Pay extra 10 R.s");
		    	int select=sc.nextInt();
		    	if(select==1) {
		    		money=money-10;
		    		System.out.println("Deducted!");
		    	}
		    	else if(select==2) {
		    		System.out.println("Ok!");
		    	}
		    	
		    	String ddate=java.time.LocalDateTime.now().getDayOfMonth()+"/"+java.time.LocalDateTime.now().getMonthValue()+"/"+java.time.LocalDateTime.now().getYear();
		    	String dtime=java.time.LocalDateTime.now().getHour()+":"+java.time.LocalDateTime.now().getMinute()+":"+java.time.LocalDateTime.now().getSecond();
		    	Account obja=new Account(save[i].getAcc_no(),ddate,dtime,money);
		    	deptranforsave[i]=obja;
		    	numOftrans++;
		    	save[i].balance=save[i].balance+money;
		    	Saving obj=new Saving(save[i].getAcc_no(),save[i].balance,save[i].opendate,save[i].opentime,save[i].withdrawdate,save[i].withdrawtime,save[i].depositdate,save[i].deposittime,save[i].depositamount,save[i].withdrawamount,numOftrans);
		    	save[i]=obj;
		    	if(save[i]!=null) {
			    	System.out.println("You Deposit R.s "+money);
			    System.out.println("Amount Deposited");
			    }
		    }
		    else {
		    	numOftrans=save[i].numOftrans;
		    	numOftrans++;
		    	save[i].balance=save[i].balance+money;
		    	String ddate=java.time.LocalDateTime.now().getDayOfMonth()+"/"+java.time.LocalDateTime.now().getMonthValue()+"/"+java.time.LocalDateTime.now().getYear();
		    	String dtime=java.time.LocalDateTime.now().getHour()+":"+java.time.LocalDateTime.now().getMinute()+":"+java.time.LocalDateTime.now().getSecond();
		    	Saving obj=new Saving(save[i].getAcc_no(),save[i].balance,save[i].opendate,save[i].opentime,save[i].withdrawdate,save[i].withdrawtime,ddate,dtime,money,save[i].withdrawamount,numOftrans);
				    save[i]=obj;
				    if(save[i]!=null) {
				    	System.out.println("You Deposit R.s "+money);
				    System.out.println("Amount Deposited");
				    }
		    }
			
		    find=false;
		    break;
			}}
			if(find==true) {
				System.out.println("CNIC or Account number is incorrect");
			}
		}
		else {
			System.out.println("WRONG Input!");
		}	
	}
	
		
	
	
	void rate(double rate) {
		System.out.println("Enter rate.");
	}
	
	void makeWithdrawal(int choice,String acc_no,String cnic,Customer []cs,Customer []cc,Saving []save,Checking[]check ,int countcheck,int countsave,Account []deptranforcheck,Account []deptranforsave,Account []widtranforcheck,Account []widtranforsave) {
		boolean find=true;
		
		if(choice==1) {
			
			String waste=sc.nextLine();
		
		  for(int i=0;i<countcheck;i++) {
			  if(check[i].getAcc_no().equals(acc_no)&&cc[i].CNIC.equals(cnic)) {
				 
				  System.out.println("Enter amount please");
				double amount=sc.nextDouble();
				if(check[i].balance<amount) {
					System.out.println("You don't have enough balance");
				}
				if(check[i].numOftrans>=2&&check[i].balance>amount) {
			    	System.out.println("Your FREE transactions are Over. You are supposed to pay R.s 10 for this transaction\n"+"1- Deduct from this amount\n"+"2- Pay extra 10 R.s");
			    	int select=sc.nextInt();
			    	if(select==1) {
			    		amount=amount-10;
			    		System.out.println("Deducted!");
			    	}
			    	else if(select==2) {
			    		System.out.println("Ok!");
			    	}
			    	
			    	String wdate=java.time.LocalDateTime.now().getDayOfMonth()+"/"+java.time.LocalDateTime.now().getMonthValue()+"/"+java.time.LocalDateTime.now().getYear();
			    	String wtime=java.time.LocalDateTime.now().getHour()+":"+java.time.LocalDateTime.now().getMinute()+":"+java.time.LocalDateTime.now().getSecond();
			    	Account obja=new Account(check[i].getAcc_no(),amount,wdate,wtime);
			    	widtranforcheck[i]=obja;
			    	numOftrans++;
			    	check[i].balance=check[i].balance-amount;
			    	Checking obj=new Checking(check[i].getAcc_no(),check[i].balance,check[i].opendate,check[i].opentime,check[i].withdrawdate,check[i].withdrawtime,check[i].depositdate,check[i].deposittime,check[i].depositamount,check[i].withdrawamount,numOftrans);
			    	check[i]=obj;
			    	if(check[i]!=null) {
				    	System.out.println("You Withdraw R.s "+amount);
				    System.out.println("Amount Withdrawn");
				    }
			    }
			    else if(check[i].balance>amount) {
			    	numOftrans=check[i].numOftrans;
			    	numOftrans++;
			    	check[i].balance=check[i].balance-amount;
			    	String wdate=java.time.LocalDateTime.now().getDayOfMonth()+"/"+java.time.LocalDateTime.now().getMonthValue()+"/"+java.time.LocalDateTime.now().getYear();
			    	String wtime=java.time.LocalDateTime.now().getHour()+":"+java.time.LocalDateTime.now().getMinute()+":"+java.time.LocalDateTime.now().getSecond();
			    	 Checking obj=new Checking(check[i].getAcc_no(),check[i].balance,check[i].opendate,check[i].opentime,wdate,wtime,check[i].depositdate,check[i].deposittime,check[i].depositamount,amount,numOftrans);
					    check[i]=obj;
					    if(check[i]!=null) {
					    	System.out.println("You withdraw R.s "+amount);
					    System.out.println("Amount withdrawn");
					    }
			    }
				
				find=false;
					break;
			  }
		  }
		  if(find==true) {
			  System.out.println("Account with the given CNIC doesn't exist");
		  }
	    }
		else if(choice==2) {
			String waste=sc.nextLine();
			
			  for(int i=0;i<countsave;i++) {
				  if(save[i].getAcc_no().equals(acc_no)&&cs[i].CNIC.equals(cnic)) {
					 
					  System.out.println("Enter amount please");
						double amount=sc.nextDouble();	
						if(save[i].balance<amount) {
							System.out.println("You don't have enough balance");
						}
						if(save[i].numOftrans>=2&&save[i].balance>amount) {
					    	System.out.println("Your FREE transactions are Over. You are supposed to pay R.s 10 for this transaction\n"+"1- Deduct from this amount\n"+"2- Pay extra 10 R.s");
					    	int select=sc.nextInt();
					    	if(select==1) {
					    		amount=amount-10;
					    		System.out.println("Deducted!");
					    	}
					    	else if(select==2) {
					    		System.out.println("Ok!");
					    	}
					    	
					    	String wdate=java.time.LocalDateTime.now().getDayOfMonth()+"/"+java.time.LocalDateTime.now().getMonthValue()+"/"+java.time.LocalDateTime.now().getYear();
					    	String wtime=java.time.LocalDateTime.now().getHour()+":"+java.time.LocalDateTime.now().getMinute()+":"+java.time.LocalDateTime.now().getSecond();
					    	Account obja=new Account(save[i].getAcc_no(),amount,wdate,wtime);
					    	widtranforsave[i]=obja;
					    	numOftrans++;
					    	save[i].balance=save[i].balance-amount;
					    	Saving obj=new Saving(save[i].getAcc_no(),save[i].balance,save[i].opendate,save[i].opentime,save[i].withdrawdate,save[i].withdrawtime,save[i].depositdate,save[i].deposittime,save[i].depositamount,save[i].withdrawamount,numOftrans);
					    	save[i]=obj;
					    	if(save[i]!=null) {
						    	System.out.println("You Withdraw R.s "+amount);
						    System.out.println("Amount Withdrawn");
						    }
					    }
					    else if(save[i].balance>amount){
					    	numOftrans=save[i].numOftrans;
					    	numOftrans++;
					    	save[i].balance=save[i].balance-amount;
					    	String wdate=java.time.LocalDateTime.now().getDayOfMonth()+"/"+java.time.LocalDateTime.now().getMonthValue()+"/"+java.time.LocalDateTime.now().getYear();
                            String wtime=java.time.LocalDateTime.now().getHour()+":"+java.time.LocalDateTime.now().getMinute()+":"+java.time.LocalDateTime.now().getSecond();
					    	 Saving obj=new Saving(save[i].getAcc_no(),save[i].balance,save[i].opendate,save[i].opentime,wdate,wtime,save[i].depositdate,save[i].deposittime,save[i].depositamount,amount,numOftrans);
							    save[i]=obj;
							    if(save[i]!=null) {
							    	System.out.println("You Withdraw R.s "+amount);
							    System.out.println("Amount Withdrawn");
							    }
					    }
				  }
						find=false;
						break;
				  }
			  
			  if(find==true) {
				  System.out.println("Account with the given CNIC doesn't exist");
			  }
		    }
	  
	else {
		System.out.println("Invalid input");
	   }
	}
	
	
	void printStatement(int choice,String acc_no,String cnic,Customer []cs,Customer []cc,Saving []save,Checking[]check ,int countcheck,int countsave,Account []deptranforcheck,Account []deptranforsave,Account []widtranforcheck,Account []widtranforsave,Account []dedsavetransfer,Account []dedchecktransfer) {
        boolean find=true;
		
		if(choice==1) {
			String waste=sc.nextLine();
			
			    for(int i=0;i<countcheck;i++) {
					  if(cc[i].CNIC.equals(cnic)) {
						  System.out.println("Personal Details==>"); 
						  System.out.println("Name : "+cc[i].Name);
						  System.out.println("CNIC : "+cc[i].CNIC);
						  System.out.println("Gender : "+cc[i].sex);
						  System.out.println("Email : "+cc[i].email);
						  System.out.println("Adress : "+cc[i].address);
						  System.out.println("Contact # :"+cc[i].phoneNo);
						  System.out.println("Account Details==>");
						  System.out.println("Account number : "+check[i].getAcc_no());
						  
						  System.out.println("Date and time of opening : "+check[i].opendate+"  "+check[i].opentime);
						  System.out.println("Number of transactions : "+check[i].numOftrans);
						  if(check[i].depositdate!=null&&!check[i].depositdate.equals("null")) {
						  System.out.println("Deposit Date & Time: "+check[i].depositdate+"  "+check[i].deposittime);
						  System.out.println("Deposit amount : "+check[i].depositamount+"  (FREE)");}
						  if(check[i].numOftrans>=2) {
							  for(int j=0;j<30;j++) {
								  if(deptranforcheck[j]!=null&&check[i]!=null&&deptranforcheck[j].getAcc_no().equals(check[i].getAcc_no())&&!deptranforcheck[j].depositdate.equals("null")) {
								  System.out.println("Deposit Date & Time: "+deptranforcheck[j].depositdate+"  "+deptranforcheck[i].deposittime);
								  System.out.println("Deposit amount : "+deptranforcheck[j].depositamount+"  (PAID Rs. 10)");
							  }
								  }
						  }
						  if(check[i].withdrawdate!=null&&!check[i].withdrawdate.equals("null")) {
						  System.out.println("Withdraw Date &Time : "+check[i].withdrawdate+"  "+check[i].withdrawtime);
						  System.out.println("Withdraw amount : "+check[i].withdrawamount+"  (FREE)");}
						  if(check[i].numOftrans>=2) {
							  for(int j=0;j<30;j++) {
								  if(widtranforcheck[j]!=null&&check[i]!=null&&widtranforcheck[j].getAcc_no().equals(check[i].getAcc_no())&&!widtranforcheck[j].withdrawdate.equals("null")) {
								  System.out.println("Withdraw Date & Time: "+widtranforcheck[j].withdrawdate+"  "+widtranforcheck[j].withdrawtime);
								  System.out.println("Withdraw amount : "+widtranforcheck[j].withdrawamount+"  (PAID Rs. 10)");
							  }
								  }
						  }
						  if(dedchecktransfer[i]!=null&&!dedchecktransfer[i].getAcc_no().equals("null")) {
							  System.out.println("Money transfered to "+dedchecktransfer[i].getAcc_no());
							  System.out.println("Transfer date : "+dedchecktransfer[i].transferdate+" "+dedchecktransfer[i].transfertime);
						  }
						  System.out.println("Balance : "+check[i].balance);
						  System.out.println(" ");
							find=false;
							break;
					  }
				  }
				if(find==true) {
					System.out.println("Account number or CNIC is incorrect!");
				}
		}
		else if(choice==2) {
			String waste=sc.nextLine();
			 
			    for(int i=0;i<countsave;i++) {
					  if(cs[i].CNIC.equals(cnic)) {
						  System.out.println("Personal Details==>"); 
						  System.out.println("Name : "+cs[i].Name);
						  System.out.println("CNIC : "+cs[i].CNIC);
						  System.out.println("Gender : "+cs[i].sex);
						  System.out.println("Email : "+cs[i].email);
						  System.out.println("Adress : "+cs[i].address);
						  System.out.println("Contact # :"+cs[i].phoneNo);
						  System.out.println("Account Details==>");
						  System.out.println("Account number : "+save[i].getAcc_no());
						  System.out.println("Date and time of opening : "+save[i].opendate+"  "+save[i].opentime);
						  System.out.println("Number of transactions : "+save[i].numOftrans);
						  if(save[i].depositdate!=null&&!save[i].depositdate.equals("null")) {
						  System.out.println("Deposit Date & Time : "+save[i].depositdate+"  "+save[i].deposittime);
						  System.out.println("Deposit amount : "+save[i].depositamount+"  (FREE)");}
						  if(save[i].numOftrans>=2) {
							  for(int j=0;j<30;j++) {
								  if(deptranforsave[j]!=null&&save[i]!=null&&deptranforsave[j].getAcc_no().equals(save[i].getAcc_no())&&!deptranforsave[j].depositdate.equals("null")) {
								  System.out.println("Deposit date: "+deptranforsave[j].depositdate+"  "+deptranforsave[j].deposittime);
								  System.out.println("Deposit amount : "+deptranforsave[j].depositamount+"  (PAID Rs. 10)");
							  }
								  }
						  }
						  if(save[i].withdrawdate!=null&&!save[i].withdrawdate.equals("null")) {
						  System.out.println("Withdraw Date & Time: "+save[i].withdrawdate+"  "+save[i].withdrawtime);
						  System.out.println("Withdraw amount : "+save[i].withdrawamount+"  (FREE)");}
						  if(save[i].numOftrans>=2) {
							  for(int j=0;j<30;j++) {
								  if(widtranforsave[j]!=null&&save[i]!=null&&widtranforsave[j].getAcc_no().equals(save[i].getAcc_no())&&!widtranforsave[j].withdrawdate.equals("null")) {
								  System.out.println("Withdraw Date & Time: "+widtranforsave[j].withdrawdate+"  "+widtranforsave[j].withdrawtime);
								  System.out.println("Withdraw amount : "+widtranforsave[j].withdrawamount+"  (PAID Rs. 10)");
							  }
								  }
						  }
						  if(dedsavetransfer[i]!=null&&!dedsavetransfer[i].getAcc_no().equals("null")) {
							  System.out.println("Money transfered to "+dedsavetransfer[i].getAcc_no());
							  System.out.println("Transfer date : "+dedsavetransfer[i].transferdate+" "+dedsavetransfer[i].transfertime);
						  }
						  System.out.println("Balance : "+save[i].balance);
						  System.out.println(" ");
							find=false;
							break;
					  }
				  }
				if(find==true) {
					System.out.println("Account number or CNIC is incorrect!");
				}
			
		}
		
	}
	
	
	
	void transferAmount(int choice,String acc_no,String cnic,Customer []cs,Customer []cc,Saving []save,Checking[]check ,int countcheck,int countsave,Account []deptranforcheck,Account []deptranforsave,Account []widtranforcheck,Account []widtranforsave,Account []dedsavetransfer,Account []dedchecktransfer) {
		boolean find=false,test=false;
		if(choice==1) {
			for(int x=0;x<countcheck;x++) {
				if(check[x].getAcc_no().equals(acc_no)) {
					String waste=sc.nextLine();
					System.out.println("Enter account number to which you want to transfer.");
					String accnum=sc.nextLine();
					int loop=1;
					while(accnum.equals(acc_no)) {
						 
							System.out.println("You cannot transfer money to yourself!");
							System.out.println("Enter account number again");
							accnum=sc.nextLine();
						
					}
					for (int i=0;i<countcheck;i++) {
						if(check[i].getAcc_no().equals(accnum)) {
							test=true;
							System.out.println("Your balance is : Rs. "+check[x].balance);
							System.out.println("Enter amount to transfer.");
							double amount=sc.nextDouble();
							if(amount<check[x].balance) {
								System.out.println("Transfer Tax => Rs. 10 Deducted!");
								System.out.println("Amount transferred to "+check[i].getAcc_no());
								
								check[x].balance=check[x].balance-(amount+10);
								check[i].balance=check[i].balance+amount;
								String transdate=java.time.LocalDateTime.now().getDayOfMonth()+"/"+java.time.LocalDateTime.now().getMonthValue()+"/"+java.time.LocalDateTime.now().getYear();
						    	String transtime=java.time.LocalDateTime.now().getHour()+":"+java.time.LocalDateTime.now().getMinute()+":"+java.time.LocalDateTime.now().getSecond();

								Account obj=new Account(amount,accnum,transdate,transtime,10);
								dedchecktransfer[x]=obj;
							}
							else {
								System.out.println("Your balance is not enough!");
								System.out.println("Your balance is : Rs. "+check[x].balance);
							}
							break;
						}
					}
					if(test==false)
						for (int i=0;i<countsave;i++) {
						 if(save[i].getAcc_no().equals(accnum)) {
							test=true;
							System.out.println("Your balance is : Rs. "+check[x].balance);
							System.out.println("Enter amount to transfer.");
							double amount=sc.nextDouble();
							if(amount<check[x].balance) {
								System.out.println("Transfer Tax => Rs. 10 Deducted!");
								System.out.println("Amount transferred to "+save[i].getAcc_no());
								
								check[x].balance=check[x].balance-(amount+10);
								save[i].balance=save[i].balance+amount;
								String transdate=java.time.LocalDateTime.now().getDayOfMonth()+"/"+java.time.LocalDateTime.now().getMonthValue()+"/"+java.time.LocalDateTime.now().getYear();
						    	String transtime=java.time.LocalDateTime.now().getHour()+":"+java.time.LocalDateTime.now().getMinute()+":"+java.time.LocalDateTime.now().getSecond();

								Account obj=new Account(amount,accnum,transdate,transtime,10);
								dedchecktransfer[x]=obj;
								
							}
							else {
								System.out.println("Your balance is not enough!");
								System.out.println("Your balance is : Rs. "+check[x].balance);
							}
							break;
						}
						}
					if(test==false) {
						System.out.println("Account number to which you are transferring is incorrect");
					}
					find=true;
					break;
				}
			}
		
		if(find==false) {
			System.out.println("Your CNIC or account number might be incorrect!");
		}
	  }
		
		if(choice==2) {
			for(int x=0;x<countsave;x++) {
				if(save[x].getAcc_no().equals(acc_no)) {
					String waste=sc.nextLine();
					System.out.println("Enter account number to which you want to transfer.");
					String accnum=sc.nextLine();
					for (int i=0;i<countsave;i++) {
						if(save[i].getAcc_no().equals(accnum)) {
							test=true;
							System.out.println("Your balance is : Rs. "+save[x].balance);
							System.out.println("Enter amount to transfer.");
							double amount=sc.nextDouble();
							if(amount<save[x].balance) {
								
								save[x].balance=save[x].balance-(amount);
								save[i].balance=save[i].balance+amount;
								String transdate=java.time.LocalDateTime.now().getDayOfMonth()+"/"+java.time.LocalDateTime.now().getMonthValue()+"/"+java.time.LocalDateTime.now().getYear();
						    	String transtime=java.time.LocalDateTime.now().getHour()+":"+java.time.LocalDateTime.now().getMinute()+":"+java.time.LocalDateTime.now().getSecond();

								Account obj=new Account(amount,accnum,transdate,transtime,10);
								dedsavetransfer[x]=obj;
								System.out.println("Amount transferred");
							}
							else {
								System.out.println("Your balance is not enough!");
								System.out.println("Your balance is : Rs. "+save[x].balance);
							}
							break;
						}
						else if(check[i].getAcc_no().equals(accnum)) {
							test=true;
							System.out.println("Your balance is : Rs. "+save[x].balance);
							System.out.println("Enter amount to transfer.");
							double amount=sc.nextDouble();
							if(amount<save[x].balance) {
								
								save[x].balance=save[x].balance-(amount);
								check[i].balance=check[i].balance+amount;
								String transdate=java.time.LocalDateTime.now().getDayOfMonth()+"/"+java.time.LocalDateTime.now().getMonthValue()+"/"+java.time.LocalDateTime.now().getYear();
						    	String transtime=java.time.LocalDateTime.now().getHour()+":"+java.time.LocalDateTime.now().getMinute()+":"+java.time.LocalDateTime.now().getSecond();

								Account obj=new Account(amount,accnum,transdate,transtime,10);
								dedsavetransfer[x]=obj;
								System.out.println("Amount transferred");
							}
							else {
								System.out.println("Your balance is not enough!");
								System.out.println("Your balance is : Rs. "+save[x].balance);
							}
							break;
						}
					}
					if(test==false) {
						System.out.println("Account number to which you are transferring is incorrect");
					}
					find=true;
					break;
				}
			}
		
		if(find==false) {
			System.out.println("Your CNIC or account number might be incorrect!");
		}
	  }
		
		
	}

	
	
	
	void displayAllDeductions(int choice,String acc_no,String cnic,Customer []cs,Customer []cc,Saving []save,Checking[]check ,int countcheck,int countsave, Saving [] zakatdeduction,Account []dedsavetransfer,Account []dedchecktransfer) {
		boolean find=true;
		
		if(choice==1) {
			String waste=sc.nextLine();
			
			  for(int i=0;i<countcheck;i++) {
				  if(check[i].getAcc_no().equals(acc_no)&&cc[i].CNIC.equals(cnic)) {
					  System.out.println("Account holder : "+cc[i].Name);
					  System.out.println("Account number : "+check[i].getAcc_no());
					  System.out.println("CNIC : "+cc[i].CNIC);
					  if(dedchecktransfer[i]!=null) {
						  System.out.println("Transferred money to "+dedchecktransfer[i].getAcc_no());
					  System.out.println("Tax deducted on transfer money : Rs."+dedchecktransfer[i].transferTax+" on "+dedchecktransfer[i].transferdate+"  "+dedchecktransfer[i].transfertime);
					  }
					  else {
						  System.out.println("No tax has been deducted till now");
					  }
					  find=false;
					  break;
				  }
		      }
			  if(find==true) {
				  System.out.println("CNIC or Account# INCORRECT!!");
			  }
		}
		else if(choice==2) {
			String waste=sc.nextLine();
			System.out.println(zakatdeduction[0].Zakat);
			  for(int i=0;i<countsave;i++) {
				  if(save[i].getAcc_no().equals(acc_no)&&cs[i].CNIC.equals(cnic)) {
					  System.out.println("Account holder : "+cs[i].Name);
					  System.out.println("Account number : "+save[i].getAcc_no());
					  System.out.println("CNIC : "+cs[i].CNIC);
					if(zakatdeduction[i]!=null) {
					  System.out.println("ZAKAT deducted : Rs."+zakatdeduction[i].Zakat+" on "+zakatdeduction[i].zakatdate+"  "+zakatdeduction[i].zakattime);
				  }
					  else {
						  System.out.println("No tax has been deducted till now");
					  }
					  find=false;
					  break;
				  }
		      }
			  if(find==true) {
				  System.out.println("Something went Wrong!");
			  }
	  }
		
		else
		{System.out.println("WRONG Input!");}
	}
	
		
	
	
	
	void showdetails(Customer []cs,Customer []cc,Saving []save,Checking[]check ,int countcheck,int countsave,Account []deptranforcheck,Account []deptranforsave,Account []widtranforcheck,Account []widtranforsave,Account []dedsavetransfer,Account []dedchecktransfer) {
		 boolean find=true;
			System.out.println("Which Account?\n"+"1- Checking Account\n"+"2- Saving Account");
			int choice=sc.nextInt();
			while(choice<1 || choice>2) {
				  System.out.println("WRONG INPUT! Enter again");
				  choice=sc.nextInt();
			  }
			if(choice==1) {
				String waste=sc.nextLine();
				
				//System.out.println(cc[countcheck-1]);
				//System.out.println(check[countcheck-1]);
				    for(int i=0;i<countcheck;i++) {
						  if(cc[i]!=null&&check[i]!=null) {
							  System.out.println("Customer's Personal Details==>"); 
							  System.out.println("Name : "+cc[i].Name);
							  System.out.println("CNIC : "+cc[i].CNIC);
							  System.out.println("Gender : "+cc[i].sex);
							  System.out.println("Email : "+cc[i].email);
							  System.out.println("Adress : "+cc[i].address);
							  System.out.println("Contact # :"+cc[i].phoneNo);
							  System.out.println("Customer's Account Details==>");
							  System.out.println("Account number : "+check[i].getAcc_no());
							  System.out.println("Date and time of opening : "+check[i].opendate+"  "+check[i].opentime);
							  System.out.println("Number of transactions : "+check[i].numOftrans);
							  if(check[i].depositdate!=null) {
							  System.out.println("Deposit date and time : "+check[i].depositdate+"  "+check[i].deposittime);
							  System.out.println("Deposit amount : "+check[i].depositamount);}
							  if(check[i].numOftrans>=2) {
								  for(int j=0;j<30;j++) {
									  if(deptranforcheck[j]!=null&&check[i]!=null&&deptranforcheck[j].getAcc_no().equals(check[i].getAcc_no())) {
									  System.out.println("Deposit date and time : "+deptranforcheck[j].depositdate+"  "+check[i].deposittime);
									  System.out.println("Deposit amount : "+deptranforcheck[j].depositamount);
								  }
									  }
							  }
							  if(check[i].withdrawdate!=null) {
							  System.out.println("Withdraw date and time: "+check[i].withdrawdate+"  "+check[i].withdrawtime);
							  System.out.println("Withdraw amount : "+check[i].withdrawamount);}
							  if(check[i].numOftrans>=2) {
								  for(int j=0;j<30;j++) {
									  if(widtranforcheck[j]!=null&&check[i]!=null&&widtranforcheck[j].getAcc_no().equals(check[i].getAcc_no())) {
									  System.out.println("Withdraw date and time : "+widtranforcheck[j].withdrawdate+"  "+check[i].withdrawtime);
									  System.out.println("Withdraw amount : "+widtranforcheck[j].withdrawamount);
								  }
									  }
							  }
							  if(dedchecktransfer[i]!=null) {
								  System.out.println("Money transfered to "+dedchecktransfer[i].getAcc_no());
								  System.out.println("Transfer date : "+dedchecktransfer[i].transferdate+" "+dedchecktransfer[i].transfertime);
							  }
							  System.out.println("Balance : "+check[i].balance);
							  System.out.println(" ");
								find=false;
								
						  }
					  }
					
			}
			else if(choice==2) {
				String waste=sc.nextLine();
				 System.out.println(countsave);
				    for(int i=0;i<countsave;i++) {
						  if(cs[i]!=null&&save[i]!=null) {
							  System.out.println("Customer's Personal Details==>"); 
							  System.out.println("Name : "+cs[i].Name);
							  System.out.println("CNIC : "+cs[i].CNIC);
							  System.out.println("Gender : "+cs[i].sex);
							  System.out.println("Email : "+cs[i].email);
							  System.out.println("Adress : "+cs[i].address);
							  System.out.println("Contact # :"+cs[i].phoneNo);
							  System.out.println("Customer's Account Details==>");
							  System.out.println("Account number : "+save[i].getAcc_no());
							  System.out.println("Date and time of opening : "+save[i].opendate+"  "+save[i].opentime);
							  System.out.println("Number of transactions : "+save[i].numOftrans);
							  if(save[i].depositdate!=null) {
							  System.out.println("Deposit date and time : "+save[i].depositdate+"  "+save[i].deposittime);
							  System.out.println("Deposit amount : "+save[i].depositamount);}
							  if(save[i].numOftrans>=2) {
								  for(int j=0;j<30;j++) {
									  if(deptranforsave[j]!=null&&save[i]!=null&&deptranforsave[j].getAcc_no().equals(save[i].getAcc_no())) {
									  System.out.println("Deposit date and time : "+deptranforsave[j].depositdate+"  "+save[i].deposittime);
									  System.out.println("Deposit amount : "+deptranforsave[j].depositamount);
								  }
									  }
							  }
							  if(save[i].withdrawdate!=null) {
							  System.out.println("Withdraw date and time : "+save[i].withdrawdate+"  "+save[i].withdrawtime);
							  System.out.println("Withdraw amount : "+save[i].withdrawamount);}
							  if(save[i].numOftrans>=2) {
								  for(int j=0;j<30;j++) {
									  if(widtranforsave[j]!=null&&save[i]!=null&&widtranforsave[j].getAcc_no().equals(save[i].getAcc_no())) {
									  System.out.println("Withdraw dateand time : "+widtranforsave[j].withdrawdate+"  "+save[i].withdrawtime);
									  System.out.println("Withdraw amount : "+widtranforsave[j].withdrawamount);
								  }
									  }
							  }
							  if(dedsavetransfer[i]!=null) {
								  System.out.println("Money transfered to "+dedsavetransfer[i].getAcc_no());
								  System.out.println("Transfer date : "+dedsavetransfer[i].transferdate+" "+dedsavetransfer[i].transfertime);
							  }
							  System.out.println("Balance : "+save[i].balance);
							  System.out.println(" ");
								find=false;
								
						  }
					  }
					
				
			}
	}
}