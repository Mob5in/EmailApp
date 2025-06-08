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

    public User(String name, String email, String password) {
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

    public void setName(String name) {
        if(name.isEmpty()){
            throw new NullPointerException("Name canot be empty");
        }
        this.name = name;
    }

    public String getEmail() {
        if(email.isEmpty()){
            throw new NullPointerException("email canot be empty");
        }
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword() throws Exception {
        if(email.length() <= 8){
            throw new Exception("Password is weak");
        }
        return password;
    }

    public void setPassword(String password) {
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