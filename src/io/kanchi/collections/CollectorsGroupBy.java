package io.kanchi.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsGroupBy {

	public static void main(String[] args) {

		List<Person> personList = Arrays.asList(
				new Person(1,"Mayank","Bilthare"),
				new Person(2,"Akash","Sharma"),
				new Person(3,"Akansha","A"),
				new Person(4,"Sakshi","T"),
				new Person(5,"Mayank","B"));

		//Set of names
		Set<Person> personset = personList.stream().collect(Collectors.toSet());

		//Collectors1 - using one param classification function
		Map<String, List<Person>>  result = personList.stream().collect(Collectors.groupingBy(Person::getName));
		result.forEach((k,V) -> {
			System.out.println("Name "+k+" Count of emp with same name"+ V.size());
		});
		System.out.println("---------------------------");

		//Function and Collector(Using mapping function)
		Map<String, List<Integer>> result2 = personList.stream().collect(Collectors.groupingBy(Person::getName, Collectors.mapping(Person::getId, Collectors.toList())));
		result2.forEach((k,V) -> {
			System.out.println("Name: "+k+" IDs with same name : "+ V.toString());
		});	
		System.out.println("---------------------------");

		//Using Counting method
		Map<String, Long> result3 = personList.stream().collect(Collectors.groupingBy(Person::getName, Collectors.counting()));
		result3.forEach((k,V) -> {
			System.out.println("Name "+k+"  Count of emp with same name "+ V);
		});
		System.out.println("---------------------------");

		Map<String, Double> result4 = personList.stream().collect(Collectors.groupingBy(Person::getName, Collectors.averagingInt(Person::getId)));

		result4.forEach((k,V) -> {
			System.out.println("Name "+k+" ID Avergae "+ V);
		});	
		System.out.println("---------------------------");

		Map<String, Optional<Person>> result5 = personList.stream().collect(Collectors.groupingBy((p -> (p.getName())), Collectors.maxBy(Comparator.comparingInt(Person::getId))));

		result5.forEach((k,V) -> {
			System.out.println("Name "+k+" max ID"+ V.get().getId());
		});	
		System.out.println("---------------------------");

		//Sort output in descending order, also can pass Collections.reverseOrder() in Treemap constructor
		Map<String, Long> result6 = personList.stream().collect(Collectors.groupingBy(p -> (p.getName()) , TreeMap::new, Collectors.counting())).descendingMap();
		result6.forEach((k,V) -> {
			System.out.println("Name "+k+" Count "+ V);
		});
		System.out.println("---------------------------");

		//Using Collectors.toMap 
		Map<String, Integer> result7 = personList.stream()
				.collect(Collectors.toMap(p -> p.getName(), Person::getId , (item, identicalItem) -> identicalItem));		
		result7.forEach((k,V) -> {
			System.out.println("Key1 "+k+" Object "+ V);
		});

		System.out.println("---------------------------");
		//Map<Person, Person> resul = personList.stream()
		//.collect(Collectors.toMap(keyMapper, valueMapper, mergeFunction, mapSupplier))


	}

}
