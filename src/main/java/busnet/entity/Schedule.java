package busnet.entity;

import javax.persistence.*;

@Entity
public class Schedule {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String station;

    @Column
    private String line;

    @Column
    private String time;

    @Column
    private int stationnumber;

    @Column
    private boolean direction;

    public Schedule() {
    }

    public Schedule(int id, String line, String station, String time, int stationnumber, boolean direction) {
        this.id = id;
        this.line = line;
        this.station = station;
        this.time = time;
        this.stationnumber = stationnumber;
        this.direction = direction;
    }

    public Schedule(int stationnumber) {
        this.stationnumber = stationnumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getStationnumber() {
        return stationnumber;
    }

    public void setStationnumber(int stationnumber) {
        this.stationnumber = stationnumber;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public boolean isDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }
}
