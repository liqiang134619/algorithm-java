package algorithm.tree;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Liq
 * @date 2020-12-3
 */
public class TEstss {







    public static void main(String[] args) {
        String s ="^T1\\d{20}$";

        Pattern p = Pattern.compile(s);

        Matcher matcher = p.matcher("T1222222222222222s2222");
        boolean b = matcher.find();
        System.out.println(b);


    }
}
