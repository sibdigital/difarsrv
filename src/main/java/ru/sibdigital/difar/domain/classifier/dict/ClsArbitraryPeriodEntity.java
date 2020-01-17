package ru.sibdigital.difar.domain.classifier.dict;

import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.classifier.base.ClsBaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cls_arbitrary_period", schema = "dict")
public class ClsArbitraryPeriodEntity extends ClsBaseEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private long id;
    private long idStandardPeriod;
    private long idRegion;
    private long idDistrict;
    private long idOrganization;
    private Date dateBegin;
    private Date dateEnd;
    private ClsStandardPeriodEntity clsStandardPeriodByIdStandardPeriod;
    private ClsRegionEntity clsRegionByIdRegion;
    private ClsDistrictEntity clsDistrictByIdDistrict;
    private ClsOrganizationEntity clsOrganizationByIdOrganization;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public ClsArbitraryPeriodEntity setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public ClsArbitraryPeriodEntity setName(String name) {
        this.name = name;
        return this;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public ClsArbitraryPeriodEntity setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public ClsArbitraryPeriodEntity setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public ClsArbitraryPeriodEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "cls_arbitrary_period_id_seq", schema = "dict")
    public long getId() {
        return id;
    }

    public ClsArbitraryPeriodEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "id_standard_period", nullable = false, insertable = false, updatable = false)
    public long getIdStandardPeriod() {
        return idStandardPeriod;
    }

    public ClsArbitraryPeriodEntity setIdStandardPeriod(long idStandardPeriod) {
        this.idStandardPeriod = idStandardPeriod;
        return this;
    }

    @Basic
    @Column(name = "id_region", nullable = false, insertable = false, updatable = false)
    public long getIdRegion() {
        return idRegion;
    }

    public ClsArbitraryPeriodEntity setIdRegion(long idRegion) {
        this.idRegion = idRegion;
        return this;
    }

    @Basic
    @Column(name = "id_district", nullable = false, insertable = false, updatable = false)
    public long getIdDistrict() {
        return idDistrict;
    }

    public ClsArbitraryPeriodEntity setIdDistrict(long idDistrict) {
        this.idDistrict = idDistrict;
        return this;
    }

    @Basic
    @Column(name = "id_organization", nullable = false, insertable = false, updatable = false)
    public long getIdOrganization() {
        return idOrganization;
    }

    public ClsArbitraryPeriodEntity setIdOrganization(long idOrganization) {
        this.idOrganization = idOrganization;
        return this;
    }

    @Basic
    @Column(name = "date_begin", nullable = true)
    public Date getDateBegin() {
        return dateBegin;
    }

    public ClsArbitraryPeriodEntity setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
        return this;
    }

    @Basic
    @Column(name = "date_end", nullable = true)
    public Date getDateEnd() {
        return dateEnd;
    }

    public ClsArbitraryPeriodEntity setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsArbitraryPeriodEntity that = (ClsArbitraryPeriodEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idStandardPeriod != that.idStandardPeriod) return false;
        if (idRegion != that.idRegion) return false;
        if (idDistrict != that.idDistrict) return false;
        if (idOrganization != that.idOrganization) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (dateBegin != null ? !dateBegin.equals(that.dateBegin) : that.dateBegin != null) return false;
        return dateEnd != null ? dateEnd.equals(that.dateEnd) : that.dateEnd == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idStandardPeriod ^ (idStandardPeriod >>> 32));
        result = 31 * result + (int) (idRegion ^ (idRegion >>> 32));
        result = 31 * result + (int) (idDistrict ^ (idDistrict >>> 32));
        result = 31 * result + (int) (idOrganization ^ (idOrganization >>> 32));
        result = 31 * result + (dateBegin != null ? dateBegin.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_standard_period", referencedColumnName = "id", nullable = false)
    public ClsStandardPeriodEntity getClsStandardPeriodByIdStandardPeriod() {
        return clsStandardPeriodByIdStandardPeriod;
    }

    public ClsArbitraryPeriodEntity setClsStandardPeriodByIdStandardPeriod(ClsStandardPeriodEntity clsStandardPeriodByIdStandardPeriod) {
        this.clsStandardPeriodByIdStandardPeriod = clsStandardPeriodByIdStandardPeriod;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "id_region", referencedColumnName = "id", nullable = false)
    public ClsRegionEntity getClsRegionByIdRegion() {
        return clsRegionByIdRegion;
    }

    public ClsArbitraryPeriodEntity setClsRegionByIdRegion(ClsRegionEntity clsRegionByIdRegion) {
        this.clsRegionByIdRegion = clsRegionByIdRegion;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "id_district", referencedColumnName = "id", nullable = false)
    public ClsDistrictEntity getClsDistrictByIdDistrict() {
        return clsDistrictByIdDistrict;
    }

    public ClsArbitraryPeriodEntity setClsDistrictByIdDistrict(ClsDistrictEntity clsDistrictByIdDistrict) {
        this.clsDistrictByIdDistrict = clsDistrictByIdDistrict;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "id_organization", referencedColumnName = "id", nullable = false)
    public ClsOrganizationEntity getClsOrganizationByIdOrganization() {
        return clsOrganizationByIdOrganization;
    }

    public ClsArbitraryPeriodEntity setClsOrganizationByIdOrganization(ClsOrganizationEntity clsOrganizationByIdOrganization) {
        this.clsOrganizationByIdOrganization = clsOrganizationByIdOrganization;
        return this;
    }
}
