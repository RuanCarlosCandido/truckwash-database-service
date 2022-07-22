package lava.jato.caminhao.com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "invoicing")
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    @Column(name = "truck_plate")
	@JsonProperty("truck_plate")
    private String truckPlate;

    @Column(name = "wash_date")
	@JsonProperty("wash_date")
    private Timestamp washDate;

    @Column(name = "value")
	@JsonProperty("value")
    private BigDecimal value;

    public Invoice() {

    }

    public Invoice(Integer ID, String truckPlate, Timestamp washDate, BigDecimal value) {
        this.ID = ID;
        this.truckPlate = truckPlate;
        this.washDate = washDate;
        this.value = value;
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

    public Timestamp getWashDate() {
        return washDate;
    }

    public void setWashDate(Timestamp washDate) {
        this.washDate = washDate;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
