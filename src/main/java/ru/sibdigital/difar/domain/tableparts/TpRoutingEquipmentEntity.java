package ru.sibdigital.difar.domain.tableparts;

import ru.sibdigital.difar.domain.classifier.dict.ClsUnitEntity;
import ru.sibdigital.difar.domain.document.DocRoutingEntity;
import ru.sibdigital.difar.domain.register.RegOrganizationEquipmentEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tp_routing_equipment", schema = "agrc")
public class TpRoutingEquipmentEntity {
    private long idUserCreator;
    private Boolean isDeleted;
    private long number;
    private long id;
    private long idRouting;
    private long idRoutingWork;
    private long idOrganizationEquipment;
    private long idFuelUnit;
    private BigDecimal fuelConsum;
    private DocRoutingEntity docRoutingByIdRouting;
    private TpRoutingWorkEntity tpRoutingWorkByIdRoutingWork;
    private RegOrganizationEquipmentEntity regOrganizationEquipmentByIdOrganizationEquipment;
    private ClsUnitEntity clsUnitByIdFuelUnit;

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
    @Column(name = "id_routing", nullable = false, insertable = false, updatable = false)
    public long getIdRouting() {
        return idRouting;
    }

    public void setIdRouting(long idRouting) {
        this.idRouting = idRouting;
    }

    @Basic
    @Column(name = "id_routing_work", nullable = false, insertable = false, updatable = false)
    public long getIdRoutingWork() {
        return idRoutingWork;
    }

    public void setIdRoutingWork(long idRoutingWork) {
        this.idRoutingWork = idRoutingWork;
    }

    @Basic
    @Column(name = "id_organization_equipment", nullable = false, insertable = false, updatable = false)
    public long getIdOrganizationEquipment() {
        return idOrganizationEquipment;
    }

    public void setIdOrganizationEquipment(long idOrganizationEquipment) {
        this.idOrganizationEquipment = idOrganizationEquipment;
    }

    @Basic
    @Column(name = "id_fuel_unit", nullable = false, insertable = false, updatable = false)
    public long getIdFuelUnit() {
        return idFuelUnit;
    }

    public void setIdFuelUnit(long idFuelUnit) {
        this.idFuelUnit = idFuelUnit;
    }

    @Basic
    @Column(name = "fuel_consum", nullable = true, precision = 5)
    public BigDecimal getFuelConsum() {
        return fuelConsum;
    }

    public void setFuelConsum(BigDecimal fuelConsum) {
        this.fuelConsum = fuelConsum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TpRoutingEquipmentEntity that = (TpRoutingEquipmentEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (number != that.number) return false;
        if (id != that.id) return false;
        if (idRouting != that.idRouting) return false;
        if (idRoutingWork != that.idRoutingWork) return false;
        if (idOrganizationEquipment != that.idOrganizationEquipment) return false;
        if (idFuelUnit != that.idFuelUnit) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        return fuelConsum != null ? fuelConsum.equals(that.fuelConsum) : that.fuelConsum == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (int) (number ^ (number >>> 32));
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idRouting ^ (idRouting >>> 32));
        result = 31 * result + (int) (idRoutingWork ^ (idRoutingWork >>> 32));
        result = 31 * result + (int) (idOrganizationEquipment ^ (idOrganizationEquipment >>> 32));
        result = 31 * result + (int) (idFuelUnit ^ (idFuelUnit >>> 32));
        result = 31 * result + (fuelConsum != null ? fuelConsum.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_routing", referencedColumnName = "id", nullable = false)
    public DocRoutingEntity getDocRoutingByIdRouting() {
        return docRoutingByIdRouting;
    }

    public void setDocRoutingByIdRouting(DocRoutingEntity docRoutingByIdRouting) {
        this.docRoutingByIdRouting = docRoutingByIdRouting;
    }

    @ManyToOne
    @JoinColumn(name = "id_routing_work", referencedColumnName = "id", nullable = false)
    public TpRoutingWorkEntity getTpRoutingWorkByIdRoutingWork() {
        return tpRoutingWorkByIdRoutingWork;
    }

    public void setTpRoutingWorkByIdRoutingWork(TpRoutingWorkEntity tpRoutingWorkByIdRoutingWork) {
        this.tpRoutingWorkByIdRoutingWork = tpRoutingWorkByIdRoutingWork;
    }

    @ManyToOne
    @JoinColumn(name = "id_organization_equipment", referencedColumnName = "id", nullable = false)
    public RegOrganizationEquipmentEntity getRegOrganizationEquipmentByIdOrganizationEquipment() {
        return regOrganizationEquipmentByIdOrganizationEquipment;
    }

    public void setRegOrganizationEquipmentByIdOrganizationEquipment(RegOrganizationEquipmentEntity regOrganizationEquipmentByIdOrganizationEquipment) {
        this.regOrganizationEquipmentByIdOrganizationEquipment = regOrganizationEquipmentByIdOrganizationEquipment;
    }

    @ManyToOne
    @JoinColumn(name = "id_fuel_unit", referencedColumnName = "id", nullable = false)
    public ClsUnitEntity getClsUnitByIdFuelUnit() {
        return clsUnitByIdFuelUnit;
    }

    public void setClsUnitByIdFuelUnit(ClsUnitEntity clsUnitByIdFuelUnit) {
        this.clsUnitByIdFuelUnit = clsUnitByIdFuelUnit;
    }
}
