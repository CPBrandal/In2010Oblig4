import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Tre {
    Node start;
    int storrelse = 0;
    int[] A;

    public void lesFrafil(String filnavn) throws NumberFormatException, IOException{
        BufferedReader bR = new BufferedReader(new FileReader(filnavn+".txt"));
        BufferedReader bR2 = new BufferedReader(new FileReader(filnavn+".txt"));
        String les;
        String les2;
        bR2.readLine();
        while(!(les2 = bR2.readLine()).equals("-1")){
            String[] l2 = les2.split(" ");
            storrelse += l2.length - 1;
        }
        A = new int[storrelse*2];
        start = new Node(Integer.parseInt(bR.readLine()));
        while(!(les = bR.readLine()).equals("-1")){
            String[] l = les.split(" ");
            for(int x = 0; x < l.length; x++){
            }
        }
        bR2.close();
        bR.close();
    }

    public int hashFunksjon(int k, int N){
        return k % N;
    }

    public void insert(Node n){
        int i = hashFunksjon(n.data, A.length);
        while(A[i] != 0){
            if(n.data == A[i]){
                A[i] = n.data;
                return;
            }
            i = ((i+1) % A.length);
        }
        storrelse += 1;
        A[i] = n.data;
    }

    public void remove(int t){
        int i = hashFunksjon(t, A.length);
        while(A[i] != 0){
            int ti = A[i];
            if(t == ti){
                storrelse -=1;
                A[i] = 0;
                tettHull(i);
                return;
            }
            i = (i+1) % A.length;
        }
    }

    public void tettHull(int i){
        int s = 1;
        while(A[(i + s) % A.length] != 0){
            int k = A[(i + s) % A.length];
            int j = hashFunksjon(k, A.length);
            if(!(0 < (j - i) % A.length)){
                A[i] = k;
                A[(i + s)%A.length] = 0;
                tettHull((i+s)%A.length);
                return;
            }
            s += 1;
        }
    }

    public boolean contains(int t){
        int i = hashFunksjon(t, A.length);
        while(A[i] != 0){
            int ki = A[i];
            if(t == ki){
                return true;
            }
            i = (i+1) % A.length;
        }
        return false;
    }

    public int size(){
        return storrelse;
    }

    class Node{
        int data;
        int forelder;

        Node(int i){
            data = i;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Tre t = new Tre();
        t.lesFrafil(args[0]);
        System.out.println(t.storrelse);
    }
}
