package ru.sibdigital.difar.domain.classifier.agrc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.sibdigital.difar.domain.classifier.base.ClsBaseEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsUnitEntity;
import ru.sibdigital.difar.domain.tableparts.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_plant_disease", schema = "agrc")
@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
public class ClsPlantDiseaseEntity extends ClsBaseEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private String code;
    private long id;
    private long idUnit;
    private JsonNode symptom;
    private JsonNode cause;
    private JsonNode harmfulness;
    private JsonNode photos;
    private JsonNode additionalNames;
    private JsonNode condition;
    private Integer minIncubPeriod;
    private Integer maxIncubPeriod;
    private ClsUnitEntity clsUnitByIdUnit;
    private Collection<TpPlantDiseaseAffectedCropEntity> tpPlantDiseaseAffectedCropsById;
    private Collection<TpPlantDiseaseDiseaseFeatureEntity> tpPlantDiseaseDiseaseFeaturesById;
    private Collection<TpPlantDiseasePeriodEntity> tpPlantDiseasePeriodsById;
    private Collection<TpPlantDiseasePlantOrganEntity> tpPlantDiseasePlantOrgansById;
    private Collection<TpPlantDiseaseTypicalAreaEntity> tpPlantDiseaseTypicalAreasById;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public ClsPlantDiseaseEntity setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public ClsPlantDiseaseEntity setName(String name) {
        this.name = name;
        return this;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public ClsPlantDiseaseEntity setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public ClsPlantDiseaseEntity setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public ClsPlantDiseaseEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    @Basic
    @Column(name = "code", nullable = false, length = 64)
    public String getCode() {
        return code;
    }

    public ClsPlantDiseaseEntity setCode(String code) {
        this.code = code;
        return this;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "cls_plant_disease_id_seq", schema = "agrc")
    public long getId() {
        return id;
    }

    public ClsPlantDiseaseEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "id_unit", nullable = false, insertable = false, updatable = false)
    public long getIdUnit() {
        return idUnit;
    }

    public ClsPlantDiseaseEntity setIdUnit(long idUnit) {
        this.idUnit = idUnit;
        return this;
    }

    @Type(type = "jsonb-node")
    @Column(name = "symptom", nullable = true)
    public JsonNode getSymptom() {
        return symptom;
    }

    public ClsPlantDiseaseEntity setSymptom(JsonNode symptom) {
        this.symptom = symptom;
        return this;
    }

    @Type(type = "jsonb-node")
    @Column(name = "cause", nullable = true)
    public JsonNode getCause() {
        return cause;
    }

    public ClsPlantDiseaseEntity setCause(JsonNode cause) {
        this.cause = cause;
        return this;
    }

    @Type(type = "jsonb-node")
    @Column(name = "harmfulness", nullable = true)
    public JsonNode getHarmfulness() {
        return harmfulness;
    }

    public ClsPlantDiseaseEntity setHarmfulness(JsonNode harmfulness) {
        this.harmfulness = harmfulness;
        return this;
    }

    @Type(type = "jsonb-node")
    @Column(name = "photos", nullable = true)
    public JsonNode getPhotos() {
        return photos;
    }

    public ClsPlantDiseaseEntity setPhotos(JsonNode photos) {
        this.photos = photos;
        return this;
    }

    @Type(type = "jsonb-node")
    @Column(name = "additional_names", nullable = true)
    public JsonNode getAdditionalNames() {
        return additionalNames;
    }

    public ClsPlantDiseaseEntity setAdditionalNames(JsonNode additionalNames) {
        this.additionalNames = additionalNames;
        return this;
    }

    @Type(type = "jsonb-node")
    @Column(name = "condition", nullable = true)
    public JsonNode getCondition() {
        return condition;
    }

    public ClsPlantDiseaseEntity setCondition(JsonNode condition) {
        this.condition = condition;
        return this;
    }

    @Basic
    @Column(name = "min_incub_period", nullable = true)
    public Integer getMinIncubPeriod() {
        return minIncubPeriod;
    }

    public ClsPlantDiseaseEntity setMinIncubPeriod(Integer minIncubPeriod) {
        this.minIncubPeriod = minIncubPeriod;
        return this;
    }

    @Basic
    @Column(name = "max_incub_period", nullable = true)
    public Integer getMaxIncubPeriod() {
        return maxIncubPeriod;
    }

    public ClsPlantDiseaseEntity setMaxIncubPeriod(Integer maxIncubPeriod) {
        this.maxIncubPeriod = maxIncubPeriod;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsPlantDiseaseEntity that = (ClsPlantDiseaseEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idUnit != that.idUnit) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (symptom != null ? !symptom.equals(that.symptom) : that.symptom != null) return false;
        if (cause != null ? !cause.equals(that.cause) : that.cause != null) return false;
        if (harmfulness != null ? !harmfulness.equals(that.harmfulness) : that.harmfulness != null) return false;
        if (photos != null ? !photos.equals(that.photos) : that.photos != null) return false;
        if (additionalNames != null ? !additionalNames.equals(that.additionalNames) : that.additionalNames != null)
            return false;
        if (condition != null ? !condition.equals(that.condition) : that.condition != null) return false;
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
        result = 31 * result + (symptom != null ? symptom.hashCode() : 0);
        result = 31 * result + (cause != null ? cause.hashCode() : 0);
        result = 31 * result + (harmfulness != null ? harmfulness.hashCode() : 0);
        result = 31 * result + (photos != null ? photos.hashCode() : 0);
        result = 31 * result + (additionalNames != null ? additionalNames.hashCode() : 0);
        result = 31 * result + (condition != null ? condition.hashCode() : 0);
        result = 31 * result + (minIncubPeriod != null ? minIncubPeriod.hashCode() : 0);
        result = 31 * result + (maxIncubPeriod != null ? maxIncubPeriod.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_unit", referencedColumnName = "id", nullable = false)
    public ClsUnitEntity getClsUnitByIdUnit() {
        return clsUnitByIdUnit;
    }

    public ClsPlantDiseaseEntity setClsUnitByIdUnit(ClsUnitEntity clsUnitByIdUnit) {
        this.clsUnitByIdUnit = clsUnitByIdUnit;
        return this;
    }

    @OneToMany(mappedBy = "clsPlantDiseaseByIdPlantDisease")
    @JsonIgnore
    public Collection<TpPlantDiseaseAffectedCropEntity> getTpPlantDiseaseAffectedCropsById() {
        return tpPlantDiseaseAffectedCropsById;
    }

    public ClsPlantDiseaseEntity setTpPlantDiseaseAffectedCropsById(Collection<TpPlantDiseaseAffectedCropEntity> tpPlantDiseaseAffectedCropsById) {
        this.tpPlantDiseaseAffectedCropsById = tpPlantDiseaseAffectedCropsById;
        return this;
    }

    @OneToMany(mappedBy = "clsPlantDiseaseByIdPlantDisease")
    @JsonIgnore
    public Collection<TpPlantDiseaseDiseaseFeatureEntity> getTpPlantDiseaseDiseaseFeaturesById() {
        return tpPlantDiseaseDiseaseFeaturesById;
    }

    public ClsPlantDiseaseEntity setTpPlantDiseaseDiseaseFeaturesById(Collection<TpPlantDiseaseDiseaseFeatureEntity> tpPlantDiseaseDiseaseFeaturesById) {
        this.tpPlantDiseaseDiseaseFeaturesById = tpPlantDiseaseDiseaseFeaturesById;
        return this;
    }

    @OneToMany(mappedBy = "clsPlantDiseaseByIdPlantDisease")
    @JsonIgnore
    public Collection<TpPlantDiseasePeriodEntity> getTpPlantDiseasePeriodsById() {
        return tpPlantDiseasePeriodsById;
    }

    public ClsPlantDiseaseEntity setTpPlantDiseasePeriodsById(Collection<TpPlantDiseasePeriodEntity> tpPlantDiseasePeriodsById) {
        this.tpPlantDiseasePeriodsById = tpPlantDiseasePeriodsById;
        return this;
    }

    @OneToMany(mappedBy = "clsPlantDiseaseByIdPlantDisease")
    @JsonIgnore
    public Collection<TpPlantDiseasePlantOrganEntity> getTpPlantDiseasePlantOrgansById() {
        return tpPlantDiseasePlantOrgansById;
    }

    public ClsPlantDiseaseEntity setTpPlantDiseasePlantOrgansById(Collection<TpPlantDiseasePlantOrganEntity> tpPlantDiseasePlantOrgansById) {
        this.tpPlantDiseasePlantOrgansById = tpPlantDiseasePlantOrgansById;
        return this;
    }

    @OneToMany(mappedBy = "clsPlantDiseaseByIdPlantDisease")
    @JsonIgnore
    public Collection<TpPlantDiseaseTypicalAreaEntity> getTpPlantDiseaseTypicalAreasById() {
        return tpPlantDiseaseTypicalAreasById;
    }

    public ClsPlantDiseaseEntity setTpPlantDiseaseTypicalAreasById(Collection<TpPlantDiseaseTypicalAreaEntity> tpPlantDiseaseTypicalAreasById) {
        this.tpPlantDiseaseTypicalAreasById = tpPlantDiseaseTypicalAreasById;
        return this;
    }
}
