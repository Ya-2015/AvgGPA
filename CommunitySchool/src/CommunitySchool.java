import java.util.ArrayList;
import java.util.Scanner;

public class CommunitySchool {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String inputStr = "input";
		String endStr = "end";
		String[] inputArray;
		final int LENGTH = 5;
		ArrayList<Double> gpa = new ArrayList<Double>();
		ArrayList<String> grade = new ArrayList<String>();
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> gender = new ArrayList<String>();
		ArrayList<String> state = new ArrayList<String>();
		ArrayList<String> major = new ArrayList<String>();
		double sumGpa = 0;
		double currentGpa = 0;
		
		while (!inputStr.equals(endStr)){
			System.out.println("Please key in Name, Grade, Gender, Major, and State of Origin, seperated by ','");
			inputStr = scan.nextLine();
			inputArray = inputStr.split(",");
			if(inputArray.length == LENGTH){
				//process only if the number of input is 5
				name.add(inputArray[0].toUpperCase());
				grade.add(inputArray[1].toUpperCase());
				gender.add(inputArray[2].toUpperCase());
				major.add(inputArray[3].toUpperCase());
				state.add(inputArray[4].toUpperCase());
				currentGpa = letterGradeToGPA(inputArray[1].toUpperCase());
				gpa.add(currentGpa);
				sumGpa += currentGpa;
			}
		}
		
		scan.close();
		
		//display all information
		int size = name.size();
		System.out.println("\nName\t\tGrade\tGender\tMajor\tState of Origin");
		for (int i = 0; i < size; i++){
			System.out.println(name.get(i)+"\t\t"+grade.get(i)+"\t"+gender.get(i)+"\t"+major.get(i)+"\t"+state.get(i));
		}
		
		//overall average gpa
		System.out.printf("\nOverall Avg GPA: %.2f\n", (sumGpa/size));
		
		//Avg GPA by Gender
		System.out.println("\nAvg GPA by Gender");
		calculateGpaByType(size, gpa, gender);
		
		//avg by Major
		System.out.println("\nAvg GPA by Major");
		calculateGpaByType(size, gpa, major);
		
		//avg by State
		System.out.println("\nAvg GPA by State");
		calculateGpaByType(size, gpa, state);
	}
	
	public static void calculateGpaByType(int size, ArrayList<Double> gpa, ArrayList<String> type){
		ArrayList<String> category = new ArrayList<String>();
		ArrayList<Double> sum = new ArrayList<Double>();
		ArrayList<Integer> cnt = new ArrayList<Integer>();
		String typ = "";
		int idx = 0;
		double val = 0;
		
		for (int i = 0; i < size; i++){
			typ = type.get(i);
			val = gpa.get(i);
			if (category.contains(typ)){
				idx = category.indexOf(typ);
				sum.set(idx, sum.get(idx) + val);
				cnt.set(idx, cnt.get(idx) + 1);
			}else{
				category.add(typ);
				sum.add(val);
				cnt.add(1);
			}
		}
		
		//print according to the type selected
		for (int j=0;j<category.size();j++){
			System.out.printf("\t%s\t%.2f\n",category.get(j),sum.get(j)/cnt.get(j));
		}
		
	}
	
	public static double letterGradeToGPA(String grade){
		double gpa = 0;
		switch(grade){
		case "A+":
		case "A":
			gpa = 4;
			break;
		case "A-":
			gpa = 3.7;
			break;
		case "B+":
			gpa = 3.3;
			break;
		case "B":
			gpa = 3;
			break;
		case "B-":
			gpa = 2.7;
			break;
		case "C+":
			gpa = 2.3;
			break;
		case "C":
			gpa = 2;
			break;
		case "C-":
			gpa = 1.7;
			break;
		case "D+":
			gpa = 1.3;
			break;
		case "D":
			gpa = 1;
			break;
		default:
			break;	
		}
		
		return gpa;
	}
}
