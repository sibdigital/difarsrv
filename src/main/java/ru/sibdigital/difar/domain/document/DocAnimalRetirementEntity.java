package ru.sibdigital.difar.domain.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.sibdigital.difar.domain.classifier.breed.ClsTypeAnimalEventEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsOrganizationEntity;
import ru.sibdigital.difar.domain.tableparts.TpAnimalRetirementAnimalEntity;
import ru.sibdigital.difar.domain.tableparts.TpAnimalRetirementAnimalGroupEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "doc_animal_retirement", schema = "breed")
public class DocAnimalRetirementEntity {
    private long idUserCreator;
    private Timestamp dateCreate;
    private Timestamp dateReg;
    private Boolean isDeleted;
    private String number;
    private long id;
    private long idOrganization;
    private long idTypeAnimalEvent;
    private Integer multiplicity;
    private ClsOrganizationEntity clsOrganizationByIdOrganization;
    private ClsTypeAnimalEventEntity clsTypeAnimalEventByIdTypeAnimalEvent;
    private Collection<TpAnimalRetirementAnimalEntity> tpAnimalRetirementAnimalsById;
    private Collection<TpAnimalRetirementAnimalGroupEntity> tpAnimalRetirementAnimalGroupsById;

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

        DocAnimalRetirementEntity that = (DocAnimalRetirementEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idOrganization != that.idOrganization) return false;
        if (idTypeAnimalEvent != that.idTypeAnimalEvent) return false;
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

    @OneToMany(mappedBy = "docAnimalRetirementByIdAnimalRetirement")
    @JsonIgnore
    public Collection<TpAnimalRetirementAnimalEntity> getTpAnimalRetirementAnimalsById() {
        return tpAnimalRetirementAnimalsById;
    }

    public void setTpAnimalRetirementAnimalsById(Collection<TpAnimalRetirementAnimalEntity> tpAnimalRetirementAnimalsById) {
        this.tpAnimalRetirementAnimalsById = tpAnimalRetirementAnimalsById;
    }

    @OneToMany(mappedBy = "docAnimalRetirementByIdAnimalRetirement")
    @JsonIgnore
    public Collection<TpAnimalRetirementAnimalGroupEntity> getTpAnimalRetirementAnimalGroupsById() {
        return tpAnimalRetirementAnimalGroupsById;
    }

    public void setTpAnimalRetirementAnimalGroupsById(Collection<TpAnimalRetirementAnimalGroupEntity> tpAnimalRetirementAnimalGroupsById) {
        this.tpAnimalRetirementAnimalGroupsById = tpAnimalRetirementAnimalGroupsById;
    }
}
