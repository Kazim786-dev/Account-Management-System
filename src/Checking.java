
import java.util.Scanner;

public class Checking extends Account{
	
	
	Checking(String acc_no,double money,String odate,String otime,String wdate,String wtime,String depdate,String deptime,double damount,double wamount,int num){
		super(acc_no,money,odate,otime,wdate,wtime,depdate,deptime,damount,wamount,num);
	}
	Checking(){
		
	}
	Scanner sc=new Scanner(System.in);	
	
	void open(Customer []cc,Checking []check,int count){
		boolean find=true;
		String waste=sc.nextLine();
	   	System.out.println("Please enter name who want to open an account.");
	   	String name =sc.nextLine();
	   	System.out.println("Enter contact #");
	    String ph_no=sc.nextLine();
	   	System.out.println("Enter CNIC");
	   	String cnic =sc.nextLine();
	   	for(int i=0;i<count;i++) {
	   		
		   	if(cc[i]!=null&&cc[i].CNIC.equals(cnic)) {
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
		   	 cc [count]=objc;
		   	 if(cc[count]!=null) {
		   		 System.out.println("Some STEPS away!");
		   	 }
		   	waste=sc.nextLine();
		   	String odate=java.time.LocalDateTime.now().getDayOfMonth()+"/"+java.time.LocalDateTime.now().getMonthValue()+"/"+java.time.LocalDateTime.now().getYear();  
	    	String otime=java.time.LocalDateTime.now().getHour()+":"+java.time.LocalDateTime.now().getMinute()+":"+java.time.LocalDateTime.now().getSecond();
			  System.out.println("Remember your account number. It helps a lot!");
			  String acc_no="#"+(count+2020)+"f";
			  System.out.println("Account number: "+acc_no);
			  System.out.println("Keep some initial amount in account. It's empty");
			  double money=sc.nextDouble();
			  Checking obj=new Checking(acc_no,money,odate,otime,null,null,null,null,0.0,0.0,0);
			  check[count]=obj;   
		   	 System.out.println("WELCOME! Account opened.");
	   	 }
	   		
	}
	
void close(Customer []cc,Checking []check,int count) {
	int i;boolean find=true;
	String waste=sc.nextLine();
	System.out.println("Please enter account number.");
   	String acc_no =sc.nextLine();
   	System.out.println("Enter CNIC");
   	String cnic =sc.nextLine();	
   	for(i=0;i<count;i++) {
   	
	   	if(cc[i].CNIC.equals(cnic) && check[i].getAcc_no().equals(acc_no)) {
	   		
	   		System.out.println("Your overall experience is\n"+"1- Excellent\n"+"2- Good\n"+"3- Bad");
	   		int experience=sc.nextInt();
	   		System.out.println("Account CLOSED!");
	   		System.out.println("PLEASE collect your balance of Rs."+check[i].balance);
	   		cc[i]=null;
	   		check[i]=null;
	   		for(int j=i;j<count;j++) {
	   			if(cc[j+1]!=null&&check[j+1]!=null) {
	   			cc[j]=cc[j+1];
	   			check[j]=check[j+1];
	   			}
	   			
	   		
	   		}
	   		
	   		System.out.println("DONE!");
	   		find=false;
   	         break;
	   	}}
   	if(find==true) {
   		System.out.println("SORRY!Your information might be incorrect.");
   		
   	}

}


	
}