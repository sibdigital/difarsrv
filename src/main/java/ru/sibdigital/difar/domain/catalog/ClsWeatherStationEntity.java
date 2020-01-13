package ru.sibdigital.difar.domain.catalog;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.sibdigital.difar.domain.register.RegWeatherStationReadingEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_weather_station", schema = "agrc")
@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
public class ClsWeatherStationEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private long id;
    private long idOrganization;
    private JsonNode description;
//    private Point point;
    private ClsOrganizationEntity clsOrganizationByIdOrganization;
    private Collection<RegWeatherStationReadingEntity> regWeatherStationReadingsById;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public void setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_organization", nullable = false, insertable = false, updatable = false)
    public long getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(long idOrganization) {
        this.idOrganization = idOrganization;
    }

    @Type(type = "jsonb-node")
    @Column(name = "description", nullable = true)
    public JsonNode getDescription() {
        return description;
    }

    public void setDescription(JsonNode description) {
        this.description = description;
    }

//    @Type(type="org.hibernate.spatial.GeometryType")
//    @Column(name = "point", nullable = true)
//    public Point getPoint() {
//        return point;
//    }
//
//    public void setPoint(Point point) {
//        this.point = point;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        ClsWeatherStationEntity that = (ClsWeatherStationEntity) o;
//
//        if (idUserCreator != that.idUserCreator) return false;
//        if (id != that.id) return false;
//        if (idOrganization != that.idOrganization) return false;
//        if (name != null ? !name.equals(that.name) : that.name != null) return false;
//        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
//        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
//        if (number != null ? !number.equals(that.number) : that.number != null) return false;
//        if (description != null ? !description.equals(that.description) : that.description != null) return false;
//        return point != null ? point.equals(that.point) : that.point == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
//        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
//        result = 31 * result + (number != null ? number.hashCode() : 0);
//        result = 31 * result + (int) (id ^ (id >>> 32));
//        result = 31 * result + (int) (idOrganization ^ (idOrganization >>> 32));
//        result = 31 * result + (description != null ? description.hashCode() : 0);
//        result = 31 * result + (point != null ? point.hashCode() : 0);
//        return result;
//    }

    @ManyToOne
    @JoinColumn(name = "id_organization", referencedColumnName = "id", nullable = false)
    public ClsOrganizationEntity getClsOrganizationByIdOrganization() {
        return clsOrganizationByIdOrganization;
    }

    public void setClsOrganizationByIdOrganization(ClsOrganizationEntity clsOrganizationByIdOrganization) {
        this.clsOrganizationByIdOrganization = clsOrganizationByIdOrganization;
    }

    @OneToMany(mappedBy = "clsWeatherStationByIdWeatherStation")
    @JsonIgnore
public Collection<RegWeatherStationReadingEntity> getRegWeatherStationReadingsById() {
        return regWeatherStationReadingsById;
    }

    public void setRegWeatherStationReadingsById(Collection<RegWeatherStationReadingEntity> regWeatherStationReadingsById) {
        this.regWeatherStationReadingsById = regWeatherStationReadingsById;
    }
}
