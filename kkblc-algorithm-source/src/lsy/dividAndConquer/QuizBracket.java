package lsy.dividAndConquer;

public class QuizBracket {

	public String solution(String p) {
        StringBuilder sb= new StringBuilder();
        
        mySplit(sb, p);
        String answer = sb.toString();
        System.out.println(answer);
        return answer;
    }
	
	public void mySplit(StringBuilder answer, String p) {
		if(p.length()==0) return;
		int check = 0;
		boolean isCorrect = true;
		String u="";
		String v="";
		for(int i=0; i<p.length();i++) {
			if(p.charAt(i)=='(') { 
				check++;
			}else{
				check--;
			}
			if(check<0) isCorrect = false;
			if(check==0) {
				u = p.substring(0, i+1);
				v = p.substring(i+1);
				break;
			}
		}
		if(isCorrect) {
			answer.append(u);
			mySplit(answer, v);
		}else {
			StringBuilder tempSb = new StringBuilder();
			tempSb.append("(");
			mySplit(tempSb,v);
			tempSb.append(")");
			tempSb.append(reverseBracket(u));
			answer.append(tempSb.toString());
		}
	}
	
	public String reverseBracket(String u) {
		if(u.length()==0) return u;
		String answer = u.substring(1,u.length()-1);
		StringBuilder sb= new StringBuilder();
		for(int i=0; i<answer.length();i++) {
			if(answer.charAt(i)=='(') {
				sb.append(")");
			}else {
				sb.append("(");
			}
		}
		answer = sb.toString();
		return answer;
	}
	
	
	
	public static void main(String[] args) {
		QuizBracket q= new QuizBracket();
		q.solution(")(");
	}

}
