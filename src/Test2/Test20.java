package Test2;

import java.util.Arrays;
import java.util.Comparator;

class Student implements Comparable<Student>{
	String name;
	int id;
	double score;
	
	public Student(String name, int id, double score){
		this.name = name;
		this.id = id;
		this.score = score;
	}
	public String toString(){
		return "이름: "+name+", 학번: "+id+", 학점: "+score;
	}
	
	/* 기본 정렬 기준: 학번 오름차순 */
	public int compareTo(Student anotherStudent) {
		return Integer.compare(id, anotherStudent.id);
	}
}

public class Test20 {
	public static void main(String[] args){
		
		Student student[] = new Student[5];
		//순서대로 "이름", 학번, 학점
		student[0] = new Student("Dave", 20120001, 4.2);
		student[1] = new Student("Amie", 20150001, 4.5);
		student[2] = new Student("Emma", 20110001, 3.5);
		student[3] = new Student("Brad", 20130001, 2.8);
		student[4] = new Student("Cara", 20140001, 4.2);
		
		Arrays.sort(student, new Comparator<Student>(){
			public int compare(Student s1, Student s2) {
				double s1Score = s1.score;
				double s2Score = s2.score;
				if(s1Score == s2Score) {
					return Double.compare(s1.id, s2.id); 
				}
				
				return Double.compare(s2Score,s1Score); //내림차순
			}
		});
		
		for(int i=0;i<5;i++){
			System.out.println(student[i]);
		}
	}
}

