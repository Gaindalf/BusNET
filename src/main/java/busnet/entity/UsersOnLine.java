package busnet.entity;

import javax.persistence.*;

@Entity
public class UsersOnLine {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String username;

    @Column
    private String date;

    @Column
    private int runnumber;

    public UsersOnLine(int id, String username, String date, int runnumber) {
        this.id = id;
        this.username = username;
        this.date = date;
        this.runnumber = runnumber;
    }

    public UsersOnLine(String username, String date, int runnumber) {
        this.username = username;
        this.date = date;
        this.runnumber = runnumber;
    }

    public UsersOnLine() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRunnumber() {
        return runnumber;
    }

    public void setRunnumber(int runnumber) {
        this.runnumber = runnumber;
    }

}
