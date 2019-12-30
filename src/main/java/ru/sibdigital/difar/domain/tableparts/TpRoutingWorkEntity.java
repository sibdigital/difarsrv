package ru.sibdigital.difar.domain.tableparts;

import ru.sibdigital.difar.domain.document.DocRoutingEntity;
import ru.sibdigital.difar.domain.register.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tp_routing_work", schema = "agrc")
public class TpRoutingWorkEntity {
    private long idUserCreator;
    private Boolean isDeleted;
    private long number;
    private long id;
    private long idRouting;
    private long idRoutingStage;
    private Object execTime;
    private Collection<RegExecRoutingConsumEntity> regExecRoutingConsumsById;
    private Collection<RegExecRoutingEquipmentEntity> regExecRoutingEquipmentsById;
    private Collection<RegExecRoutingFertilizerEntity> regExecRoutingFertilizersById;
    private Collection<RegExecRoutingProtectionEquipmentEntity> regExecRoutingProtectionEquipmentsById;
    private Collection<RegExecRoutingWorkEntity> regExecRoutingWorksById;
    private Collection<TpRoutingConsumEntity> tpRoutingConsumsById;
    private Collection<TpRoutingEquipmentEntity> tpRoutingEquipmentsById;
    private Collection<TpRoutingFertilizerEntity> tpRoutingFertilizersById;
    private Collection<TpRoutingProtectionEquipmentEntity> tpRoutingProtectionEquipmentsById;
    private DocRoutingEntity docRoutingByIdRouting;
    private TpRoutingStageEntity tpRoutingStageByIdRoutingStage;

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
    @Column(name = "id_routing", nullable = false)
    public long getIdRouting() {
        return idRouting;
    }

    public void setIdRouting(long idRouting) {
        this.idRouting = idRouting;
    }

    @Basic
    @Column(name = "id_routing_stage", nullable = false)
    public long getIdRoutingStage() {
        return idRoutingStage;
    }

    public void setIdRoutingStage(long idRoutingStage) {
        this.idRoutingStage = idRoutingStage;
    }

    @Basic
    @Column(name = "exec_time", nullable = true)
    public Object getExecTime() {
        return execTime;
    }

    public void setExecTime(Object execTime) {
        this.execTime = execTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TpRoutingWorkEntity that = (TpRoutingWorkEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (number != that.number) return false;
        if (id != that.id) return false;
        if (idRouting != that.idRouting) return false;
        if (idRoutingStage != that.idRoutingStage) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        return execTime != null ? execTime.equals(that.execTime) : that.execTime == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (int) (number ^ (number >>> 32));
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idRouting ^ (idRouting >>> 32));
        result = 31 * result + (int) (idRoutingStage ^ (idRoutingStage >>> 32));
        result = 31 * result + (execTime != null ? execTime.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tpRoutingWorkByIdRoutingWork")
    public Collection<RegExecRoutingConsumEntity> getRegExecRoutingConsumsById() {
        return regExecRoutingConsumsById;
    }

    public void setRegExecRoutingConsumsById(Collection<RegExecRoutingConsumEntity> regExecRoutingConsumsById) {
        this.regExecRoutingConsumsById = regExecRoutingConsumsById;
    }

    @OneToMany(mappedBy = "tpRoutingWorkByIdRoutingWork")
    public Collection<RegExecRoutingEquipmentEntity> getRegExecRoutingEquipmentsById() {
        return regExecRoutingEquipmentsById;
    }

    public void setRegExecRoutingEquipmentsById(Collection<RegExecRoutingEquipmentEntity> regExecRoutingEquipmentsById) {
        this.regExecRoutingEquipmentsById = regExecRoutingEquipmentsById;
    }

    @OneToMany(mappedBy = "tpRoutingWorkByIdRoutingWork")
    public Collection<RegExecRoutingFertilizerEntity> getRegExecRoutingFertilizersById() {
        return regExecRoutingFertilizersById;
    }

    public void setRegExecRoutingFertilizersById(Collection<RegExecRoutingFertilizerEntity> regExecRoutingFertilizersById) {
        this.regExecRoutingFertilizersById = regExecRoutingFertilizersById;
    }

    @OneToMany(mappedBy = "tpRoutingWorkByIdRoutingWork")
    public Collection<RegExecRoutingProtectionEquipmentEntity> getRegExecRoutingProtectionEquipmentsById() {
        return regExecRoutingProtectionEquipmentsById;
    }

    public void setRegExecRoutingProtectionEquipmentsById(Collection<RegExecRoutingProtectionEquipmentEntity> regExecRoutingProtectionEquipmentsById) {
        this.regExecRoutingProtectionEquipmentsById = regExecRoutingProtectionEquipmentsById;
    }

    @OneToMany(mappedBy = "tpRoutingWorkByIdRoutingWork")
    public Collection<RegExecRoutingWorkEntity> getRegExecRoutingWorksById() {
        return regExecRoutingWorksById;
    }

    public void setRegExecRoutingWorksById(Collection<RegExecRoutingWorkEntity> regExecRoutingWorksById) {
        this.regExecRoutingWorksById = regExecRoutingWorksById;
    }

    @OneToMany(mappedBy = "tpRoutingWorkByIdRoutingWork")
    public Collection<TpRoutingConsumEntity> getTpRoutingConsumsById() {
        return tpRoutingConsumsById;
    }

    public void setTpRoutingConsumsById(Collection<TpRoutingConsumEntity> tpRoutingConsumsById) {
        this.tpRoutingConsumsById = tpRoutingConsumsById;
    }

    @OneToMany(mappedBy = "tpRoutingWorkByIdRoutingWork")
    public Collection<TpRoutingEquipmentEntity> getTpRoutingEquipmentsById() {
        return tpRoutingEquipmentsById;
    }

    public void setTpRoutingEquipmentsById(Collection<TpRoutingEquipmentEntity> tpRoutingEquipmentsById) {
        this.tpRoutingEquipmentsById = tpRoutingEquipmentsById;
    }

    @OneToMany(mappedBy = "tpRoutingWorkByIdRoutingWork")
    public Collection<TpRoutingFertilizerEntity> getTpRoutingFertilizersById() {
        return tpRoutingFertilizersById;
    }

    public void setTpRoutingFertilizersById(Collection<TpRoutingFertilizerEntity> tpRoutingFertilizersById) {
        this.tpRoutingFertilizersById = tpRoutingFertilizersById;
    }

    @OneToMany(mappedBy = "tpRoutingWorkByIdRoutingWork")
    public Collection<TpRoutingProtectionEquipmentEntity> getTpRoutingProtectionEquipmentsById() {
        return tpRoutingProtectionEquipmentsById;
    }

    public void setTpRoutingProtectionEquipmentsById(Collection<TpRoutingProtectionEquipmentEntity> tpRoutingProtectionEquipmentsById) {
        this.tpRoutingProtectionEquipmentsById = tpRoutingProtectionEquipmentsById;
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
    @JoinColumn(name = "id_routing_stage", referencedColumnName = "id", nullable = false)
    public TpRoutingStageEntity getTpRoutingStageByIdRoutingStage() {
        return tpRoutingStageByIdRoutingStage;
    }

    public void setTpRoutingStageByIdRoutingStage(TpRoutingStageEntity tpRoutingStageByIdRoutingStage) {
        this.tpRoutingStageByIdRoutingStage = tpRoutingStageByIdRoutingStage;
    }
}
