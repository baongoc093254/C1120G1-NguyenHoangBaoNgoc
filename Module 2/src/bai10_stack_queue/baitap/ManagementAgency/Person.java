package bai10_stack_queue.baitap.ManagementAgency;

public class Person implements Comparable<Person> {
    private String name;
    private  String gender;
    private String birthday;
    private int age;

    public Person() {
    }

    public Person(String name, String gender, String birthday, int age) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {

        return 0;
    }
}
