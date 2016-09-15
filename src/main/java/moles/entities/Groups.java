package moles.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by moles on 25.07.2016.
 */
@Entity
@Table(name = "groups")
@SequenceGenerator(name = "groups_seq", sequenceName = "groups_id_seq")
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "groups_seq")
    private int id;
    @Column(name = "name", length = 64)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "groups_roles",
            joinColumns = {@JoinColumn(name = "group_id")},
            inverseJoinColumns = {@JoinColumn(name = "roles_id")})
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
