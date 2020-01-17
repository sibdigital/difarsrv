package ru.sibdigital.difar.domain.register;

import ru.sibdigital.difar.domain.classifier.agrc.ClsGpsModuleEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsOrganizationEntity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "reg_gps_module_organization_equipment", schema = "agrc")
public class RegGpsModuleOrganizationEquipmentEntity {
    private long idUserCreator;
    private Timestamp dateCreate;
    private Timestamp dateBegin;
    private Timestamp dateEnd;
    private long id;
    private long idGpsModule;
    private long idOrganization;
    private long idOrganizationEquipment;
    private ClsGpsModuleEntity clsGpsModuleByIdGpsModule;
    private ClsOrganizationEntity clsOrganizationByIdOrganization;

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
    @Column(name = "id_gps_module", nullable = false, insertable = false, updatable = false)
    public long getIdGpsModule() {
        return idGpsModule;
    }

    public void setIdGpsModule(long idGpsModule) {
        this.idGpsModule = idGpsModule;
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
    @Column(name = "id_organization_equipment", nullable = false, insertable = false, updatable = false)
    public long getIdOrganizationEquipment() {
        return idOrganizationEquipment;
    }

    public void setIdOrganizationEquipment(long idOrganizationEquipment) {
        this.idOrganizationEquipment = idOrganizationEquipment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegGpsModuleOrganizationEquipmentEntity that = (RegGpsModuleOrganizationEquipmentEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idGpsModule != that.idGpsModule) return false;
        if (idOrganization != that.idOrganization) return false;
        if (idOrganizationEquipment != that.idOrganizationEquipment) return false;
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
        result = 31 * result + (int) (idGpsModule ^ (idGpsModule >>> 32));
        result = 31 * result + (int) (idOrganization ^ (idOrganization >>> 32));
        result = 31 * result + (int) (idOrganizationEquipment ^ (idOrganizationEquipment >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_gps_module", referencedColumnName = "id", nullable = false)
    public ClsGpsModuleEntity getClsGpsModuleByIdGpsModule() {
        return clsGpsModuleByIdGpsModule;
    }

    public void setClsGpsModuleByIdGpsModule(ClsGpsModuleEntity clsGpsModuleByIdGpsModule) {
        this.clsGpsModuleByIdGpsModule = clsGpsModuleByIdGpsModule;
    }

    @ManyToOne
    @JoinColumn(name = "id_organization", referencedColumnName = "id", nullable = false)
    public ClsOrganizationEntity getClsOrganizationByIdOrganization() {
        return clsOrganizationByIdOrganization;
    }

    public void setClsOrganizationByIdOrganization(ClsOrganizationEntity clsOrganizationByIdOrganization) {
        this.clsOrganizationByIdOrganization = clsOrganizationByIdOrganization;
    }
}
