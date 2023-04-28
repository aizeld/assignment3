public class Student {
    private String name;
    private int age;
    private int id;
    public Student(String name, int id){
        this.id= id;
        this.name = name;
    }
    public Student(int id){
        this.id= id;
        this.name = "name" + id;
    }

   @Override
    public int hashCode() {
        int hash = 17;
        hash = hash*31+ name.hashCode();
        hash = hash*31+id;
        return hash;

    }


    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Student)) {
            return false;
        }
        Student other = (Student) obj;
        return this.name.equals(other.name) && this.id == other.id;
    }

}
