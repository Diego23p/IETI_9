package eci.ieti;

import eci.ieti.data.CustomerRepository;
import eci.ieti.data.ProductRepository;
import eci.ieti.data.TodoRepository;
import eci.ieti.data.UserRepository;
import eci.ieti.data.model.Customer;
import eci.ieti.data.model.Product;
import eci.ieti.data.model.Todo;
import eci.ieti.data.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private TodoRepository todoRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //-----------------------Customer------------------
        /*
        customerRepository.deleteAll();

        customerRepository.save(new Customer("Alice", "Smith"));
        customerRepository.save(new Customer("Bob", "Marley"));
        customerRepository.save(new Customer("Jimmy", "Page"));
        customerRepository.save(new Customer("Freddy", "Mercury"));
        customerRepository.save(new Customer("Michael", "Jackson"));

        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        
        customerRepository.findAll().stream().forEach(System.out::println);
        System.out.println();
        */
        //-----------------------Product------------------
        /*
        productRepository.deleteAll();

        productRepository.save(new Product(1L, "Samsung S8", "All new mobile phone Samsung S8"));
        productRepository.save(new Product(2L, "Samsung S8 plus", "All new mobile phone Samsung S8 plus"));
        productRepository.save(new Product(3L, "Samsung S9", "All new mobile phone Samsung S9"));
        productRepository.save(new Product(4L, "Samsung S9 plus", "All new mobile phone Samsung S9 plus"));
        productRepository.save(new Product(5L, "Samsung S10", "All new mobile phone Samsung S10"));
        productRepository.save(new Product(6L, "Samsung S10 plus", "All new mobile phone Samsung S10 plus"));
        productRepository.save(new Product(7L, "Samsung S20", "All new mobile phone Samsung S20"));
        productRepository.save(new Product(8L, "Samsung S20 plus", "All new mobile phone Samsung S20 plus"));
        productRepository.save(new Product(9L, "Samsung S20 ultra", "All new mobile phone Samsung S20 ultra"));
        
        System.out.println("Paginated search of products by criteria:");
        System.out.println("-------------------------------");
        
        productRepository.findByDescriptionContaining("plus", PageRequest.of(0, 2)).stream()
        	.forEach(System.out::println);
   
        System.out.println();
        */
        //-----------------------Todo------------------
        /*
        todoRepository.deleteAll();
        
        todoRepository.save(new Todo("travel to Galapagos",10, new Date(System.currentTimeMillis()+1000000000),"charles@natural.com","pending"));
        todoRepository.save(new Todo("travel to Malvinas",4,new Date(System.currentTimeMillis()-1000000000),"charles@natural.com","pending"));
        todoRepository.save(new Todo("go to Galapagos",7,new Date(System.currentTimeMillis()+1000000000),"christobal@natural.com","pending"));
        todoRepository.save(new Todo("go to Malvinas",9,new Date(System.currentTimeMillis()-1000000000),"charles@natural.com","pending"));
        todoRepository.save(new Todo("travel to Bermudas",3,new Date(System.currentTimeMillis()+1000000000),"charles@natural.com","pending"));

        todoRepository.save(new Todo("Read Galapagos",10,new Date(System.currentTimeMillis()-1000000000),"Darwin@natural.com","pending"));
        todoRepository.save(new Todo("Write to Malvinas",4,new Date(System.currentTimeMillis()+1000000000),"Darwin@natural.com","pending"));
        todoRepository.save(new Todo("Read book Galapagos",7,new Date(System.currentTimeMillis()-1000000000),"christobal@natural.com","pending"));
        todoRepository.save(new Todo("Write book Malvinas",9,new Date(System.currentTimeMillis()+1000000000),"Darwin@natural.com","pending"));
        todoRepository.save(new Todo("Discover Bermudas",3,new Date(System.currentTimeMillis()+1000000000),"Darwin@natural.com","pending"));

        todoRepository.save(new Todo("Find Galapagos",1,new Date(System.currentTimeMillis()-1000000000),"Darwin@natural.com","pending"));
        todoRepository.save(new Todo("Find Malvinas",2,new Date(System.currentTimeMillis()+1000000000),"charles@natural.com","pending"));
        todoRepository.save(new Todo("Draw Galapagos",3,new Date(System.currentTimeMillis()-1000000000),"Darwin@natural.com","pending"));
        todoRepository.save(new Todo("Draw Malvinas",4,new Date(System.currentTimeMillis()+1000000000),"charles@natural.com","pending"));
        todoRepository.save(new Todo("Paint Bermudas",5,new Date(System.currentTimeMillis()-1000000000),"Darwin@natural.com","pending"));

        todoRepository.save(new Todo("Paint Galapagos",6,new Date(System.currentTimeMillis()+1000000000),"Darwin@natural.com","pending"));
        todoRepository.save(new Todo("Paint Malvinas",7,new Date(System.currentTimeMillis()-1000000000),"Darwin@natural.com","pending"));
        todoRepository.save(new Todo("Share Galapagos",8,new Date(System.currentTimeMillis()+1000000000),"christobal@natural.com","pending"));
        todoRepository.save(new Todo("Share Malvinas",9,new Date(System.currentTimeMillis()-1000000000),"charles@natural.com","pending"));
        todoRepository.save(new Todo("Share travel to Bermudas",10,new Date(System.currentTimeMillis()+1000000000),"Darwin@natural.com","pending"));

        todoRepository.save(new Todo("Share travel to Galapagos",10,new Date(System.currentTimeMillis()+1000000000),"Darwin@natural.com","pending"));
        todoRepository.save(new Todo("Share travel to Malvinas",4,new Date(System.currentTimeMillis()-1000000000),"charles@natural.com","pending"));
        todoRepository.save(new Todo("Go back Galapagos",7,new Date(System.currentTimeMillis()+1000000000),"Darwin@natural.com","pending"));
        todoRepository.save(new Todo("Go back Malvinas",9,new Date(System.currentTimeMillis()-1000000000),"charles@natural.com","pending"));
        todoRepository.save(new Todo("Go back Bermudas and Go back Malvinas and share it",3,new Date(System.currentTimeMillis()+1000000000),"charles@Darwin.com","pending"));
        */


        /*
        System.out.println("Paginated search of Todo by responsible:");
        System.out.println("-------------------------------");
        
        todoRepository.findByResponsible("charles@natural.com", PageRequest.of(0, 3)).stream()
        	.forEach(System.out::println);
        
        System.out.println();
        */


        //-----------------------Users------------------

        /*
        userRepository.deleteAll();

        userRepository.save(new User("123450","Charles Darwin","charles@natural.com"));
        userRepository.save(new User("123451","Darwin","Darwin@natural.com"));
        userRepository.save(new User("123452","christobal","christobal@natural.com"));
        userRepository.save(new User("123453","Jose","jose@natural.com"));
        userRepository.save(new User("123454","Isabel","isabel@natural.com"));
        userRepository.save(new User("123455","Newton","Newton@natural.com"));
        userRepository.save(new User("123456","Kennedy","kennedy@natural.com"));
        userRepository.save(new User("123457","Jackson","jackson@natural.com"));
        userRepository.save(new User("123458","Diego","diego@natural.com"));
        userRepository.save(new User("123459","Colon","colon@natural.com"));
        */

        //-----------------------Custom Querries------------------

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");

        //-----------------------Querry 1------------------

        Query query1 = new Query();
        query1.addCriteria(Criteria.where("dueDate").lt(new Date()));

        List<Todo> todos1 = mongoOperation.find(query1, Todo.class);

        System.out.println("Search of Todos that dueDate has expired:");
        System.out.println("Query: "+query1.toString());
        System.out.println("-------------------------------");

        for (Todo todo : todos1) {
            System.out.println(todo.toString());
        }
        System.out.println();

        //-----------------------Querry 2------------------

        Query query = new Query();
        query.addCriteria(Criteria.where("responsible").is("Darwin@natural.com").and("priority").gt(4));

        List<Todo> todos = mongoOperation.find(query, Todo.class);

        System.out.println("Search of Todos that are assigned to \"Darwin@natural.com\" and have priority greater equal to 5:");
        System.out.println("Query: "+query.toString());
        System.out.println("-------------------------------");

        for (Todo todo : todos) {
            System.out.println(todo.toString());
        }
        System.out.println();


        //-----------------------Querry 3------------------

        Query allUsers = new Query();
        List<User> users = mongoOperation.find(allUsers, User.class);

        Query queryAllTodos = new Query();
        List<Todo> allTodos = mongoOperation.find(queryAllTodos, Todo.class);

        List<User> listWhitMoreThan2Todos = new ArrayList<>();

        for (User user : users) {
            int count = 0;
            for (Todo todo : allTodos) {
                if (todo.getResponsible().equals(user.getEmail())){
                    count += 1;
                }
            }
            if (count>2){
                listWhitMoreThan2Todos.add(user);
            }
        }

        System.out.println("Users with more than 2 Todos:");
        System.out.println("-------------------------------");
        for (User user : listWhitMoreThan2Todos) {
            System.out.println(user.toString());
        }
        System.out.println();

        //-----------------------Querry 4------------------

        Query query4 = new Query();
        query4.addCriteria(Criteria.where("description").regex("[a-z,A-Z,0-9, ' ', ]{30,}"));
        List<Todo> largeDescription = mongoOperation.find(query4, Todo.class);

        System.out.println("Todos whit description with a length of 30 characters or more:");
        System.out.println("Query: "+query4.toString());
        System.out.println("-------------------------------");
        for (Todo todo : largeDescription) {
            System.out.println(todo.toString());
        }
        System.out.println();

    }

}