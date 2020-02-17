package ru.sibdigital.difar.domain.classifier.agrc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.classifier.base.ClsBaseEntity;
import ru.sibdigital.difar.domain.document.DocActualYieldEntity;
import ru.sibdigital.difar.domain.document.DocRoutingEntity;
import ru.sibdigital.difar.domain.tableparts.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_crop", schema = "agrc")
public class ClsCropEntity extends ClsBaseEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted = false;
    private String number;
    private String code;
    private long id;
    private Collection<ClsCropVarietyEntity> clsCropVarietiesById;
    private Collection<DocActualYieldEntity> docActualYieldsById;
    private Collection<DocRoutingEntity> docRoutingsById;
    private Collection<TpPlantDiseaseAffectedCropEntity> tpPlantDiseaseAffectedCropsById;
    private Collection<TpPlantDiseaseDiseaseFeatureEntity> tpPlantDiseaseDiseaseFeaturesById;
    private Collection<TpPlantDiseasePeriodEntity> tpPlantDiseasePeriodsById;
    private Collection<TpPlantDiseasePlantOrganEntity> tpPlantDiseasePlantOrgansById;
    private Collection<TpPlantDiseaseTypicalAreaEntity> tpPlantDiseaseTypicalAreasById;
    private Collection<TpPlantPestAffectedCropEntity> tpPlantPestAffectedCropsById;
    private Collection<TpPlantPestPeriodEntity> tpPlantPestPeriodsById;
    private Collection<TpPlantPestPlantOrganEntity> tpPlantPestPlantOrgansById;
    private Collection<TpPlantPestTypicalAreaEntity> tpPlantPestTypicalAreasById;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public ClsCropEntity setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public ClsCropEntity setName(String name) {
        this.name = name;
        return this;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public ClsCropEntity setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public ClsCropEntity setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public ClsCropEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    @Basic
    @Column(name = "code", nullable = false, length = 64)
    public String getCode() {
        return code;
    }

    public ClsCropEntity setCode(String code) {
        this.code = code;
        return this;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "cls_crop_id_seq", schema = "agrc")
    public long getId() {
        return id;
    }

    public ClsCropEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsCropEntity that = (ClsCropEntity) o;

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

    @OneToMany(mappedBy = "clsCropByIdCrop")
    @JsonIgnore
    public Collection<ClsCropVarietyEntity> getClsCropVarietiesById() {
        return clsCropVarietiesById;
    }

    public ClsCropEntity setClsCropVarietiesById(Collection<ClsCropVarietyEntity> clsCropVarietiesById) {
        this.clsCropVarietiesById = clsCropVarietiesById;
        return this;
    }

    @OneToMany(mappedBy = "clsCropByIdCrop")
    @JsonIgnore
    public Collection<DocActualYieldEntity> getDocActualYieldsById() {
        return docActualYieldsById;
    }

    public ClsCropEntity setDocActualYieldsById(Collection<DocActualYieldEntity> docActualYieldsById) {
        this.docActualYieldsById = docActualYieldsById;
        return this;
    }

    @OneToMany(mappedBy = "clsCropByIdCrop")
    @JsonIgnore
    public Collection<DocRoutingEntity> getDocRoutingsById() {
        return docRoutingsById;
    }

    public ClsCropEntity setDocRoutingsById(Collection<DocRoutingEntity> docRoutingsById) {
        this.docRoutingsById = docRoutingsById;
        return this;
    }

    @OneToMany(mappedBy = "clsCropByIdCrop")
    @JsonIgnore
    public Collection<TpPlantDiseaseAffectedCropEntity> getTpPlantDiseaseAffectedCropsById() {
        return tpPlantDiseaseAffectedCropsById;
    }

    public ClsCropEntity setTpPlantDiseaseAffectedCropsById(Collection<TpPlantDiseaseAffectedCropEntity> tpPlantDiseaseAffectedCropsById) {
        this.tpPlantDiseaseAffectedCropsById = tpPlantDiseaseAffectedCropsById;
        return this;
    }

    @OneToMany(mappedBy = "clsCropByIdCrop")
    @JsonIgnore
    public Collection<TpPlantDiseaseDiseaseFeatureEntity> getTpPlantDiseaseDiseaseFeaturesById() {
        return tpPlantDiseaseDiseaseFeaturesById;
    }

    public ClsCropEntity setTpPlantDiseaseDiseaseFeaturesById(Collection<TpPlantDiseaseDiseaseFeatureEntity> tpPlantDiseaseDiseaseFeaturesById) {
        this.tpPlantDiseaseDiseaseFeaturesById = tpPlantDiseaseDiseaseFeaturesById;
        return this;
    }

    @OneToMany(mappedBy = "clsCropByIdCrop")
    @JsonIgnore
    public Collection<TpPlantDiseasePeriodEntity> getTpPlantDiseasePeriodsById() {
        return tpPlantDiseasePeriodsById;
    }

    public ClsCropEntity setTpPlantDiseasePeriodsById(Collection<TpPlantDiseasePeriodEntity> tpPlantDiseasePeriodsById) {
        this.tpPlantDiseasePeriodsById = tpPlantDiseasePeriodsById;
        return this;
    }

    @OneToMany(mappedBy = "clsCropByIdCrop")
    @JsonIgnore
    public Collection<TpPlantDiseasePlantOrganEntity> getTpPlantDiseasePlantOrgansById() {
        return tpPlantDiseasePlantOrgansById;
    }

    public ClsCropEntity setTpPlantDiseasePlantOrgansById(Collection<TpPlantDiseasePlantOrganEntity> tpPlantDiseasePlantOrgansById) {
        this.tpPlantDiseasePlantOrgansById = tpPlantDiseasePlantOrgansById;
        return this;
    }

    @OneToMany(mappedBy = "clsCropByIdCrop")
    @JsonIgnore
    public Collection<TpPlantDiseaseTypicalAreaEntity> getTpPlantDiseaseTypicalAreasById() {
        return tpPlantDiseaseTypicalAreasById;
    }

    public ClsCropEntity setTpPlantDiseaseTypicalAreasById(Collection<TpPlantDiseaseTypicalAreaEntity> tpPlantDiseaseTypicalAreasById) {
        this.tpPlantDiseaseTypicalAreasById = tpPlantDiseaseTypicalAreasById;
        return this;
    }

    @OneToMany(mappedBy = "clsCropByIdCrop")
    @JsonIgnore
    public Collection<TpPlantPestAffectedCropEntity> getTpPlantPestAffectedCropsById() {
        return tpPlantPestAffectedCropsById;
    }

    public ClsCropEntity setTpPlantPestAffectedCropsById(Collection<TpPlantPestAffectedCropEntity> tpPlantPestAffectedCropsById) {
        this.tpPlantPestAffectedCropsById = tpPlantPestAffectedCropsById;
        return this;
    }

    @OneToMany(mappedBy = "clsCropByIdCrop")
    @JsonIgnore
    public Collection<TpPlantPestPeriodEntity> getTpPlantPestPeriodsById() {
        return tpPlantPestPeriodsById;
    }

    public ClsCropEntity setTpPlantPestPeriodsById(Collection<TpPlantPestPeriodEntity> tpPlantPestPeriodsById) {
        this.tpPlantPestPeriodsById = tpPlantPestPeriodsById;
        return this;
    }

    @OneToMany(mappedBy = "clsCropByIdCrop")
    @JsonIgnore
    public Collection<TpPlantPestPlantOrganEntity> getTpPlantPestPlantOrgansById() {
        return tpPlantPestPlantOrgansById;
    }

    public ClsCropEntity setTpPlantPestPlantOrgansById(Collection<TpPlantPestPlantOrganEntity> tpPlantPestPlantOrgansById) {
        this.tpPlantPestPlantOrgansById = tpPlantPestPlantOrgansById;
        return this;
    }

    @OneToMany(mappedBy = "clsCropByIdCrop")
    @JsonIgnore
    public Collection<TpPlantPestTypicalAreaEntity> getTpPlantPestTypicalAreasById() {
        return tpPlantPestTypicalAreasById;
    }

    public ClsCropEntity setTpPlantPestTypicalAreasById(Collection<TpPlantPestTypicalAreaEntity> tpPlantPestTypicalAreasById) {
        this.tpPlantPestTypicalAreasById = tpPlantPestTypicalAreasById;
        return this;
    }
}
