Coverage: 57%
# Inventory Management System

This is my Inventory Management System project. Which showcases the skills I have managed to gain during the last 5 weeks training with QA Academy.
The language used to write up the program was Java, along with storing and creating the Database in MYSQL which was later connected and transported 
into Java. The IMS allows users to perform a basic CRUD functionality. The system accepts orders which are made and then gives them an Items ID, Quantitiy and the Total cost.

## Getting Started

These instructions will get you a copy of the project up These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.
See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

	Java
	Git Bash
	Eclipse 
	Maven
	Jira
	MySQL workbench

### Installing

1. Clone the project using the repo
2. Install it using the code: cd .... then mvn java -jar
3. Open the project in Eclipse 

Once you have made the CRUD functualities and the application is fully functional you can manipulate the database, by selecting a table to perform operations on. 
Then select the operations you wish to make. 

	db.url=jdbc:mysql://localhost:3306/inventoryManagementSystems?serverTimezone=UTC
	db.user=root
	db.password=Tuffyahmed98

## Running the tests

In order to run the tests on your system, you must fork the repo then clone it onto your own github repo. Then you must clone the repo into you local git repo. To clone the repo you must use the following command in your local git bash:

	git clone https://github.com/Tufayel98/IMS-Project

### Unit Tests 

Explain what these tests test, why and how to run them

	@Test
	public void settersTest() {
		assertNotNull(item.getId());
		assertNotNull(item.getItemName());
		assertNotNull(item.getPrice());
	
	item.setId(null);
	assertNull(item.getId());
	item.setItemName(null);
	assertNull(item.getItemName());
	item.setPrice(null);
	assertNull(item.getPrice());	
}

### Integration Tests 
Integration testing is the phase in software testing in which individual software modules are combined and tested as a group. This is to see how the classes interact with one another. Intergration testing is conducted to evaluate the compliance of a system or component with specified functional requirements. This occurs after unit testing and before system testing.

Here is an example of how my integration tests look for my item classes:

	@Test
	public void testReadAll() {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1L, "jordan", "harrison"));

		Mockito.when(dao.readAll()).thenReturn(customers);

		assertEquals(customers, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}


## Deployment

In order to deploy the project connect it to the Database from the MySQL database. You will need to use your personal login information as I have already shown above in the 'Installing' header. After you have logged into your MySQL, to set up your database on MySQL, you must run the following:

	DROP DATABASE IF EXISTS inventoryManagementSystems;
	CREATE DATABASE IF NOT EXISTS inventoryManagementSystems;
	USE inventoryManagementSystems;

	CREATE TABLE customers (
    id int AUTO_INCREMENT,
    first_name varchar(40),
    surname varchar(40),
    PRIMARY KEY (id)
    );

	CREATE TABLE items (
    id INT AUTO_INCREMENT,
    item_name varchar(40),
    price decimal(9,3),
    PRIMARY KEY (id)
    );
    
	CREATE TABLE orders (
    id int AUTO_INCREMENT,
    customer_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) 
        REFERENCES customers(id)
    );

	CREATE TABLE order_items (
    id INT AUTO_INCREMENT,
    customer_id INT,
	 order_id INT,
		quantity INT,
	 PRIMARY KEY (id),
	  FOREIGN KEY (order_id)
	        REFERENCES orders(id),
		FOREIGN KEY (customer_id)
	        REFERENCES customers(id)
		);

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We used git version control

## Authors
	
	Chris Perrins - Initial work - christophperrins
	Mohammed Tufayel Ahmed
	
## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
