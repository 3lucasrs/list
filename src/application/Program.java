package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> list = new ArrayList<>();

		System.out.print("Quantos funcionarios vão ser registrados? ");
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			System.out.println();
			System.out.println("Funcionario #" + (i + 1) + ":");
			System.out.print("ID: ");
			Integer id = sc.nextInt();
			while(hasId(list, id)) {
				System.out.print("Esse ID já existe, tente novamente: ");
				id = sc.nextInt();
			}
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();

			Employee emp = new Employee(id, name, salary);

			list.add(emp);
		}

		System.out.println();
		System.out.print("Entre com o ID do funcionario para ter o aumento:");
		int idsalary = sc.nextInt();

		Employee emp = list.stream().filter(x -> x.getId() == idsalary).findFirst().orElse(null);

		if (emp == null) {
			System.out.println("Esse ID não existe!");
		} else {
			System.out.print("Qual a porcentagem a ser aumentada: ");
			double percent = sc.nextDouble();
			emp.increaseSalary(percent);
		}

		System.out.println();
		System.out.println("Lista de funcionarios:");

		for (Employee e : list) {
			System.out.println(e);
		}

		sc.close();
	}

	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}
