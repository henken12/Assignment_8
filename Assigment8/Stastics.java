package Assigment8;

import java.util.ArrayList;
import java.util.List;

public class Stastics {
    public static double computeSumOfSalaries(List<? extends EmployeeData> employeeDataList) {
        double sum = 0.0;
        for (EmployeeData employee : employeeDataList) {
            sum += employee.getSalary();
        }
        return sum;
    }
    interface EmployeeData {
        double getSalary();
    }


    final class Staff implements EmployeeData {
        private double salary;


        @Override
        public double getSalary() {
            return salary;
        }

    }

    final class Teacher implements EmployeeData {
        private double salary;

        @Override
        public double getSalary() {
            return salary;
        }

    }
    class Main {
        public static void main(String[] args) {
            List<Staff> staffList = new ArrayList<>();
            List<Teacher> teacherList = new ArrayList<>();



            List<EmployeeData> combinedList = combine(staffList, teacherList);
            double totalSalaries = Stastics.computeSumOfSalaries(combinedList);
            System.out.println("Total sum of salaries: " + totalSalaries);
        }

        public static List<EmployeeData> combine(List<Staff> staffList, List<Teacher> teacherList) {
            List<EmployeeData> combinedList = new ArrayList<>();
            combinedList.addAll(staffList);
            combinedList.addAll(teacherList);
            return combinedList;
        }
    }
}
