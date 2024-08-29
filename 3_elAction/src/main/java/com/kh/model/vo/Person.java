package com.kh.model.vo;

public class Person {
	// 필드부 (변수)
	private String name;
	private int age;
	private String gender;
	
	// 생성자부
	public Person() {
		
	}
	
	public Person(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	// 메소드부
	// getter/setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	// toString() => 필드부에 저장된 값들을 확인하는 용도
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

}
