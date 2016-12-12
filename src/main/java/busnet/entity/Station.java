package busnet.entity;

import javax.persistence.*;

@Entity
public class Station {
    public Station() {
    }

    public Station(String stationName) {
        this.stationName = stationName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "station_name")
    private String stationName;

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
