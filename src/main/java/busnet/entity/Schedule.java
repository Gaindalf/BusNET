package busnet.entity;

import javax.persistence.*;

@Entity
public class Schedule {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "station_id")
    private String stationId;

    @Column(name = "bus_number")
    private String busNumber;

    @Column
    private String time;

    public Schedule() {
    }

    public Schedule(int id, String stationId, String busNumber, String time) {
        this.id = id;
        this.stationId = stationId;
        this.busNumber = busNumber;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
