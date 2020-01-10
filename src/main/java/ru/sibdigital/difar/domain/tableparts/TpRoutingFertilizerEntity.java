package ru.sibdigital.difar.domain.tableparts;

import ru.sibdigital.difar.domain.catalog.ClsUnitEntity;
import ru.sibdigital.difar.domain.document.DocRoutingEntity;
import ru.sibdigital.difar.domain.register.RegOrganizationFertilizerEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tp_routing_fertilizer", schema = "agrc")
public class TpRoutingFertilizerEntity {
    private long idUserCreator;
    private Boolean isDeleted;
    private long number;
    private long id;
    private long idRouting;
    private long idRoutingWork;
    private long idOrganizationFertilizer;
    private long idFertilizerUnit;
    private BigDecimal fertilizerConsum;
    private DocRoutingEntity docRoutingByIdRouting;
    private TpRoutingWorkEntity tpRoutingWorkByIdRoutingWork;
    private RegOrganizationFertilizerEntity regOrganizationFertilizerByIdOrganizationFertilizer;
    private ClsUnitEntity clsUnitByIdFertilizerUnit;

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
    @Column(name = "id_organization_fertilizer", nullable = false, insertable = false, updatable = false)
    public long getIdOrganizationFertilizer() {
        return idOrganizationFertilizer;
    }

    public void setIdOrganizationFertilizer(long idOrganizationFertilizer) {
        this.idOrganizationFertilizer = idOrganizationFertilizer;
    }

    @Basic
    @Column(name = "id_fertilizer_unit", nullable = false, insertable = false, updatable = false)
    public long getIdFertilizerUnit() {
        return idFertilizerUnit;
    }

    public void setIdFertilizerUnit(long idFertilizerUnit) {
        this.idFertilizerUnit = idFertilizerUnit;
    }

    @Basic
    @Column(name = "fertilizer_consum", nullable = true, precision = 5)
    public BigDecimal getFertilizerConsum() {
        return fertilizerConsum;
    }

    public void setFertilizerConsum(BigDecimal fertilizerConsum) {
        this.fertilizerConsum = fertilizerConsum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TpRoutingFertilizerEntity that = (TpRoutingFertilizerEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (number != that.number) return false;
        if (id != that.id) return false;
        if (idRouting != that.idRouting) return false;
        if (idRoutingWork != that.idRoutingWork) return false;
        if (idOrganizationFertilizer != that.idOrganizationFertilizer) return false;
        if (idFertilizerUnit != that.idFertilizerUnit) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        return fertilizerConsum != null ? fertilizerConsum.equals(that.fertilizerConsum) : that.fertilizerConsum == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (int) (number ^ (number >>> 32));
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idRouting ^ (idRouting >>> 32));
        result = 31 * result + (int) (idRoutingWork ^ (idRoutingWork >>> 32));
        result = 31 * result + (int) (idOrganizationFertilizer ^ (idOrganizationFertilizer >>> 32));
        result = 31 * result + (int) (idFertilizerUnit ^ (idFertilizerUnit >>> 32));
        result = 31 * result + (fertilizerConsum != null ? fertilizerConsum.hashCode() : 0);
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
    @JoinColumn(name = "id_organization_fertilizer", referencedColumnName = "id", nullable = false)
    public RegOrganizationFertilizerEntity getRegOrganizationFertilizerByIdOrganizationFertilizer() {
        return regOrganizationFertilizerByIdOrganizationFertilizer;
    }

    public void setRegOrganizationFertilizerByIdOrganizationFertilizer(RegOrganizationFertilizerEntity regOrganizationFertilizerByIdOrganizationFertilizer) {
        this.regOrganizationFertilizerByIdOrganizationFertilizer = regOrganizationFertilizerByIdOrganizationFertilizer;
    }

    @ManyToOne
    @JoinColumn(name = "id_fertilizer_unit", referencedColumnName = "id", nullable = false)
    public ClsUnitEntity getClsUnitByIdFertilizerUnit() {
        return clsUnitByIdFertilizerUnit;
    }

    public void setClsUnitByIdFertilizerUnit(ClsUnitEntity clsUnitByIdFertilizerUnit) {
        this.clsUnitByIdFertilizerUnit = clsUnitByIdFertilizerUnit;
    }
}
