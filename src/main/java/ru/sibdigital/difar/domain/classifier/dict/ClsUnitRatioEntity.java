package ru.sibdigital.difar.domain.classifier.dict;

import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.classifier.base.ClsBaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "cls_unit_ratio", schema = "dict")
public class ClsUnitRatioEntity extends ClsBaseEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private long id;
    private long idUnitFrom;
    private long idUnitTo;
    private BigDecimal ratio;
    private ClsUnitEntity clsUnitByIdUnitFrom;
    private ClsUnitEntity clsUnitByIdUnitTo;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public ClsUnitRatioEntity setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public ClsUnitRatioEntity setName(String name) {
        this.name = name;
        return this;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public ClsUnitRatioEntity setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public ClsUnitRatioEntity setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public ClsUnitRatioEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "cls_unit_radio_id_seq", schema = "dict")
    public long getId() {
        return id;
    }

    public ClsUnitRatioEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "id_unit_from", nullable = false, insertable = false, updatable = false)
    public long getIdUnitFrom() {
        return idUnitFrom;
    }

    public ClsUnitRatioEntity setIdUnitFrom(long idUnitFrom) {
        this.idUnitFrom = idUnitFrom;
        return this;
    }

    @Basic
    @Column(name = "id_unit_to", nullable = false, insertable = false, updatable = false)
    public long getIdUnitTo() {
        return idUnitTo;
    }

    public ClsUnitRatioEntity setIdUnitTo(long idUnitTo) {
        this.idUnitTo = idUnitTo;
        return this;
    }

    @Basic
    @Column(name = "ratio", nullable = true, precision = 6)
    public BigDecimal getRatio() {
        return ratio;
    }

    public ClsUnitRatioEntity setRatio(BigDecimal ratio) {
        this.ratio = ratio;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsUnitRatioEntity that = (ClsUnitRatioEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idUnitFrom != that.idUnitFrom) return false;
        if (idUnitTo != that.idUnitTo) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        return ratio != null ? ratio.equals(that.ratio) : that.ratio == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idUnitFrom ^ (idUnitFrom >>> 32));
        result = 31 * result + (int) (idUnitTo ^ (idUnitTo >>> 32));
        result = 31 * result + (ratio != null ? ratio.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_unit_from", referencedColumnName = "id", nullable = false)
    public ClsUnitEntity getClsUnitByIdUnitFrom() {
        return clsUnitByIdUnitFrom;
    }

    public ClsUnitRatioEntity setClsUnitByIdUnitFrom(ClsUnitEntity clsUnitByIdUnitFrom) {
        this.clsUnitByIdUnitFrom = clsUnitByIdUnitFrom;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "id_unit_to", referencedColumnName = "id", nullable = false)
    public ClsUnitEntity getClsUnitByIdUnitTo() {
        return clsUnitByIdUnitTo;
    }

    public ClsUnitRatioEntity setClsUnitByIdUnitTo(ClsUnitEntity clsUnitByIdUnitTo) {
        this.clsUnitByIdUnitTo = clsUnitByIdUnitTo;
        return this;
    }
}
