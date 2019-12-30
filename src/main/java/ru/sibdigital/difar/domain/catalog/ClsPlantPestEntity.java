package ru.sibdigital.difar.domain.catalog;

import ru.sibdigital.difar.domain.tableparts.TpPlantPestAffectedCropEntity;
import ru.sibdigital.difar.domain.tableparts.TpPlantPestPeriodEntity;
import ru.sibdigital.difar.domain.tableparts.TpPlantPestPlantOrganEntity;
import ru.sibdigital.difar.domain.tableparts.TpPlantPestTypicalAreaEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "cls_plant_pest", schema = "agrc")
public class ClsPlantPestEntity {
    private long idUserCreator;
    private String name;
    private Timestamp dateCreate;
    private Boolean isDeleted;
    private String number;
    private String code;
    private long id;
    private long idUnit;
    private Object photos;
    private Object additionalNames;
    private Object condition;
    private Object description;
    private Integer minIncubPeriod;
    private Integer maxIncubPeriod;
    private ClsUnitEntity clsUnitByIdUnit;
    private Collection<TpPlantPestAffectedCropEntity> tpPlantPestAffectedCropsById;
    private Collection<TpPlantPestPeriodEntity> tpPlantPestPeriodsById;
    private Collection<TpPlantPestPlantOrganEntity> tpPlantPestPlantOrgansById;
    private Collection<TpPlantPestTypicalAreaEntity> tpPlantPestTypicalAreasById;

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

    @Basic
    @Column(name = "date_create", nullable = true)
    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
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

    @Basic
    @Column(name = "code", nullable = false, length = 64)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    @Column(name = "id_unit", nullable = false)
    public long getIdUnit() {
        return idUnit;
    }

    public void setIdUnit(long idUnit) {
        this.idUnit = idUnit;
    }

    @Basic
    @Column(name = "photos", nullable = true)
    public Object getPhotos() {
        return photos;
    }

    public void setPhotos(Object photos) {
        this.photos = photos;
    }

    @Basic
    @Column(name = "additional_names", nullable = true)
    public Object getAdditionalNames() {
        return additionalNames;
    }

    public void setAdditionalNames(Object additionalNames) {
        this.additionalNames = additionalNames;
    }

    @Basic
    @Column(name = "condition", nullable = true)
    public Object getCondition() {
        return condition;
    }

    public void setCondition(Object condition) {
        this.condition = condition;
    }

    @Basic
    @Column(name = "description", nullable = true)
    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    @Basic
    @Column(name = "min_incub_period", nullable = true)
    public Integer getMinIncubPeriod() {
        return minIncubPeriod;
    }

    public void setMinIncubPeriod(Integer minIncubPeriod) {
        this.minIncubPeriod = minIncubPeriod;
    }

    @Basic
    @Column(name = "max_incub_period", nullable = true)
    public Integer getMaxIncubPeriod() {
        return maxIncubPeriod;
    }

    public void setMaxIncubPeriod(Integer maxIncubPeriod) {
        this.maxIncubPeriod = maxIncubPeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsPlantPestEntity that = (ClsPlantPestEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idUnit != that.idUnit) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (photos != null ? !photos.equals(that.photos) : that.photos != null) return false;
        if (additionalNames != null ? !additionalNames.equals(that.additionalNames) : that.additionalNames != null)
            return false;
        if (condition != null ? !condition.equals(that.condition) : that.condition != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (minIncubPeriod != null ? !minIncubPeriod.equals(that.minIncubPeriod) : that.minIncubPeriod != null)
            return false;
        return maxIncubPeriod != null ? maxIncubPeriod.equals(that.maxIncubPeriod) : that.maxIncubPeriod == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idUnit ^ (idUnit >>> 32));
        result = 31 * result + (photos != null ? photos.hashCode() : 0);
        result = 31 * result + (additionalNames != null ? additionalNames.hashCode() : 0);
        result = 31 * result + (condition != null ? condition.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (minIncubPeriod != null ? minIncubPeriod.hashCode() : 0);
        result = 31 * result + (maxIncubPeriod != null ? maxIncubPeriod.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_unit", referencedColumnName = "id", nullable = false)
    public ClsUnitEntity getClsUnitByIdUnit() {
        return clsUnitByIdUnit;
    }

    public void setClsUnitByIdUnit(ClsUnitEntity clsUnitByIdUnit) {
        this.clsUnitByIdUnit = clsUnitByIdUnit;
    }

    @OneToMany(mappedBy = "clsPlantPestByIdPlantPest")
    public Collection<TpPlantPestAffectedCropEntity> getTpPlantPestAffectedCropsById() {
        return tpPlantPestAffectedCropsById;
    }

    public void setTpPlantPestAffectedCropsById(Collection<TpPlantPestAffectedCropEntity> tpPlantPestAffectedCropsById) {
        this.tpPlantPestAffectedCropsById = tpPlantPestAffectedCropsById;
    }

    @OneToMany(mappedBy = "clsPlantPestByIdPlantPest")
    public Collection<TpPlantPestPeriodEntity> getTpPlantPestPeriodsById() {
        return tpPlantPestPeriodsById;
    }

    public void setTpPlantPestPeriodsById(Collection<TpPlantPestPeriodEntity> tpPlantPestPeriodsById) {
        this.tpPlantPestPeriodsById = tpPlantPestPeriodsById;
    }

    @OneToMany(mappedBy = "clsPlantPestByIdPlantPest")
    public Collection<TpPlantPestPlantOrganEntity> getTpPlantPestPlantOrgansById() {
        return tpPlantPestPlantOrgansById;
    }

    public void setTpPlantPestPlantOrgansById(Collection<TpPlantPestPlantOrganEntity> tpPlantPestPlantOrgansById) {
        this.tpPlantPestPlantOrgansById = tpPlantPestPlantOrgansById;
    }

    @OneToMany(mappedBy = "clsPlantPestByIdPlantPest")
    public Collection<TpPlantPestTypicalAreaEntity> getTpPlantPestTypicalAreasById() {
        return tpPlantPestTypicalAreasById;
    }

    public void setTpPlantPestTypicalAreasById(Collection<TpPlantPestTypicalAreaEntity> tpPlantPestTypicalAreasById) {
        this.tpPlantPestTypicalAreasById = tpPlantPestTypicalAreasById;
    }
}
