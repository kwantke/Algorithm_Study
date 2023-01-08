package Test2;

import java.util.Arrays;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String[] strArry = {"muzi", "frodo", "apeach", "neo"};
		String[] reportArry = {"muzi frodo"
							  ,"muzi neo"
							  ,"apeach frodo"
							  ,"apeach muzi"
							  ,"frodo neo"
							  };
		int k = 2;*/
		
		String[] strArry = {"con", "ryan"};
		String[] reportArry = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int k = 3;
		int[] answer = solution(strArry, reportArry, k);
		
		System.out.println("answer = " + Arrays.toString(answer));
	}
	public static int[] solution(String[] id_list, String[] report, int k){
		
		int size = id_list.length;
		int[] answer = new int[size];
		int[] reportCnt = new int[size];
		String[] reportUser = new String[10]; 
		int t=0;
		
			for(String reportId2 : report){
				String[] reportUsers = reportId2.split(" ");
				String user1= reportUsers[0];
				String user2 = reportUsers[1];		
				
				for(int i = 0; i<id_list.length; i++){
					String id = id_list[i];				
					
					if(id.equals(user2)){
						int count = reportCnt[i]+1;
						reportCnt[i] = count;
						if(count == 2){
							reportUser[t]=id;
							t++;
						}
					}	
				}	
			}		
			for(String reportId2 : report){
				String[] reportUsers = reportId2.split(" ");
				String user1= reportUsers[0];
				String user2 = reportUsers[1];		
				for(int r=0;r<reportUser.length;r++){
					
					if(reportUser[r]==null)
						break;
					
					if(reportUser[r].equals(user2)){
						for(int i = 0;i<id_list.length;i++){
							if(id_list[i].equals(user1)){
								int count = answer[i]+1;
								if(count<=k)
									answer[i] = count;
								else
									answer[i] = 0;
							}
							
						}
					}
				}
			}	
		
		return answer;
	}
	
	/*public static int[] countArray(String[] idArry, String[] reportArry, int[] countArry,int key){
				
		
		return answer;
	}*/
}
