package ru.sibdigital.difar.domain.catalog;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.register.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_employee", schema = "org")
public class ClsEmployeeEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private long id;
    private String surname;
    private String firstname;
    private String patronymic;
    private long idDepart;
    private long idOrganization;
    private Collection<ClsUserEntity> clsUsersById;
    private Collection<RegExecRoutingConsumEntity> regExecRoutingConsumsById;
    private Collection<RegExecRoutingConsumEntity> regExecRoutingConsumsById_0;
    private Collection<RegExecRoutingEquipmentEntity> regExecRoutingEquipmentsById;
    private Collection<RegExecRoutingEquipmentEntity> regExecRoutingEquipmentsById_0;
    private Collection<RegExecRoutingFertilizerEntity> regExecRoutingFertilizersById;
    private Collection<RegExecRoutingFertilizerEntity> regExecRoutingFertilizersById_0;
    private Collection<RegExecRoutingProtectionEquipmentEntity> regExecRoutingProtectionEquipmentsById;
    private Collection<RegExecRoutingProtectionEquipmentEntity> regExecRoutingProtectionEquipmentsById_0;
    private Collection<RegExecRoutingWorkEntity> regExecRoutingWorksById;
    private Collection<RegExecRoutingWorkEntity> regExecRoutingWorksById_0;
    private ClsDepartEntity clsDepartByIdDepart;
    private ClsOrganizationEntity clsOrganizationByIdOrganization;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
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
    @Column(name = "surname", nullable = true, length = -1)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "firstname", nullable = true, length = -1)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "patronymic", nullable = true, length = -1)
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Basic
    @Column(name = "id_depart", nullable = false, insertable = false, updatable = false)
    public long getIdDepart() {
        return idDepart;
    }

    public void setIdDepart(long idDepart) {
        this.idDepart = idDepart;
    }

    @Basic
    @Column(name = "id_organization", nullable = false, insertable = false, updatable = false)
    public long getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(long idOrganization) {
        this.idOrganization = idOrganization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsEmployeeEntity that = (ClsEmployeeEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idDepart != that.idDepart) return false;
        if (idOrganization != that.idOrganization) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return patronymic != null ? patronymic.equals(that.patronymic) : that.patronymic == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (int) (idDepart ^ (idDepart >>> 32));
        result = 31 * result + (int) (idOrganization ^ (idOrganization >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "clsEmployeeByIdEmployee")
    @JsonIgnore
public Collection<ClsUserEntity> getClsUsersById() {
        return clsUsersById;
    }

    public void setClsUsersById(Collection<ClsUserEntity> clsUsersById) {
        this.clsUsersById = clsUsersById;
    }

    @OneToMany(mappedBy = "clsEmployeeByIdMaker")
    @JsonIgnore
public Collection<RegExecRoutingConsumEntity> getRegExecRoutingConsumsById() {
        return regExecRoutingConsumsById;
    }

    public void setRegExecRoutingConsumsById(Collection<RegExecRoutingConsumEntity> regExecRoutingConsumsById) {
        this.regExecRoutingConsumsById = regExecRoutingConsumsById;
    }

    @OneToMany(mappedBy = "clsEmployeeByIdEmployee")
    @JsonIgnore
public Collection<RegExecRoutingConsumEntity> getRegExecRoutingConsumsById_0() {
        return regExecRoutingConsumsById_0;
    }

    public void setRegExecRoutingConsumsById_0(Collection<RegExecRoutingConsumEntity> regExecRoutingConsumsById_0) {
        this.regExecRoutingConsumsById_0 = regExecRoutingConsumsById_0;
    }

    @OneToMany(mappedBy = "clsEmployeeByIdMaker")
    @JsonIgnore
public Collection<RegExecRoutingEquipmentEntity> getRegExecRoutingEquipmentsById() {
        return regExecRoutingEquipmentsById;
    }

    public void setRegExecRoutingEquipmentsById(Collection<RegExecRoutingEquipmentEntity> regExecRoutingEquipmentsById) {
        this.regExecRoutingEquipmentsById = regExecRoutingEquipmentsById;
    }

    @OneToMany(mappedBy = "clsEmployeeByIdEmployee")
    @JsonIgnore
public Collection<RegExecRoutingEquipmentEntity> getRegExecRoutingEquipmentsById_0() {
        return regExecRoutingEquipmentsById_0;
    }

    public void setRegExecRoutingEquipmentsById_0(Collection<RegExecRoutingEquipmentEntity> regExecRoutingEquipmentsById_0) {
        this.regExecRoutingEquipmentsById_0 = regExecRoutingEquipmentsById_0;
    }

    @OneToMany(mappedBy = "clsEmployeeByIdMaker")
    @JsonIgnore
public Collection<RegExecRoutingFertilizerEntity> getRegExecRoutingFertilizersById() {
        return regExecRoutingFertilizersById;
    }

    public void setRegExecRoutingFertilizersById(Collection<RegExecRoutingFertilizerEntity> regExecRoutingFertilizersById) {
        this.regExecRoutingFertilizersById = regExecRoutingFertilizersById;
    }

    @OneToMany(mappedBy = "clsEmployeeByIdEmployee")
    @JsonIgnore
public Collection<RegExecRoutingFertilizerEntity> getRegExecRoutingFertilizersById_0() {
        return regExecRoutingFertilizersById_0;
    }

    public void setRegExecRoutingFertilizersById_0(Collection<RegExecRoutingFertilizerEntity> regExecRoutingFertilizersById_0) {
        this.regExecRoutingFertilizersById_0 = regExecRoutingFertilizersById_0;
    }

    @OneToMany(mappedBy = "clsEmployeeByIdMaker")
    @JsonIgnore
public Collection<RegExecRoutingProtectionEquipmentEntity> getRegExecRoutingProtectionEquipmentsById() {
        return regExecRoutingProtectionEquipmentsById;
    }

    public void setRegExecRoutingProtectionEquipmentsById(Collection<RegExecRoutingProtectionEquipmentEntity> regExecRoutingProtectionEquipmentsById) {
        this.regExecRoutingProtectionEquipmentsById = regExecRoutingProtectionEquipmentsById;
    }

    @OneToMany(mappedBy = "clsEmployeeByIdEmployee")
    @JsonIgnore
public Collection<RegExecRoutingProtectionEquipmentEntity> getRegExecRoutingProtectionEquipmentsById_0() {
        return regExecRoutingProtectionEquipmentsById_0;
    }

    public void setRegExecRoutingProtectionEquipmentsById_0(Collection<RegExecRoutingProtectionEquipmentEntity> regExecRoutingProtectionEquipmentsById_0) {
        this.regExecRoutingProtectionEquipmentsById_0 = regExecRoutingProtectionEquipmentsById_0;
    }

    @OneToMany(mappedBy = "clsEmployeeByIdMaker")
    @JsonIgnore
public Collection<RegExecRoutingWorkEntity> getRegExecRoutingWorksById() {
        return regExecRoutingWorksById;
    }

    public void setRegExecRoutingWorksById(Collection<RegExecRoutingWorkEntity> regExecRoutingWorksById) {
        this.regExecRoutingWorksById = regExecRoutingWorksById;
    }

    @OneToMany(mappedBy = "clsEmployeeByIdEmployee")
    @JsonIgnore
public Collection<RegExecRoutingWorkEntity> getRegExecRoutingWorksById_0() {
        return regExecRoutingWorksById_0;
    }

    public void setRegExecRoutingWorksById_0(Collection<RegExecRoutingWorkEntity> regExecRoutingWorksById_0) {
        this.regExecRoutingWorksById_0 = regExecRoutingWorksById_0;
    }

    @ManyToOne
    @JoinColumn(name = "id_depart", referencedColumnName = "id", nullable = false)
    public ClsDepartEntity getClsDepartByIdDepart() {
        return clsDepartByIdDepart;
    }

    public void setClsDepartByIdDepart(ClsDepartEntity clsDepartByIdDepart) {
        this.clsDepartByIdDepart = clsDepartByIdDepart;
    }

    @ManyToOne
    @JoinColumn(name = "id_organization", referencedColumnName = "id", nullable = false)
    public ClsOrganizationEntity getClsOrganizationByIdOrganization() {
        return clsOrganizationByIdOrganization;
    }

    public void setClsOrganizationByIdOrganization(ClsOrganizationEntity clsOrganizationByIdOrganization) {
        this.clsOrganizationByIdOrganization = clsOrganizationByIdOrganization;
    }
}
