package ru.sibdigital.difar.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cls_user", schema = "accs")
public class ClsUserEntity {

    @Basic
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    private long idUserCreator;

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    private String name;

    @Basic
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "date_create", nullable = true)
    private Date dateCreate;

    @Basic
    @Column(name = "is_deleted", nullable = true)
    private Boolean isDeleted;

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    private String number;

    @Basic
    @Column(name = "password", nullable = false, length = -1)
    private String password;

    @Basic
    @Column(name = "id_employee", nullable = false)
    private long employeeId;

    @Basic
    @Column(name = "id_organization", nullable = false)
    private long organizationId;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(long organizationId) {
        this.organizationId = organizationId;
    }

    //    @OneToOne
//    @JoinColumn(name = "id_employee")
//    private ClsEmployeeEntity employee;
//
//    @OneToOne
//    @JoinColumn(name = "id_organization")
//    private ClsOrganizationEntity organization;

//    public ClsEmployeeEntity getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(ClsEmployeeEntity employee) {
//        this.employee = employee;
//    }
//
//    public ClsOrganizationEntity getOrganization() {
//        return organization;
//    }
//
//    public void setOrganization(ClsOrganizationEntity organization) {
//        this.organization = organization;
//    }

    public long getIdUserCreator() {
        return idUserCreator;
    }

    public void setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsUserEntity that = (ClsUserEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
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
        return result;
    }
}
