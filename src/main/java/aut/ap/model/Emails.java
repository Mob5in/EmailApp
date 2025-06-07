package aut.ap.model;
import aut.ap.model.EmailRecipient;


import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Emails")
public class Emails {
    @Id
    @Column(name = "code", length = 6)
    private String code;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    private String subject;
    private String body;

    @Column(name = "sent_date", updatable = false, insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDate;

    @OneToMany(mappedBy = "email", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EmailRecipient> recipients = new HashSet<>();

    public Emails() {}

    public Emails(String code, User sender, String subject, String body) {
        this.code = code;
        this.sender = sender;
        this.subject = subject;
        this.body = body;
    }

    // Getters and Setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public Set<EmailRecipient> getRecipients() {
        return recipients;
    }

    public void addRecipient(EmailRecipient recipient) {
        recipients.add(recipient);
        recipient.setEmail(this);
    }

    public void removeRecipient(EmailRecipient recipient) {
        recipients.remove(recipient);
        recipient.setEmail(null);
    }

    @Override
    public String toString() {
        return "Email{" +
                "code='" + code + '\'' +
                ", subject='" + subject + '\'' +
                ", sentDate=" + sentDate +
                '}';
    }
}