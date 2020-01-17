package ru.sibdigital.difar.domain.classifier.dict;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.classifier.agrc.ClsFertilizerEntity;
import ru.sibdigital.difar.domain.classifier.agrc.ClsPlantDiseaseEntity;
import ru.sibdigital.difar.domain.classifier.agrc.ClsPlantPestEntity;
import ru.sibdigital.difar.domain.classifier.agrc.ClsProtectionEquipmentEntity;
import ru.sibdigital.difar.domain.classifier.base.ClsBaseEntity;
import ru.sibdigital.difar.domain.document.DocActualYieldEntity;
import ru.sibdigital.difar.domain.document.DocRoutingEntity;
import ru.sibdigital.difar.domain.register.*;
import ru.sibdigital.difar.domain.tableparts.TpRoutingConsumEntity;
import ru.sibdigital.difar.domain.tableparts.TpRoutingEquipmentEntity;
import ru.sibdigital.difar.domain.tableparts.TpRoutingFertilizerEntity;
import ru.sibdigital.difar.domain.tableparts.TpRoutingProtectionEquipmentEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_unit", schema = "dict")
public class ClsUnitEntity extends ClsBaseEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private String code;
    private long id;
    private String reduct;
    private Collection<ClsFertilizerEntity> clsFertilizersById;
    private Collection<ClsPlantDiseaseEntity> clsPlantDiseasesById;
    private Collection<ClsPlantPestEntity> clsPlantPestsById;
    private Collection<ClsProtectionEquipmentEntity> clsProtectionEquipmentsById;
    private Collection<DocActualYieldEntity> docActualYieldsById;
    private Collection<DocActualYieldEntity> docActualYieldsById_0;
    private Collection<DocRoutingEntity> docRoutingsById;
    private Collection<RegExecRoutingConsumEntity> regExecRoutingConsumsById;
    private Collection<RegExecRoutingEquipmentEntity> regExecRoutingEquipmentsById;
    private Collection<RegExecRoutingFertilizerEntity> regExecRoutingFertilizersById;
    private Collection<RegExecRoutingProtectionEquipmentEntity> regExecRoutingProtectionEquipmentsById;
    private Collection<TpRoutingConsumEntity> tpRoutingConsumsById;
    private Collection<TpRoutingEquipmentEntity> tpRoutingEquipmentsById;
    private Collection<TpRoutingFertilizerEntity> tpRoutingFertilizersById;
    private Collection<TpRoutingProtectionEquipmentEntity> tpRoutingProtectionEquipmentsById;
    private Collection<RegAnimalParamEntity> regAnimalParamsById;
    private Collection<ClsConsumableEntity> clsConsumablesById;
    private Collection<ClsUnitRatioEntity> clsUnitRatiosById;
    private Collection<ClsUnitRatioEntity> clsUnitRatiosById_0;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public ClsUnitEntity setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public ClsUnitEntity setName(String name) {
        this.name = name;
        return this;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public ClsUnitEntity setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public ClsUnitEntity setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public ClsUnitEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    @Basic
    @Column(name = "code", nullable = false, length = 64)
    public String getCode() {
        return code;
    }

    public ClsUnitEntity setCode(String code) {
        this.code = code;
        return this;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "cls_unit_id_seq", schema = "dict")
    public long getId() {
        return id;
    }

    public ClsUnitEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "reduct", nullable = true, length = -1)
    public String getReduct() {
        return reduct;
    }

    public ClsUnitEntity setReduct(String reduct) {
        this.reduct = reduct;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsUnitEntity that = (ClsUnitEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        return reduct != null ? reduct.equals(that.reduct) : that.reduct == null;
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
        result = 31 * result + (reduct != null ? reduct.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "clsUnitByIdUnit")
    @JsonIgnore
    public Collection<ClsFertilizerEntity> getClsFertilizersById() {
        return clsFertilizersById;
    }

    public ClsUnitEntity setClsFertilizersById(Collection<ClsFertilizerEntity> clsFertilizersById) {
        this.clsFertilizersById = clsFertilizersById;
        return this;
    }

    @OneToMany(mappedBy = "clsUnitByIdUnit")
    @JsonIgnore
    public Collection<ClsPlantDiseaseEntity> getClsPlantDiseasesById() {
        return clsPlantDiseasesById;
    }

    public ClsUnitEntity setClsPlantDiseasesById(Collection<ClsPlantDiseaseEntity> clsPlantDiseasesById) {
        this.clsPlantDiseasesById = clsPlantDiseasesById;
        return this;
    }

    @OneToMany(mappedBy = "clsUnitByIdUnit")
    @JsonIgnore
    public Collection<ClsPlantPestEntity> getClsPlantPestsById() {
        return clsPlantPestsById;
    }

    public ClsUnitEntity setClsPlantPestsById(Collection<ClsPlantPestEntity> clsPlantPestsById) {
        this.clsPlantPestsById = clsPlantPestsById;
        return this;
    }

    @OneToMany(mappedBy = "clsUnitByIdUnit")
    @JsonIgnore
    public Collection<ClsProtectionEquipmentEntity> getClsProtectionEquipmentsById() {
        return clsProtectionEquipmentsById;
    }

    public ClsUnitEntity setClsProtectionEquipmentsById(Collection<ClsProtectionEquipmentEntity> clsProtectionEquipmentsById) {
        this.clsProtectionEquipmentsById = clsProtectionEquipmentsById;
        return this;
    }

    @OneToMany(mappedBy = "clsUnitByIdUnit")
    @JsonIgnore
    public Collection<DocActualYieldEntity> getDocActualYieldsById() {
        return docActualYieldsById;
    }

    public ClsUnitEntity setDocActualYieldsById(Collection<DocActualYieldEntity> docActualYieldsById) {
        this.docActualYieldsById = docActualYieldsById;
        return this;
    }

    @OneToMany(mappedBy = "clsUnitByIdActualProlificnessUnit")
    @JsonIgnore
    public Collection<DocActualYieldEntity> getDocActualYieldsById_0() {
        return docActualYieldsById_0;
    }

    public ClsUnitEntity setDocActualYieldsById_0(Collection<DocActualYieldEntity> docActualYieldsById_0) {
        this.docActualYieldsById_0 = docActualYieldsById_0;
        return this;
    }

    @OneToMany(mappedBy = "clsUnitByIdUnit")
    @JsonIgnore
    public Collection<DocRoutingEntity> getDocRoutingsById() {
        return docRoutingsById;
    }

    public ClsUnitEntity setDocRoutingsById(Collection<DocRoutingEntity> docRoutingsById) {
        this.docRoutingsById = docRoutingsById;
        return this;
    }

    @OneToMany(mappedBy = "clsUnitByIdConsumUnit")
    @JsonIgnore
    public Collection<RegExecRoutingConsumEntity> getRegExecRoutingConsumsById() {
        return regExecRoutingConsumsById;
    }

    public ClsUnitEntity setRegExecRoutingConsumsById(Collection<RegExecRoutingConsumEntity> regExecRoutingConsumsById) {
        this.regExecRoutingConsumsById = regExecRoutingConsumsById;
        return this;
    }

    @OneToMany(mappedBy = "clsUnitByIdUnit")
    @JsonIgnore
    public Collection<RegExecRoutingEquipmentEntity> getRegExecRoutingEquipmentsById() {
        return regExecRoutingEquipmentsById;
    }

    public ClsUnitEntity setRegExecRoutingEquipmentsById(Collection<RegExecRoutingEquipmentEntity> regExecRoutingEquipmentsById) {
        this.regExecRoutingEquipmentsById = regExecRoutingEquipmentsById;
        return this;
    }

    @OneToMany(mappedBy = "clsUnitByIdFertilizerUnit")
    @JsonIgnore
    public Collection<RegExecRoutingFertilizerEntity> getRegExecRoutingFertilizersById() {
        return regExecRoutingFertilizersById;
    }

    public ClsUnitEntity setRegExecRoutingFertilizersById(Collection<RegExecRoutingFertilizerEntity> regExecRoutingFertilizersById) {
        this.regExecRoutingFertilizersById = regExecRoutingFertilizersById;
        return this;
    }

    @OneToMany(mappedBy = "clsUnitByIdProtectionEquipmentUnit")
    @JsonIgnore
    public Collection<RegExecRoutingProtectionEquipmentEntity> getRegExecRoutingProtectionEquipmentsById() {
        return regExecRoutingProtectionEquipmentsById;
    }

    public ClsUnitEntity setRegExecRoutingProtectionEquipmentsById(Collection<RegExecRoutingProtectionEquipmentEntity> regExecRoutingProtectionEquipmentsById) {
        this.regExecRoutingProtectionEquipmentsById = regExecRoutingProtectionEquipmentsById;
        return this;
    }

    @OneToMany(mappedBy = "clsUnitByIdConsumableUnit")
    @JsonIgnore
    public Collection<TpRoutingConsumEntity> getTpRoutingConsumsById() {
        return tpRoutingConsumsById;
    }

    public ClsUnitEntity setTpRoutingConsumsById(Collection<TpRoutingConsumEntity> tpRoutingConsumsById) {
        this.tpRoutingConsumsById = tpRoutingConsumsById;
        return this;
    }

    @OneToMany(mappedBy = "clsUnitByIdFuelUnit")
    @JsonIgnore
    public Collection<TpRoutingEquipmentEntity> getTpRoutingEquipmentsById() {
        return tpRoutingEquipmentsById;
    }

    public ClsUnitEntity setTpRoutingEquipmentsById(Collection<TpRoutingEquipmentEntity> tpRoutingEquipmentsById) {
        this.tpRoutingEquipmentsById = tpRoutingEquipmentsById;
        return this;
    }

    @OneToMany(mappedBy = "clsUnitByIdFertilizerUnit")
    @JsonIgnore
    public Collection<TpRoutingFertilizerEntity> getTpRoutingFertilizersById() {
        return tpRoutingFertilizersById;
    }

    public ClsUnitEntity setTpRoutingFertilizersById(Collection<TpRoutingFertilizerEntity> tpRoutingFertilizersById) {
        this.tpRoutingFertilizersById = tpRoutingFertilizersById;
        return this;
    }

    @OneToMany(mappedBy = "clsUnitByIdProtectionEquipmentUnit")
    @JsonIgnore
    public Collection<TpRoutingProtectionEquipmentEntity> getTpRoutingProtectionEquipmentsById() {
        return tpRoutingProtectionEquipmentsById;
    }

    public ClsUnitEntity setTpRoutingProtectionEquipmentsById(Collection<TpRoutingProtectionEquipmentEntity> tpRoutingProtectionEquipmentsById) {
        this.tpRoutingProtectionEquipmentsById = tpRoutingProtectionEquipmentsById;
        return this;
    }

    @OneToMany(mappedBy = "clsUnitByIdUnitWeight")
    @JsonIgnore
    public Collection<RegAnimalParamEntity> getRegAnimalParamsById() {
        return regAnimalParamsById;
    }

    public ClsUnitEntity setRegAnimalParamsById(Collection<RegAnimalParamEntity> regAnimalParamsById) {
        this.regAnimalParamsById = regAnimalParamsById;
        return this;
    }

    @OneToMany(mappedBy = "clsUnitByIdUnit")
    @JsonIgnore
    public Collection<ClsConsumableEntity> getClsConsumablesById() {
        return clsConsumablesById;
    }

    public ClsUnitEntity setClsConsumablesById(Collection<ClsConsumableEntity> clsConsumablesById) {
        this.clsConsumablesById = clsConsumablesById;
        return this;
    }

    @OneToMany(mappedBy = "clsUnitByIdUnitFrom")
    @JsonIgnore
    public Collection<ClsUnitRatioEntity> getClsUnitRatiosById() {
        return clsUnitRatiosById;
    }

    public ClsUnitEntity setClsUnitRatiosById(Collection<ClsUnitRatioEntity> clsUnitRatiosById) {
        this.clsUnitRatiosById = clsUnitRatiosById;
        return this;
    }

    @OneToMany(mappedBy = "clsUnitByIdUnitTo")
    @JsonIgnore
    public Collection<ClsUnitRatioEntity> getClsUnitRatiosById_0() {
        return clsUnitRatiosById_0;
    }

    public ClsUnitEntity setClsUnitRatiosById_0(Collection<ClsUnitRatioEntity> clsUnitRatiosById_0) {
        this.clsUnitRatiosById_0 = clsUnitRatiosById_0;
        return this;
    }
}
