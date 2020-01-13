package ru.sibdigital.difar.domain.register;

import ru.sibdigital.difar.domain.catalog.ClsEmployeeEntity;
import ru.sibdigital.difar.domain.catalog.ClsUnitEntity;
import ru.sibdigital.difar.domain.document.DocRoutingEntity;
import ru.sibdigital.difar.domain.tableparts.TpRoutingWorkEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "reg_exec_routing_consum", schema = "agrc")
public class RegExecRoutingConsumEntity {
    private long idUserCreator;
    private Timestamp dateCreate;
    private Timestamp dateBegin;
    private Timestamp dateEnd;
    private long id;
    private long idRouting;
    private long idRoutingWork;
    private long idMaker;
    private long idEmployee;
    private long idOrganizationConsum;
    private long idRoutingConsum;
    private long idExecRoutingWork;
    private long idConsumUnit;
    private BigDecimal consumConsum;
    private String number;
    private DocRoutingEntity docRoutingByIdRouting;
    private TpRoutingWorkEntity tpRoutingWorkByIdRoutingWork;
    private ClsEmployeeEntity clsEmployeeByIdMaker;
    private ClsEmployeeEntity clsEmployeeByIdEmployee;
    private RegOrganizationConsumableEntity regOrganizationConsumableByIdOrganizationConsum;
    private RegOrganizationConsumableEntity regOrganizationConsumableByIdRoutingConsum;
    private RegExecRoutingWorkEntity regExecRoutingWorkByIdExecRoutingWork;
    private ClsUnitEntity clsUnitByIdConsumUnit;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
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
    @Column(name = "id_organization_consum", nullable = false, insertable = false, updatable = false)
    public long getIdOrganizationConsum() {
        return idOrganizationConsum;
    }

    public void setIdOrganizationConsum(long idOrganizationConsum) {
        this.idOrganizationConsum = idOrganizationConsum;
    }

    @Basic
    @Column(name = "id_routing_consum", nullable = false, insertable = false, updatable = false)
    public long getIdRoutingConsum() {
        return idRoutingConsum;
    }

    public void setIdRoutingConsum(long idRoutingConsum) {
        this.idRoutingConsum = idRoutingConsum;
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
    @Column(name = "id_consum_unit", nullable = false, insertable = false, updatable = false)
    public long getIdConsumUnit() {
        return idConsumUnit;
    }

    public void setIdConsumUnit(long idConsumUnit) {
        this.idConsumUnit = idConsumUnit;
    }

    @Basic
    @Column(name = "consum_consum", nullable = true, precision = 5)
    public BigDecimal getConsumConsum() {
        return consumConsum;
    }

    public void setConsumConsum(BigDecimal consumConsum) {
        this.consumConsum = consumConsum;
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

        RegExecRoutingConsumEntity that = (RegExecRoutingConsumEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idRouting != that.idRouting) return false;
        if (idRoutingWork != that.idRoutingWork) return false;
        if (idMaker != that.idMaker) return false;
        if (idEmployee != that.idEmployee) return false;
        if (idOrganizationConsum != that.idOrganizationConsum) return false;
        if (idRoutingConsum != that.idRoutingConsum) return false;
        if (idExecRoutingWork != that.idExecRoutingWork) return false;
        if (idConsumUnit != that.idConsumUnit) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (dateBegin != null ? !dateBegin.equals(that.dateBegin) : that.dateBegin != null) return false;
        if (dateEnd != null ? !dateEnd.equals(that.dateEnd) : that.dateEnd != null) return false;
        if (consumConsum != null ? !consumConsum.equals(that.consumConsum) : that.consumConsum != null) return false;
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
        result = 31 * result + (int) (idOrganizationConsum ^ (idOrganizationConsum >>> 32));
        result = 31 * result + (int) (idRoutingConsum ^ (idRoutingConsum >>> 32));
        result = 31 * result + (int) (idExecRoutingWork ^ (idExecRoutingWork >>> 32));
        result = 31 * result + (int) (idConsumUnit ^ (idConsumUnit >>> 32));
        result = 31 * result + (consumConsum != null ? consumConsum.hashCode() : 0);
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
    @JoinColumn(name = "id_organization_consum", referencedColumnName = "id", nullable = false)
    public RegOrganizationConsumableEntity getRegOrganizationConsumableByIdOrganizationConsum() {
        return regOrganizationConsumableByIdOrganizationConsum;
    }

    public void setRegOrganizationConsumableByIdOrganizationConsum(RegOrganizationConsumableEntity regOrganizationConsumableByIdOrganizationConsum) {
        this.regOrganizationConsumableByIdOrganizationConsum = regOrganizationConsumableByIdOrganizationConsum;
    }

    @ManyToOne
    @JoinColumn(name = "id_routing_consum", referencedColumnName = "id", nullable = false)
    public RegOrganizationConsumableEntity getRegOrganizationConsumableByIdRoutingConsum() {
        return regOrganizationConsumableByIdRoutingConsum;
    }

    public void setRegOrganizationConsumableByIdRoutingConsum(RegOrganizationConsumableEntity regOrganizationConsumableByIdRoutingConsum) {
        this.regOrganizationConsumableByIdRoutingConsum = regOrganizationConsumableByIdRoutingConsum;
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
    @JoinColumn(name = "id_consum_unit", referencedColumnName = "id", nullable = false)
    public ClsUnitEntity getClsUnitByIdConsumUnit() {
        return clsUnitByIdConsumUnit;
    }

    public void setClsUnitByIdConsumUnit(ClsUnitEntity clsUnitByIdConsumUnit) {
        this.clsUnitByIdConsumUnit = clsUnitByIdConsumUnit;
    }
}
