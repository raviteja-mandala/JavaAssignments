package com.zemoso.streamapi;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class StreamApiProblem {
    public static void main(String[] args){
        List<Student> studentList=new ArrayList<Student>();
        studentList.add(new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8));
        studentList.add(new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2));
        studentList.add(new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3));
        studentList.add(new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80));
        studentList.add(new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70));
        studentList.add(new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70));
        studentList.add(new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70));
        studentList.add(new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80));
        studentList.add(new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85));
        studentList.add(new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82));
        studentList.add(new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83));
        studentList.add(new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4));
        studentList.add(new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6));
        studentList.add(new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8));
        studentList.add(new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4));
        studentList.add(new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4));
        studentList.add(new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5));

        //print names of all departments
        System.out.println("Names of all departments:");
        studentList.stream().map(p->p.engDepartment).distinct().forEach(p->System.out.print(p+" "));
        System.out.println();
        //print names of all students who enrolled after 2018
        System.out.println("names of all students who enrolled after 2018");
        studentList.stream().filter(p->p.yearOfEnrollment>2018).forEach(p->System.out.print(p.name+" "));
        System.out.println();
        //Get the details of all male student in the computer sci department
        System.out.println("names of all male students in computer science department");
        studentList.stream().filter(p->(p.gender=="Male" && p.engDepartment=="Computer Science")).forEach(p->System.out.print(p.name+" "));
        System.out.println();
        //Get number of male and female student
        System.out.println("number of male and female students");
        Map<String,Long> studentMap=studentList.stream().collect(Collectors.groupingBy(p->p.gender,Collectors.counting()));
        studentMap.entrySet().stream().forEach((Map.Entry mp) -> {System.out.println("Gender-> "+mp.getKey()+" Number of students-> "+mp.getValue());});
        System.out.println();
        //Get average age of male and female student
        System.out.println("average age of male and female students");
        Map<String,Double> studentAgeMap=studentList.stream().collect(Collectors.groupingBy(p->p.gender,Collectors.averagingDouble(p->p.age)));
        studentAgeMap.entrySet().stream().forEach((Map.Entry mp) -> {System.out.println("Gender-> "+mp.getKey()+" Number of students-> "+mp.getValue());});
        System.out.println();
        //highest student having highest percentage
        System.out.println("Student having highest percentage:");
        Student studentWithHighestPercent=studentList.stream().max(Comparator.comparing(p->p.percentTillDate)).get();
        System.out.println("Student with highest percent: "+studentWithHighestPercent.name);
        System.out.println();
        //Count the number of students in each department
        System.out.println("Count of students in each department");
        Map<String,Long> studentCountDeptWiseMap=studentList.stream().collect(Collectors.groupingBy(p->p.engDepartment,Collectors.counting()));
        studentCountDeptWiseMap.entrySet().stream().forEach((Map.Entry mp)->{System.out.println("Department name -->"+mp.getKey()+" Number of students "+mp.getValue());});
        System.out.println();
        //What is the average percentage achieved in each department
        System.out.println("Average percentage in each department");
        Map<String,Double> avgPercentStudentMap=studentList.stream().collect(Collectors.groupingBy(p->p.engDepartment,Collectors.averagingDouble(p->p.percentTillDate)));
        avgPercentStudentMap.entrySet().stream().forEach((Map.Entry mp)->{System.out.println("Department name -->"+mp.getKey()+" Average Percentage--> "+mp.getValue());});
        System.out.println();
        //Get the details of youngest male student in the Electronic department?
        System.out.println("Get the youngest male student in the Electronic department");
        Optional<Student> youngestStudent=studentList.stream().filter(p->p.engDepartment.equalsIgnoreCase("Electronic")).collect(Collectors.minBy(Comparator.comparing(p->p.age)));
        if(youngestStudent.isPresent()){
            System.out.println(youngestStudent.get().name);
        }
        else{
            System.out.println("no such student");
        }
        System.out.println();
        //number of male and female students are there in the computer science department
        System.out.println("male and female students count in the computer science department");
        Map<String,Long> studentInCSEDeptGenderWiseMap=studentList.stream().filter(p->p.engDepartment.equalsIgnoreCase("Computer Science")).
                collect(Collectors.groupingBy(p->p.gender,Collectors.counting()));
        studentInCSEDeptGenderWiseMap.entrySet().stream().forEach((Map.Entry mp)-> System.out.println("Male Students in CSE-> "+mp.getKey()+" Female Students" +
                "in CSE->"+mp.getValue()));

        System.out.println();





    }
}

class Student{
    public Integer id;
    public String name;
    public Integer age;
    public String gender;
    public String engDepartment;
    public Integer yearOfEnrollment;
    public Double percentTillDate;
    public Student(int id,String name, int age, String gender, String engDepartment,int yearOfEnrollment,double percentTillDate){
        this.id=id;
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.engDepartment=engDepartment;
        this.yearOfEnrollment=yearOfEnrollment;
        this.percentTillDate=percentTillDate;
    }
}
