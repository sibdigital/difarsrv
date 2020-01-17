package ru.sibdigital.difar.domain.classifier.dict;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.classifier.base.ClsBaseEntity;
import ru.sibdigital.difar.domain.document.DocRoutingEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_standard_period", schema = "dict")
public class ClsStandardPeriodEntity extends ClsBaseEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private long id;
    private Integer periodType;
    private Date dateBegin;
    private Date dateEnd;
    private Collection<DocRoutingEntity> docRoutingsById;
    private Collection<ClsArbitraryPeriodEntity> ClsArbitraryPeriodsById;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public ClsStandardPeriodEntity setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public ClsStandardPeriodEntity setName(String name) {
        this.name = name;
        return this;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public ClsStandardPeriodEntity setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public ClsStandardPeriodEntity setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public ClsStandardPeriodEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "cls_standard_period_id_seq", schema = "dict")
    public long getId() {
        return id;
    }

    public ClsStandardPeriodEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "period_type", nullable = true)
    public Integer getPeriodType() {
        return periodType;
    }

    public ClsStandardPeriodEntity setPeriodType(Integer periodType) {
        this.periodType = periodType;
        return this;
    }

    @Basic
    @Column(name = "date_begin", nullable = true)
    public Date getDateBegin() {
        return dateBegin;
    }

    public ClsStandardPeriodEntity setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
        return this;
    }

    @Basic
    @Column(name = "date_end", nullable = true)
    public Date getDateEnd() {
        return dateEnd;
    }

    public ClsStandardPeriodEntity setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsStandardPeriodEntity that = (ClsStandardPeriodEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (periodType != null ? !periodType.equals(that.periodType) : that.periodType != null) return false;
        if (dateBegin != null ? !dateBegin.equals(that.dateBegin) : that.dateBegin != null) return false;
        return dateEnd != null ? dateEnd.equals(that.dateEnd) : that.dateEnd == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (periodType != null ? periodType.hashCode() : 0);
        result = 31 * result + (dateBegin != null ? dateBegin.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "clsStandardPeriodByIdStandardPeriod")
    @JsonIgnore
    public Collection<DocRoutingEntity> getDocRoutingsById() {
        return docRoutingsById;
    }

    public ClsStandardPeriodEntity setDocRoutingsById(Collection<DocRoutingEntity> docRoutingsById) {
        this.docRoutingsById = docRoutingsById;
        return this;
    }

    @OneToMany(mappedBy = "clsStandardPeriodByIdStandardPeriod")
    @JsonIgnore
    public Collection<ClsArbitraryPeriodEntity> getClsArbitraryPeriodsById() {
        return ClsArbitraryPeriodsById;
    }

    public ClsStandardPeriodEntity setClsArbitraryPeriodsById(Collection<ClsArbitraryPeriodEntity> ClsArbitraryPeriodsById) {
        this.ClsArbitraryPeriodsById = ClsArbitraryPeriodsById;
        return this;
    }
}
