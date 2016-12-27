package busnet.entity;

import javax.persistence.*;

@Entity
public class Roles {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String role_name;

    public Roles(int id, String role_name) {
        this.id = id;
        this.role_name = role_name;
    }

    public Roles(String role_name) {
        this.role_name = role_name;
    }

    public Roles() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
