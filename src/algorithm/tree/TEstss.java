package algorithm.tree;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Liq
 * @date 2020-12-3
 */
public class TEstss {







    public static void main(String[] args) {
        String s ="^(T1|T2)\\d{2}$";

        Pattern p = Pattern.compile(s);

        Matcher matcher = p.matcher("T2122");
        boolean b = matcher.find();
        System.out.println(b);


    }
}
