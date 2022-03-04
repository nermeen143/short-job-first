package Project;
import java.util.Scanner;
public class SJF {
	public static void main(String args[]) {
		Scanner input=new Scanner(System.in);
		System.out.println("Welcome to Our SJF CPU Schedual Programming");
		System.out.println("-------------------------------------------");
		int x=0,k=0,y,p2;
		int total=0;
		System.out.print("Please, Enter number of process :  ");
		int num = input.nextInt();
		int l = 0;
		int wait[] =new int [num];
		int wait2[] =new int [num-1];	
		int brust[]=new int [num];
		int brust2[]=new int [num-1];
		while (l < num) {
			y = l+1;
			System.out.print("Enter process " + y +" Arrival time:");
			wait[l] = input.nextInt();
			System.out.print("Enter process "+y+" Burst time:");
			brust[l] = input.nextInt();
			l+=1;
		}
		
		for(int i=0;i<num;i++) {
			if(wait[i]==0)
				 x=brust[i];
		}
		for(int j=0;j<num;j++) {
			if(wait[j]<x && wait[j]!=0) {	
				brust2[k]=brust[j];	
				wait2[k]=wait[j];
				k++;
			}}
		for(int out=num-2;out>1;out--)
			for(int in=0;in<out;in++)
				if(brust2[in]>brust2[in+1]) {
					int temp =brust2[in];
					brust2[in]=brust2[in+1];
					brust2[in+1]=temp;
					int doub =wait2[in];
					wait2[in]=wait2[in+1];
					wait2[in+1]=doub;
					}

		p2=x-wait2[0];
		int time=0;
		for(int in=0;in<num-2;in++) {
			time+=brust2[in];
			total+=x+time-wait2[in+1];
		}
		
		float average;
		average=(p2+total)/num;
		System.out.println();
		System.out.println("Process		Arrival.T	Brust.T");
		for(int w=0;w<num;w++) {
			int s=w+1;
			System.out.println(s+"		"+wait[w]+"		"+brust[w]);}
		System.out.println("The Average Waiting Time  is "+average);



	}
}

