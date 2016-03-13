package co.edu.mobile.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "FILES")
@Data
public class SharedFile
{
    @Id
    @Column(name = "FILE_ID")
    @GeneratedValue
    private long id;

    @Lob
    @JsonIgnore
    @Column(name = "DATA_LOB")
    private byte[] data;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CONTENT_TYPE")
    private String contentType;

    @Column(name = "USER_ID_FROM")
    private long from;

    @Column(name = "USER_ID_TO")
    private long to;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "F_DATE")
    private Date date;
}
