
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class Bank {

	Formatter fwcheck;
	Formatter fwsave;
	Scanner readcheck;
	Scanner readsave;
	
	public void writeCheckingFile(int countcheck,Customer [] cforcheck,Checking [] checkarr,Account [] dforcheck,Account [] wforcheck,Account [] dchecktrans,File file) {
		try {
		  fwcheck=new Formatter(file);
		}
		catch(Exception e) {
			System.out.println("No file with this name!");
		}
		for(int i=0;i<countcheck;i++) {
			if(cforcheck!=null) {
				if(dforcheck[i]==null) {
					Account obja=new Account(null,null,null,0.0);
			    	dforcheck[i]=obja;	
				}
				if(wforcheck[i]==null) {
					Account obja=new Account(null,null,null,0.0);
			    	wforcheck[i]=obja;	
				}
				if(dchecktrans[i]==null) {
					Account obj=new Account(0,null,null,null,0);
					dchecktrans[i]=obj;
				}
				
				  fwcheck.format("%s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %d \n",

						cforcheck[i].Name,cforcheck[i].CNIC,cforcheck[i].address,cforcheck[i].email,cforcheck[i].phoneNo,cforcheck[i].sex,
						checkarr[i].getAcc_no(),checkarr[i].opendate,checkarr[i].opentime,checkarr[i].balance,checkarr[i].depositamount,
						checkarr[i].depositdate,checkarr[i].deposittime,checkarr[i].withdrawamount,checkarr[i].withdrawdate,checkarr[i].withdrawtime,
						dforcheck[i].depositamount,dforcheck[i].depositdate,dforcheck[i].deposittime,
						wforcheck[i].withdrawamount,wforcheck[i].withdrawdate,wforcheck[i].withdrawtime,
						dchecktrans[i].transferamount,dchecktrans[i].transferdate,dchecktrans[i].transfertime,dchecktrans[i].transferTax,dchecktrans[i].getAcc_no(),checkarr[i].numOftrans);
			
			}
		}
		fwcheck.close();
		
		}
	
	public void writeSavingFile(int countsave,Customer [] cforsave,Saving[] savearr,Account [] dforsave,Account [] wforsave,Account [] dsavetrans,File file1, Saving [] interestcoll, Saving [] zakatded) {
		try {
		  fwsave=new Formatter(file1);
		}
		catch(Exception e) {
			System.out.println("No file with this name!");
		}
		for(int i=0;i<countsave;i++) {
			if(cforsave!=null) {
				if(dforsave[i]==null) {
					Account obja=new Account(null,null,null,0.0);
					dforsave[i]=obja;	
				}
				if(wforsave[i]==null) {
					Account obja=new Account(null,null,null,0.0);
					wforsave[i]=obja;	
				}
				if(dsavetrans[i]==null) {
					Account obj=new Account(0,null,null,null,0);
					dsavetrans[i]=obj;
					
				}
				if(interestcoll[i]==null) {
					Saving objs=new Saving(null,null,null,0.0);	
					interestcoll[i]=objs;	
					
				}
                if(zakatded[i]==null) {
                	Saving objs=new Saving(null,0.0, null,null);
					zakatded[i]=objs;
				}

				  fwsave.format("%s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %d %s %s %s %s %s %s \n",
				//fwcheck.format("%s %s %s %s %s %s %s %s %s %d %d %s %s %d %s %s %d %s %s %d %s %s %d %s %s %d %s %d",	
				cforsave[i].Name,cforsave[i].CNIC,cforsave[i].address,cforsave[i].email,cforsave[i].phoneNo,cforsave[i].sex,
						savearr[i].getAcc_no(),savearr[i].opendate,savearr[i].opentime,savearr[i].balance,savearr[i].depositamount,
						savearr[i].depositdate,savearr[i].deposittime,savearr[i].withdrawamount,savearr[i].withdrawdate,savearr[i].withdrawtime,
						dforsave[i].depositamount,dforsave[i].depositdate,dforsave[i].deposittime,
						wforsave[i].withdrawamount,wforsave[i].withdrawdate,wforsave[i].withdrawtime,
						dsavetrans[i].transferamount,dsavetrans[i].transferdate,dsavetrans[i].transfertime,dsavetrans[i].transferTax,dsavetrans[i].getAcc_no(),savearr[i].numOftrans,
				        interestcoll[i].interest,interestcoll[i].intrestcolldate, interestcoll[i].intrestcolltime,
				        zakatded[i].Zakat,zakatded[i].zakatdate,zakatded[i].zakattime);
			}
		}
		fwsave.close();
		
		}
	
	
	
	
	
	public int readcheckingfile(int countcheck,Customer [] cforcheck,Checking [] checkarr, Account [] dforcheck, Account [] wforcheck, Account [] dchecktrans) {
		
		try {
			readcheck=new Scanner(new File("C:\\Users\\Taha Asif\\Documents\\_Assignments-2nd semester\\Oop\\file handling AMS\\src\\checkingaccountdetails.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in reading file, no such file : checkingAccountDetails");
			e.printStackTrace();
		}
		
		while(readcheck.hasNext()) {
		
		String a=readcheck.next(); String b=readcheck.next();String c=readcheck.next(); String d=readcheck.next();	String e=readcheck.next();
		String f=readcheck.next(); String g=readcheck.next(); String h=readcheck.next(); String i=readcheck.next();
 		String j=readcheck.next(); double Balance=Double.parseDouble(j);
		String k=readcheck.next(); double damount=Double.parseDouble(k);
		String l=readcheck.next(); String m=readcheck.next();
		String n=readcheck.next(); double wamount=Double.parseDouble(n);
		String o=readcheck.next(); String p=readcheck.next();
		String q=readcheck.next(); double damount1=Double.parseDouble(q);
		String r=readcheck.next(); String s=readcheck.next();
		String t=readcheck.next(); double wamount1=Double.parseDouble(t);
		String u=readcheck.next(); String v=readcheck.next();
		String w=readcheck.next(); double tamount=Double.parseDouble(w);
		String x=readcheck.next(); String y=readcheck.next();
		int tTax=Integer.parseInt(readcheck.next()); 
		String z=readcheck.next();  
		int nOftran=Integer.parseInt(readcheck.next()); 
		
		
	// Assigning the read values from file
			Customer objc=new Customer(a,d,e,b,c,f); 
	   	cforcheck [countcheck]=objc;
	   	Checking obj=new Checking(g,Balance,h,i,o,p,l,m,damount,wamount,nOftran);
	 checkarr[countcheck]=obj;
	 Account obja=new Account(g,r,s,damount1);
 	dforcheck[countcheck]=obja;
 	Account obja1=new Account(g,wamount1,u,v);
	wforcheck[countcheck]=obja1;
	Account obja2=new Account(tamount,z,x,y,tTax);
	dchecktrans[countcheck]=obja2;
	 	
		 countcheck++;
		}
		readcheck.close();
		return countcheck;
	}
	
	
public int readsavingfile(int countsave,Customer [] cforsave, Saving [] savearr, Account [] dforsave, Account [] wforsave, Account [] dsavetrans, Saving [] interestcollect, Saving [] zakatdeduction) {
		
		try {
			readsave=new Scanner(new File("C:\\Users\\Taha Asif\\Documents\\_Assignments-2nd semester\\Oop\\file handling AMS\\src\\savingaccountdetails.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in reading file, no such file : savingAccountDetails");
			e.printStackTrace();
		}
		
		while(readsave.hasNext()) {
		
		String a=readsave.next(); String b=readsave.next(); String c=readsave.next(); String d=readsave.next();	String e=readsave.next();
		String f=readsave.next(); String g=readsave.next(); String h=readsave.next(); String i=readsave.next();
 		String j=readsave.next(); double Balance=Double.parseDouble(j);
		String k=readsave.next(); double damount=Double.parseDouble(k);
		String l=readsave.next(); String m=readsave.next();
		String n=readsave.next(); double wamount=Double.parseDouble(n);
		String o=readsave.next(); String p=readsave.next();
		String q=readsave.next(); double damount1=Double.parseDouble(q);
		String r=readsave.next(); String s=readsave.next();
		String t=readsave.next(); double wamount1=Double.parseDouble(t);
		String u=readsave.next(); String v=readsave.next();
		String w=readsave.next(); double tamount=Double.parseDouble(w);
		String x=readsave.next(); String y=readsave.next();
		int tTax=Integer.parseInt(readsave.next()); 
		String z=readsave.next();  
		int nOftran=Integer.parseInt(readsave.next()); 
		double iamount=Double.parseDouble(readsave.next()); String idate=readsave.next(); String itime=readsave.next();
		double zamount=Double.parseDouble(readsave.next()); String zdate=readsave.next(); String ztime=readsave.next();
		
	// Assigning the read values from file
			Customer objc=new Customer(a,d,e,b,c,f); 
	   	cforsave [countsave]=objc;
	   	Saving objs=new Saving(g,Balance,h,i,o,p,l,m,damount,wamount,nOftran);
	 savearr[countsave]=objs;
	 Account obja=new Account(g,r,s,damount1);
 	dforsave[countsave]=obja;
 	Account obja1=new Account(g,wamount1,u,v);
	wforsave[countsave]=obja1;
	Account obja2=new Account(tamount,z,x,y,tTax);
	dsavetrans[countsave]=obja2;
	Saving objs1=new Saving(idate,itime,g,iamount);	
	interestcollect[countsave]=objs1;
	Saving objs2=new Saving(g,zamount, zdate,ztime);
	zakatdeduction[countsave]=objs2;
	
	      countsave++;
		}
		readsave.close();
		return countsave;
	}
	
	
	
	
	
    public static void main(String[] args) {
    	Saving []nul=new Saving[1];
		// TODO Auto-generated method stub
    	
int index=1,countcheckcustomer=0,countsavecustomer=0;

Customer [] cforcheck = new Customer[30];	
Customer [] cforsave = new Customer[30];	

Checking [] checkarr=new Checking[30];

Saving [] savearr= new Saving[30];
Saving [] interestcollect=new Saving[30];
Saving [] zakatdeduction=new Saving [30];

Account []deptranforcheck=new Account[30];
Account []widtranforcheck=new Account[30];
Account []deptranforsave=new Account[30];
Account []widtranforsave=new Account[30];
Account []dedsavetransfer=new Account [30];
Account []dedchecktransfer=new Account [30];

Account objaccount=new Account();
Checking objcheck=new Checking();
Saving objsave=new Saving();
Bank objB=new Bank();

//creating file
File file=null;
File file1=null;
try {
	file=new File("C:\\Users\\Taha Asif\\Documents\\_Assignments-2nd semester\\Oop\\file handling AMS\\src\\checkingaccountdetails.txt");
	file1=new File("C:\\Users\\Taha Asif\\Documents\\_Assignments-2nd semester\\Oop\\file handling AMS\\src\\savingaccountdetails.txt");
	if(file.createNewFile()&&file1.createNewFile()) {
		System.out.println("Everything is Ok!");
	}
} catch (IOException e) {
	System.out.println("File not created1!");
	// TODO Auto-generated catch block
	e.printStackTrace();
}

//read file to collect previous record

if(file.length()!=0) {
	
	countcheckcustomer=objB.readcheckingfile(countcheckcustomer, cforcheck, checkarr, deptranforcheck, widtranforcheck, dedchecktransfer);	
}
if(file1.length()!=0) {
	countsavecustomer=objB.readsavingfile(countsavecustomer, cforsave, savearr, deptranforsave, widtranforsave, dedsavetransfer,interestcollect, zakatdeduction);
}

Scanner sc=new Scanner(System.in);		
  while(index==1) {
		
		 System.out.println("1- Open a New Account\n" + "2- Close an account\r\n"
				+ "3- Login to a specific account by providing the unique account number\r\n"
				+ "4- Perform account operations \r\n"
				+ "5- Specify the Interest Rate, applicable to all Saving Accounts\r\n"
				+ "6- Calculate Interest of specific Saving Account \n"
				+ "7- Deduct Zakat from a specific Saving Account\r\n"
				+ "8- Display all account details, including the bank owner details\r\n"
				+ "9- Display all accounts deductions along with account details\n"
				+ "10- Exit");
		 
		int choice=sc.nextInt();
		while(choice<1||choice>10) {
			System.out.println("Wrong input! Please Enter again");
			choice=sc.nextInt();
			}
		switch(choice) {
		case 1:{
		  System.out.println("Which account you want to open");
		  System.out.println("1- Checking account \n"+"2- Saving account");
		  int select=sc.nextInt();
		  while(select<1 || select>2) {
			  System.out.println("WRONG INPUT! Enter again");
			  select=sc.nextInt();
		  }
		  if(select==1) {
			  objcheck.open(cforcheck,checkarr,countcheckcustomer);
			  
			 if(cforcheck[countcheckcustomer]!=null&&checkarr[countcheckcustomer]!=null)
				 countcheckcustomer++;
			  
		  }
		  if(select==2) {
			  objsave.open(cforsave,savearr,countsavecustomer);
			  if(cforsave[countsavecustomer]!=null&&savearr[countsavecustomer]!=null)
			  countsavecustomer++;
			 
		  }
		  
		  
		}break;
		case 2:{
			System.out.println("Which account\n"+"1- Checking account\n"+"2- Saving account");
			int select=sc.nextInt();
			while(select<1 || select>2) {
				  System.out.println("WRONG INPUT! Enter again");
				  select=sc.nextInt();
			  }
			if(select==1) {
			objcheck.close(cforcheck, checkarr, countcheckcustomer);
			countcheckcustomer--;}
			if(select==2) {
				objsave.close(cforsave, savearr, countsavecustomer);
				countsavecustomer--;
			}
			
		}break;
		case 3:{
			
		}
		case 4:{
			int loop=1;boolean check=false;
			System.out.println("Which Account!\n"+"1- Checking account\n"+"2- Saving Account!");
			int input=sc.nextInt();
			while(input<1||input>2) {
				System.out.println("Wrong Input! Enter again");
				input=sc.nextInt();
			}
			String waste=sc.nextLine();	
		System.out.println("Enter Account number");	
		String acc_num=sc.nextLine();
		System.out.println("Enter CNIC");
		String nic=sc.nextLine();
		do {
		if(input==1) {
			
		 for(int i=0;i<countcheckcustomer;i++) {
			  if(checkarr[i].getAcc_no().equals(acc_num)&&cforcheck[i].CNIC.equals(nic)) {
				  check=true;
				  break;
			  }
		 }
		 }
		else if(input==2) {
			 for(int i=0;i<countsavecustomer;i++) {
				  if(savearr[i].getAcc_no().equals(acc_num)&&cforsave[i].CNIC.equals(nic)) {
					  check=true;
					  break;
				  }
			 }
			 }
		if(check==false) {
			System.out.println("CNIC or Account # Incorrect! Enter again");
			System.out.println("Enter Account number");	
			 acc_num=sc.nextLine();
			System.out.println("Enter CNIC");
			 nic=sc.nextLine();
		}
		}while(check==false);
		
		while(loop==1) {
			System.out.println("1- Check Balance\n"+"2- Deposit Money\n"+"3- Withdraw Money\n"+"4- Print Statement\n"+"5- Transfer money\n"+"6- Display deductions\n"+"7- Take Interest (Only for saving)\n"+"8- Check when you collect your Interest\n"+"9- Go back");
		int select=sc.nextInt();
		while(select<1||select>9) {
			System.out.println("Wrong Input! Enter again");
			select=sc.nextInt();
		}
		
if(select==1) {
	objaccount.checkBalance(input,acc_num,nic,cforsave, cforcheck, savearr, checkarr, countcheckcustomer,countsavecustomer);	
		}
if(select==2) {
		objaccount.makeDeposit(input,acc_num,nic,cforsave, cforcheck, savearr, checkarr, countcheckcustomer,countsavecustomer,deptranforcheck,deptranforsave,widtranforcheck,widtranforsave);
		
		}
if(select==3) {
	 objaccount.makeWithdrawal(input,acc_num,nic,cforsave, cforcheck, savearr, checkarr, countcheckcustomer,countsavecustomer,deptranforcheck,deptranforsave,widtranforcheck,widtranforsave);
}
if(select==4) {
	objaccount.printStatement(input,acc_num,nic,cforsave, cforcheck, savearr, checkarr, countcheckcustomer,countsavecustomer,deptranforcheck,deptranforsave,widtranforcheck,widtranforsave,dedsavetransfer,dedchecktransfer);	
}
if(select==5) {
	objaccount.transferAmount(input, acc_num, nic, cforsave, cforcheck, savearr, checkarr, countcheckcustomer, countsavecustomer, deptranforcheck, deptranforsave, widtranforcheck, widtranforsave,dedsavetransfer,dedchecktransfer);
}
if(select==6) {
	if(input==1) {
		objaccount.displayAllDeductions(input, acc_num, nic, cforsave, cforcheck, savearr, checkarr, countcheckcustomer, countsavecustomer, nul,dedsavetransfer,dedchecktransfer);
	}
	else if(input==2)
	objsave.display(input,acc_num,nic,cforsave, cforcheck, savearr, checkarr, countcheckcustomer,countsavecustomer,zakatdeduction,dedsavetransfer,dedchecktransfer);
}
if(select==7) {
	if(input==2)
	objsave.calculatelnterest(2,acc_num,cforsave, savearr, countsavecustomer,interestcollect);
	else {
		System.out.println("Interest is for only Saving accounts.");
	}
}
if(select==8) {
	if(input==2)
	objsave.checkforinterest(acc_num, cforsave, savearr, countsavecustomer,interestcollect);
	else {
		System.out.println("Interest is for only Saving accounts.");
	}
}
if(select==9) {
	System.out.println("Are you sure!\n"
			+ "1- Yes\n"
			+ "0- No\n");
	int logout=sc.nextInt();
	if(logout==1) {
	loop=0;}
}
	}
		}break;
		case 5:{
			
			System.out.println("Enter rate ( in % ) you want to specify for Saving accounts.");
			double rate=sc.nextDouble();
			Saving objs=new Saving(rate);
			objsave.rate(rate);
			
		}break;
		case 6:{
			String waste=sc.nextLine();
			System.out.println("Enter account #");
			String acc_num=sc.nextLine();
			objsave.calculatelnterest(1,acc_num,cforsave, savearr, countsavecustomer,interestcollect);
			
		}break;
		case 7:{
			String waste=sc.nextLine();
			System.out.println("Enter account #");
			String acc_num=sc.nextLine();
			
			objsave.calculateZakat(acc_num,cforsave, savearr, countsavecustomer,zakatdeduction);
		}break;
		case 8:{
			Bankowner objb=new Bankowner();
			objb.ownerdetails();
			objaccount.showdetails(cforsave, cforcheck, savearr, checkarr, countcheckcustomer,countsavecustomer, deptranforcheck, deptranforsave, widtranforcheck, widtranforsave,dedsavetransfer,dedchecktransfer);
		}break;
		case 9:{
			System.out.println("Which Account!\n"+"1- Checking account\n"+"2- Saving Account!");
			int input=sc.nextInt();
			while(input<1||input>2) {
				System.out.println("Wrong Input! Enter again");
				input=sc.nextInt();
			}
			String waste=sc.nextLine();	
		System.out.println("Enter Account number");	
		String acc_num=sc.nextLine();
		System.out.println("Enter CNIC");
		String nic=sc.nextLine();
		if(input==1) {
			objaccount.displayAllDeductions(input, acc_num, nic, cforsave, cforcheck, savearr, checkarr, countcheckcustomer, countsavecustomer, nul,dedsavetransfer,dedchecktransfer);
		}
		if(input==2)
		objsave.display(input, acc_num, nic, cforsave, cforcheck, savearr, checkarr, countcheckcustomer, countsavecustomer,zakatdeduction,dedsavetransfer,dedchecktransfer);
		}break;
		case 10:{
			objB.writeCheckingFile(countcheckcustomer, cforcheck, checkarr, deptranforcheck, widtranforcheck, dedchecktransfer, file);
			objB.writeSavingFile(countsavecustomer, cforsave, savearr, deptranforsave, widtranforsave, dedsavetransfer, file1, interestcollect, zakatdeduction);
			index=0;
		}
	   }
  }
}
}
