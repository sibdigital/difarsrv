package ru.sibdigital.difar.domain.register;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.sibdigital.difar.domain.classifier.breed.ClsAnimalGroupKindEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsOrganizationEntity;
import ru.sibdigital.difar.domain.classifier.org.ClsRanchEntity;
import ru.sibdigital.difar.domain.tableparts.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "reg_animal_group", schema = "breed")
public class RegAnimalGroupEntity {
    private long idUserCreator;
    private Timestamp dateCreate;
    private Timestamp dateBegin;
    private Timestamp dateEnd;
    private long id;
    private long idOrganization;
    private long idRanch;
    private long idAnimal;
    private long idAnimalGroupKind;
    private Collection<RegAnimalEntity> regAnimalsById;
    private Collection<RegAnimalEntity> regAnimalsById_0;
    private ClsOrganizationEntity clsOrganizationByIdOrganization;
    private ClsRanchEntity clsRanchByIdRanch;
    private RegAnimalEntity regAnimalByIdAnimal;
    private ClsAnimalGroupKindEntity clsAnimalGroupKindByIdAnimalGroupKind;
    private Collection<TpAnimalAppraisalAnimalGroupEntity> tpAnimalAppraisalAnimalGroupsById;
    private Collection<TpAnimalBeatingAnimalGroupEntity> tpAnimalBeatingAnimalGroupsById;
    private Collection<TpAnimalCalvingAnimalGroupEntity> tpAnimalCalvingAnimalGroupsById;
    private Collection<TpAnimalCalvingAnimalGroupEntity> tpAnimalCalvingAnimalGroupsById_0;
    private Collection<TpAnimalCopulationAnimalGroupEntity> tpAnimalCopulationAnimalGroupsById;
    private Collection<TpAnimalCopulationAnimalGroupEntity> tpAnimalCopulationAnimalGroupsById_0;
    private Collection<TpAnimalCopulationAnimalGroupFemaleEntity> tpAnimalCopulationAnimalGroupFemalesById;
    private Collection<TpAnimalCopulationAnimalGroupFemaleEntity> tpAnimalCopulationAnimalGroupFemalesById_0;
    private Collection<TpAnimalEventAnimalGroupEntity> tpAnimalEventAnimalGroupsById;
    private Collection<TpAnimalEventAnimalGroupEntity> tpAnimalEventAnimalGroupsById_0;
    private Collection<TpAnimalRetirementAnimalGroupEntity> tpAnimalRetirementAnimalGroupsById;
    private Collection<TpAnimalSaleAnimalGroupEntity> tpAnimalSaleAnimalGroupsById;
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
    @Column(name = "id_organization", nullable = false, insertable = false, updatable = false)
    public long getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(long idOrganization) {
        this.idOrganization = idOrganization;
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
    @Column(name = "id_animal", nullable = false, insertable = false, updatable = false)
    public long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(long idAnimal) {
        this.idAnimal = idAnimal;
    }

    @Basic
    @Column(name = "id_animal_group_kind", nullable = false, insertable = false, updatable = false)
    public long getIdAnimalGroupKind() {
        return idAnimalGroupKind;
    }

    public void setIdAnimalGroupKind(long idAnimalGroupKind) {
        this.idAnimalGroupKind = idAnimalGroupKind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegAnimalGroupEntity that = (RegAnimalGroupEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idOrganization != that.idOrganization) return false;
        if (idRanch != that.idRanch) return false;
        if (idAnimal != that.idAnimal) return false;
        if (idAnimalGroupKind != that.idAnimalGroupKind) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (dateBegin != null ? !dateBegin.equals(that.dateBegin) : that.dateBegin != null) return false;
        return dateEnd != null ? dateEnd.equals(that.dateEnd) : that.dateEnd == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (dateBegin != null ? dateBegin.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idOrganization ^ (idOrganization >>> 32));
        result = 31 * result + (int) (idRanch ^ (idRanch >>> 32));
        result = 31 * result + (int) (idAnimal ^ (idAnimal >>> 32));
        result = 31 * result + (int) (idAnimalGroupKind ^ (idAnimalGroupKind >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "regAnimalGroupByIdGroupMother")
    @JsonIgnore
    public Collection<RegAnimalEntity> getRegAnimalsById() {
        return regAnimalsById;
    }

    public void setRegAnimalsById(Collection<RegAnimalEntity> regAnimalsById) {
        this.regAnimalsById = regAnimalsById;
    }

    @OneToMany(mappedBy = "regAnimalGroupByIdGroupFather")
    @JsonIgnore
    public Collection<RegAnimalEntity> getRegAnimalsById_0() {
        return regAnimalsById_0;
    }

    public void setRegAnimalsById_0(Collection<RegAnimalEntity> regAnimalsById_0) {
        this.regAnimalsById_0 = regAnimalsById_0;
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
    @JoinColumn(name = "id_ranch", referencedColumnName = "id", nullable = false)
    public ClsRanchEntity getClsRanchByIdRanch() {
        return clsRanchByIdRanch;
    }

    public void setClsRanchByIdRanch(ClsRanchEntity clsRanchByIdRanch) {
        this.clsRanchByIdRanch = clsRanchByIdRanch;
    }

    @ManyToOne
    @JoinColumn(name = "id_animal", referencedColumnName = "id", nullable = false)
    public RegAnimalEntity getRegAnimalByIdAnimal() {
        return regAnimalByIdAnimal;
    }

    public void setRegAnimalByIdAnimal(RegAnimalEntity regAnimalByIdAnimal) {
        this.regAnimalByIdAnimal = regAnimalByIdAnimal;
    }

    @ManyToOne
    @JoinColumn(name = "id_animal_group_kind", referencedColumnName = "id", nullable = false)
    public ClsAnimalGroupKindEntity getClsAnimalGroupKindByIdAnimalGroupKind() {
        return clsAnimalGroupKindByIdAnimalGroupKind;
    }

    public void setClsAnimalGroupKindByIdAnimalGroupKind(ClsAnimalGroupKindEntity clsAnimalGroupKindByIdAnimalGroupKind) {
        this.clsAnimalGroupKindByIdAnimalGroupKind = clsAnimalGroupKindByIdAnimalGroupKind;
    }

    @OneToMany(mappedBy = "regAnimalGroupByIdAnimalGroup")
    @JsonIgnore
    public Collection<TpAnimalAppraisalAnimalGroupEntity> getTpAnimalAppraisalAnimalGroupsById() {
        return tpAnimalAppraisalAnimalGroupsById;
    }

    public void setTpAnimalAppraisalAnimalGroupsById(Collection<TpAnimalAppraisalAnimalGroupEntity> tpAnimalAppraisalAnimalGroupsById) {
        this.tpAnimalAppraisalAnimalGroupsById = tpAnimalAppraisalAnimalGroupsById;
    }

    @OneToMany(mappedBy = "regAnimalGroupByIdAnimalMotherGroup")
    @JsonIgnore
    public Collection<TpAnimalBeatingAnimalGroupEntity> getTpAnimalBeatingAnimalGroupsById() {
        return tpAnimalBeatingAnimalGroupsById;
    }

    public void setTpAnimalBeatingAnimalGroupsById(Collection<TpAnimalBeatingAnimalGroupEntity> tpAnimalBeatingAnimalGroupsById) {
        this.tpAnimalBeatingAnimalGroupsById = tpAnimalBeatingAnimalGroupsById;
    }

    @OneToMany(mappedBy = "regAnimalGroupByIdAnimalMotherGroup")
    @JsonIgnore
    public Collection<TpAnimalCalvingAnimalGroupEntity> getTpAnimalCalvingAnimalGroupsById() {
        return tpAnimalCalvingAnimalGroupsById;
    }

    public void setTpAnimalCalvingAnimalGroupsById(Collection<TpAnimalCalvingAnimalGroupEntity> tpAnimalCalvingAnimalGroupsById) {
        this.tpAnimalCalvingAnimalGroupsById = tpAnimalCalvingAnimalGroupsById;
    }

    @OneToMany(mappedBy = "regAnimalGroupByIdAnimalFatherGroup")
    @JsonIgnore
    public Collection<TpAnimalCalvingAnimalGroupEntity> getTpAnimalCalvingAnimalGroupsById_0() {
        return tpAnimalCalvingAnimalGroupsById_0;
    }

    public void setTpAnimalCalvingAnimalGroupsById_0(Collection<TpAnimalCalvingAnimalGroupEntity> tpAnimalCalvingAnimalGroupsById_0) {
        this.tpAnimalCalvingAnimalGroupsById_0 = tpAnimalCalvingAnimalGroupsById_0;
    }

    @OneToMany(mappedBy = "regAnimalGroupByIdAnimalFemaleGroup")
    @JsonIgnore
    public Collection<TpAnimalCopulationAnimalGroupEntity> getTpAnimalCopulationAnimalGroupsById() {
        return tpAnimalCopulationAnimalGroupsById;
    }

    public void setTpAnimalCopulationAnimalGroupsById(Collection<TpAnimalCopulationAnimalGroupEntity> tpAnimalCopulationAnimalGroupsById) {
        this.tpAnimalCopulationAnimalGroupsById = tpAnimalCopulationAnimalGroupsById;
    }

    @OneToMany(mappedBy = "regAnimalGroupByIdAnimalMaleGroup")
    @JsonIgnore
    public Collection<TpAnimalCopulationAnimalGroupEntity> getTpAnimalCopulationAnimalGroupsById_0() {
        return tpAnimalCopulationAnimalGroupsById_0;
    }

    public void setTpAnimalCopulationAnimalGroupsById_0(Collection<TpAnimalCopulationAnimalGroupEntity> tpAnimalCopulationAnimalGroupsById_0) {
        this.tpAnimalCopulationAnimalGroupsById_0 = tpAnimalCopulationAnimalGroupsById_0;
    }

    @OneToMany(mappedBy = "regAnimalGroupByIdAnimalFemaleGroup")
    @JsonIgnore
    public Collection<TpAnimalCopulationAnimalGroupFemaleEntity> getTpAnimalCopulationAnimalGroupFemalesById() {
        return tpAnimalCopulationAnimalGroupFemalesById;
    }

    public void setTpAnimalCopulationAnimalGroupFemalesById(Collection<TpAnimalCopulationAnimalGroupFemaleEntity> tpAnimalCopulationAnimalGroupFemalesById) {
        this.tpAnimalCopulationAnimalGroupFemalesById = tpAnimalCopulationAnimalGroupFemalesById;
    }

    @OneToMany(mappedBy = "regAnimalGroupByIdAnimalMale")
    @JsonIgnore
    public Collection<TpAnimalCopulationAnimalGroupFemaleEntity> getTpAnimalCopulationAnimalGroupFemalesById_0() {
        return tpAnimalCopulationAnimalGroupFemalesById_0;
    }

    public void setTpAnimalCopulationAnimalGroupFemalesById_0(Collection<TpAnimalCopulationAnimalGroupFemaleEntity> tpAnimalCopulationAnimalGroupFemalesById_0) {
        this.tpAnimalCopulationAnimalGroupFemalesById_0 = tpAnimalCopulationAnimalGroupFemalesById_0;
    }

    @OneToMany(mappedBy = "regAnimalGroupByIdAnimalGroup1")
    @JsonIgnore
    public Collection<TpAnimalEventAnimalGroupEntity> getTpAnimalEventAnimalGroupsById() {
        return tpAnimalEventAnimalGroupsById;
    }

    public void setTpAnimalEventAnimalGroupsById(Collection<TpAnimalEventAnimalGroupEntity> tpAnimalEventAnimalGroupsById) {
        this.tpAnimalEventAnimalGroupsById = tpAnimalEventAnimalGroupsById;
    }

    @OneToMany(mappedBy = "regAnimalGroupByIdAnimalGroup2")
    @JsonIgnore
    public Collection<TpAnimalEventAnimalGroupEntity> getTpAnimalEventAnimalGroupsById_0() {
        return tpAnimalEventAnimalGroupsById_0;
    }

    public void setTpAnimalEventAnimalGroupsById_0(Collection<TpAnimalEventAnimalGroupEntity> tpAnimalEventAnimalGroupsById_0) {
        this.tpAnimalEventAnimalGroupsById_0 = tpAnimalEventAnimalGroupsById_0;
    }

    @OneToMany(mappedBy = "regAnimalGroupByIdAnimalGroup")
    @JsonIgnore
    public Collection<TpAnimalRetirementAnimalGroupEntity> getTpAnimalRetirementAnimalGroupsById() {
        return tpAnimalRetirementAnimalGroupsById;
    }

    public void setTpAnimalRetirementAnimalGroupsById(Collection<TpAnimalRetirementAnimalGroupEntity> tpAnimalRetirementAnimalGroupsById) {
        this.tpAnimalRetirementAnimalGroupsById = tpAnimalRetirementAnimalGroupsById;
    }

    @OneToMany(mappedBy = "regAnimalGroupByIdAnimalGroup")
    @JsonIgnore
    public Collection<TpAnimalSaleAnimalGroupEntity> getTpAnimalSaleAnimalGroupsById() {
        return tpAnimalSaleAnimalGroupsById;
    }

    public void setTpAnimalSaleAnimalGroupsById(Collection<TpAnimalSaleAnimalGroupEntity> tpAnimalSaleAnimalGroupsById) {
        this.tpAnimalSaleAnimalGroupsById = tpAnimalSaleAnimalGroupsById;
    }

    @OneToMany(mappedBy = "regAnimalGroupByIdAnimalGroup")
    @JsonIgnore
    public Collection<TpAnimalTransferAnimalGroupEntity> getTpAnimalTransferAnimalGroupsById() {
        return tpAnimalTransferAnimalGroupsById;
    }

    public void setTpAnimalTransferAnimalGroupsById(Collection<TpAnimalTransferAnimalGroupEntity> tpAnimalTransferAnimalGroupsById) {
        this.tpAnimalTransferAnimalGroupsById = tpAnimalTransferAnimalGroupsById;
    }
}
