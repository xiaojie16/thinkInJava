package chapters17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by kissx on 2016/11/16.
 */
public class CountedString {

    private static List<String> created = new ArrayList<>();
    private String s;
    private int id;

    public CountedString(String s) {
        this.s = s;
        created.add(s);
        for (String s2 : created) {
            if (s2.equals(s))
                id++;
        }
    }

    @Override
    public String toString() {
        return "String: " + s + " id: " + id + " hashCode(): " + hashCode();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CountedString && s.equals(((CountedString) obj).s) && (id == ((CountedString) obj).id);
    }

    public static void main(String[] args) {
//        float f = 123.456f;
//        int i = Float.floatToIntBits(f);
//        System.out.println(i);
//        float f1 = Float.intBitsToFloat(i);
//        System.out.println(f1);
//
//        long l = 100000000000000L;
//        System.out.println(l >>> 32);

        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; ++i) {
            cs[i] = new CountedString("hi");
            map.put(cs[i], i);
        }
        System.out.println(map);
        for (CountedString cstring : cs) {
            System.out.println("Looking up " + cstring);
            System.out.println(map.get(cstring));
        }

    }

}
