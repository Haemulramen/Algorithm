import java.util.*;

class Solution {
    
    Map<String, Integer> carIn = new HashMap<>();
    Map<String, Integer> carFee = new HashMap<>();
    
    int LAST_TIME = 23 * 60 + 59;
    
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        
        for (String record : records) {
            String[] split = record.split(" ");
            String car = split[1];
            int time = toMinute(split[0]);
            
            if (split[2].equals("IN")) {
                carIn.put(car, time);
            } else {
                int inTime = carIn.get(car);
                carIn.remove(car);
                carFee.put(car, carFee.getOrDefault(car, 0) + time - inTime);
            }
        }
        
        for (String car : carIn.keySet()) {
            int inTime = carIn.get(car);
            carFee.put(car, carFee.getOrDefault(car, 0) + LAST_TIME - inTime);
        }
        
        Object[] cars = carFee.keySet().toArray();
        Arrays.sort(cars);
        
        answer = new int[cars.length];
        for (int i = 0; i < cars.length; i++) {
            int parkTime = carFee.get(cars[i]);
            if (parkTime <= fees[0]) {
                answer[i] = fees[1];
            } else {
                answer[i] = fees[1];
                parkTime -= fees[0];
                if (parkTime % fees[2] != 0) {
                    answer[i] += fees[3];
                }
                answer[i] += parkTime / fees[2] * fees[3];
            }
        }
        
        return answer;
    }
    
    public int toMinute(String s) {
        String[] split = s.split(":");
        int hh = Integer.parseInt(split[0]);
        int mm = Integer.parseInt(split[1]);
        return hh * 60 + mm;
    }
}