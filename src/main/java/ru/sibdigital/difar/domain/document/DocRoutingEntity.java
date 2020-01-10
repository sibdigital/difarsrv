package ru.sibdigital.difar.domain.document;

import ru.sibdigital.difar.domain.catalog.*;
import ru.sibdigital.difar.domain.register.*;
import ru.sibdigital.difar.domain.tableparts.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "doc_routing", schema = "agrc")
public class DocRoutingEntity {
    private long idUserCreator;
    private Timestamp dateCreate;
    private Timestamp dateReg;
    private Boolean isDeleted;
    private String number;
    private long id;
    private long idOrganization;
    private long idStandardPeriod;
    private long idCrop;
    private long idField;
    private long idUnit;
    private BigDecimal prolificness;
    private Collection<DocActualYieldEntity> docActualYieldsById;
    private ClsOrganizationEntity clsOrganizationByIdOrganization;
    private ClsStandardPeriodEntity clsStandardPeriodByIdStandardPeriod;
    private ClsCropEntity clsCropByIdCrop;
    private ClsFieldEntity clsFieldByIdField;
    private ClsUnitEntity clsUnitByIdUnit;
    private Collection<RegExecRoutingConsumEntity> regExecRoutingConsumsById;
    private Collection<RegExecRoutingEquipmentEntity> regExecRoutingEquipmentsById;
    private Collection<RegExecRoutingFertilizerEntity> regExecRoutingFertilizersById;
    private Collection<RegExecRoutingProtectionEquipmentEntity> regExecRoutingProtectionEquipmentsById;
    private Collection<RegExecRoutingWorkEntity> regExecRoutingWorksById;
    private Collection<TpRoutingConsumEntity> tpRoutingConsumsById;
    private Collection<TpRoutingEquipmentEntity> tpRoutingEquipmentsById;
    private Collection<TpRoutingFertilizerEntity> tpRoutingFertilizersById;
    private Collection<TpRoutingProtectionEquipmentEntity> tpRoutingProtectionEquipmentsById;
    private Collection<TpRoutingStageEntity> tpRoutingStagesById;
    private Collection<TpRoutingWorkEntity> tpRoutingWorksById;

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
    @Column(name = "date_reg", nullable = true)
    public Timestamp getDateReg() {
        return dateReg;
    }

    public void setDateReg(Timestamp dateReg) {
        this.dateReg = dateReg;
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

    @Basic
    @Column(name = "id_standard_period", nullable = false, insertable = false, updatable = false)
    public long getIdStandardPeriod() {
        return idStandardPeriod;
    }

    public void setIdStandardPeriod(long idStandardPeriod) {
        this.idStandardPeriod = idStandardPeriod;
    }

    @Basic
    @Column(name = "id_crop", nullable = false, insertable = false, updatable = false)
    public long getIdCrop() {
        return idCrop;
    }

    public void setIdCrop(long idCrop) {
        this.idCrop = idCrop;
    }

    @Basic
    @Column(name = "id_field", nullable = false, insertable = false, updatable = false)
    public long getIdField() {
        return idField;
    }

    public void setIdField(long idField) {
        this.idField = idField;
    }

    @Basic
    @Column(name = "id_unit", nullable = false, insertable = false, updatable = false)
    public long getIdUnit() {
        return idUnit;
    }

    public void setIdUnit(long idUnit) {
        this.idUnit = idUnit;
    }

    @Basic
    @Column(name = "prolificness", nullable = true, precision = 5)
    public BigDecimal getProlificness() {
        return prolificness;
    }

    public void setProlificness(BigDecimal prolificness) {
        this.prolificness = prolificness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocRoutingEntity that = (DocRoutingEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idOrganization != that.idOrganization) return false;
        if (idStandardPeriod != that.idStandardPeriod) return false;
        if (idCrop != that.idCrop) return false;
        if (idField != that.idField) return false;
        if (idUnit != that.idUnit) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (dateReg != null ? !dateReg.equals(that.dateReg) : that.dateReg != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        return prolificness != null ? prolificness.equals(that.prolificness) : that.prolificness == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (dateReg != null ? dateReg.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idOrganization ^ (idOrganization >>> 32));
        result = 31 * result + (int) (idStandardPeriod ^ (idStandardPeriod >>> 32));
        result = 31 * result + (int) (idCrop ^ (idCrop >>> 32));
        result = 31 * result + (int) (idField ^ (idField >>> 32));
        result = 31 * result + (int) (idUnit ^ (idUnit >>> 32));
        result = 31 * result + (prolificness != null ? prolificness.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "docRoutingByIdRouting")
    public Collection<DocActualYieldEntity> getDocActualYieldsById() {
        return docActualYieldsById;
    }

    public void setDocActualYieldsById(Collection<DocActualYieldEntity> docActualYieldsById) {
        this.docActualYieldsById = docActualYieldsById;
    }

    @ManyToOne
    @JoinColumn(name = "id_organization", referencedColumnName = "id", nullable = false)
    public ClsOrganizationEntity getClsOrganizationByIdOrganization() {
        return clsOrganizationByIdOrganization;
    }

    public void setClsOrganizationByIdOrganization(ClsOrganizationEntity clsOrganizationByIdOrganization) {
        this.clsOrganizationByIdOrganization = clsOrganizationByIdOrganization;
    }

    @ManyToOne
    @JoinColumn(name = "id_standard_period", referencedColumnName = "id", nullable = false)
    public ClsStandardPeriodEntity getClsStandardPeriodByIdStandardPeriod() {
        return clsStandardPeriodByIdStandardPeriod;
    }

    public void setClsStandardPeriodByIdStandardPeriod(ClsStandardPeriodEntity clsStandardPeriodByIdStandardPeriod) {
        this.clsStandardPeriodByIdStandardPeriod = clsStandardPeriodByIdStandardPeriod;
    }

    @ManyToOne
    @JoinColumn(name = "id_crop", referencedColumnName = "id", nullable = false)
    public ClsCropEntity getClsCropByIdCrop() {
        return clsCropByIdCrop;
    }

    public void setClsCropByIdCrop(ClsCropEntity clsCropByIdCrop) {
        this.clsCropByIdCrop = clsCropByIdCrop;
    }

    @ManyToOne
    @JoinColumn(name = "id_field", referencedColumnName = "id", nullable = false)
    public ClsFieldEntity getClsFieldByIdField() {
        return clsFieldByIdField;
    }

    public void setClsFieldByIdField(ClsFieldEntity clsFieldByIdField) {
        this.clsFieldByIdField = clsFieldByIdField;
    }

    @ManyToOne
    @JoinColumn(name = "id_unit", referencedColumnName = "id", nullable = false)
    public ClsUnitEntity getClsUnitByIdUnit() {
        return clsUnitByIdUnit;
    }

    public void setClsUnitByIdUnit(ClsUnitEntity clsUnitByIdUnit) {
        this.clsUnitByIdUnit = clsUnitByIdUnit;
    }

    @OneToMany(mappedBy = "docRoutingByIdRouting")
    public Collection<RegExecRoutingConsumEntity> getRegExecRoutingConsumsById() {
        return regExecRoutingConsumsById;
    }

    public void setRegExecRoutingConsumsById(Collection<RegExecRoutingConsumEntity> regExecRoutingConsumsById) {
        this.regExecRoutingConsumsById = regExecRoutingConsumsById;
    }

    @OneToMany(mappedBy = "docRoutingByIdRouting")
    public Collection<RegExecRoutingEquipmentEntity> getRegExecRoutingEquipmentsById() {
        return regExecRoutingEquipmentsById;
    }

    public void setRegExecRoutingEquipmentsById(Collection<RegExecRoutingEquipmentEntity> regExecRoutingEquipmentsById) {
        this.regExecRoutingEquipmentsById = regExecRoutingEquipmentsById;
    }

    @OneToMany(mappedBy = "docRoutingByIdRouting")
    public Collection<RegExecRoutingFertilizerEntity> getRegExecRoutingFertilizersById() {
        return regExecRoutingFertilizersById;
    }

    public void setRegExecRoutingFertilizersById(Collection<RegExecRoutingFertilizerEntity> regExecRoutingFertilizersById) {
        this.regExecRoutingFertilizersById = regExecRoutingFertilizersById;
    }

    @OneToMany(mappedBy = "docRoutingByIdRouting")
    public Collection<RegExecRoutingProtectionEquipmentEntity> getRegExecRoutingProtectionEquipmentsById() {
        return regExecRoutingProtectionEquipmentsById;
    }

    public void setRegExecRoutingProtectionEquipmentsById(Collection<RegExecRoutingProtectionEquipmentEntity> regExecRoutingProtectionEquipmentsById) {
        this.regExecRoutingProtectionEquipmentsById = regExecRoutingProtectionEquipmentsById;
    }

    @OneToMany(mappedBy = "docRoutingByIdRouting")
    public Collection<RegExecRoutingWorkEntity> getRegExecRoutingWorksById() {
        return regExecRoutingWorksById;
    }

    public void setRegExecRoutingWorksById(Collection<RegExecRoutingWorkEntity> regExecRoutingWorksById) {
        this.regExecRoutingWorksById = regExecRoutingWorksById;
    }

    @OneToMany(mappedBy = "docRoutingByIdRouting")
    public Collection<TpRoutingConsumEntity> getTpRoutingConsumsById() {
        return tpRoutingConsumsById;
    }

    public void setTpRoutingConsumsById(Collection<TpRoutingConsumEntity> tpRoutingConsumsById) {
        this.tpRoutingConsumsById = tpRoutingConsumsById;
    }

    @OneToMany(mappedBy = "docRoutingByIdRouting")
    public Collection<TpRoutingEquipmentEntity> getTpRoutingEquipmentsById() {
        return tpRoutingEquipmentsById;
    }

    public void setTpRoutingEquipmentsById(Collection<TpRoutingEquipmentEntity> tpRoutingEquipmentsById) {
        this.tpRoutingEquipmentsById = tpRoutingEquipmentsById;
    }

    @OneToMany(mappedBy = "docRoutingByIdRouting")
    public Collection<TpRoutingFertilizerEntity> getTpRoutingFertilizersById() {
        return tpRoutingFertilizersById;
    }

    public void setTpRoutingFertilizersById(Collection<TpRoutingFertilizerEntity> tpRoutingFertilizersById) {
        this.tpRoutingFertilizersById = tpRoutingFertilizersById;
    }

    @OneToMany(mappedBy = "docRoutingByIdRouting")
    public Collection<TpRoutingProtectionEquipmentEntity> getTpRoutingProtectionEquipmentsById() {
        return tpRoutingProtectionEquipmentsById;
    }

    public void setTpRoutingProtectionEquipmentsById(Collection<TpRoutingProtectionEquipmentEntity> tpRoutingProtectionEquipmentsById) {
        this.tpRoutingProtectionEquipmentsById = tpRoutingProtectionEquipmentsById;
    }

    @OneToMany(mappedBy = "docRoutingByIdRouting")
    public Collection<TpRoutingStageEntity> getTpRoutingStagesById() {
        return tpRoutingStagesById;
    }

    public void setTpRoutingStagesById(Collection<TpRoutingStageEntity> tpRoutingStagesById) {
        this.tpRoutingStagesById = tpRoutingStagesById;
    }

    @OneToMany(mappedBy = "docRoutingByIdRouting")
    public Collection<TpRoutingWorkEntity> getTpRoutingWorksById() {
        return tpRoutingWorksById;
    }

    public void setTpRoutingWorksById(Collection<TpRoutingWorkEntity> tpRoutingWorksById) {
        this.tpRoutingWorksById = tpRoutingWorksById;
    }
}
