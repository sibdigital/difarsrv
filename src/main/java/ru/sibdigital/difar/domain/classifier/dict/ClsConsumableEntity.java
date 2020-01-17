package ru.sibdigital.difar.domain.classifier.dict;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.classifier.base.ClsBaseEntity;
import ru.sibdigital.difar.domain.register.RegOrganizationConsumableEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_consumable", schema = "dict")
public class ClsConsumableEntity extends ClsBaseEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private long id;
    private long idConsumableKind;
    private long idUnit;
    private BigDecimal maxConsum;
    private BigDecimal minConsum;
    private ClsConsumableKindEntity clsConsumableKindByIdConsumableKind;
    private ClsUnitEntity clsUnitByIdUnit;
    private Collection<RegOrganizationConsumableEntity> regOrganizationConsumablesById;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public ClsConsumableEntity setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public ClsConsumableEntity setName(String name) {
        this.name = name;
        return this;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public ClsConsumableEntity setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public ClsConsumableEntity setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public ClsConsumableEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "cls_consumable_id_seq", schema = "dict")
    public long getId() {
        return id;
    }

    public ClsConsumableEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "id_consumable_kind", nullable = false, insertable = false, updatable = false)
    public long getIdConsumableKind() {
        return idConsumableKind;
    }

    public ClsConsumableEntity setIdConsumableKind(long idConsumableKind) {
        this.idConsumableKind = idConsumableKind;
        return this;
    }

    @Basic
    @Column(name = "id_unit", nullable = false, insertable = false, updatable = false)
    public long getIdUnit() {
        return idUnit;
    }

    public ClsConsumableEntity setIdUnit(long idUnit) {
        this.idUnit = idUnit;
        return this;
    }

    @Basic
    @Column(name = "max_consum", nullable = true, precision = 6)
    public BigDecimal getMaxConsum() {
        return maxConsum;
    }

    public ClsConsumableEntity setMaxConsum(BigDecimal maxConsum) {
        this.maxConsum = maxConsum;
        return this;
    }

    @Basic
    @Column(name = "min_consum", nullable = true, precision = 6)
    public BigDecimal getMinConsum() {
        return minConsum;
    }

    public ClsConsumableEntity setMinConsum(BigDecimal minConsum) {
        this.minConsum = minConsum;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsConsumableEntity that = (ClsConsumableEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idConsumableKind != that.idConsumableKind) return false;
        if (idUnit != that.idUnit) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (maxConsum != null ? !maxConsum.equals(that.maxConsum) : that.maxConsum != null) return false;
        return minConsum != null ? minConsum.equals(that.minConsum) : that.minConsum == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idConsumableKind ^ (idConsumableKind >>> 32));
        result = 31 * result + (int) (idUnit ^ (idUnit >>> 32));
        result = 31 * result + (maxConsum != null ? maxConsum.hashCode() : 0);
        result = 31 * result + (minConsum != null ? minConsum.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_consumable_kind", referencedColumnName = "id", nullable = false)
    public ClsConsumableKindEntity getClsConsumableKindByIdConsumableKind() {
        return clsConsumableKindByIdConsumableKind;
    }

    public ClsConsumableEntity setClsConsumableKindByIdConsumableKind(ClsConsumableKindEntity clsConsumableKindByIdConsumableKind) {
        this.clsConsumableKindByIdConsumableKind = clsConsumableKindByIdConsumableKind;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "id_unit", referencedColumnName = "id", nullable = false)
    public ClsUnitEntity getClsUnitByIdUnit() {
        return clsUnitByIdUnit;
    }

    public ClsConsumableEntity setClsUnitByIdUnit(ClsUnitEntity clsUnitByIdUnit) {
        this.clsUnitByIdUnit = clsUnitByIdUnit;
        return this;
    }

    @OneToMany(mappedBy = "clsConsumableByIdConsumable")
    @JsonIgnore
    public Collection<RegOrganizationConsumableEntity> getRegOrganizationConsumablesById() {
        return regOrganizationConsumablesById;
    }

    public ClsConsumableEntity setRegOrganizationConsumablesById(Collection<RegOrganizationConsumableEntity> regOrganizationConsumablesById) {
        this.regOrganizationConsumablesById = regOrganizationConsumablesById;
        return this;
    }
}
