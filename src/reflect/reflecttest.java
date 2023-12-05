package reflect;

public class reflecttest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class c = Class.forName("reflect.reflecttest");
        Object o = c.newInstance();
        System.out.println(o);
    }
}
