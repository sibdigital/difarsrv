package ru.sibdigital.difar.domain.classifier.agrc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.classifier.base.ClsBaseEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsUnitEntity;
import ru.sibdigital.difar.domain.register.RegOrganizationProtectionEquipmentEntity;
import ru.sibdigital.difar.domain.tableparts.TpPlantDiseaseAffectedCropEntity;
import ru.sibdigital.difar.domain.tableparts.TpPlantPestAffectedCropEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_protection_equipment", schema = "agrc")
public class ClsProtectionEquipmentEntity extends ClsBaseEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private String code;
    private long id;
    private long idUnit;
    private BigDecimal maxConsum;
    private BigDecimal minConsum;
    private ClsUnitEntity clsUnitByIdUnit;
    private Collection<RegOrganizationProtectionEquipmentEntity> regOrganizationProtectionEquipmentsById;
    private Collection<TpPlantDiseaseAffectedCropEntity> tpPlantDiseaseAffectedCropsById;
    private Collection<TpPlantPestAffectedCropEntity> tpPlantPestAffectedCropsById;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public ClsProtectionEquipmentEntity setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public ClsProtectionEquipmentEntity setName(String name) {
        this.name = name;
        return this;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public ClsProtectionEquipmentEntity setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public ClsProtectionEquipmentEntity setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public ClsProtectionEquipmentEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    @Basic
    @Column(name = "code", nullable = false, length = 64)
    public String getCode() {
        return code;
    }

    public ClsProtectionEquipmentEntity setCode(String code) {
        this.code = code;
        return this;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "cls_protection_equipment_id_seq", schema = "agrc")
    public long getId() {
        return id;
    }

    public ClsProtectionEquipmentEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "id_unit", nullable = false, insertable = false, updatable = false)
    public long getIdUnit() {
        return idUnit;
    }

    public ClsProtectionEquipmentEntity setIdUnit(long idUnit) {
        this.idUnit = idUnit;
        return this;
    }

    @Basic
    @Column(name = "max_consum", nullable = true, precision = 5)
    public BigDecimal getMaxConsum() {
        return maxConsum;
    }

    public ClsProtectionEquipmentEntity setMaxConsum(BigDecimal maxConsum) {
        this.maxConsum = maxConsum;
        return this;
    }

    @Basic
    @Column(name = "min_consum", nullable = true, precision = 5)
    public BigDecimal getMinConsum() {
        return minConsum;
    }

    public ClsProtectionEquipmentEntity setMinConsum(BigDecimal minConsum) {
        this.minConsum = minConsum;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsProtectionEquipmentEntity that = (ClsProtectionEquipmentEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idUnit != that.idUnit) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (maxConsum != null ? !maxConsum.equals(that.maxConsum) : that.maxConsum != null) return false;
        return minConsum != null ? minConsum.equals(that.minConsum) : that.minConsum == null;
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
        result = 31 * result + (maxConsum != null ? maxConsum.hashCode() : 0);
        result = 31 * result + (minConsum != null ? minConsum.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_unit", referencedColumnName = "id", nullable = false)
    public ClsUnitEntity getClsUnitByIdUnit() {
        return clsUnitByIdUnit;
    }

    public ClsProtectionEquipmentEntity setClsUnitByIdUnit(ClsUnitEntity clsUnitByIdUnit) {
        this.clsUnitByIdUnit = clsUnitByIdUnit;
        return this;
    }

    @OneToMany(mappedBy = "clsProtectionEquipmentByIdProtectionEquipment")
    @JsonIgnore
    public Collection<RegOrganizationProtectionEquipmentEntity> getRegOrganizationProtectionEquipmentsById() {
        return regOrganizationProtectionEquipmentsById;
    }

    public ClsProtectionEquipmentEntity setRegOrganizationProtectionEquipmentsById(Collection<RegOrganizationProtectionEquipmentEntity> regOrganizationProtectionEquipmentsById) {
        this.regOrganizationProtectionEquipmentsById = regOrganizationProtectionEquipmentsById;
        return this;
    }

    @OneToMany(mappedBy = "clsProtectionEquipmentByIdProtectionEquipment")
    @JsonIgnore
    public Collection<TpPlantDiseaseAffectedCropEntity> getTpPlantDiseaseAffectedCropsById() {
        return tpPlantDiseaseAffectedCropsById;
    }

    public ClsProtectionEquipmentEntity setTpPlantDiseaseAffectedCropsById(Collection<TpPlantDiseaseAffectedCropEntity> tpPlantDiseaseAffectedCropsById) {
        this.tpPlantDiseaseAffectedCropsById = tpPlantDiseaseAffectedCropsById;
        return this;
    }

    @OneToMany(mappedBy = "clsProtectionEquipmentByIdProtectionEquipment")
    @JsonIgnore
    public Collection<TpPlantPestAffectedCropEntity> getTpPlantPestAffectedCropsById() {
        return tpPlantPestAffectedCropsById;
    }

    public ClsProtectionEquipmentEntity setTpPlantPestAffectedCropsById(Collection<TpPlantPestAffectedCropEntity> tpPlantPestAffectedCropsById) {
        this.tpPlantPestAffectedCropsById = tpPlantPestAffectedCropsById;
        return this;
    }
}
