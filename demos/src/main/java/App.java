package a.b.c;
/**
 * Created by guojun.wang on 2017/2/17.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("demo");
        System.out.println(App.class.getClassLoader().getParent());
        System.out.println(App.class.getPackage().getName());
    }

}
