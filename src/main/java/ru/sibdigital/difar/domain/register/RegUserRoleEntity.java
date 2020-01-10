package ru.sibdigital.difar.domain.register;

import ru.sibdigital.difar.domain.catalog.ClsRoleEntity;
import ru.sibdigital.difar.domain.catalog.ClsUserEntity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "reg_user_role", schema = "accs")
public class RegUserRoleEntity {
    private long idUserCreator;
    private Timestamp dateCreate;
    private Timestamp dateBegin;
    private Timestamp dateEnd;
    private long id;
    private long idUser;
    private long idRole;
    private ClsUserEntity clsUserByIdUser;
    private ClsRoleEntity clsRoleByIdRole;

    @Basic
    @Column(name = "id_user_creator", nullable = false, insertable = false, updatable = false)
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
    @Column(name = "id_user", nullable = false, insertable = false, updatable = false)
    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "id_role", nullable = false, insertable = false, updatable = false)
    public long getIdRole() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegUserRoleEntity that = (RegUserRoleEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idUser != that.idUser) return false;
        if (idRole != that.idRole) return false;
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
        result = 31 * result + (int) (idUser ^ (idUser >>> 32));
        result = 31 * result + (int) (idRole ^ (idRole >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false)
    public ClsUserEntity getClsUserByIdUser() {
        return clsUserByIdUser;
    }

    public void setClsUserByIdUser(ClsUserEntity clsUserByIdUser) {
        this.clsUserByIdUser = clsUserByIdUser;
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
