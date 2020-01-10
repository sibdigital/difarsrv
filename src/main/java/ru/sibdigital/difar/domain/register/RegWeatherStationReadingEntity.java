package ru.sibdigital.difar.domain.register;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.sibdigital.difar.domain.catalog.ClsOrganizationEntity;
import ru.sibdigital.difar.domain.catalog.ClsWeatherStationEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "reg_weather_station_reading", schema = "agrc")
@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
public class RegWeatherStationReadingEntity {
    private long idUserCreator;
    private Timestamp dateCreate;
    private Timestamp dateBegin;
    private Timestamp dateEnd;
    private long id;
    private long idWeatherStation;
    private long idOrganization;
    private Timestamp dateReg;
    private JsonNode composition;
    private BigDecimal temperature;
    private BigDecimal humidity;
    private ClsWeatherStationEntity clsWeatherStationByIdWeatherStation;
    private ClsOrganizationEntity clsOrganizationByIdOrganization;

    @Basic
    @Column(name = "id_user_creator", nullable = false, insertable = false, updatable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public void setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
    }

    @Basic
    @Column(name = "date_create", nullable = true)
    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Basic
    @Column(name = "date_begin", nullable = true)
    public Timestamp getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Timestamp dateBegin) {
        this.dateBegin = dateBegin;
    }

    @Basic
    @Column(name = "date_end", nullable = true)
    public Timestamp getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_weather_station", nullable = false, insertable = false, updatable = false)
    public long getIdWeatherStation() {
        return idWeatherStation;
    }

    public void setIdWeatherStation(long idWeatherStation) {
        this.idWeatherStation = idWeatherStation;
    }

    @Basic
    @Column(name = "id_organization", nullable = false, insertable = false, updatable = false)
    public long getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(long idOrganization) {
        this.idOrganization = idOrganization;
    }

    @Basic
    @Column(name = "date_reg", nullable = true)
    public Timestamp getDateReg() {
        return dateReg;
    }

    public void setDateReg(Timestamp dateReg) {
        this.dateReg = dateReg;
    }

    @Type(type = "jsonb-node")
    @Column(name = "composition", nullable = true)
    public JsonNode getComposition() {
        return composition;
    }

    public void setComposition(JsonNode composition) {
        this.composition = composition;
    }

    @Basic
    @Column(name = "temperature", nullable = true, precision = 5)
    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    @Basic
    @Column(name = "humidity", nullable = true, precision = 5)
    public BigDecimal getHumidity() {
        return humidity;
    }

    public void setHumidity(BigDecimal humidity) {
        this.humidity = humidity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegWeatherStationReadingEntity that = (RegWeatherStationReadingEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idWeatherStation != that.idWeatherStation) return false;
        if (idOrganization != that.idOrganization) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (dateBegin != null ? !dateBegin.equals(that.dateBegin) : that.dateBegin != null) return false;
        if (dateEnd != null ? !dateEnd.equals(that.dateEnd) : that.dateEnd != null) return false;
        if (dateReg != null ? !dateReg.equals(that.dateReg) : that.dateReg != null) return false;
        if (composition != null ? !composition.equals(that.composition) : that.composition != null) return false;
        if (temperature != null ? !temperature.equals(that.temperature) : that.temperature != null) return false;
        return humidity != null ? humidity.equals(that.humidity) : that.humidity == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (dateBegin != null ? dateBegin.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idWeatherStation ^ (idWeatherStation >>> 32));
        result = 31 * result + (int) (idOrganization ^ (idOrganization >>> 32));
        result = 31 * result + (dateReg != null ? dateReg.hashCode() : 0);
        result = 31 * result + (composition != null ? composition.hashCode() : 0);
        result = 31 * result + (temperature != null ? temperature.hashCode() : 0);
        result = 31 * result + (humidity != null ? humidity.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_weather_station", referencedColumnName = "id", nullable = false)
    public ClsWeatherStationEntity getClsWeatherStationByIdWeatherStation() {
        return clsWeatherStationByIdWeatherStation;
    }

    public void setClsWeatherStationByIdWeatherStation(ClsWeatherStationEntity clsWeatherStationByIdWeatherStation) {
        this.clsWeatherStationByIdWeatherStation = clsWeatherStationByIdWeatherStation;
    }

    @ManyToOne
    @JoinColumn(name = "id_organization", referencedColumnName = "id", nullable = false)
    public ClsOrganizationEntity getClsOrganizationByIdOrganization() {
        return clsOrganizationByIdOrganization;
    }

    public void setClsOrganizationByIdOrganization(ClsOrganizationEntity clsOrganizationByIdOrganization) {
        this.clsOrganizationByIdOrganization = clsOrganizationByIdOrganization;
    }
}
