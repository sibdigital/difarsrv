package ru.sibdigital.difar.domain.register;

import ru.sibdigital.difar.domain.catalog.ClsEmployeeEntity;
import ru.sibdigital.difar.domain.catalog.ClsUnitEntity;
import ru.sibdigital.difar.domain.document.DocRoutingEntity;
import ru.sibdigital.difar.domain.tableparts.TpRoutingWorkEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "reg_exec_routing_equipment", schema = "agrc")
public class RegExecRoutingEquipmentEntity {
    private long idUserCreator;
    private Timestamp dateCreate;
    private Timestamp dateBegin;
    private Timestamp dateEnd;
    private long id;
    private long idRouting;
    private long idRoutingWork;
    private long idMaker;
    private long idEmployee;
    private long idOrganizationEquipment;
    private long idRoutingEquipment;
    private long idExecRoutingWork;
    private long idUnit;
    private BigDecimal fuelConsum;
    private String number;
    private DocRoutingEntity docRoutingByIdRouting;
    private TpRoutingWorkEntity tpRoutingWorkByIdRoutingWork;
    private ClsEmployeeEntity clsEmployeeByIdMaker;
    private ClsEmployeeEntity clsEmployeeByIdEmployee;
    private RegOrganizationEquipmentEntity regOrganizationEquipmentByIdOrganizationEquipment;
    private RegOrganizationEquipmentEntity regOrganizationEquipmentByIdRoutingEquipment;
    private RegExecRoutingWorkEntity regExecRoutingWorkByIdExecRoutingWork;
    private ClsUnitEntity clsUnitByIdUnit;

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
    @Column(name = "date_begin", nullable = true)
    public Timestamp getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Timestamp dateBegin) {
        this.dateBegin = dateBegin;
    }

    @Basic
    @Column(name = "date_end", nullable = true)
    public Timestamp getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
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
    @Column(name = "id_maker", nullable = false, insertable = false, updatable = false)
    public long getIdMaker() {
        return idMaker;
    }

    public void setIdMaker(long idMaker) {
        this.idMaker = idMaker;
    }

    @Basic
    @Column(name = "id_employee", nullable = false, insertable = false, updatable = false)
    public long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(long idEmployee) {
        this.idEmployee = idEmployee;
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
    @Column(name = "id_routing_equipment", nullable = false, insertable = false, updatable = false)
    public long getIdRoutingEquipment() {
        return idRoutingEquipment;
    }

    public void setIdRoutingEquipment(long idRoutingEquipment) {
        this.idRoutingEquipment = idRoutingEquipment;
    }

    @Basic
    @Column(name = "id_exec_routing_work", nullable = false, insertable = false, updatable = false)
    public long getIdExecRoutingWork() {
        return idExecRoutingWork;
    }

    public void setIdExecRoutingWork(long idExecRoutingWork) {
        this.idExecRoutingWork = idExecRoutingWork;
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
    @Column(name = "fuel_consum", nullable = true, precision = 5)
    public BigDecimal getFuelConsum() {
        return fuelConsum;
    }

    public void setFuelConsum(BigDecimal fuelConsum) {
        this.fuelConsum = fuelConsum;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegExecRoutingEquipmentEntity that = (RegExecRoutingEquipmentEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idRouting != that.idRouting) return false;
        if (idRoutingWork != that.idRoutingWork) return false;
        if (idMaker != that.idMaker) return false;
        if (idEmployee != that.idEmployee) return false;
        if (idOrganizationEquipment != that.idOrganizationEquipment) return false;
        if (idRoutingEquipment != that.idRoutingEquipment) return false;
        if (idExecRoutingWork != that.idExecRoutingWork) return false;
        if (idUnit != that.idUnit) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (dateBegin != null ? !dateBegin.equals(that.dateBegin) : that.dateBegin != null) return false;
        if (dateEnd != null ? !dateEnd.equals(that.dateEnd) : that.dateEnd != null) return false;
        if (fuelConsum != null ? !fuelConsum.equals(that.fuelConsum) : that.fuelConsum != null) return false;
        return number != null ? number.equals(that.number) : that.number == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (dateBegin != null ? dateBegin.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idRouting ^ (idRouting >>> 32));
        result = 31 * result + (int) (idRoutingWork ^ (idRoutingWork >>> 32));
        result = 31 * result + (int) (idMaker ^ (idMaker >>> 32));
        result = 31 * result + (int) (idEmployee ^ (idEmployee >>> 32));
        result = 31 * result + (int) (idOrganizationEquipment ^ (idOrganizationEquipment >>> 32));
        result = 31 * result + (int) (idRoutingEquipment ^ (idRoutingEquipment >>> 32));
        result = 31 * result + (int) (idExecRoutingWork ^ (idExecRoutingWork >>> 32));
        result = 31 * result + (int) (idUnit ^ (idUnit >>> 32));
        result = 31 * result + (fuelConsum != null ? fuelConsum.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
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
    @JoinColumn(name = "id_maker", referencedColumnName = "id", nullable = false)
    public ClsEmployeeEntity getClsEmployeeByIdMaker() {
        return clsEmployeeByIdMaker;
    }

    public void setClsEmployeeByIdMaker(ClsEmployeeEntity clsEmployeeByIdMaker) {
        this.clsEmployeeByIdMaker = clsEmployeeByIdMaker;
    }

    @ManyToOne
    @JoinColumn(name = "id_employee", referencedColumnName = "id", nullable = false)
    public ClsEmployeeEntity getClsEmployeeByIdEmployee() {
        return clsEmployeeByIdEmployee;
    }

    public void setClsEmployeeByIdEmployee(ClsEmployeeEntity clsEmployeeByIdEmployee) {
        this.clsEmployeeByIdEmployee = clsEmployeeByIdEmployee;
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
    @JoinColumn(name = "id_routing_equipment", referencedColumnName = "id", nullable = false)
    public RegOrganizationEquipmentEntity getRegOrganizationEquipmentByIdRoutingEquipment() {
        return regOrganizationEquipmentByIdRoutingEquipment;
    }

    public void setRegOrganizationEquipmentByIdRoutingEquipment(RegOrganizationEquipmentEntity regOrganizationEquipmentByIdRoutingEquipment) {
        this.regOrganizationEquipmentByIdRoutingEquipment = regOrganizationEquipmentByIdRoutingEquipment;
    }

    @ManyToOne
    @JoinColumn(name = "id_exec_routing_work", referencedColumnName = "id", nullable = false)
    public RegExecRoutingWorkEntity getRegExecRoutingWorkByIdExecRoutingWork() {
        return regExecRoutingWorkByIdExecRoutingWork;
    }

    public void setRegExecRoutingWorkByIdExecRoutingWork(RegExecRoutingWorkEntity regExecRoutingWorkByIdExecRoutingWork) {
        this.regExecRoutingWorkByIdExecRoutingWork = regExecRoutingWorkByIdExecRoutingWork;
    }

    @ManyToOne
    @JoinColumn(name = "id_unit", referencedColumnName = "id", nullable = false)
    public ClsUnitEntity getClsUnitByIdUnit() {
        return clsUnitByIdUnit;
    }

    public void setClsUnitByIdUnit(ClsUnitEntity clsUnitByIdUnit) {
        this.clsUnitByIdUnit = clsUnitByIdUnit;
    }
}
