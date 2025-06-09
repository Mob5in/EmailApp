package aut.ap.model;
import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "email", length = 255, unique = true, nullable = false)
    private String email;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    // Constructors
    public User() {}

    public User(String name, String email, String password) throws Exception {
        setName(name);
        setEmail(email);
        setPassword(password);
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if(name.isEmpty()){
            throw new Exception("Name canot be empty");
        }
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) throws Exception {
        if(email.isEmpty()){
            throw new Exception("email canot be empty");
        }
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) throws Exception {
        if(password.length() <= 8){
            System.out.println("it is weak");
            throw new Exception("Password is weak");
        }
        this.password = password;
    }

    // toString method
    @Override
    public String toString() {
        return "User\n" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'';
    }
}