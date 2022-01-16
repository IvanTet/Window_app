package org.bsuir.model;

import javafx.beans.value.ObservableValue;
import javafx.beans.value.ObservableValueBase;

import java.util.Arrays;

public class Student {
    private final String firstName;
    private final String surname;
    private final String secondName;
    private final String groupNumber;
    private final int[] socialWork;

    public Student(String surname, String firstName, String secondName, String groupNumber, int[] socialWork) {
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.groupNumber = groupNumber;
        this.socialWork = Arrays.copyOfRange(socialWork, 0, socialWork.length);
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFio() {
        StringBuilder builder = new StringBuilder();
        if(!surname.isEmpty())
            builder.append(surname).append(" ");
        if(!firstName.isEmpty())
            builder.append(firstName).append(" ");
        if(!secondName.isEmpty())
            builder.append(secondName);

        return builder.toString();
    }

    public int getWorkingHours(){
        int sum = 0;
        for (int time : socialWork) {
            sum += time;
        }
        return sum;
    }

    public int[] getSocialWork() {
        return socialWork;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public ObservableValue<Integer> getSocialWork(int i) {
        return new ObservableValueBase<Integer>() {
            @Override
            public Integer getValue() {
                return socialWork[i];
            }
        };
    }
}
