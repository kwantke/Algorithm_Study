package Test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Test41_renewerMenu {
	
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	public static void main(String[] args) {
		
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		String[] orders3 = {"XYZ", "XWY", "WXA"};
		
		int [] course = {2,3,4};
		int [] course2 = {2,3,5};
		int [] course3 = {2,3,4};
		//String[][] sol = new String[3][24];
		//solution(orders, course );
		//solution(orders2, course2);
		//solution(orders3, course3);
		//System.out.println(so.toString());
		StringBuffer sb = new StringBuffer();
		combil("ABC",sb,0,0,3);
		
		
	}
	static String[] solution(String[] orders, int[] course) {
        
		String[] answer = {};
		ArrayList al = new ArrayList();
		for(int i=0;i<orders.length;i++){
			char[] arr = orders[i].toCharArray();
			Arrays.sort(arr);
			orders[i] = String.valueOf(arr); 
		}
		
		for(int i=0;i<course.length;i++){
			for(int t=0;t<orders.length;t++){
				StringBuffer sb = new StringBuffer();
				if(course[i] <= orders[t].length()){
					String str = orders[t];
					combil(str,sb,0,0,course[i]);
				}
			}
			
			int max = 0;
			
			for(Map.Entry<String,Integer> menu : map.entrySet()){
				if(menu.getValue()>1){
					max = Math.max(max, menu.getValue());
				}
				
			}
			for(Map.Entry<String, Integer> menu : map.entrySet()){
				if(max == menu.getValue()){
					al.add(menu.getKey());
				}
			}
			map.clear();
		}
		Collections.sort(al);
		answer = new String[al.size()];
		for(int d=0;d<al.size();d++){
			answer[d] = (String) al.get(d);
		}
		for(int i=0;i<answer.length;i++){
			System.out.print(answer[i] +" ");
		}
		System.out.println();
        return answer;
    }
	
	static void combil(String str, StringBuffer sb, int idx, int cnt, int n){
		
		if(cnt == n) {
			//map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
			return;
		}
		
		for(int i=idx;i<str.length();i++){
			sb.append(str.charAt(i));
			System.out.println(sb.toString());
			combil(str, sb, i+1, cnt+1,n);
			sb.delete(cnt, cnt+1);
		}
		
	}
	
}
