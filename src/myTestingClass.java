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

        System.out.println(table.get(new Student("name3",3)));

        table.remove(new Student("name3", 3)); ///let's see what we got after removing
        System.out.println(table.get(new Student("name3",3)));
        System.out.println(table.size);

        System.out.println(table.contains("GOODJOB101")); // false, лимит чисел 100, проверил на работоспособность
        System.out.println(table.contains("GOODJOB56")); // true

        Student key = table.getkey("GOODJOB56");
        System.out.println(key.getName() + " " + key.getId()); // показывает

        int[] bucketsizes = table.getBuckeds();
        for(int i = 0;i<bucketsizes.length; i++){
         System.out.println("Every size of the bucket " + i + " is " + bucketsizes[i]);
        }



}}


