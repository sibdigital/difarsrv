package ru.sibdigital.difar.domain.catalog;

import ru.sibdigital.difar.domain.register.RegUserRoleEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "cls_user", schema = "accs")
public class ClsUserEntity {
    private long idUserCreator;
    private String name;
    private Timestamp dateCreate;
    private Boolean isDeleted;
    private String number;
    private long id;
    private String password;
    private long idOrganization;
    private long idEmployee;
    private ClsOrganizationEntity clsOrganizationByIdOrganization;
    private ClsEmployeeEntity clsEmployeeByIdEmployee;
    private Collection<RegUserRoleEntity> regUserRolesById;

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

    @Basic
    @Column(name = "date_create", nullable = true)
    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
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
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "password", nullable = false, length = -1)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "id_organization", nullable = false)
    public long getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(long idOrganization) {
        this.idOrganization = idOrganization;
    }

    @Basic
    @Column(name = "id_employee", nullable = false)
    public long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(long idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsUserEntity that = (ClsUserEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idOrganization != that.idOrganization) return false;
        if (idEmployee != that.idEmployee) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        return password != null ? password.equals(that.password) : that.password == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (int) (idOrganization ^ (idOrganization >>> 32));
        result = 31 * result + (int) (idEmployee ^ (idEmployee >>> 32));
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
    @JoinColumn(name = "id_employee", referencedColumnName = "id", nullable = false)
    public ClsEmployeeEntity getClsEmployeeByIdEmployee() {
        return clsEmployeeByIdEmployee;
    }

    public void setClsEmployeeByIdEmployee(ClsEmployeeEntity clsEmployeeByIdEmployee) {
        this.clsEmployeeByIdEmployee = clsEmployeeByIdEmployee;
    }

    @OneToMany(mappedBy = "clsUserByIdUser")
    public Collection<RegUserRoleEntity> getRegUserRolesById() {
        return regUserRolesById;
    }

    public void setRegUserRolesById(Collection<RegUserRoleEntity> regUserRolesById) {
        this.regUserRolesById = regUserRolesById;
    }
}
