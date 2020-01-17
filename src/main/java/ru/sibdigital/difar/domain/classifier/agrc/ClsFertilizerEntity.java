package ru.sibdigital.difar.domain.classifier.agrc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.classifier.base.ClsBaseEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsUnitEntity;
import ru.sibdigital.difar.domain.register.RegOrganizationFertilizerEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_fertilizer", schema = "agrc")
public class ClsFertilizerEntity extends ClsBaseEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private String code;
    private long id;
    private long idUnit;
    private BigDecimal maxConsum;
    private BigDecimal minConsum;
    private ClsUnitEntity clsUnitByIdUnit;
    private Collection<RegOrganizationFertilizerEntity> regOrganizationFertilizersById;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public ClsFertilizerEntity setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public ClsFertilizerEntity setName(String name) {
        this.name = name;
        return this;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public ClsFertilizerEntity setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public ClsFertilizerEntity setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public ClsFertilizerEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    @Basic
    @Column(name = "code", nullable = false, length = 64)
    public String getCode() {
        return code;
    }

    public ClsFertilizerEntity setCode(String code) {
        this.code = code;
        return this;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "cls_fertilizer_id_seq", schema = "agrc")
    public long getId() {
        return id;
    }

    public ClsFertilizerEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "id_unit", nullable = false, insertable = false, updatable = false)
    public long getIdUnit() {
        return idUnit;
    }

    public ClsFertilizerEntity setIdUnit(long idUnit) {
        this.idUnit = idUnit;
        return this;
    }

    @Basic
    @Column(name = "max_consum", nullable = true, precision = 5)
    public BigDecimal getMaxConsum() {
        return maxConsum;
    }

    public ClsFertilizerEntity setMaxConsum(BigDecimal maxConsum) {
        this.maxConsum = maxConsum;
        return this;
    }

    @Basic
    @Column(name = "min_consum", nullable = true, precision = 5)
    public BigDecimal getMinConsum() {
        return minConsum;
    }

    public ClsFertilizerEntity setMinConsum(BigDecimal minConsum) {
        this.minConsum = minConsum;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsFertilizerEntity that = (ClsFertilizerEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idUnit != that.idUnit) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
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
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idUnit ^ (idUnit >>> 32));
        result = 31 * result + (maxConsum != null ? maxConsum.hashCode() : 0);
        result = 31 * result + (minConsum != null ? minConsum.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_unit", referencedColumnName = "id", nullable = false)
    public ClsUnitEntity getClsUnitByIdUnit() {
        return clsUnitByIdUnit;
    }

    public ClsFertilizerEntity setClsUnitByIdUnit(ClsUnitEntity clsUnitByIdUnit) {
        this.clsUnitByIdUnit = clsUnitByIdUnit;
        return this;
    }

    @OneToMany(mappedBy = "clsFertilizerByIdFertilizer")
    @JsonIgnore
    public Collection<RegOrganizationFertilizerEntity> getRegOrganizationFertilizersById() {
        return regOrganizationFertilizersById;
    }

    public ClsFertilizerEntity setRegOrganizationFertilizersById(Collection<RegOrganizationFertilizerEntity> regOrganizationFertilizersById) {
        this.regOrganizationFertilizersById = regOrganizationFertilizersById;
        return this;
    }
}
