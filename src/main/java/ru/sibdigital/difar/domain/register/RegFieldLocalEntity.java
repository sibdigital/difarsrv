package ru.sibdigital.difar.domain.register;

import ru.sibdigital.difar.domain.classifier.agrc.ClsFieldEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsAreaEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsDistrictEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsRegionEntity;
import ru.sibdigital.difar.domain.classifier.org.ClsDepartEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "reg_field_local", schema = "agrc")
public class RegFieldLocalEntity {
    private long idUserCreator;
    private Timestamp dateCreate;
    private Timestamp dateBegin;
    private Timestamp dateEnd;
    private long id;
    private long idField;
    private long idRegion;
    private long idDistrict;
    private long idArea;
    private long idDepart;
    //    private Object bound;
    private BigDecimal area;
    private ClsFieldEntity clsFieldByIdField;
    private ClsRegionEntity clsRegionByIdRegion;
    private ClsDistrictEntity clsDistrictByIdDistrict;
    private ClsAreaEntity clsAreaByIdArea;
    private ClsDepartEntity clsDepartByIdDepart;

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
    @Column(name = "id_field", nullable = false, insertable = false, updatable = false)
    public long getIdField() {
        return idField;
    }

    public void setIdField(long idField) {
        this.idField = idField;
    }

    @Basic
    @Column(name = "id_region", nullable = false, insertable = false, updatable = false)
    public long getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(long idRegion) {
        this.idRegion = idRegion;
    }

    @Basic
    @Column(name = "id_district", nullable = false, insertable = false, updatable = false)
    public long getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(long idDistrict) {
        this.idDistrict = idDistrict;
    }

    @Basic
    @Column(name = "id_area", nullable = false, insertable = false, updatable = false)
    public long getIdArea() {
        return idArea;
    }

    public void setIdArea(long idArea) {
        this.idArea = idArea;
    }

    @Basic
    @Column(name = "id_depart", nullable = false, insertable = false, updatable = false)
    public long getIdDepart() {
        return idDepart;
    }

    public void setIdDepart(long idDepart) {
        this.idDepart = idDepart;
    }

//    @Basic
//    @Column(name = "bound", nullable = true)
//    public Object getBound() {
//        return bound;
//    }
//
//    public void setBound(Object bound) {
//        this.bound = bound;
//    }

    @Basic
    @Column(name = "area", nullable = true, precision = 5)
    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        RegFieldLocalEntity that = (RegFieldLocalEntity) o;
//
//        if (idUserCreator != that.idUserCreator) return false;
//        if (id != that.id) return false;
//        if (idField != that.idField) return false;
//        if (idRegion != that.idRegion) return false;
//        if (idDistrict != that.idDistrict) return false;
//        if (idArea != that.idArea) return false;
//        if (idDepart != that.idDepart) return false;
//        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
//        if (dateBegin != null ? !dateBegin.equals(that.dateBegin) : that.dateBegin != null) return false;
//        if (dateEnd != null ? !dateEnd.equals(that.dateEnd) : that.dateEnd != null) return false;
//        if (bound != null ? !bound.equals(that.bound) : that.bound != null) return false;
//        return area != null ? area.equals(that.area) : that.area == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
//        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
//        result = 31 * result + (dateBegin != null ? dateBegin.hashCode() : 0);
//        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
//        result = 31 * result + (int) (id ^ (id >>> 32));
//        result = 31 * result + (int) (idField ^ (idField >>> 32));
//        result = 31 * result + (int) (idRegion ^ (idRegion >>> 32));
//        result = 31 * result + (int) (idDistrict ^ (idDistrict >>> 32));
//        result = 31 * result + (int) (idArea ^ (idArea >>> 32));
//        result = 31 * result + (int) (idDepart ^ (idDepart >>> 32));
//        result = 31 * result + (bound != null ? bound.hashCode() : 0);
//        result = 31 * result + (area != null ? area.hashCode() : 0);
//        return result;
//    }

    @ManyToOne
    @JoinColumn(name = "id_field", referencedColumnName = "id", nullable = false)
    public ClsFieldEntity getClsFieldByIdField() {
        return clsFieldByIdField;
    }

    public void setClsFieldByIdField(ClsFieldEntity clsFieldByIdField) {
        this.clsFieldByIdField = clsFieldByIdField;
    }

    @ManyToOne
    @JoinColumn(name = "id_region", referencedColumnName = "id", nullable = false)
    public ClsRegionEntity getClsRegionByIdRegion() {
        return clsRegionByIdRegion;
    }

    public void setClsRegionByIdRegion(ClsRegionEntity clsRegionByIdRegion) {
        this.clsRegionByIdRegion = clsRegionByIdRegion;
    }

    @ManyToOne
    @JoinColumn(name = "id_district", referencedColumnName = "id", nullable = false)
    public ClsDistrictEntity getClsDistrictByIdDistrict() {
        return clsDistrictByIdDistrict;
    }

    public void setClsDistrictByIdDistrict(ClsDistrictEntity clsDistrictByIdDistrict) {
        this.clsDistrictByIdDistrict = clsDistrictByIdDistrict;
    }

    @ManyToOne
    @JoinColumn(name = "id_area", referencedColumnName = "id", nullable = false)
    public ClsAreaEntity getClsAreaByIdArea() {
        return clsAreaByIdArea;
    }

    public void setClsAreaByIdArea(ClsAreaEntity clsAreaByIdArea) {
        this.clsAreaByIdArea = clsAreaByIdArea;
    }

    @ManyToOne
    @JoinColumn(name = "id_depart", referencedColumnName = "id", nullable = false)
    public ClsDepartEntity getClsDepartByIdDepart() {
        return clsDepartByIdDepart;
    }

    public void setClsDepartByIdDepart(ClsDepartEntity clsDepartByIdDepart) {
        this.clsDepartByIdDepart = clsDepartByIdDepart;
    }
}
