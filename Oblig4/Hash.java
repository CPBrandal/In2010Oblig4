import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Hash{
    int storrelse;
    int antall;
    int[] A;

    public void lesFrafil(String filnavn) throws FileNotFoundException, IOException{
        BufferedReader leser = new BufferedReader(new FileReader(filnavn + ".txt"));
        String les;
        antall = Integer.parseInt(leser.readLine());
        A = new int[antall*2];
        while((les = leser.readLine()) != null){
            String[] liste = les.split(" ");
            if(liste[0].equals("insert")){
                this.insert(Integer.parseInt(liste[1]));
            }
            else if(liste[0].equals("contains")){
                System.out.println(this.contains(Integer.parseInt(liste[1])));
            }
            else if(liste[0].equals("remove")){
                this.remove((Integer.parseInt(liste[1])));
            }
            else if(liste[0].equals("size")){
                System.out.println(this.size());
            }
        } 
        leser.close();
    }
    
    public int hashFunksjon(int k, int N){
        return k % N;
    }

    public void insert(int t){
        int i = hashFunksjon(t, A.length);
        while(A[i] != 0){
            if(t == A[i]){
                A[i] = t;
                return;
            }
            i = ((i+1) % A.length);
        }
        storrelse += 1;
        A[i] = t;
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

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Hash hash = new Hash();
        hash.lesFrafil(args[0]);
    }
}