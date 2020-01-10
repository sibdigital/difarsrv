package ru.sibdigital.difar.domain.catalog;

import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.register.RegFieldLocalEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_depart", schema = "org")
public class ClsDepartEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private long id;
    private long idLegalEntity;
    private long idOrganization;
    private Boolean isSeparate;
    private Collection<RegFieldLocalEntity> regFieldLocalsById;
    private ClsLegalEntityEntity clsLegalEntityByIdLegalEntity;
    private ClsOrganizationEntity clsOrganizationByIdOrganization;
    private Collection<ClsEmployeeEntity> clsEmployeesById;
    private Collection<ClsEquipmentBaseEntity> clsEquipmentBasesById;
    private Collection<ClsRanchEntity> clsRanchesById;

    @Basic
    @Column(name = "id_user_creator", nullable = false, insertable = false, updatable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public void setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_legal_entity", nullable = false, insertable = false, updatable = false)
    public long getIdLegalEntity() {
        return idLegalEntity;
    }

    public void setIdLegalEntity(long idLegalEntity) {
        this.idLegalEntity = idLegalEntity;
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
    @Column(name = "is_separate", nullable = true)
    public Boolean getSeparate() {
        return isSeparate;
    }

    public void setSeparate(Boolean separate) {
        isSeparate = separate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsDepartEntity that = (ClsDepartEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idLegalEntity != that.idLegalEntity) return false;
        if (idOrganization != that.idOrganization) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        return isSeparate != null ? isSeparate.equals(that.isSeparate) : that.isSeparate == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idLegalEntity ^ (idLegalEntity >>> 32));
        result = 31 * result + (int) (idOrganization ^ (idOrganization >>> 32));
        result = 31 * result + (isSeparate != null ? isSeparate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "clsDepartByIdDepart")
    public Collection<RegFieldLocalEntity> getRegFieldLocalsById() {
        return regFieldLocalsById;
    }

    public void setRegFieldLocalsById(Collection<RegFieldLocalEntity> regFieldLocalsById) {
        this.regFieldLocalsById = regFieldLocalsById;
    }

    @ManyToOne
    @JoinColumn(name = "id_legal_entity", referencedColumnName = "id", nullable = false)
    public ClsLegalEntityEntity getClsLegalEntityByIdLegalEntity() {
        return clsLegalEntityByIdLegalEntity;
    }

    public void setClsLegalEntityByIdLegalEntity(ClsLegalEntityEntity clsLegalEntityByIdLegalEntity) {
        this.clsLegalEntityByIdLegalEntity = clsLegalEntityByIdLegalEntity;
    }

    @ManyToOne
    @JoinColumn(name = "id_organization", referencedColumnName = "id", nullable = false)
    public ClsOrganizationEntity getClsOrganizationByIdOrganization() {
        return clsOrganizationByIdOrganization;
    }

    public void setClsOrganizationByIdOrganization(ClsOrganizationEntity clsOrganizationByIdOrganization) {
        this.clsOrganizationByIdOrganization = clsOrganizationByIdOrganization;
    }

    @OneToMany(mappedBy = "clsDepartByIdDepart")
    public Collection<ClsEmployeeEntity> getClsEmployeesById() {
        return clsEmployeesById;
    }

    public void setClsEmployeesById(Collection<ClsEmployeeEntity> clsEmployeesById) {
        this.clsEmployeesById = clsEmployeesById;
    }

    @OneToMany(mappedBy = "clsDepartByIdDepart")
    public Collection<ClsEquipmentBaseEntity> getClsEquipmentBasesById() {
        return clsEquipmentBasesById;
    }

    public void setClsEquipmentBasesById(Collection<ClsEquipmentBaseEntity> clsEquipmentBasesById) {
        this.clsEquipmentBasesById = clsEquipmentBasesById;
    }

    @OneToMany(mappedBy = "clsDepartByIdDepart")
    public Collection<ClsRanchEntity> getClsRanchesById() {
        return clsRanchesById;
    }

    public void setClsRanchesById(Collection<ClsRanchEntity> clsRanchesById) {
        this.clsRanchesById = clsRanchesById;
    }
}
