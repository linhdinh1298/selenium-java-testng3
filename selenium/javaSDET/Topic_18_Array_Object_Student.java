package javaSDET;
public class Topic_18_Array_Object_Student {
    String name;
    int age;

    public Topic_18_Array_Object_Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        Topic_18_Array_Object_Student[] students = new Topic_18_Array_Object_Student[3];
        students[0] = new Topic_18_Array_Object_Student("Tuan", 24);
        students[1] = new Topic_18_Array_Object_Student("Cuong", 25);
        students[2] = new Topic_18_Array_Object_Student("Duc", 24);

        for (int i = 0; i < 3; i++) {
            students[i].display();
        }
    }
}
