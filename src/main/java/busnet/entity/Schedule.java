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
    private String transferstation;

    @Column
    private int stationnumber;

    public Schedule() {
    }

    public Schedule(int id, String station, String line, String time, String transferstation, int stationnumber) {
        this.id = id;
        this.station = station;
        this.line = line;
        this.time = time;
        this.transferstation = transferstation;
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

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTransferstation() {
        return transferstation;
    }

    public void setTransferstation(String transferstation) {
        this.transferstation = transferstation;
    }

    public int getStationnumber() {
        return stationnumber;
    }

    public void setStationnumber(int stationnumber) {
        this.stationnumber = stationnumber;
    }
}
