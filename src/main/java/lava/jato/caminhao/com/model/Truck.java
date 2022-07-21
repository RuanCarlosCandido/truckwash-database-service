package lava.jato.caminhao.com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.*;

@Entity
@Table(name = "trucks")
public class Truck implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    //it can be null, mainly, when updating a truck
    @Column(name = "truck_plate")
	@JsonProperty("truck_plate")
    private String truckPlate;

    @Column(name = "truck_company")
	@JsonProperty("truck_company")
    private String truckCompany;

    @Column(name = "last_wash")
	@JsonProperty("last_wash")
    private Timestamp lastWash;

    @Column(name = "next_wash")
	@JsonProperty("next_wash")
    private Timestamp nextWash;

    @Column(name = "driver_name")
	@JsonProperty("driver_name")
    private String driverName;

    public Truck() {

    }

    public Truck(Integer ID, String truckPlate, String truckCompany, Timestamp lastWash, Timestamp nextWash, String driverName) {
        this.ID = ID;
        this.truckPlate = truckPlate;
        this.truckCompany = truckCompany;
        this.lastWash = lastWash;
        this.nextWash = nextWash;
        this.driverName = driverName;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTruckPlate() {
        return truckPlate;
    }

    public void setTruckPlate(String truckPlate) {
        this.truckPlate = truckPlate;
    }

    public String getTruckCompany() {
        return truckCompany;
    }

    public void setTruckCompany(String truckCompany) {
        this.truckCompany = truckCompany;
    }

    public Timestamp getLastWash() {
        return lastWash;
    }

    public void setLastWash(Timestamp lastWash) {
        this.lastWash = lastWash;
    }

    public Timestamp getNextWash() {
        return nextWash;
    }

    public void setNextWash(Timestamp nextWash) {
        this.nextWash = nextWash;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
}
