package busnet.entity;

import javax.persistence.*;

@Entity
public class Stations {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    public Stations(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Stations(String name) {
        this.name = name;
    }

    public Stations() {
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
