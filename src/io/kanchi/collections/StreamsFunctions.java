package io.kanchi.collections;


	import java.util.Arrays;
	import java.util.*;
	import java.util.stream.Collectors;

	public class StreamsFunctions {

		public static void main(String[] args) {
			List<Employee> empList = Arrays.asList(new Employee(1,"Mayank","CIS",95),
					new Employee(2,"Akash","Dev",80),
					new Employee(3,"Sakshi","QA", 70),
					new Employee(4,"Neha","Dev", 90),
					new Employee(5,"Akash","CIS",60));
			
			//Optional<Employee> highestscorer = empList.stream().max((e1,e2) -> Integer.compare(e1.getScore(),e2.getScore()));
			
			Optional<Employee> highestscorer = empList.stream().max(Comparator.comparingInt(Employee::getScore));
			
			if(highestscorer.isPresent())
				System.out.println(highestscorer.get().getName());
			
			List<String>NameList = empList.stream().map(Employee::getName).collect(Collectors.toList());

			//To get count of Employees of each dept
			TreeMap<String, Long> result = empList.stream().collect(Collectors.groupingBy(Employee::getDept, TreeMap:: new, Collectors.counting()));		
			result.forEach((K,V)->{
				System.out.println("Department: "+K+" Count: "+V);
			});

			//To get Averge score of each dept
			Map<String, Double> result1 = empList.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingDouble(Employee::getScore)));
			result1.forEach((K,V)->{
				System.out.println("Department: "+K+" Average Score: "+V);
			});

			//To get max score of each dept
			Map<String, Optional<Employee>> result2 = empList.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.maxBy(Comparator.comparingInt(Employee::getScore))));
			result2.forEach((K,V)->{
				System.out.println("Department: "+K+" Max Score: "+V.get().getScore());
			});
			
			Set<Employee> nameSet = empList.stream().collect(Collectors.toSet());







		}

	}
	

	class Employee{	
		private Integer id;
		private String name;
		private String dept;
		private Integer score;

		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDept() {
			return dept;
		}
		public void setDept(String dept) {
			this.dept = dept;
		}
		public Integer getScore() {
			return score;
		}
		public void setScore(Integer score) {
			this.score = score;
		}
		public Employee(Integer id, String name, String dept, Integer score) {
			super();
			this.id = id;
			this.name = name;
			this.dept = dept;
			this.score = score;
		}


	}

