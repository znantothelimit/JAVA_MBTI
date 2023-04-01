package MBTI_report;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MBTI_report_20190954 {

	public static void main(String[] args) throws IOException {
		final int ROWS = 4, COLS =2; // 상수로 2차원 배열의 행 열 선언
		
		int p_type[][] = new int[ROWS][COLS]; // EI / SN / TF / JP 구분하는 2차원 int형 배열 2*4 p_type생성
		String MBTI = ""; // mbti 결과를 담을 변수 선언
		
		int input; // 여기에 사용자의 답이 입력됨
		
		Scanner file = new Scanner(new File("C:\\Users\\hks56\\Documents\\mbti\\MBTI_questions.txt"));
		Scanner scan = new Scanner(System.in);
		
		System.out.println("MBTI검사를 시작합니다!(20190954허진환)");
		
		
		//*파일 한줄씩 입력받으면서 2차원배열 내 해당 유형에 ++*/
		while(file.hasNextLine()) {
			String buf = file.nextLine(); // buf 문자열에 임시로 읽어온 한 줄씩 저장	
			System.out.println(buf); // 한 줄씩 출력

			do {
				System.out.print("please input 1 or 2 >>");			
				input = scan.nextInt(); 
				if(input == 1 || input ==2)
					break;
			} while(true); // 입력이 1또는 2가 아닌경우 계속 다시 입력받도록 함 (한 번은 무조건 실행되어야하므로 do while문 사용)

			if(buf.contains("E-I") == true) { // 읽어온 문자열 buf 안에 "E-I"문자열이 포함되어 있다면 -> E-I를 구분하는 데 사용
				//rows = 0; 인 경우 (E-I를 구분)
				switch(input) {
				case 1 : 
					p_type[0][0]++;	// E 유형인 경우		
					break;
				case 2 :
					p_type[0][1]++; // I 유형인 경우
					break;
				}
			}			
			else if(buf.contains("S-N") == true) {
				//rows = 1;
				switch(input) {
				case 1 :  
					p_type[1][0]++;					
					break;
				case 2 :
					p_type[1][1]++;
					break;
				}				
			}
			else if(buf.contains("T-F") == true) {
				//rows = 2;
				switch(input) {
				case 1 : 
					p_type[2][0]++;		
					break;
				case 2 :
					p_type[2][1]++;
					break;
				}				
			}
			else if(buf.contains("J-P") == true) {
				//rows = 3;
				switch(input) {
				case 1 : 
					p_type[3][0]++;		
					break;
				case 2 :
					p_type[3][1]++;
					break;				
				}				
			}
	
		}
		
		scan.close(); // 파일 닫기
		
		if(p_type[0][0]>p_type[0][1]) // E-I간 사용자 답 개수 비교
			MBTI += 'E';
		else 
			MBTI += 'I';		
		
		if(p_type[1][0]>p_type[1][1]) // S-N간 사용자 답 개수 비교
			MBTI += 'S';
		else 
			MBTI += 'N';
		
		if(p_type[2][0]>p_type[2][1]) // T-F간 사용자 답 개수 비교
			MBTI += 'T';
		else 
			MBTI += 'F';
		
		if(p_type[3][0]>p_type[3][1]) // J-P간 사용자 답 개수 비교
			MBTI += 'J';
		else 
			MBTI += 'P';
		
		System.out.println("MBTI 결과 : " + MBTI); // 결과 출력
		System.out.println("20190954 허진환");

	}

}
