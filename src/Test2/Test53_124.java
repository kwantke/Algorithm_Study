package Test2;

public class Test53_124 {
	static int a=1;
	static String result;
	static boolean checked;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args){
		
		int n = 10;
		System.out.println(solution(n));
	}
	static String solution(int n) {
       
        int[] num = {1,2,4};
		StringBuffer sb = new StringBuffer();
		
        int aa = 3;
		int count = 1;
		int sum = 3;
		if(n>3){
			while(n > sum){			
				aa = aa*3;
				sum +=aa;
				count++;
			}
			//a = sum - aa+1;
		}
		
		dfs(num, 0, sb, 3, n);
        return result;
    }
	
    static void hello(int n) {
        if(n == 1) {
            sb.append("1");
        }else if(n == 2) {
            sb.append("2");
        }else if(n == 3 || n == 0) {
            sb.append("4");
        }else {
            hello((n-1)/3); 
            hello(n%3);
        }
    }

    /*static String solution(int n) {
        hello(n);
        return sb.toString();
    }*/
	
	static void dfs(int[] num, int idx, StringBuffer sb, int res, int n){
		if(idx == res && sb != null){	
			System.out.println("num = "+a +" "+sb.toString());
			if(a == n){
				result = sb.toString();
				checked = true;
			}
			a++;
			return;
		}
		for(int i=idx;i<num.length;i++){
			if(checked) break;
			sb.append(num[i]);
			dfs(num, i+1, sb, res, n);
			sb.delete(idx, sb.toString().length());
			
		}
	}
	
}
/*
124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.

124 나라에는 자연수만 존재합니다.
124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.

10진법	124 나라	10진법	124 나라
1	1	6	14
2	2	7	21
3	4	8	22
4	11	9	24
5	12	10	41
자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.

제한사항
n은 500,000,000이하의 자연수 입니다.
입출력 예
n	result
1	1
2	2
3	4
4	11
*/