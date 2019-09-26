import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test {

    private Test(){

    }

    private static void test1(){
        System.out.println("111");
    }

    public static void main(String[] args) {
//        String url = "https://daff@dfaf";
//
//        String[] a = url.split("//");
//        String[] b = a[1].split("@");
//        String newUrl = a[0] + "//" + b[1];
//        System.out.println(newUrl);

        Integer a = 1;
        Integer b = 1;
        Integer c = 123456;
        Integer d = 123456;
        Map<Integer,Object> map = new HashMap<Integer,Object>();
        map.put(a,null);
        map.put(d,null);
        System.out.println(map.containsKey(b));
        System.out.println(map.containsKey(c));
        System.out.println(a.equals(b));
        System.out.println(c.equals(d));

        String a1[] = {"1","2","3"};
        String b1[] = {"1","2","3"};
        System.out.println(a1.equals(b1));
        Test test = null;
        test.test1();

    }





}

