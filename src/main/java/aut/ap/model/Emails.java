package aut.ap.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Emails")
public class Emails{

    @Id
    @Column(name = "code", length = 6)
    private String code;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @Column(name = "subject", nullable = false, length = 255)
    private String subject;

    @Column(name = "body", nullable = false, columnDefinition = "TEXT")
    private String body;

    @Column(name = "sent_date", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime sentDate;

    // Constructor
    public Emails(){
        this.code = generateUniqueKey();
        this.sentDate = LocalDateTime.now();
    }

    public Emails(User sender, String subject, String body){
        this.code = generateUniqueKey();
        this.sentDate = LocalDateTime.now();
        setSender(sender);
        setBody(body);
        setSubject(subject);
    }



    // Generate 6-character unique code
    public static String generateUniqueKey() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().substring(0, 6);
    }

    // Getters and Setters
    public String getCode() {
        return code;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getSentDate() {
        return sentDate;
    }

    public void setSentDate(LocalDateTime sentDate) {
        this.sentDate = sentDate;
    }
}