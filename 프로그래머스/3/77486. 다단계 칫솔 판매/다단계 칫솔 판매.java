import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        int[] money = new int[enroll.length];
        
        //<사람이름, Person<윗사람 이름, 돈>> 이런 형식으로 저장
        Map<String, Person> map = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], new Person(referral[i], 0));
        }
        
        for (int i = 0; i < seller.length; i++) {
            Person p = map.get(seller[i]);
            dfs(map, p, amount[i] * 100);
        }
        
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = map.get(enroll[i]).money;
        }
        
        return answer;
    }
    
    static class Person{
        public String ref;
        public int money;
        
        Person(String ref, int money) {
            this.ref = ref;
            this.money = money;
        }
    }
    
    void dfs(Map<String, Person> map, Person p, int money) {
        p.money += money;
        if (money < 10)
            return;
        
        p.money -= money / 10;
        
        if (p.ref.equals("-")) {
            return;
        } else {
            Person ref = map.get(p.ref);
            dfs(map, ref, money / 10);
        }
    }
}