package CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Employee>> employees = new HashMap<>();

        while (n-- > 0) {

            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];

            if (!employees.containsKey(department)) {
                employees.put(department, new ArrayList<>());
            }


            if (data.length == 4) {
                employees.get(department).add(new Employee(name, salary, position, department, "n/a", -1));
            } else {
                if (data.length == 5) {
                    if (data[4].contains("@")) {
                        employees.get(department).add(new Employee(name, salary, position, department, data[4], -1));
                    } else {
                        employees.get(department).add(new Employee(name, salary, position, department, "n/a", Integer.parseInt(data[4])));
                    }
                } else { //length = 6
                    employees.get(department).add(new Employee(name, salary, position, department, data[4], Integer.parseInt(data[5])));
                }
            }

        }

        HashMap<String, Double> results = new HashMap<>();

        employees.forEach((key, value) -> {
            {
                double averageSalary = (value.stream().mapToDouble(Employee::getSalary).sum()) / (value.size());

                results.put(value.get(0).getDepartment(), averageSalary);

            }
        });



        Map<String,Double> finalResult =
                results.entrySet()
                .stream()
                .sorted((Map.Entry.<String,Double>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("Highest Average Salary: " + finalResult.keySet().iterator().next());

        employees.get(finalResult.keySet().iterator().next())
                .stream()
                .sorted((p2,p1)->Double.compare(p1.getSalary(),p2.getSalary()))
                .forEach(person->{{


                    System.out.println(String.format("%s %.2f %s %d",
                            person.getName(),
                            person.getSalary(),
                            person.getEmail(),
                            person.getAge()
                            ));
                }
                });

    }





}
