package ru.sibdigital.difar.domain.register;

import ru.sibdigital.difar.domain.catalog.ClsResourceEntity;
import ru.sibdigital.difar.domain.catalog.ClsRoleEntity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "reg_cvitantion", schema = "accs")
public class RegCvitantionEntity {
    private long idUserCreator;
    private Timestamp dateCreate;
    private Timestamp dateBegin;
    private Timestamp dateEnd;
    private long id;
    private long idResource;
    private long idRole;
    private String operation;
    private ClsResourceEntity clsResourceByIdResource;
    private ClsRoleEntity clsRoleByIdRole;

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
    @Column(name = "id_resource", nullable = false, insertable = false, updatable = false)
    public long getIdResource() {
        return idResource;
    }

    public void setIdResource(long idResource) {
        this.idResource = idResource;
    }

    @Basic
    @Column(name = "id_role", nullable = false, insertable = false, updatable = false)
    public long getIdRole() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    @Basic
    @Column(name = "operation", nullable = false, length = 15)
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegCvitantionEntity that = (RegCvitantionEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idResource != that.idResource) return false;
        if (idRole != that.idRole) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (dateBegin != null ? !dateBegin.equals(that.dateBegin) : that.dateBegin != null) return false;
        if (dateEnd != null ? !dateEnd.equals(that.dateEnd) : that.dateEnd != null) return false;
        return operation != null ? operation.equals(that.operation) : that.operation == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (dateBegin != null ? dateBegin.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idResource ^ (idResource >>> 32));
        result = 31 * result + (int) (idRole ^ (idRole >>> 32));
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_resource", referencedColumnName = "id", nullable = false)
    public ClsResourceEntity getClsResourceByIdResource() {
        return clsResourceByIdResource;
    }

    public void setClsResourceByIdResource(ClsResourceEntity clsResourceByIdResource) {
        this.clsResourceByIdResource = clsResourceByIdResource;
    }

    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id", nullable = false)
    public ClsRoleEntity getClsRoleByIdRole() {
        return clsRoleByIdRole;
    }

    public void setClsRoleByIdRole(ClsRoleEntity clsRoleByIdRole) {
        this.clsRoleByIdRole = clsRoleByIdRole;
    }
}
