package ru.sibdigital.difar.domain.tableparts;

import ru.sibdigital.difar.domain.catalog.ClsCropEntity;
import ru.sibdigital.difar.domain.catalog.ClsPlantPestEntity;
import ru.sibdigital.difar.domain.catalog.ClsProtectionEquipmentEntity;
import ru.sibdigital.difar.domain.catalog.ClsVegetPeriodEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tp_plant_pest_affected_crop", schema = "agrc")
public class TpPlantPestAffectedCropEntity {
    private long idUserCreator;
    private Boolean isDeleted;
    private long number;
    private long id;
    private long idCrop;
    private long idPlantPest;
    private long idVegetPeriod;
    private long idProtectionEquipment;
    private BigDecimal minAppRate;
    private BigDecimal maxAppRate;
    private BigDecimal waitPeriod;
    private BigDecimal operationMultiplicity;
    private BigDecimal periodHandwork;
    private BigDecimal periodMechwork;
    private ClsCropEntity clsCropByIdCrop;
    private ClsPlantPestEntity clsPlantPestByIdPlantPest;
    private ClsVegetPeriodEntity clsVegetPeriodByIdVegetPeriod;
    private ClsProtectionEquipmentEntity clsProtectionEquipmentByIdProtectionEquipment;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public void setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
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
    @Column(name = "number", nullable = false)
    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
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
    @Column(name = "id_crop", nullable = false)
    public long getIdCrop() {
        return idCrop;
    }

    public void setIdCrop(long idCrop) {
        this.idCrop = idCrop;
    }

    @Basic
    @Column(name = "id_plant_pest", nullable = false)
    public long getIdPlantPest() {
        return idPlantPest;
    }

    public void setIdPlantPest(long idPlantPest) {
        this.idPlantPest = idPlantPest;
    }

    @Basic
    @Column(name = "id_veget_period", nullable = false)
    public long getIdVegetPeriod() {
        return idVegetPeriod;
    }

    public void setIdVegetPeriod(long idVegetPeriod) {
        this.idVegetPeriod = idVegetPeriod;
    }

    @Basic
    @Column(name = "id_protection_equipment", nullable = false)
    public long getIdProtectionEquipment() {
        return idProtectionEquipment;
    }

    public void setIdProtectionEquipment(long idProtectionEquipment) {
        this.idProtectionEquipment = idProtectionEquipment;
    }

    @Basic
    @Column(name = "min_app_rate", nullable = true, precision = 5)
    public BigDecimal getMinAppRate() {
        return minAppRate;
    }

    public void setMinAppRate(BigDecimal minAppRate) {
        this.minAppRate = minAppRate;
    }

    @Basic
    @Column(name = "max_app_rate", nullable = true, precision = 5)
    public BigDecimal getMaxAppRate() {
        return maxAppRate;
    }

    public void setMaxAppRate(BigDecimal maxAppRate) {
        this.maxAppRate = maxAppRate;
    }

    @Basic
    @Column(name = "wait_period", nullable = true, precision = 5)
    public BigDecimal getWaitPeriod() {
        return waitPeriod;
    }

    public void setWaitPeriod(BigDecimal waitPeriod) {
        this.waitPeriod = waitPeriod;
    }

    @Basic
    @Column(name = "operation_multiplicity", nullable = true, precision = 5)
    public BigDecimal getOperationMultiplicity() {
        return operationMultiplicity;
    }

    public void setOperationMultiplicity(BigDecimal operationMultiplicity) {
        this.operationMultiplicity = operationMultiplicity;
    }

    @Basic
    @Column(name = "period_handwork", nullable = true, precision = 5)
    public BigDecimal getPeriodHandwork() {
        return periodHandwork;
    }

    public void setPeriodHandwork(BigDecimal periodHandwork) {
        this.periodHandwork = periodHandwork;
    }

    @Basic
    @Column(name = "period_mechwork", nullable = true, precision = 5)
    public BigDecimal getPeriodMechwork() {
        return periodMechwork;
    }

    public void setPeriodMechwork(BigDecimal periodMechwork) {
        this.periodMechwork = periodMechwork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TpPlantPestAffectedCropEntity that = (TpPlantPestAffectedCropEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (number != that.number) return false;
        if (id != that.id) return false;
        if (idCrop != that.idCrop) return false;
        if (idPlantPest != that.idPlantPest) return false;
        if (idVegetPeriod != that.idVegetPeriod) return false;
        if (idProtectionEquipment != that.idProtectionEquipment) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (minAppRate != null ? !minAppRate.equals(that.minAppRate) : that.minAppRate != null) return false;
        if (maxAppRate != null ? !maxAppRate.equals(that.maxAppRate) : that.maxAppRate != null) return false;
        if (waitPeriod != null ? !waitPeriod.equals(that.waitPeriod) : that.waitPeriod != null) return false;
        if (operationMultiplicity != null ? !operationMultiplicity.equals(that.operationMultiplicity) : that.operationMultiplicity != null)
            return false;
        if (periodHandwork != null ? !periodHandwork.equals(that.periodHandwork) : that.periodHandwork != null)
            return false;
        return periodMechwork != null ? periodMechwork.equals(that.periodMechwork) : that.periodMechwork == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (int) (number ^ (number >>> 32));
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idCrop ^ (idCrop >>> 32));
        result = 31 * result + (int) (idPlantPest ^ (idPlantPest >>> 32));
        result = 31 * result + (int) (idVegetPeriod ^ (idVegetPeriod >>> 32));
        result = 31 * result + (int) (idProtectionEquipment ^ (idProtectionEquipment >>> 32));
        result = 31 * result + (minAppRate != null ? minAppRate.hashCode() : 0);
        result = 31 * result + (maxAppRate != null ? maxAppRate.hashCode() : 0);
        result = 31 * result + (waitPeriod != null ? waitPeriod.hashCode() : 0);
        result = 31 * result + (operationMultiplicity != null ? operationMultiplicity.hashCode() : 0);
        result = 31 * result + (periodHandwork != null ? periodHandwork.hashCode() : 0);
        result = 31 * result + (periodMechwork != null ? periodMechwork.hashCode() : 0);
        return result;
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
    @JoinColumn(name = "id_plant_pest", referencedColumnName = "id", nullable = false)
    public ClsPlantPestEntity getClsPlantPestByIdPlantPest() {
        return clsPlantPestByIdPlantPest;
    }

    public void setClsPlantPestByIdPlantPest(ClsPlantPestEntity clsPlantPestByIdPlantPest) {
        this.clsPlantPestByIdPlantPest = clsPlantPestByIdPlantPest;
    }

    @ManyToOne
    @JoinColumn(name = "id_veget_period", referencedColumnName = "id", nullable = false)
    public ClsVegetPeriodEntity getClsVegetPeriodByIdVegetPeriod() {
        return clsVegetPeriodByIdVegetPeriod;
    }

    public void setClsVegetPeriodByIdVegetPeriod(ClsVegetPeriodEntity clsVegetPeriodByIdVegetPeriod) {
        this.clsVegetPeriodByIdVegetPeriod = clsVegetPeriodByIdVegetPeriod;
    }

    @ManyToOne
    @JoinColumn(name = "id_protection_equipment", referencedColumnName = "id", nullable = false)
    public ClsProtectionEquipmentEntity getClsProtectionEquipmentByIdProtectionEquipment() {
        return clsProtectionEquipmentByIdProtectionEquipment;
    }

    public void setClsProtectionEquipmentByIdProtectionEquipment(ClsProtectionEquipmentEntity clsProtectionEquipmentByIdProtectionEquipment) {
        this.clsProtectionEquipmentByIdProtectionEquipment = clsProtectionEquipmentByIdProtectionEquipment;
    }
}
