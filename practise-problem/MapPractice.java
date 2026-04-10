import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
public class MapPractice{
    public static void main(String[] args){
        HashMap<Integer,Integer>hm =new HashMap<>();
        hm.put(2,98);
        hm.put(6,88);
        hm.put(3,78);
        hm.put(1,99);
System.out.println("values :" +hm.keySet());
for(int a: hm.keySet()){
    System.out.println(a);
}
System.out.println("values :" +hm.values());
for(int b :hm.values()){
    System.out.println(b);
}

System.out.println(hm);

}
    }
