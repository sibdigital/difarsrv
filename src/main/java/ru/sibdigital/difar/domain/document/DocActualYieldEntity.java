package ru.sibdigital.difar.domain.document;

import ru.sibdigital.difar.domain.classifier.agrc.ClsCropEntity;
import ru.sibdigital.difar.domain.classifier.agrc.ClsFieldEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsOrganizationEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsUnitEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "doc_actual_yield", schema = "agrc")
public class DocActualYieldEntity {
    private long idUserCreator;
    private Timestamp dateCreate;
    private Timestamp dateReg;
    private Boolean isDeleted;
    private String number;
    private long id;
    private long idOrganization;
    private long idRouting;
    private long idCrop;
    private long idField;
    private long idUnit;
    private long idActualProlificnessUnit;
    private BigDecimal yield;
    private BigDecimal actualProlificness;
    private ClsOrganizationEntity clsOrganizationByIdOrganization;
    private DocRoutingEntity docRoutingByIdRouting;
    private ClsCropEntity clsCropByIdCrop;
    private ClsFieldEntity clsFieldByIdField;
    private ClsUnitEntity clsUnitByIdUnit;
    private ClsUnitEntity clsUnitByIdActualProlificnessUnit;

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
    @Column(name = "date_reg", nullable = true)
    public Timestamp getDateReg() {
        return dateReg;
    }

    public void setDateReg(Timestamp dateReg) {
        this.dateReg = dateReg;
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
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_organization", nullable = false, insertable = false, updatable = false)
    public long getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(long idOrganization) {
        this.idOrganization = idOrganization;
    }

    @Basic
    @Column(name = "id_routing", nullable = false, insertable = false, updatable = false)
    public long getIdRouting() {
        return idRouting;
    }

    public void setIdRouting(long idRouting) {
        this.idRouting = idRouting;
    }

    @Basic
    @Column(name = "id_crop", nullable = false, insertable = false, updatable = false)
    public long getIdCrop() {
        return idCrop;
    }

    public void setIdCrop(long idCrop) {
        this.idCrop = idCrop;
    }

    @Basic
    @Column(name = "id_field", nullable = false, insertable = false, updatable = false)
    public long getIdField() {
        return idField;
    }

    public void setIdField(long idField) {
        this.idField = idField;
    }

    @Basic
    @Column(name = "id_unit", nullable = false, insertable = false, updatable = false)
    public long getIdUnit() {
        return idUnit;
    }

    public void setIdUnit(long idUnit) {
        this.idUnit = idUnit;
    }

    @Basic
    @Column(name = "id_actual_prolificness_unit", nullable = false, insertable = false, updatable = false)
    public long getIdActualProlificnessUnit() {
        return idActualProlificnessUnit;
    }

    public void setIdActualProlificnessUnit(long idActualProlificnessUnit) {
        this.idActualProlificnessUnit = idActualProlificnessUnit;
    }

    @Basic
    @Column(name = "yield", nullable = true, precision = 5)
    public BigDecimal getYield() {
        return yield;
    }

    public void setYield(BigDecimal yield) {
        this.yield = yield;
    }

    @Basic
    @Column(name = "actual_prolificness", nullable = true, precision = 5)
    public BigDecimal getActualProlificness() {
        return actualProlificness;
    }

    public void setActualProlificness(BigDecimal actualProlificness) {
        this.actualProlificness = actualProlificness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocActualYieldEntity that = (DocActualYieldEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idOrganization != that.idOrganization) return false;
        if (idRouting != that.idRouting) return false;
        if (idCrop != that.idCrop) return false;
        if (idField != that.idField) return false;
        if (idUnit != that.idUnit) return false;
        if (idActualProlificnessUnit != that.idActualProlificnessUnit) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (dateReg != null ? !dateReg.equals(that.dateReg) : that.dateReg != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (yield != null ? !yield.equals(that.yield) : that.yield != null) return false;
        return actualProlificness != null ? actualProlificness.equals(that.actualProlificness) : that.actualProlificness == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (dateReg != null ? dateReg.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idOrganization ^ (idOrganization >>> 32));
        result = 31 * result + (int) (idRouting ^ (idRouting >>> 32));
        result = 31 * result + (int) (idCrop ^ (idCrop >>> 32));
        result = 31 * result + (int) (idField ^ (idField >>> 32));
        result = 31 * result + (int) (idUnit ^ (idUnit >>> 32));
        result = 31 * result + (int) (idActualProlificnessUnit ^ (idActualProlificnessUnit >>> 32));
        result = 31 * result + (yield != null ? yield.hashCode() : 0);
        result = 31 * result + (actualProlificness != null ? actualProlificness.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_organization", referencedColumnName = "id", nullable = false)
    public ClsOrganizationEntity getClsOrganizationByIdOrganization() {
        return clsOrganizationByIdOrganization;
    }

    public void setClsOrganizationByIdOrganization(ClsOrganizationEntity clsOrganizationByIdOrganization) {
        this.clsOrganizationByIdOrganization = clsOrganizationByIdOrganization;
    }

    @ManyToOne
    @JoinColumn(name = "id_routing", referencedColumnName = "id", nullable = false)
    public DocRoutingEntity getDocRoutingByIdRouting() {
        return docRoutingByIdRouting;
    }

    public void setDocRoutingByIdRouting(DocRoutingEntity docRoutingByIdRouting) {
        this.docRoutingByIdRouting = docRoutingByIdRouting;
    }

    @ManyToOne
    @JoinColumn(name = "id_crop", referencedColumnName = "id", nullable = false)
    public ClsCropEntity getClsCropByIdCrop() {
        return clsCropByIdCrop;
    }

    public void setClsCropByIdCrop(ClsCropEntity clsCropByIdCrop) {
        this.clsCropByIdCrop = clsCropByIdCrop;
    }

    @ManyToOne
    @JoinColumn(name = "id_field", referencedColumnName = "id", nullable = false)
    public ClsFieldEntity getClsFieldByIdField() {
        return clsFieldByIdField;
    }

    public void setClsFieldByIdField(ClsFieldEntity clsFieldByIdField) {
        this.clsFieldByIdField = clsFieldByIdField;
    }

    @ManyToOne
    @JoinColumn(name = "id_unit", referencedColumnName = "id", nullable = false)
    public ClsUnitEntity getClsUnitByIdUnit() {
        return clsUnitByIdUnit;
    }

    public void setClsUnitByIdUnit(ClsUnitEntity clsUnitByIdUnit) {
        this.clsUnitByIdUnit = clsUnitByIdUnit;
    }

    @ManyToOne
    @JoinColumn(name = "id_actual_prolificness_unit", referencedColumnName = "id", nullable = false)
    public ClsUnitEntity getClsUnitByIdActualProlificnessUnit() {
        return clsUnitByIdActualProlificnessUnit;
    }

    public void setClsUnitByIdActualProlificnessUnit(ClsUnitEntity clsUnitByIdActualProlificnessUnit) {
        this.clsUnitByIdActualProlificnessUnit = clsUnitByIdActualProlificnessUnit;
    }
}
