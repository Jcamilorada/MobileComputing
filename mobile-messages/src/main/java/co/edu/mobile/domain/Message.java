package co.edu.mobile.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "MESSAGES")
@Data
public class Message
{
    @Id
    @Column(name = "MESSAGE_ID")
    @GeneratedValue
    private long id;

    @Column(name = "USER_FROM")
    private long from;

    @Column(name = "USER_TO")
    private long to;

    @Column(name = "MESSAGE_TEXT", length=500)
    private String text;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "M_DATE")
    private Date date;
}
