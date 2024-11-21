import java.util.*;

class Solution {
    
    public String solution(String new_id) {
        
        String answer = new_id.toLowerCase();
        
        answer = answer.replaceAll("[^a-z0-9.\\-_]", "");
        
        answer = answer.replaceAll("\\.{2,}", ".");
        
        answer = answer.replaceFirst("^\\.", "");
        
        if (!answer.isEmpty() && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }
        
        if (answer.isEmpty()) {
            answer = "a";
        }
        
        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
            if (answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, 14);
            }
        }
        
        while (answer.length() <= 2) {
            answer = answer.concat(answer.substring(answer.length() - 1));
        }
        
        System.out.println(answer);
        
        return answer;
    }
}