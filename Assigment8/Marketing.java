package Assigment8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Marketing {

        private String employeeName;
        private String productName;
        private double salesAmount;

        public Marketing(String employeeName, String productName, double salesAmount) {
            this.employeeName = employeeName;
            this.productName = productName;
            this.salesAmount = salesAmount;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public String getProductName() {
            return productName;
        }

        public double getSalesAmount() {
            return salesAmount;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Marketing)) return false;
            Marketing marketing = (Marketing) o;
            return Double.compare(marketing.salesAmount, salesAmount) == 0 &&
                    Objects.equals(employeeName, marketing.employeeName) &&
                    Objects.equals(productName, marketing.productName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(employeeName, productName, salesAmount);
        }

        @Override
        public String toString() {
            return "Marketing{" +
                    "employeeName='" + employeeName + '\'' +
                    ", productName='" + productName + '\'' +
                    ", salesAmount=" + salesAmount +
                    '}';
        }
    }

    class Main {
        public static void main(String[] args) {
            List<Marketing> marketingList = new ArrayList<>();
            add(marketingList, new Marketing("Awet", "ProductA", 1500));
            add(marketingList, new Marketing("Berhe", "ProductB", 950));
            add(marketingList, new Marketing("sami", "ProductC", 1200));
            add(marketingList, new Marketing("abel", "ProductD", 1100));
            System.out.println(marketingList);

        }

        public static void add(List<Marketing> list, Marketing m) {
            list.add(m);
        }

        public static void remove(List<Marketing> list, Marketing m) {
            list.remove(m);
        }

        public static void printSize(List<Marketing> list) {
            System.out.println("Size of the list: " + list.size());
        }

        public static void sortBySalesAmount(List<Marketing> list) {
            list.sort(Comparator.comparingDouble(Marketing::getSalesAmount));
        }

        public static List<Marketing> listMoreThan1000(List<Marketing> list) {
            return list.stream()
                    .filter(m -> m.getSalesAmount() > 1000)
                    .sorted(Comparator.comparing(Marketing::getEmployeeName))
                    .collect(Collectors.toList());
        }
    }

