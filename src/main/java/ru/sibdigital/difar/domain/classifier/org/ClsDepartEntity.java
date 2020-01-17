package ru.sibdigital.difar.domain.classifier.org;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.classifier.base.ClsBaseEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsLegalEntityEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsOrganizationEntity;
import ru.sibdigital.difar.domain.register.RegFieldLocalEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_depart", schema = "org")
public class ClsDepartEntity extends ClsBaseEntity {
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
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public ClsDepartEntity setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public ClsDepartEntity setName(String name) {
        this.name = name;
        return this;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public ClsDepartEntity setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public ClsDepartEntity setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public ClsDepartEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "cls_depart_id_seq", schema = "org")
    public long getId() {
        return id;
    }

    public ClsDepartEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "id_legal_entity", nullable = false, insertable = false, updatable = false)
    public long getIdLegalEntity() {
        return idLegalEntity;
    }

    public ClsDepartEntity setIdLegalEntity(long idLegalEntity) {
        this.idLegalEntity = idLegalEntity;
        return this;
    }

    @Basic
    @Column(name = "id_organization", nullable = false, insertable = false, updatable = false)
    public long getIdOrganization() {
        return idOrganization;
    }

    public ClsDepartEntity setIdOrganization(long idOrganization) {
        this.idOrganization = idOrganization;
        return this;
    }

    @Basic
    @Column(name = "is_separate", nullable = true)
    public Boolean getSeparate() {
        return isSeparate;
    }

    public ClsDepartEntity setSeparate(Boolean separate) {
        isSeparate = separate;
        return this;
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
    @JsonIgnore
    public Collection<RegFieldLocalEntity> getRegFieldLocalsById() {
        return regFieldLocalsById;
    }

    public ClsDepartEntity setRegFieldLocalsById(Collection<RegFieldLocalEntity> regFieldLocalsById) {
        this.regFieldLocalsById = regFieldLocalsById;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "id_legal_entity", referencedColumnName = "id", nullable = false)
    public ClsLegalEntityEntity getClsLegalEntityByIdLegalEntity() {
        return clsLegalEntityByIdLegalEntity;
    }

    public ClsDepartEntity setClsLegalEntityByIdLegalEntity(ClsLegalEntityEntity clsLegalEntityByIdLegalEntity) {
        this.clsLegalEntityByIdLegalEntity = clsLegalEntityByIdLegalEntity;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "id_organization", referencedColumnName = "id", nullable = false)
    public ClsOrganizationEntity getClsOrganizationByIdOrganization() {
        return clsOrganizationByIdOrganization;
    }

    public ClsDepartEntity setClsOrganizationByIdOrganization(ClsOrganizationEntity clsOrganizationByIdOrganization) {
        this.clsOrganizationByIdOrganization = clsOrganizationByIdOrganization;
        return this;
    }

    @OneToMany(mappedBy = "clsDepartByIdDepart")
    @JsonIgnore
    public Collection<ClsEmployeeEntity> getClsEmployeesById() {
        return clsEmployeesById;
    }

    public ClsDepartEntity setClsEmployeesById(Collection<ClsEmployeeEntity> clsEmployeesById) {
        this.clsEmployeesById = clsEmployeesById;
        return this;
    }

    @OneToMany(mappedBy = "clsDepartByIdDepart")
    @JsonIgnore
    public Collection<ClsEquipmentBaseEntity> getClsEquipmentBasesById() {
        return clsEquipmentBasesById;
    }

    public ClsDepartEntity setClsEquipmentBasesById(Collection<ClsEquipmentBaseEntity> clsEquipmentBasesById) {
        this.clsEquipmentBasesById = clsEquipmentBasesById;
        return this;
    }

    @OneToMany(mappedBy = "clsDepartByIdDepart")
    @JsonIgnore
    public Collection<ClsRanchEntity> getClsRanchesById() {
        return clsRanchesById;
    }

    public ClsDepartEntity setClsRanchesById(Collection<ClsRanchEntity> clsRanchesById) {
        this.clsRanchesById = clsRanchesById;
        return this;
    }
}
