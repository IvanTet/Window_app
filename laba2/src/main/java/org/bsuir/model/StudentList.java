package org.bsuir.model;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    private final List<Student> list;

    public StudentList(){
        list = new ArrayList<>();
    }

    public void addStudent(Student student){
        list.add(student);
    }

    public int removeBySurnameOrGroupNumber(String surname, String groupNumber){
        int deleteStudentCount = 0;

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getSurname().equals(surname) || list.get(i).getGroupNumber().equals(groupNumber)){
                list.remove(i);
                deleteStudentCount++;
                i--;
            }
        }

        return deleteStudentCount;
    }

    public int removeBySurname(String groupNumber, int minWorkingHours, int maxWorkingHours){
        int deleteStudentCount = 0;

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getSurname().equals(groupNumber) &&
                    minWorkingHours <= list.get(i).getWorkingHours() &&
                    list.get(i).getWorkingHours() <= maxWorkingHours){
                list.remove(i);
                deleteStudentCount++;
                i--;
            }
        }

        return deleteStudentCount;
    }

    public int removeByGroupNumber(String groupNumber, int minWorkingHours, int maxWorkingHours){
        int deleteStudentCount = 0;

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getGroupNumber().equals(groupNumber) &&
                    minWorkingHours <= list.get(i).getWorkingHours() &&
                    list.get(i).getWorkingHours() <= maxWorkingHours){
                list.remove(i);
                deleteStudentCount++;
                i--;
            }
        }

        return deleteStudentCount;
    }

    public List<Student> searchBySurnameOrGroupNumber(String surname, String groupNumber){
        List<Student> soughtStudents = new ArrayList<>();
        for (Student student : list) {
            if(student.getSurname().equals(surname) || student.getGroupNumber().equals(groupNumber))
                soughtStudents.add(student);
        }
        return soughtStudents;
    }

    public List<Student> searchBySurname(String surname, int minWorkingHours, int maxWorkingHours){
        List<Student> soughtStudents = new ArrayList<>();
        for (Student student : list) {
            if(student.getSurname().equals(surname) &&
                minWorkingHours <= student.getWorkingHours() &&
                student.getWorkingHours() <= maxWorkingHours)
                    soughtStudents.add(student);
        }
        return soughtStudents;
    }

    public List<Student> searchByGroupNumber(String groupNumber, int minWorkingHours, int maxWorkingHours){
        List<Student> soughtStudents = new ArrayList<>();
        for (Student student : list) {
            if(student.getGroupNumber().equals(groupNumber) &&
                    minWorkingHours <= student.getWorkingHours() &&
                    student.getWorkingHours() <= maxWorkingHours)
                        soughtStudents.add(student);
        }
        return soughtStudents;
    }

    public List<Student> getList() {
        return list;
    }
}
