package Test2;

import java.util.Scanner;

public class test01 {

	public static void main(String[] args) {
		
		/*Scanner in = new Scanner(System.in);
		
		int m = in.nextInt();
		int n = in.nextInt();*/
		
		/*test(m,n);*/
		test(3,4);
	}
	
	public static void test(int m, int n) {
		int mul = m*n;
		int t=0, y = 0, dirct=0;
		int[][] arry = new int[3][4];
		for(int i=0; i<mul; i++){			
			arry[t][y]=i+1;			
			/*if(y==n-1){
				dirct=1;
				
			}
			if(t==m-1){
				dirct=2;
			}
			if(t==m-1&& y==0) {
				dirct=3;
			}	*/	
			if(dirct==0) {
				y++;
				if(y==n){
					dirct++;
					y--;
				} else if(arry[t][y]!=0){
					dirct++;
					y--;
					t++;
				}	
				
			}else if(dirct==1){
				t++;
				if(arry[t][y]!=0) {
					dirct++;
					t--;
					y--;
				}else if(t==m){
					dirct++;
					t--;
					y--;
				} 
			}else if(dirct==2){
				y--;
				if(arry[t][y]!=0){
					dirct++;				
					y++;
					t--;
				}
				else  if(y==0){
					dirct++;					
				}
			}else if(dirct==3) {				
				t--;
				if(t==0){
					dirct=0;
					t++;
					y++;
				} else if(arry[t][y]!=0){					
					dirct=0;
					t++;
					y++;
				}	
			}
		}
		for(int i=0;i<m;i++){
			for(int e=0; e<n; e++){
				System.out.print(arry[i][e]+"\t");
			}
			System.out.println();
		}
		
	}

}
