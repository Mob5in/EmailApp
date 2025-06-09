package aut.ap.model;
import jakarta.persistence.*;
import aut.ap.model.Emails;


@Entity
@Table(name = "Email_recipients")
public class EmailRecipient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "email_code", referencedColumnName = "code")
    private Emails email;

    @ManyToOne
    @JoinColumn(name = "recipient_id", referencedColumnName = "id")
    private User recipient;

    @Column(name = "is_read", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isRead;

    // Constructors
    public EmailRecipient() {
        this.isRead = false;
    }

    public EmailRecipient(Emails email, User recipient) {
        this.isRead = false;
        this.email = email;
        this.recipient = recipient;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public Emails getEmail() {
        return email;
    }

    public void setEmail(Emails email) {
        this.email = email;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}