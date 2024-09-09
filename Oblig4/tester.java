import java.util.HashMap;

public class tester {
    public static void main(String[] args) {
        System.out.println(635 % 20);
        String[] liste = new String[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(2,4);
        hm.put(3,8);
        hm.put(2,6);
        for(int k : hm.values()){
            System.out.println(k);
        }
    }   
}
