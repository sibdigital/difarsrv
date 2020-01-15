package ru.sibdigital.difar.domain.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.sibdigital.difar.domain.catalog.ClsOrganizationEntity;
import ru.sibdigital.difar.domain.catalog.ClsRanchEntity;
import ru.sibdigital.difar.domain.catalog.ClsTypeAnimalEventEntity;
import ru.sibdigital.difar.domain.tableparts.TpAnimalTransferAnimalEntity;
import ru.sibdigital.difar.domain.tableparts.TpAnimalTransferAnimalGroupEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "doc_animal_transfer", schema = "breed")
public class DocAnimalTransferEntity {
    private long idUserCreator;
    private Timestamp dateCreate;
    private Timestamp dateReg;
    private Boolean isDeleted;
    private String number;
    private long id;
    private long idOrganization;
    private long idTypeAnimalEvent;
    private long idRanch;
    private long idRanchCurrent;
    private Integer multiplicity;
    private ClsOrganizationEntity clsOrganizationByIdOrganization;
    private ClsTypeAnimalEventEntity clsTypeAnimalEventByIdTypeAnimalEvent;
    private ClsRanchEntity clsRanchByIdRanch;
    private ClsRanchEntity clsRanchByIdRanchCurrent;
    private Collection<TpAnimalTransferAnimalEntity> tpAnimalTransferAnimalsById;
    private Collection<TpAnimalTransferAnimalGroupEntity> tpAnimalTransferAnimalGroupsById;

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
    @Column(name = "id_type_animal_event", nullable = false, insertable = false, updatable = false)
    public long getIdTypeAnimalEvent() {
        return idTypeAnimalEvent;
    }

    public void setIdTypeAnimalEvent(long idTypeAnimalEvent) {
        this.idTypeAnimalEvent = idTypeAnimalEvent;
    }

    @Basic
    @Column(name = "id_ranch", nullable = false, insertable = false, updatable = false)
    public long getIdRanch() {
        return idRanch;
    }

    public void setIdRanch(long idRanch) {
        this.idRanch = idRanch;
    }

    @Basic
    @Column(name = "id_ranch_current", nullable = false, insertable = false, updatable = false)
    public long getIdRanchCurrent() {
        return idRanchCurrent;
    }

    public void setIdRanchCurrent(long idRanchCurrent) {
        this.idRanchCurrent = idRanchCurrent;
    }

    @Basic
    @Column(name = "multiplicity", nullable = true)
    public Integer getMultiplicity() {
        return multiplicity;
    }

    public void setMultiplicity(Integer multiplicity) {
        this.multiplicity = multiplicity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocAnimalTransferEntity that = (DocAnimalTransferEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idOrganization != that.idOrganization) return false;
        if (idTypeAnimalEvent != that.idTypeAnimalEvent) return false;
        if (idRanch != that.idRanch) return false;
        if (idRanchCurrent != that.idRanchCurrent) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (dateReg != null ? !dateReg.equals(that.dateReg) : that.dateReg != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        return multiplicity != null ? multiplicity.equals(that.multiplicity) : that.multiplicity == null;
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
        result = 31 * result + (int) (idTypeAnimalEvent ^ (idTypeAnimalEvent >>> 32));
        result = 31 * result + (int) (idRanch ^ (idRanch >>> 32));
        result = 31 * result + (int) (idRanchCurrent ^ (idRanchCurrent >>> 32));
        result = 31 * result + (multiplicity != null ? multiplicity.hashCode() : 0);
        return result;
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
    @JoinColumn(name = "id_type_animal_event", referencedColumnName = "id", nullable = false)
    public ClsTypeAnimalEventEntity getClsTypeAnimalEventByIdTypeAnimalEvent() {
        return clsTypeAnimalEventByIdTypeAnimalEvent;
    }

    public void setClsTypeAnimalEventByIdTypeAnimalEvent(ClsTypeAnimalEventEntity clsTypeAnimalEventByIdTypeAnimalEvent) {
        this.clsTypeAnimalEventByIdTypeAnimalEvent = clsTypeAnimalEventByIdTypeAnimalEvent;
    }

    @ManyToOne
    @JoinColumn(name = "id_ranch", referencedColumnName = "id", nullable = false)
    public ClsRanchEntity getClsRanchByIdRanch() {
        return clsRanchByIdRanch;
    }

    public void setClsRanchByIdRanch(ClsRanchEntity clsRanchByIdRanch) {
        this.clsRanchByIdRanch = clsRanchByIdRanch;
    }

    @ManyToOne
    @JoinColumn(name = "id_ranch_current", referencedColumnName = "id", nullable = false)
    public ClsRanchEntity getClsRanchByIdRanchCurrent() {
        return clsRanchByIdRanchCurrent;
    }

    public void setClsRanchByIdRanchCurrent(ClsRanchEntity clsRanchByIdRanchCurrent) {
        this.clsRanchByIdRanchCurrent = clsRanchByIdRanchCurrent;
    }

    @OneToMany(mappedBy = "docAnimalTransferByIdAnimalTransfer")
    @JsonIgnore
    public Collection<TpAnimalTransferAnimalEntity> getTpAnimalTransferAnimalsById() {
        return tpAnimalTransferAnimalsById;
    }

    public void setTpAnimalTransferAnimalsById(Collection<TpAnimalTransferAnimalEntity> tpAnimalTransferAnimalsById) {
        this.tpAnimalTransferAnimalsById = tpAnimalTransferAnimalsById;
    }

    @OneToMany(mappedBy = "docAnimalTransferByIdAnimalTransfer")
    @JsonIgnore
    public Collection<TpAnimalTransferAnimalGroupEntity> getTpAnimalTransferAnimalGroupsById() {
        return tpAnimalTransferAnimalGroupsById;
    }

    public void setTpAnimalTransferAnimalGroupsById(Collection<TpAnimalTransferAnimalGroupEntity> tpAnimalTransferAnimalGroupsById) {
        this.tpAnimalTransferAnimalGroupsById = tpAnimalTransferAnimalGroupsById;
    }
}
