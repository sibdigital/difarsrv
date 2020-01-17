package ru.sibdigital.difar.domain.classifier.agrc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.classifier.base.ClsBaseEntity;
import ru.sibdigital.difar.domain.tableparts.TpPlantDiseaseAffectedCropEntity;
import ru.sibdigital.difar.domain.tableparts.TpPlantDiseasePeriodEntity;
import ru.sibdigital.difar.domain.tableparts.TpPlantPestAffectedCropEntity;
import ru.sibdigital.difar.domain.tableparts.TpPlantPestPeriodEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_veget_period", schema = "agrc")
public class ClsVegetPeriodEntity extends ClsBaseEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private String code;
    private long id;
    private Collection<TpPlantDiseaseAffectedCropEntity> tpPlantDiseaseAffectedCropsById;
    private Collection<TpPlantDiseasePeriodEntity> tpPlantDiseasePeriodsById;
    private Collection<TpPlantPestAffectedCropEntity> tpPlantPestAffectedCropsById;
    private Collection<TpPlantPestPeriodEntity> tpPlantPestPeriodsById;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public ClsVegetPeriodEntity setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public ClsVegetPeriodEntity setName(String name) {
        this.name = name;
        return this;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public ClsVegetPeriodEntity setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public ClsVegetPeriodEntity setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public ClsVegetPeriodEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    @Basic
    @Column(name = "code", nullable = false, length = 64)
    public String getCode() {
        return code;
    }

    public ClsVegetPeriodEntity setCode(String code) {
        this.code = code;
        return this;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "cls_veget_period_id_seq", schema = "agrc")
    public long getId() {
        return id;
    }

    public ClsVegetPeriodEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsVegetPeriodEntity that = (ClsVegetPeriodEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        return code != null ? code.equals(that.code) : that.code == null;
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
        return result;
    }

    @OneToMany(mappedBy = "clsVegetPeriodByIdVegetPeriod")
    @JsonIgnore
    public Collection<TpPlantDiseaseAffectedCropEntity> getTpPlantDiseaseAffectedCropsById() {
        return tpPlantDiseaseAffectedCropsById;
    }

    public ClsVegetPeriodEntity setTpPlantDiseaseAffectedCropsById(Collection<TpPlantDiseaseAffectedCropEntity> tpPlantDiseaseAffectedCropsById) {
        this.tpPlantDiseaseAffectedCropsById = tpPlantDiseaseAffectedCropsById;
        return this;
    }

    @OneToMany(mappedBy = "clsVegetPeriodByIdVegetPeriod")
    @JsonIgnore
    public Collection<TpPlantDiseasePeriodEntity> getTpPlantDiseasePeriodsById() {
        return tpPlantDiseasePeriodsById;
    }

    public ClsVegetPeriodEntity setTpPlantDiseasePeriodsById(Collection<TpPlantDiseasePeriodEntity> tpPlantDiseasePeriodsById) {
        this.tpPlantDiseasePeriodsById = tpPlantDiseasePeriodsById;
        return this;
    }

    @OneToMany(mappedBy = "clsVegetPeriodByIdVegetPeriod")
    @JsonIgnore
    public Collection<TpPlantPestAffectedCropEntity> getTpPlantPestAffectedCropsById() {
        return tpPlantPestAffectedCropsById;
    }

    public ClsVegetPeriodEntity setTpPlantPestAffectedCropsById(Collection<TpPlantPestAffectedCropEntity> tpPlantPestAffectedCropsById) {
        this.tpPlantPestAffectedCropsById = tpPlantPestAffectedCropsById;
        return this;
    }

    @OneToMany(mappedBy = "clsVegetPeriodByIdVegetPeriod")
    @JsonIgnore
    public Collection<TpPlantPestPeriodEntity> getTpPlantPestPeriodsById() {
        return tpPlantPestPeriodsById;
    }

    public ClsVegetPeriodEntity setTpPlantPestPeriodsById(Collection<TpPlantPestPeriodEntity> tpPlantPestPeriodsById) {
        this.tpPlantPestPeriodsById = tpPlantPestPeriodsById;
        return this;
    }
}
