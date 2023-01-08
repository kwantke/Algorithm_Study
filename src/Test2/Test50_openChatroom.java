package Test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test50_openChatroom {
	
	public static void main(String[] args){
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] result = solution(record);
		for(String str: result){
			System.out.println(str);
		}
	}
	
	static String[] solution(String[] record) {
        String[] answer;
        Map<String, String> enterMap = new HashMap<>();
        List<String> enterList = new ArrayList<>();
        for(int i=0;i<record.length;i++){
        	Map<String, String> map = new HashMap<>();
        	String[] person = record[i].split(" ");
        	if("Enter".equals(person[0])){   
        		enterList.add(person[1]+"님이 들어왔습니다.");
        		enterMap.put(person[1], person[2]);
        	} else if("Leave".equals(person[0])){
        		enterList.add(person[1]+"님이 나갔습니다.");
        	} else{
        		enterMap.put(person[1], person[2]);
        	}
        }
        List<String> list = new ArrayList<>();
        for(int i=0;i<enterList.size();i++){
        	String str = enterList.get(i);
        	int idx = str.indexOf('님');
        	String id2 = str.substring(0,idx);
        	enterList.set(i, str.replace(id2, enterMap.get(id2)));
        }
        answer = enterList.toArray(new String[enterList.size()]);
        return answer;
    }
}

/*
record	
["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]	
result
["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
*/
