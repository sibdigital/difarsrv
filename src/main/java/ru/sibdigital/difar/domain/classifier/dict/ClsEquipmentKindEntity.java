package ru.sibdigital.difar.domain.classifier.dict;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.classifier.base.ClsBaseEntity;
import ru.sibdigital.difar.domain.register.RegOrganizationEquipmentEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_equipment_kind", schema = "dict")
public class ClsEquipmentKindEntity extends ClsBaseEntity {
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

    public ClsEquipmentKindEntity setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public ClsEquipmentKindEntity setName(String name) {
        this.name = name;
        return this;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public ClsEquipmentKindEntity setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public ClsEquipmentKindEntity setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public ClsEquipmentKindEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "cls_equipment_kind_id_seq", schema = "dict")
    public long getId() {
        return id;
    }

    public ClsEquipmentKindEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "id_equipment_type", nullable = false, insertable = false, updatable = false)
    public long getIdEquipmentType() {
        return idEquipmentType;
    }

    public ClsEquipmentKindEntity setIdEquipmentType(long idEquipmentType) {
        this.idEquipmentType = idEquipmentType;
        return this;
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

    public ClsEquipmentKindEntity setClsEquipmentTypeByIdEquipmentType(ClsEquipmentTypeEntity clsEquipmentTypeByIdEquipmentType) {
        this.clsEquipmentTypeByIdEquipmentType = clsEquipmentTypeByIdEquipmentType;
        return this;
    }

    @OneToMany(mappedBy = "clsEquipmentKindByIdEquipmentKind")
    @JsonIgnore
    public Collection<RegOrganizationEquipmentEntity> getRegOrganizationEquipmentsById() {
        return regOrganizationEquipmentsById;
    }

    public ClsEquipmentKindEntity setRegOrganizationEquipmentsById(Collection<RegOrganizationEquipmentEntity> regOrganizationEquipmentsById) {
        this.regOrganizationEquipmentsById = regOrganizationEquipmentsById;
        return this;
    }
}
