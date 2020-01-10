package ru.sibdigital.difar.domain.tableparts;

import ru.sibdigital.difar.domain.catalog.ClsUnitEntity;
import ru.sibdigital.difar.domain.document.DocRoutingEntity;
import ru.sibdigital.difar.domain.register.RegOrganizationProtectionEquipmentEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tp_routing_protection_equipment", schema = "agrc")
public class TpRoutingProtectionEquipmentEntity {
    private long idUserCreator;
    private Boolean isDeleted;
    private long number;
    private long id;
    private long idRouting;
    private long idRoutingWork;
    private long idOrganizationProtectionEquipment;
    private long idProtectionEquipmentUnit;
    private BigDecimal protectionEquipmentConsum;
    private DocRoutingEntity docRoutingByIdRouting;
    private TpRoutingWorkEntity tpRoutingWorkByIdRoutingWork;
    private RegOrganizationProtectionEquipmentEntity regOrganizationProtectionEquipmentByIdOrganizationProtectionEquipment;
    private ClsUnitEntity clsUnitByIdProtectionEquipmentUnit;

    @Basic
    @Column(name = "id_user_creator", nullable = false, insertable = false, updatable = false)
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
    @Column(name = "id_organization_protection_equipment", nullable = false, insertable = false, updatable = false)
    public long getIdOrganizationProtectionEquipment() {
        return idOrganizationProtectionEquipment;
    }

    public void setIdOrganizationProtectionEquipment(long idOrganizationProtectionEquipment) {
        this.idOrganizationProtectionEquipment = idOrganizationProtectionEquipment;
    }

    @Basic
    @Column(name = "id_protection_equipment_unit", nullable = false, insertable = false, updatable = false)
    public long getIdProtectionEquipmentUnit() {
        return idProtectionEquipmentUnit;
    }

    public void setIdProtectionEquipmentUnit(long idProtectionEquipmentUnit) {
        this.idProtectionEquipmentUnit = idProtectionEquipmentUnit;
    }

    @Basic
    @Column(name = "protection_equipment_consum", nullable = true, precision = 5)
    public BigDecimal getProtectionEquipmentConsum() {
        return protectionEquipmentConsum;
    }

    public void setProtectionEquipmentConsum(BigDecimal protectionEquipmentConsum) {
        this.protectionEquipmentConsum = protectionEquipmentConsum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TpRoutingProtectionEquipmentEntity that = (TpRoutingProtectionEquipmentEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (number != that.number) return false;
        if (id != that.id) return false;
        if (idRouting != that.idRouting) return false;
        if (idRoutingWork != that.idRoutingWork) return false;
        if (idOrganizationProtectionEquipment != that.idOrganizationProtectionEquipment) return false;
        if (idProtectionEquipmentUnit != that.idProtectionEquipmentUnit) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        return protectionEquipmentConsum != null ? protectionEquipmentConsum.equals(that.protectionEquipmentConsum) : that.protectionEquipmentConsum == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (int) (number ^ (number >>> 32));
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idRouting ^ (idRouting >>> 32));
        result = 31 * result + (int) (idRoutingWork ^ (idRoutingWork >>> 32));
        result = 31 * result + (int) (idOrganizationProtectionEquipment ^ (idOrganizationProtectionEquipment >>> 32));
        result = 31 * result + (int) (idProtectionEquipmentUnit ^ (idProtectionEquipmentUnit >>> 32));
        result = 31 * result + (protectionEquipmentConsum != null ? protectionEquipmentConsum.hashCode() : 0);
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
    @JoinColumn(name = "id_organization_protection_equipment", referencedColumnName = "id", nullable = false)
    public RegOrganizationProtectionEquipmentEntity getRegOrganizationProtectionEquipmentByIdOrganizationProtectionEquipment() {
        return regOrganizationProtectionEquipmentByIdOrganizationProtectionEquipment;
    }

    public void setRegOrganizationProtectionEquipmentByIdOrganizationProtectionEquipment(RegOrganizationProtectionEquipmentEntity regOrganizationProtectionEquipmentByIdOrganizationProtectionEquipment) {
        this.regOrganizationProtectionEquipmentByIdOrganizationProtectionEquipment = regOrganizationProtectionEquipmentByIdOrganizationProtectionEquipment;
    }

    @ManyToOne
    @JoinColumn(name = "id_protection_equipment_unit", referencedColumnName = "id", nullable = false)
    public ClsUnitEntity getClsUnitByIdProtectionEquipmentUnit() {
        return clsUnitByIdProtectionEquipmentUnit;
    }

    public void setClsUnitByIdProtectionEquipmentUnit(ClsUnitEntity clsUnitByIdProtectionEquipmentUnit) {
        this.clsUnitByIdProtectionEquipmentUnit = clsUnitByIdProtectionEquipmentUnit;
    }
}
