# Spring-autowiring

Dependency:

		<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>5.2.5.RELEASE</version>
		</dependency>
Autowire only works for dependencies. It is used to fill out a dependency of an object. It does automatically.
To work with @Autowired annotation in java, we have to set up our application configuration XML file. We should activate the @Autowired annotation with tag <context:annotation-config/> and adding some schemas to XML file.

    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:context="http://www.springframework.org/schema/context"
           xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>


autowire = "byName" 
Instead of looking for a <property> tag in order to complete a dependency of an object; Spring will link the bean that corresponds.
Make sure to put the "id" in bean as a same name of the atrribute.
  
    public class Person {

    private int id;
    private String name;
    private String nickName;
    private Country country;
    private City city;
    ...

Autowiring in configuration file (xml)
autowire = byName

	<bean id="myPerson" class="com.eflu.beans.Person" autowire="byName">
		<property name="id" value="1"></property>
		<property name="name" value="Edgar"></property>
		<property name="nickName" value="chano"></property>

	</bean>

	<bean id="country" class="com.eflu.beans.Country">
		<property name="name" value="Peru"></property>
	</bean>

	<bean id="city" class="com.eflu.beans.City">
		<property name="name" value="Arequipa"></property>
	</bean>
  
Autowiring in configuration file (xml)
autowire = byType

	<bean id="myPerson" class="com.eflu.beans.Person" autowire="byType">

		<property name="id" value="1"></property>
		<property name="name" value="Edgar"></property>
		<property name="nickName" value="chano"></property>

	</bean>

	<bean id="country1" class="com.eflu.beans.Country">
		<property name="name" value="Peru"></property>
	</bean>

	<bean id="city1" class="com.eflu.beans.City">
		<property name="name" value="Arequipa"></property>
	</bean>
  
Autowiring in Java class
@Autowired annotation: It links with the dependency in the appConfig.xml file.
It looks firstly for autowiring = byType, if there is an error or duplicate beans with the same type, then Autowiring has to take a Qualifier annotation in order to get byName.
    public class Person {

    private int id;
    private String name;
    private String nickName;
    private Country country;
    private City city;

    @Autowired
    public void setCity(City city) {
      this.city = city;
    }

    @Autowired
    @Qualifier("country2")
    public void setCountry(Country country) {
      this.country = country;
    }
  }
  
	<bean id="myPerson" class="com.eflu.beans.Person" >

		<property name="id" value="1"></property>
		<property name="name" value="Edgar"></property>
		<property name="nickName" value="chano"></property>

	</bean>

	<bean id="country1" class="com.eflu.beans.Country">
		<property name="name" value="Peru"></property>
	</bean>
	
	<bean id="country2" class="com.eflu.beans.Country">
		<property name="name" value="Colombia"></property>
	</bean>

	<bean id="city1" class="com.eflu.beans.City">
		<property name="name" value="Arequipa"></property>
	</bean>
