


public class Saving extends Account{

	protected double intrestrate=2,interest;
	protected String acc_no,intrestcolldate,intrestcolltime,acc_number,zakatdate,zakattime;
	
	Saving(String acc_no,double money,String odate,String otime,String wdate,String wtime,String depdate,String deptime,double damount,double wamount,int num){
		super(acc_no,money,odate,otime,wdate,wtime,depdate,deptime,damount,wamount,num);
	}
	Saving(double rate){
		intrestrate=rate;
	}
	Saving(String date,String time,String accnum,double Interest){
		intrestcolldate=date;
		intrestcolltime=time;
		acc_number=accnum;
		interest=Interest;
	}
	Saving(String accnum,double zakat,String zdate,String ztime){
		acc_no=accnum;
		Zakat=zakat;
		zakatdate=zdate;
		zakattime=ztime;
	}
	Saving(){
		
	}
	
	void rate(double rate) {
		
		System.out.println("This rate will applicable for all saving accounts\n"
				+ "Do you want to continue!\n"
				+ "1- Yes\n"
				+ "2- No");
		int yourChoice=sc.nextInt();
		while(yourChoice<1||yourChoice>2) {
			System.out.println("WRONG INPUT! Enter again.");
			yourChoice=sc.nextInt();
		}
		if(yourChoice==1) {
			intrestrate=rate;		
			System.out.println("Rate has been applied Successfuly!");
		}
		else if(yourChoice==2) {
			System.out.println("Ok! You showed disaggreement/didn't want to apply.");
		}
		
	}
	
	
	void open(Customer []cs,Saving []s,int count){
		boolean find=true;
		
		String waste=sc.nextLine();
	   	System.out.println("Please enter name who want to open an account.");
	   	String name =sc.nextLine();
	   	System.out.println("Enter contact #");
	    String ph_no=sc.nextLine();
	   	System.out.println("Enter CNIC");
	   	String cnic =sc.nextLine();
	   	for(int i=0;i<count;i++) {
		   	if(cs[i]!=null&&cs[i].CNIC.equals(cnic) ) {
		   		System.out.println("SORRY! You can't have multiple same account");
	        	find=false;
	   	         break;
		   	}}
	   	 if(find==true) {
	   		System.out.println("Enter e-mail");
		   	String mail =sc.nextLine();
		   	System.out.println("Enter address");
		   	String adres =sc.nextLine();
		   	System.out.println("Enter your sex");
		   	String sex =sc.nextLine();
		   	
		   	Customer objc=new Customer(name,mail,ph_no,cnic,adres,sex); 
		   	 cs [count]=objc;
		   	 if(cs[count]!=null) {
		   		System.out.println("Some STEPS away!");
		   	 }
		   	waste=sc.nextLine();
		   	String odate=java.time.LocalDateTime.now().getDayOfMonth()+"/"+java.time.LocalDateTime.now().getMonthValue()+"/"+java.time.LocalDateTime.now().getYear();  
	    	String otime=java.time.LocalDateTime.now().getHour()+":"+java.time.LocalDateTime.now().getMinute()+":"+java.time.LocalDateTime.now().getSecond();
			  System.out.println("Remember your account number. It helps a lot!");
			  String acc_no="#"+(count+2025)+"zw";
			  System.out.println("Account number: "+acc_no);
			  System.out.println("Keep some initial amount in account. It's empty");
			  double money=sc.nextDouble();
			  Saving obj=new Saving(acc_no,money,odate,otime,null,null,null,null,0.0,0.0,0);
			  s[count]=obj;
			  System.out.println("WELCOME! Account opened."); 
		   	 
	   	 }
	}
	
	void close(Customer []cs,Saving []save,int count) {
		int i;boolean find=true;
		String waste=sc.nextLine();
		System.out.println("Please enter account number.");		
	   	String acc_no =sc.nextLine();
	   	System.out.println("Enter CNIC");
	   	String cnic =sc.nextLine();	
	   	for(i=0;i<count;i++) {
	   	
		   	if(cs[i].CNIC.equals(cnic) && save[i].getAcc_no().equals(acc_no)) {
		   		
		   		System.out.println("Please submit your FEEDBACK!");
		   		System.out.println("Your overall experience is\n"+"1- Excellent\n"+"2- Good\n"+"3- Bad");
		   		int experience=sc.nextInt();
		   		System.out.println("Account CLOSED!");
		   		System.out.println("PLEASE collect your balance of Rs."+save[i].balance);
		   		cs[i]=null;
		   		save[i]=null;
		   		for(int j=i;j<count;j++) {
		   			cs[j]=cs[j+1];
		   			save[j]=save[j+1];
		   		}
		   		
		   		System.out.println("DONE!");
		   		find=false;
	   	         break;
		   	}}
	   	if(find==true) {
	   		System.out.println("SORRY!Your information might be Incorrect!");
	   		
	   	}
	   	
	}
	
	void display(int choice,String acc_No,String cnic,Customer []cs,Customer []cc,Saving []save,Checking[]check ,int countcheck,int countsave,Saving [] zakatdeduction,Account []dedsavetransfer,Account []dedchecktransfer) {
		Account obja=new Account();
		obja.displayAllDeductions(choice, acc_No, cnic, cs, cc, save, check, countcheck, countsave, zakatdeduction,dedsavetransfer,dedchecktransfer);
	}
	
	void calculateZakat(String account_no,Customer []cs,Saving []save,int countsave,Saving [] zakatdeduction) 
	
	{boolean find=false;
		String waste=sc.nextLine();
		
		for(int i=0;i<countsave;i++) {
		if(save[i].getAcc_no().equals(account_no)) {
			 {
				find=true;
		if(save[i].balance>=20000) {
			String zdate=java.time.LocalDateTime.now().getDayOfMonth()+"/"+java.time.LocalDateTime.now().getMonthValue()+"/"+java.time.LocalDateTime.now().getYear();
	    	String ztime=java.time.LocalDateTime.now().getHour()+":"+java.time.LocalDateTime.now().getMinute()+":"+java.time.LocalDateTime.now().getSecond();
	    	
			String dateToCompare=java.time.LocalDateTime.now().getDayOfMonth()+"/"+java.time.LocalDateTime.now().getMonthValue()+"/"+(java.time.LocalDateTime.now().getYear()-1);
	    	
			if(zakatdeduction[i]==null) {
				if(save[i].opendate.equals(dateToCompare)) {
					double zakat=(2.5*save[i].balance)/100;
					System.out.println("Your Zakat is approximately : "+zakat);
					save[i].balance=save[i].balance-zakat;
					Saving obj=new Saving(account_no,zakat, zdate,ztime);
					zakatdeduction[i]=obj;
					System.out.println("DONE!\n"+"Zakat has been paid.\n"+"Now your balance is Rs."+save[i].balance);
				}
				else {
					System.out.println("Zakat will be deducted right after one year since you opened this account.\n"
							+ "You opened your account on "+save[i].opendate);
				}
			}
			else {
				if(zakatdeduction[i].zakatdate.equals(dateToCompare)) {
					double zakat=(2.5*save[i].balance)/100;
					System.out.println("Your Zakat is approximately : "+zakat);
					save[i].balance=save[i].balance-zakat;
					Saving obj=new Saving(account_no,zakat, zdate,ztime);
					zakatdeduction[i]=obj;
					System.out.println("DONE!\n"+"Zakat has been paid.\n"+"Now your balance is Rs."+save[i].balance);
				}
				else {
					System.out.println("Zakat will be deducted right after one year since you paid last time.\n"
							+ "You paid your Zakat last year on "+zakatdeduction[i].zakatdate);
				}
			}

		}
		else 
			{System.out.println("Your balance is less than 20000.");}
		}
		
			}
		
	}
		if(find==false)
		{
			System.out.println("Invalid Account number!");
		}
  }	

	
	
	
		void calculatelnterest(int choice,String acc_num, Customer[] cs, Saving[] save, int countsave,Saving [] interestcollect) {
	
			String date=java.time.LocalDateTime.now().getDayOfMonth()+"/"+java.time.LocalDateTime.now().getMonthValue()+"/"+java.time.LocalDateTime.now().getYear();  
	    	String time=java.time.LocalDateTime.now().getHour()+":"+java.time.LocalDateTime.now().getMinute()+":"+java.time.LocalDateTime.now().getSecond();
	    	String dateToCompare=java.time.LocalDateTime.now().getDayOfMonth()+"/"+java.time.LocalDateTime.now().getMonthValue()+"/"+(java.time.LocalDateTime.now().getYear()-1);

	    	boolean find=false;
	    	for(int i=0;i<countsave;i++) {
	    		if(save[i].getAcc_no().equals(acc_num)) {
	    			//for customer
	    			if(choice==2) {
	    				if(interestcollect[i]==null) {
	    			if(save[i].opendate.equals(dateToCompare)) {
	    				System.out.println("Your balance is "+save[i].balance);
	    				double interest=(save[i].balance*1*intrestrate)/100;
	    				System.out.println("Your Interest is : "+interest);
	    				save[i].balance=save[i].balance+interest;
	    				System.out.println("Now your balance is "+save[i].balance);
	    				Saving obj=new Saving(date,time,acc_num,interest);
	    				interestcollect[i]=obj;
	    			}
	    			else {
	    				System.out.println("Interest will be given after a year.\n"
	    						+ "You opened this account on "+save[i].opendate);
	    			}
	              }
	    				else {
	    					if(interestcollect[i].intrestcolldate.equals(dateToCompare)) {
	    						System.out.println("Your balance is "+save[i].balance);
	    	    				double interest=(save[i].balance*1*intrestrate)/100;
	    	    				System.out.println("Your Interest is : "+interest);
	    	    				save[i].balance=save[i].balance+interest;
	    	    				System.out.println("Now your balance is "+save[i].balance);
	    	    				Saving obj=new Saving(date,time,acc_num,interest);
	    	    				interestcollect[i]=obj;
	    	    			}
	    	    			else {
	    	    				System.out.println("Interest will be given after a year.\n"
	    	    						+ "You collected your interest of previous year on "+interestcollect[i].intrestcolldate+"  "+interestcollect[i].intrestcolltime);
	    	    			}
	    					
	    				}
	    				
	    			}
	    			
	    			
	    			
	    			
	    			
	    			//for admin
	    			else if(choice==1) {
	    				
	    				if(interestcollect[i]==null) {
	    				if(save[i].opendate.equals(dateToCompare)) {
	    					double interest=(save[i].balance*1*intrestrate)/100;
	    					System.out.println("Balance is  : "+save[i].balance);
	    					System.out.println("Interest is : "+interest);
	    					System.out.println("Customer wants this interest\n"
	    							+ "1- YES\n"
	    							+ "2- NO");
	    					int input=sc.nextInt();
	    					if(input==1) {
	    						 
	    			    			 {
	    			    				save[i].balance=save[i].balance+interest;
	    	    						Saving obj=new Saving(date,time,acc_num,interest);	
	    	    						interestcollect[i]=obj;
	    	    						System.out.println("DONE!");
	    	    	    				System.out.println("Now balance is incresed to "+save[i].balance);
	    			    			}
	    					}
	    					else if(input==2) {
	    						System.out.println("OK!");
	    					}
	    				}
	    				else {
	    					System.out.println("Customer opened this account on "+save[i].opendate);
	    					System.out.println("According to policy, Interest will be given after one year.");
	    				}
	    				
	    				}
	    						else {
	    							if(interestcollect[i].intrestcolldate.equals(dateToCompare)) {
	    								double interest=(save[i].balance*1*intrestrate)/100;
	    								save[i].balance=save[i].balance+interest;
	    	    						Saving obj=new Saving(date,time,acc_num,interest);	
	    	    						interestcollect[i]=obj;
	    	    						System.out.println("DONE!");
	    	    	    				System.out.println("Now balance is incresed to "+save[i].balance);	
	    							}
	    						
	    				else {
    	    				System.out.println("Interest will be given after a year.\n"
    	    						+ "You collected your interest of previous year on "+interestcollect[i].intrestcolldate+"  "+interestcollect[i].intrestcolltime);
    	    			}
	    						}
	    					}
	    			
	    			
	    			find=true;
	    			break;
	    		}
	    	}
	    	if(find==false) {
	    		System.out.println("Invalid Account Number!");
	    	}
		}
	
		void checkforinterest(String acc_num, Customer[] cs, Saving[] save, int countsave, Saving [] interestcollect) {
			boolean find=false;
	    	for(int i=0;i<countsave;i++) {
	    		if(save[i].getAcc_no().equals(acc_num)&&interestcollect[i]!=null) {
	    			System.out.println("Name : "+ cs[i].Name);
		         System.out.println("Account # : "+save[i].getAcc_no());
		         System.out.println("Interest collected : "+interestcollect[i].interest+" on "+interestcollect[i].intrestcolldate);
		        
	    			find=true;
	    			break;
	    		}
	    	}
	    	if(find==false) {
	    		System.out.println("INVALID ACCOUNT# !");
	    	}
	}
}

