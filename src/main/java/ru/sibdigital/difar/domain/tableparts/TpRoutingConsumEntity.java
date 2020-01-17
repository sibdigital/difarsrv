package ru.sibdigital.difar.domain.tableparts;

import ru.sibdigital.difar.domain.classifier.dict.ClsUnitEntity;
import ru.sibdigital.difar.domain.document.DocRoutingEntity;
import ru.sibdigital.difar.domain.register.RegOrganizationConsumableEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tp_routing_consum", schema = "agrc")
public class TpRoutingConsumEntity {
    private long idUserCreator;
    private Boolean isDeleted;
    private long number;
    private long id;
    private long idRouting;
    private long idRoutingWork;
    private long idOrganizationConsumable;
    private long idConsumableUnit;
    private BigDecimal consumableConsum;
    private DocRoutingEntity docRoutingByIdRouting;
    private TpRoutingWorkEntity tpRoutingWorkByIdRoutingWork;
    private RegOrganizationConsumableEntity regOrganizationConsumableByIdOrganizationConsumable;
    private ClsUnitEntity clsUnitByIdConsumableUnit;

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
    @Column(name = "id_organization_consumable", nullable = false, insertable = false, updatable = false)
    public long getIdOrganizationConsumable() {
        return idOrganizationConsumable;
    }

    public void setIdOrganizationConsumable(long idOrganizationConsumable) {
        this.idOrganizationConsumable = idOrganizationConsumable;
    }

    @Basic
    @Column(name = "id_consumable_unit", nullable = false, insertable = false, updatable = false)
    public long getIdConsumableUnit() {
        return idConsumableUnit;
    }

    public void setIdConsumableUnit(long idConsumableUnit) {
        this.idConsumableUnit = idConsumableUnit;
    }

    @Basic
    @Column(name = "consumable_consum", nullable = true, precision = 5)
    public BigDecimal getConsumableConsum() {
        return consumableConsum;
    }

    public void setConsumableConsum(BigDecimal consumableConsum) {
        this.consumableConsum = consumableConsum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TpRoutingConsumEntity that = (TpRoutingConsumEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (number != that.number) return false;
        if (id != that.id) return false;
        if (idRouting != that.idRouting) return false;
        if (idRoutingWork != that.idRoutingWork) return false;
        if (idOrganizationConsumable != that.idOrganizationConsumable) return false;
        if (idConsumableUnit != that.idConsumableUnit) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        return consumableConsum != null ? consumableConsum.equals(that.consumableConsum) : that.consumableConsum == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (int) (number ^ (number >>> 32));
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idRouting ^ (idRouting >>> 32));
        result = 31 * result + (int) (idRoutingWork ^ (idRoutingWork >>> 32));
        result = 31 * result + (int) (idOrganizationConsumable ^ (idOrganizationConsumable >>> 32));
        result = 31 * result + (int) (idConsumableUnit ^ (idConsumableUnit >>> 32));
        result = 31 * result + (consumableConsum != null ? consumableConsum.hashCode() : 0);
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
    @JoinColumn(name = "id_organization_consumable", referencedColumnName = "id", nullable = false)
    public RegOrganizationConsumableEntity getRegOrganizationConsumableByIdOrganizationConsumable() {
        return regOrganizationConsumableByIdOrganizationConsumable;
    }

    public void setRegOrganizationConsumableByIdOrganizationConsumable(RegOrganizationConsumableEntity regOrganizationConsumableByIdOrganizationConsumable) {
        this.regOrganizationConsumableByIdOrganizationConsumable = regOrganizationConsumableByIdOrganizationConsumable;
    }

    @ManyToOne
    @JoinColumn(name = "id_consumable_unit", referencedColumnName = "id", nullable = false)
    public ClsUnitEntity getClsUnitByIdConsumableUnit() {
        return clsUnitByIdConsumableUnit;
    }

    public void setClsUnitByIdConsumableUnit(ClsUnitEntity clsUnitByIdConsumableUnit) {
        this.clsUnitByIdConsumableUnit = clsUnitByIdConsumableUnit;
    }
}
