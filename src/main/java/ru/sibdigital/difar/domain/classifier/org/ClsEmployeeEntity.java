package ru.sibdigital.difar.domain.classifier.org;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.base.ClsBaseEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsOrganizationEntity;
import ru.sibdigital.difar.domain.register.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_employee", schema = "org")
public class ClsEmployeeEntity extends ClsBaseEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private long id;
    private String surname;
    private String firstname;
    private String patronymic;
    private long idDepart;
    private long idOrganization;
    private Collection<ClsUserEntity> clsUsersById;
    private Collection<RegExecRoutingConsumEntity> regExecRoutingConsumsById;
    private Collection<RegExecRoutingConsumEntity> regExecRoutingConsumsById_0;
    private Collection<RegExecRoutingEquipmentEntity> regExecRoutingEquipmentsById;
    private Collection<RegExecRoutingEquipmentEntity> regExecRoutingEquipmentsById_0;
    private Collection<RegExecRoutingFertilizerEntity> regExecRoutingFertilizersById;
    private Collection<RegExecRoutingFertilizerEntity> regExecRoutingFertilizersById_0;
    private Collection<RegExecRoutingProtectionEquipmentEntity> regExecRoutingProtectionEquipmentsById;
    private Collection<RegExecRoutingProtectionEquipmentEntity> regExecRoutingProtectionEquipmentsById_0;
    private Collection<RegExecRoutingWorkEntity> regExecRoutingWorksById;
    private Collection<RegExecRoutingWorkEntity> regExecRoutingWorksById_0;
    private ClsDepartEntity clsDepartByIdDepart;
    private ClsOrganizationEntity clsOrganizationByIdOrganization;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public ClsEmployeeEntity setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public ClsEmployeeEntity setName(String name) {
        this.name = name;
        return this;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public ClsEmployeeEntity setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public ClsEmployeeEntity setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public ClsEmployeeEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "cls_employee_id_seq", schema = "org")
    public long getId() {
        return id;
    }

    public ClsEmployeeEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "surname", nullable = true, length = -1)
    public String getSurname() {
        return surname;
    }

    public ClsEmployeeEntity setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    @Basic
    @Column(name = "firstname", nullable = true, length = -1)
    public String getFirstname() {
        return firstname;
    }

    public ClsEmployeeEntity setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    @Basic
    @Column(name = "patronymic", nullable = true, length = -1)
    public String getPatronymic() {
        return patronymic;
    }

    public ClsEmployeeEntity setPatronymic(String patronymic) {
        this.patronymic = patronymic;
        return this;
    }

    @Basic
    @Column(name = "id_depart", nullable = false, insertable = false, updatable = false)
    public long getIdDepart() {
        return idDepart;
    }

    public ClsEmployeeEntity setIdDepart(long idDepart) {
        this.idDepart = idDepart;
        return this;
    }

    @Basic
    @Column(name = "id_organization", nullable = false, insertable = false, updatable = false)
    public long getIdOrganization() {
        return idOrganization;
    }

    public ClsEmployeeEntity setIdOrganization(long idOrganization) {
        this.idOrganization = idOrganization;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsEmployeeEntity that = (ClsEmployeeEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idDepart != that.idDepart) return false;
        if (idOrganization != that.idOrganization) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return patronymic != null ? patronymic.equals(that.patronymic) : that.patronymic == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (int) (idDepart ^ (idDepart >>> 32));
        result = 31 * result + (int) (idOrganization ^ (idOrganization >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "clsEmployeeByIdEmployee")
    @JsonIgnore
    public Collection<ClsUserEntity> getClsUsersById() {
        return clsUsersById;
    }

    public ClsEmployeeEntity setClsUsersById(Collection<ClsUserEntity> clsUsersById) {
        this.clsUsersById = clsUsersById;
        return this;
    }

    @OneToMany(mappedBy = "clsEmployeeByIdMaker")
    @JsonIgnore
    public Collection<RegExecRoutingConsumEntity> getRegExecRoutingConsumsById() {
        return regExecRoutingConsumsById;
    }

    public ClsEmployeeEntity setRegExecRoutingConsumsById(Collection<RegExecRoutingConsumEntity> regExecRoutingConsumsById) {
        this.regExecRoutingConsumsById = regExecRoutingConsumsById;
        return this;
    }

    @OneToMany(mappedBy = "clsEmployeeByIdEmployee")
    @JsonIgnore
    public Collection<RegExecRoutingConsumEntity> getRegExecRoutingConsumsById_0() {
        return regExecRoutingConsumsById_0;
    }

    public ClsEmployeeEntity setRegExecRoutingConsumsById_0(Collection<RegExecRoutingConsumEntity> regExecRoutingConsumsById_0) {
        this.regExecRoutingConsumsById_0 = regExecRoutingConsumsById_0;
        return this;
    }

    @OneToMany(mappedBy = "clsEmployeeByIdMaker")
    @JsonIgnore
    public Collection<RegExecRoutingEquipmentEntity> getRegExecRoutingEquipmentsById() {
        return regExecRoutingEquipmentsById;
    }

    public ClsEmployeeEntity setRegExecRoutingEquipmentsById(Collection<RegExecRoutingEquipmentEntity> regExecRoutingEquipmentsById) {
        this.regExecRoutingEquipmentsById = regExecRoutingEquipmentsById;
        return this;
    }

    @OneToMany(mappedBy = "clsEmployeeByIdEmployee")
    @JsonIgnore
    public Collection<RegExecRoutingEquipmentEntity> getRegExecRoutingEquipmentsById_0() {
        return regExecRoutingEquipmentsById_0;
    }

    public ClsEmployeeEntity setRegExecRoutingEquipmentsById_0(Collection<RegExecRoutingEquipmentEntity> regExecRoutingEquipmentsById_0) {
        this.regExecRoutingEquipmentsById_0 = regExecRoutingEquipmentsById_0;
        return this;
    }

    @OneToMany(mappedBy = "clsEmployeeByIdMaker")
    @JsonIgnore
    public Collection<RegExecRoutingFertilizerEntity> getRegExecRoutingFertilizersById() {
        return regExecRoutingFertilizersById;
    }

    public ClsEmployeeEntity setRegExecRoutingFertilizersById(Collection<RegExecRoutingFertilizerEntity> regExecRoutingFertilizersById) {
        this.regExecRoutingFertilizersById = regExecRoutingFertilizersById;
        return this;
    }

    @OneToMany(mappedBy = "clsEmployeeByIdEmployee")
    @JsonIgnore
    public Collection<RegExecRoutingFertilizerEntity> getRegExecRoutingFertilizersById_0() {
        return regExecRoutingFertilizersById_0;
    }

    public ClsEmployeeEntity setRegExecRoutingFertilizersById_0(Collection<RegExecRoutingFertilizerEntity> regExecRoutingFertilizersById_0) {
        this.regExecRoutingFertilizersById_0 = regExecRoutingFertilizersById_0;
        return this;
    }

    @OneToMany(mappedBy = "clsEmployeeByIdMaker")
    @JsonIgnore
    public Collection<RegExecRoutingProtectionEquipmentEntity> getRegExecRoutingProtectionEquipmentsById() {
        return regExecRoutingProtectionEquipmentsById;
    }

    public ClsEmployeeEntity setRegExecRoutingProtectionEquipmentsById(Collection<RegExecRoutingProtectionEquipmentEntity> regExecRoutingProtectionEquipmentsById) {
        this.regExecRoutingProtectionEquipmentsById = regExecRoutingProtectionEquipmentsById;
        return this;
    }

    @OneToMany(mappedBy = "clsEmployeeByIdEmployee")
    @JsonIgnore
    public Collection<RegExecRoutingProtectionEquipmentEntity> getRegExecRoutingProtectionEquipmentsById_0() {
        return regExecRoutingProtectionEquipmentsById_0;
    }

    public ClsEmployeeEntity setRegExecRoutingProtectionEquipmentsById_0(Collection<RegExecRoutingProtectionEquipmentEntity> regExecRoutingProtectionEquipmentsById_0) {
        this.regExecRoutingProtectionEquipmentsById_0 = regExecRoutingProtectionEquipmentsById_0;
        return this;
    }

    @OneToMany(mappedBy = "clsEmployeeByIdMaker")
    @JsonIgnore
    public Collection<RegExecRoutingWorkEntity> getRegExecRoutingWorksById() {
        return regExecRoutingWorksById;
    }

    public ClsEmployeeEntity setRegExecRoutingWorksById(Collection<RegExecRoutingWorkEntity> regExecRoutingWorksById) {
        this.regExecRoutingWorksById = regExecRoutingWorksById;
        return this;
    }

    @OneToMany(mappedBy = "clsEmployeeByIdEmployee")
    @JsonIgnore
    public Collection<RegExecRoutingWorkEntity> getRegExecRoutingWorksById_0() {
        return regExecRoutingWorksById_0;
    }

    public ClsEmployeeEntity setRegExecRoutingWorksById_0(Collection<RegExecRoutingWorkEntity> regExecRoutingWorksById_0) {
        this.regExecRoutingWorksById_0 = regExecRoutingWorksById_0;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "id_depart", referencedColumnName = "id", nullable = false)
    public ClsDepartEntity getClsDepartByIdDepart() {
        return clsDepartByIdDepart;
    }

    public ClsEmployeeEntity setClsDepartByIdDepart(ClsDepartEntity clsDepartByIdDepart) {
        this.clsDepartByIdDepart = clsDepartByIdDepart;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "id_organization", referencedColumnName = "id", nullable = false)
    public ClsOrganizationEntity getClsOrganizationByIdOrganization() {
        return clsOrganizationByIdOrganization;
    }

    public ClsEmployeeEntity setClsOrganizationByIdOrganization(ClsOrganizationEntity clsOrganizationByIdOrganization) {
        this.clsOrganizationByIdOrganization = clsOrganizationByIdOrganization;
        return this;
    }
}
