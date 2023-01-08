package Test2;


public class Test45_rectangular {
	
	public static void main(String[] args){
			
		System.out.println((long)solution(3,3));
	}
	
	public static long solution(int w, int h) {
        long answer = 1;
        long sum = (long)w * h;
        double x = (double)w/h;
        double a = (double)h/w;
        long count =0;        
        for(int i=0;i<w;i++){
        	for(int t=0;t<h;t++){
        		double temp = t*w/h;
        		double temp2 =(double)(t+1)*w/(long)h;
        		double tempY = (double)i*(long)h/(long)w;
        		double tempY2 = (double)(i+1)*(long)h/(long)w;        		
            	if((temp<(double)(i+1) && temp >= i) 
            		|| (temp2<(double)(i+1) && temp2 > i) 
            		|| (tempY<(double)(t+1) && tempY>=t) 
            		|| (tempY2<(double)(t+1) && tempY2>t)){
            		count = (long)count+1; 
            	} 
        	}
        	
        }
        
        return sum - (long)(count);
    }
}
