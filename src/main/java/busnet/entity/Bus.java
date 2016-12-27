package busnet.entity;


import javax.persistence.*;

@Entity
public class Bus {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String date;

    @Column
    private String time;

    @Column
    private int runnumber;

    @Column
    private int numberofpassengers;

    public Bus() {
    }

    public Bus(int id, String date, String time, int runnumber, int numberofpassengers) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.runnumber = runnumber;
        this.numberofpassengers = numberofpassengers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getRunnumber() {
        return runnumber;
    }

    public void setRunnumber(int runnumber) {
        this.runnumber = runnumber;
    }

    public int getNumberOfPassengers() {
        return numberofpassengers;
    }

    public void setNumberOfPassengers(int numberofpassengers) {
        this.numberofpassengers = numberofpassengers;
    }
}
