package ru.sibdigital.difar.domain.catalog;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "cls_unit_ratio", schema = "dict")
public class ClsUnitRatioEntity {
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
    @Column(name = "id_unit_from", nullable = false)
    public long getIdUnitFrom() {
        return idUnitFrom;
    }

    public void setIdUnitFrom(long idUnitFrom) {
        this.idUnitFrom = idUnitFrom;
    }

    @Basic
    @Column(name = "id_unit_to", nullable = false)
    public long getIdUnitTo() {
        return idUnitTo;
    }

    public void setIdUnitTo(long idUnitTo) {
        this.idUnitTo = idUnitTo;
    }

    @Basic
    @Column(name = "ratio", nullable = true, precision = 6)
    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
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

    public void setClsUnitByIdUnitFrom(ClsUnitEntity clsUnitByIdUnitFrom) {
        this.clsUnitByIdUnitFrom = clsUnitByIdUnitFrom;
    }

    @ManyToOne
    @JoinColumn(name = "id_unit_to", referencedColumnName = "id", nullable = false)
    public ClsUnitEntity getClsUnitByIdUnitTo() {
        return clsUnitByIdUnitTo;
    }

    public void setClsUnitByIdUnitTo(ClsUnitEntity clsUnitByIdUnitTo) {
        this.clsUnitByIdUnitTo = clsUnitByIdUnitTo;
    }
}
