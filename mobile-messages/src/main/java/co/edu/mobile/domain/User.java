package co.edu.mobile.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "USERS")
@Data
public class User
{
    @Id
    @Column(name = "USER_ID")
    private long userId;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "NAME")
    private String nombre;

    @JoinTable(name = "CONTACTS",
        joinColumns = {@JoinColumn(name = "UserId", referencedColumnName = "USER_ID", nullable = false)},
        inverseJoinColumns = {@JoinColumn(name = "ContactId", referencedColumnName = "USER_ID", nullable = false)})
    @ManyToMany
    @JsonIgnore
    private Collection<User> contacts;
}
