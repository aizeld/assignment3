import java.util.Random;
public class myTestingClass {



    public static void main(String[] args) {
        MyHashTable<Student, String> table = new MyHashTable<>();
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            String value = "GOODJOB" + random.nextInt(100);
            Student key = new Student(i);
            table.put(key, value);
        }


        String value1 = table.get(new Student("name2",2));
        System.out.println(value1);

}}


