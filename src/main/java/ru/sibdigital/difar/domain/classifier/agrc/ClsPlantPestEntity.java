package ru.sibdigital.difar.domain.classifier.agrc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.sibdigital.difar.domain.classifier.base.ClsBaseEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsUnitEntity;
import ru.sibdigital.difar.domain.tableparts.TpPlantPestAffectedCropEntity;
import ru.sibdigital.difar.domain.tableparts.TpPlantPestPeriodEntity;
import ru.sibdigital.difar.domain.tableparts.TpPlantPestPlantOrganEntity;
import ru.sibdigital.difar.domain.tableparts.TpPlantPestTypicalAreaEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_plant_pest", schema = "agrc")
@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
public class ClsPlantPestEntity extends ClsBaseEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private String code;
    private long id;
    private long idUnit;
    private JsonNode photos;
    private JsonNode additionalNames;
    private JsonNode condition;
    private JsonNode description;
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

    public ClsPlantPestEntity setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public ClsPlantPestEntity setName(String name) {
        this.name = name;
        return this;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public ClsPlantPestEntity setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public ClsPlantPestEntity setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public ClsPlantPestEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    @Basic
    @Column(name = "code", nullable = false, length = 64)
    public String getCode() {
        return code;
    }

    public ClsPlantPestEntity setCode(String code) {
        this.code = code;
        return this;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "cls_plant_pest_id_seq", schema = "agrc")
    public long getId() {
        return id;
    }

    public ClsPlantPestEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "id_unit", nullable = false, insertable = false, updatable = false)
    public long getIdUnit() {
        return idUnit;
    }

    public ClsPlantPestEntity setIdUnit(long idUnit) {
        this.idUnit = idUnit;
        return this;
    }

    @Type(type = "jsonb-node")
    @Column(name = "photos", nullable = true)
    public JsonNode getPhotos() {
        return photos;
    }

    public ClsPlantPestEntity setPhotos(JsonNode photos) {
        this.photos = photos;
        return this;
    }

    @Type(type = "jsonb-node")
    @Column(name = "additional_names", nullable = true)
    public JsonNode getAdditionalNames() {
        return additionalNames;
    }

    public ClsPlantPestEntity setAdditionalNames(JsonNode additionalNames) {
        this.additionalNames = additionalNames;
        return this;
    }

    @Type(type = "jsonb-node")
    @Column(name = "condition", nullable = true)
    public JsonNode getCondition() {
        return condition;
    }

    public ClsPlantPestEntity setCondition(JsonNode condition) {
        this.condition = condition;
        return this;
    }

    @Type(type = "jsonb-node")
    @Column(name = "description", nullable = true)
    public JsonNode getDescription() {
        return description;
    }

    public ClsPlantPestEntity setDescription(JsonNode description) {
        this.description = description;
        return this;
    }

    @Basic
    @Column(name = "min_incub_period", nullable = true)
    public Integer getMinIncubPeriod() {
        return minIncubPeriod;
    }

    public ClsPlantPestEntity setMinIncubPeriod(Integer minIncubPeriod) {
        this.minIncubPeriod = minIncubPeriod;
        return this;
    }

    @Basic
    @Column(name = "max_incub_period", nullable = true)
    public Integer getMaxIncubPeriod() {
        return maxIncubPeriod;
    }

    public ClsPlantPestEntity setMaxIncubPeriod(Integer maxIncubPeriod) {
        this.maxIncubPeriod = maxIncubPeriod;
        return this;
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

    public ClsPlantPestEntity setClsUnitByIdUnit(ClsUnitEntity clsUnitByIdUnit) {
        this.clsUnitByIdUnit = clsUnitByIdUnit;
        return this;
    }

    @OneToMany(mappedBy = "clsPlantPestByIdPlantPest")
    @JsonIgnore
    public Collection<TpPlantPestAffectedCropEntity> getTpPlantPestAffectedCropsById() {
        return tpPlantPestAffectedCropsById;
    }

    public ClsPlantPestEntity setTpPlantPestAffectedCropsById(Collection<TpPlantPestAffectedCropEntity> tpPlantPestAffectedCropsById) {
        this.tpPlantPestAffectedCropsById = tpPlantPestAffectedCropsById;
        return this;
    }

    @OneToMany(mappedBy = "clsPlantPestByIdPlantPest")
    @JsonIgnore
    public Collection<TpPlantPestPeriodEntity> getTpPlantPestPeriodsById() {
        return tpPlantPestPeriodsById;
    }

    public ClsPlantPestEntity setTpPlantPestPeriodsById(Collection<TpPlantPestPeriodEntity> tpPlantPestPeriodsById) {
        this.tpPlantPestPeriodsById = tpPlantPestPeriodsById;
        return this;
    }

    @OneToMany(mappedBy = "clsPlantPestByIdPlantPest")
    @JsonIgnore
    public Collection<TpPlantPestPlantOrganEntity> getTpPlantPestPlantOrgansById() {
        return tpPlantPestPlantOrgansById;
    }

    public ClsPlantPestEntity setTpPlantPestPlantOrgansById(Collection<TpPlantPestPlantOrganEntity> tpPlantPestPlantOrgansById) {
        this.tpPlantPestPlantOrgansById = tpPlantPestPlantOrgansById;
        return this;
    }

    @OneToMany(mappedBy = "clsPlantPestByIdPlantPest")
    @JsonIgnore
    public Collection<TpPlantPestTypicalAreaEntity> getTpPlantPestTypicalAreasById() {
        return tpPlantPestTypicalAreasById;
    }

    public ClsPlantPestEntity setTpPlantPestTypicalAreasById(Collection<TpPlantPestTypicalAreaEntity> tpPlantPestTypicalAreasById) {
        this.tpPlantPestTypicalAreasById = tpPlantPestTypicalAreasById;
        return this;
    }
}
