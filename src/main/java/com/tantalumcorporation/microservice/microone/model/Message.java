package com.tantalumcorporation.microservice.microone.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="message")
public class Message {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 3, max = 100, message = "Subject must be at least 3 characters.")
    @Column(name="subject")
    private String subject;

    @NotNull
    @Size(min = 3, message = "Message body must at least 3 characters.")
    @Column(name="body")
    private String body;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date")
    private Date modifyDate;

    public Date getCreateDate() {
        return createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public Message(@NotNull @Size(min = 3, max = 100, message = "Subject must be at least 3 characters.") String subject, @NotNull @Size(min = 3, message = "Message body must at least 3 characters.") String body) {
        this.subject = subject;
        this.body = body;
    }

    public Message(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
