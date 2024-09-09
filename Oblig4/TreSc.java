import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

class TreSc {
    HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
    int forste;
    public void lesFrafil() throws NumberFormatException, IOException{
        InputStreamReader l1 = new InputStreamReader(System.in);
        BufferedReader leser = new BufferedReader(l1);
        String les;
        forste = Integer.parseInt(leser.readLine());
        while(!(les = leser.readLine()).equals("-1")){
            String[] l = les.split(" ");
            for(int x = 0; x < l.length; x++){
                if(x == 0){
                    if(!hM.containsKey(Integer.parseInt(l[x]))){
                        hM.put(Integer.parseInt(l[x]), null);
                    }
                } else {
                    hM.put(Integer.parseInt(l[x]), Integer.parseInt(l[0]));
                }
            }
        }
        leser.close();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        TreSc tre = new TreSc();
        tre.lesFrafil();
        ArrayList<Integer> liste = new ArrayList<>();
        int x = tre.forste;
        while(tre.hM.get(x) != null){
            liste.add(x);
            x = tre.hM.get(x);
        }
        liste.add(x);
        String s = " ";
        for(int i : liste){
            s += i+" ";
        }
        s = s.strip();
        System.out.println(s);
    }
}
