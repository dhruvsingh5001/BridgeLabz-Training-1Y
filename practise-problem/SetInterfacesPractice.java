import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetInterfacesPractice{
    public static void main(String[] args){
HashSet<Integer> hs = new HashSet<>();
hs.add(88);
hs.add(0);
hs.add(63);
hs.add(1);
hs.add(56);
System.out.println("==========HashSet==========");
System.out.println(hs);
LinkedHashSet<Integer> ls =new LinkedHashSet<>();
ls.add(88);
ls.add(0);
ls.add(63);
ls.add(1);
ls.add(56);
System.out.println("===========LinkedHashSet==========");
System.out.println(ls);

TreeSet<Integer> ts = new TreeSet<>();
ts.add(23);
ts.add(456);    
ts.add(987);
ts.add(99);    
ts.add(6);     
System.out.println("===============TreeSet=================");
System.out.println(ts);
    }
}