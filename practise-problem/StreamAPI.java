import java.util.ArrayList;
import java.util.stream.Stream;
    public class StreamAPI{
        public static void main(String[] args){
    Stream<Integer> stream=Stream.of(1,2,3,4,5,6);
        stream.forEach(n-> System.out.println(n));
        Stream<String>  stream1 =Stream.of("aa","bb","cc");
    stream1.forEach(System.out::println);
    ArrayList<Integer> al =new ArrayList<>();
    al.add(11);
    al.add(23);
    al.add(4);
    al.add(78);
    al.add(56);
    al.add(2);
    System.out.println("------------Using stream--------------");
    Stream<Integer> stm = al.stream();
    stm.forEach(n-> System.out.println(n));
    
    
    ArrayList<String> list =new ArrayList<>();
    list.add("Dhruv");
    list.add("Gopal");
    list.add("Gagan");
    list.add("Tanishq");
    list.add("Krishna");
    list.add("Dhruv");
    list.add("Ritik");
    Stream<String> stream2 =list.stream();
    Stream<String> FilterStream = stream2.filter(n->n.startsWith("G"));
    FilterStream.forEach(System.out::println);


        }
    }