package ru.sibdigital.difar.domain.catalog;

import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.register.RegOrganizationEquipmentEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_equipment_kind", schema = "dict")
public class ClsEquipmentKindEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private long id;
    private long idEquipmentType;
    private ClsEquipmentTypeEntity clsEquipmentTypeByIdEquipmentType;
    private Collection<RegOrganizationEquipmentEntity> regOrganizationEquipmentsById;

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
    @Column(name = "id_equipment_type", nullable = false, insertable = false, updatable = false)
    public long getIdEquipmentType() {
        return idEquipmentType;
    }

    public void setIdEquipmentType(long idEquipmentType) {
        this.idEquipmentType = idEquipmentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsEquipmentKindEntity that = (ClsEquipmentKindEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idEquipmentType != that.idEquipmentType) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        return number != null ? number.equals(that.number) : that.number == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idEquipmentType ^ (idEquipmentType >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_equipment_type", referencedColumnName = "id", nullable = false)
    public ClsEquipmentTypeEntity getClsEquipmentTypeByIdEquipmentType() {
        return clsEquipmentTypeByIdEquipmentType;
    }

    public void setClsEquipmentTypeByIdEquipmentType(ClsEquipmentTypeEntity clsEquipmentTypeByIdEquipmentType) {
        this.clsEquipmentTypeByIdEquipmentType = clsEquipmentTypeByIdEquipmentType;
    }

    @OneToMany(mappedBy = "clsEquipmentKindByIdEquipmentKind")
    public Collection<RegOrganizationEquipmentEntity> getRegOrganizationEquipmentsById() {
        return regOrganizationEquipmentsById;
    }

    public void setRegOrganizationEquipmentsById(Collection<RegOrganizationEquipmentEntity> regOrganizationEquipmentsById) {
        this.regOrganizationEquipmentsById = regOrganizationEquipmentsById;
    }
}