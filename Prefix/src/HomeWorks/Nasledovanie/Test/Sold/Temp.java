package HomeWorks.Nasledovanie.Test.Sold;

public class Temp {
        public static void main(String[] args) {
            Employee emp1 = new Employee("Джордж", 100);
            Employee emp2 = new Employee("Джордж", 100);

            System.out.println(emp1 == emp2);
            System.out.println(emp1.equals(emp2));

        }
    }
    class Employee {


        String name;
        int salary;


        public Employee(String name, int salary) {
            this.name = name;
            this.salary = salary;

        }

        boolean equals(Employee emp){
            return (this.name.equals(emp.name)) && (this.salary == emp.salary);

        }

    }


