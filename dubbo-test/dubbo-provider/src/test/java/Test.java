/**
 * @author gsf
 * @date 2020/6/8 23:50
 */
public class Test {
    public static void main(String[] args) {

        String list = "08896477-B3C7-4E95-9660-11F638DC287A";
        String[] split = list.split("\n");
        for (int j = 0; j < split.length; j++) {

            String userId = split[j];
            int i = userId.hashCode();
            int a = i >>> 9 & 1;
            int b = i & 255;

            int c = i >>> 5 & 1;
            int d = i & 15;
            System.out.println("用户明细 " + userId + "\t" + a + "\t" + b);
            System.out.println("冻结明细 " + userId + "\t" + c + "\t" + d);

            System.out.println(3*0.1);
            System.out.println(3*0.1==0.3);
        }
    }
}
