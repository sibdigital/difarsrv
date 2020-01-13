package ru.sibdigital.difar.domain.catalog;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.document.*;
import ru.sibdigital.difar.domain.register.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_organization", schema = "dict")
public class ClsOrganizationEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private long id;
    private String inn;
    private long idLegalEntity;
    private Collection<ClsUserEntity> clsUsersById;
    private Collection<ClsFieldEntity> clsFieldsById;
    private Collection<ClsGpsModuleEntity> clsGpsModulesById;
    private Collection<ClsWeatherStationEntity> clsWeatherStationsById;
    private Collection<DocActualYieldEntity> docActualYieldsById;
    private Collection<DocRoutingEntity> docRoutingsById;
    private Collection<RegGpsModuleOrganizationEquipmentEntity> regGpsModuleOrganizationEquipmentsById;
    private Collection<RegGpsModuleReadingEntity> regGpsModuleReadingsById;
    private Collection<RegOrganizationFertilizerEntity> regOrganizationFertilizersById;
    private Collection<RegOrganizationProtectionEquipmentEntity> regOrganizationProtectionEquipmentsById;
    private Collection<RegWeatherStationReadingEntity> regWeatherStationReadingsById;
    private Collection<DocAnimalAppraisalEntity> docAnimalAppraisalsById;
    private Collection<DocAnimalBeatingEntity> docAnimalBeatingsById;
    private Collection<DocAnimalCalvingEntity> docAnimalCalvingsById;
    private Collection<DocAnimalCopulationEntity> docAnimalCopulationsById;
    private Collection<DocAnimalEventEntity> docAnimalEventsById;
    private Collection<DocAnimalRetirementEntity> docAnimalRetirementsById;
    private Collection<DocAnimalTransferEntity> docAnimalTransfersById;
    private Collection<RegAnimalEntity> regAnimalsById;
    private Collection<RegAnimalGroupEntity> regAnimalGroupsById;
    private Collection<RegAnimalLocalEntity> regAnimalLocalsById;
    private Collection<RegAnimalParamEntity> regAnimalParamsById;
    private Collection<RegAnimalStateEntity> regAnimalStatesById;
    private Collection<RegExternalAnimalEntity> regExternalAnimalsById;
    private Collection<ClsArbitraryPeriodEntity> ClsArbitraryPeriodsById;
    private ClsLegalEntityEntity clsLegalEntityByIdLegalEntity;
    private Collection<RegOrganizationPartnerEntity> regOrganizationPartnersById;
    private Collection<ClsDepartEntity> clsDepartsById;
    private Collection<ClsEmployeeEntity> clsEmployeesById;
    private Collection<ClsEquipmentBaseEntity> clsEquipmentBasesById;
    private Collection<ClsPositionEntity> clsPositionsById;
    private Collection<ClsRanchEntity> clsRanchesById;
    private Collection<RegEquipmentBaseLocalEntity> regEquipmentBaseLocalsById;
    private Collection<RegOrganizationConsumableEntity> regOrganizationConsumablesById;
    private Collection<RegOrganizationEquipmentEntity> regOrganizationEquipmentsById;

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
    @Column(name = "inn", nullable = true, length = 10)
    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    @Basic
    @Column(name = "id_legal_entity", nullable = false, insertable = false, updatable = false)
    public long getIdLegalEntity() {
        return idLegalEntity;
    }

    public void setIdLegalEntity(long idLegalEntity) {
        this.idLegalEntity = idLegalEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsOrganizationEntity that = (ClsOrganizationEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idLegalEntity != that.idLegalEntity) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        return inn != null ? inn.equals(that.inn) : that.inn == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (inn != null ? inn.hashCode() : 0);
        result = 31 * result + (int) (idLegalEntity ^ (idLegalEntity >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<ClsUserEntity> getClsUsersById() {
        return clsUsersById;
    }

    public void setClsUsersById(Collection<ClsUserEntity> clsUsersById) {
        this.clsUsersById = clsUsersById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<ClsFieldEntity> getClsFieldsById() {
        return clsFieldsById;
    }

    public void setClsFieldsById(Collection<ClsFieldEntity> clsFieldsById) {
        this.clsFieldsById = clsFieldsById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<ClsGpsModuleEntity> getClsGpsModulesById() {
        return clsGpsModulesById;
    }

    public void setClsGpsModulesById(Collection<ClsGpsModuleEntity> clsGpsModulesById) {
        this.clsGpsModulesById = clsGpsModulesById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<ClsWeatherStationEntity> getClsWeatherStationsById() {
        return clsWeatherStationsById;
    }

    public void setClsWeatherStationsById(Collection<ClsWeatherStationEntity> clsWeatherStationsById) {
        this.clsWeatherStationsById = clsWeatherStationsById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<DocActualYieldEntity> getDocActualYieldsById() {
        return docActualYieldsById;
    }

    public void setDocActualYieldsById(Collection<DocActualYieldEntity> docActualYieldsById) {
        this.docActualYieldsById = docActualYieldsById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<DocRoutingEntity> getDocRoutingsById() {
        return docRoutingsById;
    }

    public void setDocRoutingsById(Collection<DocRoutingEntity> docRoutingsById) {
        this.docRoutingsById = docRoutingsById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<RegGpsModuleOrganizationEquipmentEntity> getRegGpsModuleOrganizationEquipmentsById() {
        return regGpsModuleOrganizationEquipmentsById;
    }

    public void setRegGpsModuleOrganizationEquipmentsById(Collection<RegGpsModuleOrganizationEquipmentEntity> regGpsModuleOrganizationEquipmentsById) {
        this.regGpsModuleOrganizationEquipmentsById = regGpsModuleOrganizationEquipmentsById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<RegGpsModuleReadingEntity> getRegGpsModuleReadingsById() {
        return regGpsModuleReadingsById;
    }

    public void setRegGpsModuleReadingsById(Collection<RegGpsModuleReadingEntity> regGpsModuleReadingsById) {
        this.regGpsModuleReadingsById = regGpsModuleReadingsById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<RegOrganizationFertilizerEntity> getRegOrganizationFertilizersById() {
        return regOrganizationFertilizersById;
    }

    public void setRegOrganizationFertilizersById(Collection<RegOrganizationFertilizerEntity> regOrganizationFertilizersById) {
        this.regOrganizationFertilizersById = regOrganizationFertilizersById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<RegOrganizationProtectionEquipmentEntity> getRegOrganizationProtectionEquipmentsById() {
        return regOrganizationProtectionEquipmentsById;
    }

    public void setRegOrganizationProtectionEquipmentsById(Collection<RegOrganizationProtectionEquipmentEntity> regOrganizationProtectionEquipmentsById) {
        this.regOrganizationProtectionEquipmentsById = regOrganizationProtectionEquipmentsById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<RegWeatherStationReadingEntity> getRegWeatherStationReadingsById() {
        return regWeatherStationReadingsById;
    }

    public void setRegWeatherStationReadingsById(Collection<RegWeatherStationReadingEntity> regWeatherStationReadingsById) {
        this.regWeatherStationReadingsById = regWeatherStationReadingsById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<DocAnimalAppraisalEntity> getDocAnimalAppraisalsById() {
        return docAnimalAppraisalsById;
    }

    public void setDocAnimalAppraisalsById(Collection<DocAnimalAppraisalEntity> docAnimalAppraisalsById) {
        this.docAnimalAppraisalsById = docAnimalAppraisalsById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<DocAnimalBeatingEntity> getDocAnimalBeatingsById() {
        return docAnimalBeatingsById;
    }

    public void setDocAnimalBeatingsById(Collection<DocAnimalBeatingEntity> docAnimalBeatingsById) {
        this.docAnimalBeatingsById = docAnimalBeatingsById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<DocAnimalCalvingEntity> getDocAnimalCalvingsById() {
        return docAnimalCalvingsById;
    }

    public void setDocAnimalCalvingsById(Collection<DocAnimalCalvingEntity> docAnimalCalvingsById) {
        this.docAnimalCalvingsById = docAnimalCalvingsById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<DocAnimalCopulationEntity> getDocAnimalCopulationsById() {
        return docAnimalCopulationsById;
    }

    public void setDocAnimalCopulationsById(Collection<DocAnimalCopulationEntity> docAnimalCopulationsById) {
        this.docAnimalCopulationsById = docAnimalCopulationsById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<DocAnimalEventEntity> getDocAnimalEventsById() {
        return docAnimalEventsById;
    }

    public void setDocAnimalEventsById(Collection<DocAnimalEventEntity> docAnimalEventsById) {
        this.docAnimalEventsById = docAnimalEventsById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<DocAnimalRetirementEntity> getDocAnimalRetirementsById() {
        return docAnimalRetirementsById;
    }

    public void setDocAnimalRetirementsById(Collection<DocAnimalRetirementEntity> docAnimalRetirementsById) {
        this.docAnimalRetirementsById = docAnimalRetirementsById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<DocAnimalTransferEntity> getDocAnimalTransfersById() {
        return docAnimalTransfersById;
    }

    public void setDocAnimalTransfersById(Collection<DocAnimalTransferEntity> docAnimalTransfersById) {
        this.docAnimalTransfersById = docAnimalTransfersById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<RegAnimalEntity> getRegAnimalsById() {
        return regAnimalsById;
    }

    public void setRegAnimalsById(Collection<RegAnimalEntity> regAnimalsById) {
        this.regAnimalsById = regAnimalsById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<RegAnimalGroupEntity> getRegAnimalGroupsById() {
        return regAnimalGroupsById;
    }

    public void setRegAnimalGroupsById(Collection<RegAnimalGroupEntity> regAnimalGroupsById) {
        this.regAnimalGroupsById = regAnimalGroupsById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<RegAnimalLocalEntity> getRegAnimalLocalsById() {
        return regAnimalLocalsById;
    }

    public void setRegAnimalLocalsById(Collection<RegAnimalLocalEntity> regAnimalLocalsById) {
        this.regAnimalLocalsById = regAnimalLocalsById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<RegAnimalParamEntity> getRegAnimalParamsById() {
        return regAnimalParamsById;
    }

    public void setRegAnimalParamsById(Collection<RegAnimalParamEntity> regAnimalParamsById) {
        this.regAnimalParamsById = regAnimalParamsById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<RegAnimalStateEntity> getRegAnimalStatesById() {
        return regAnimalStatesById;
    }

    public void setRegAnimalStatesById(Collection<RegAnimalStateEntity> regAnimalStatesById) {
        this.regAnimalStatesById = regAnimalStatesById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<RegExternalAnimalEntity> getRegExternalAnimalsById() {
        return regExternalAnimalsById;
    }

    public void setRegExternalAnimalsById(Collection<RegExternalAnimalEntity> regExternalAnimalsById) {
        this.regExternalAnimalsById = regExternalAnimalsById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<ClsArbitraryPeriodEntity> getClsArbitraryPeriodsById() {
        return ClsArbitraryPeriodsById;
    }

    public void setClsArbitraryPeriodsById(Collection<ClsArbitraryPeriodEntity> ClsArbitraryPeriodsById) {
        this.ClsArbitraryPeriodsById = ClsArbitraryPeriodsById;
    }

    @ManyToOne
    @JoinColumn(name = "id_legal_entity", referencedColumnName = "id", nullable = false)
    public ClsLegalEntityEntity getClsLegalEntityByIdLegalEntity() {
        return clsLegalEntityByIdLegalEntity;
    }

    public void setClsLegalEntityByIdLegalEntity(ClsLegalEntityEntity clsLegalEntityByIdLegalEntity) {
        this.clsLegalEntityByIdLegalEntity = clsLegalEntityByIdLegalEntity;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<RegOrganizationPartnerEntity> getRegOrganizationPartnersById() {
        return regOrganizationPartnersById;
    }

    public void setRegOrganizationPartnersById(Collection<RegOrganizationPartnerEntity> regOrganizationPartnersById) {
        this.regOrganizationPartnersById = regOrganizationPartnersById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<ClsDepartEntity> getClsDepartsById() {
        return clsDepartsById;
    }

    public void setClsDepartsById(Collection<ClsDepartEntity> clsDepartsById) {
        this.clsDepartsById = clsDepartsById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<ClsEmployeeEntity> getClsEmployeesById() {
        return clsEmployeesById;
    }

    public void setClsEmployeesById(Collection<ClsEmployeeEntity> clsEmployeesById) {
        this.clsEmployeesById = clsEmployeesById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<ClsEquipmentBaseEntity> getClsEquipmentBasesById() {
        return clsEquipmentBasesById;
    }

    public void setClsEquipmentBasesById(Collection<ClsEquipmentBaseEntity> clsEquipmentBasesById) {
        this.clsEquipmentBasesById = clsEquipmentBasesById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<ClsPositionEntity> getClsPositionsById() {
        return clsPositionsById;
    }

    public void setClsPositionsById(Collection<ClsPositionEntity> clsPositionsById) {
        this.clsPositionsById = clsPositionsById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<ClsRanchEntity> getClsRanchesById() {
        return clsRanchesById;
    }

    public void setClsRanchesById(Collection<ClsRanchEntity> clsRanchesById) {
        this.clsRanchesById = clsRanchesById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<RegEquipmentBaseLocalEntity> getRegEquipmentBaseLocalsById() {
        return regEquipmentBaseLocalsById;
    }

    public void setRegEquipmentBaseLocalsById(Collection<RegEquipmentBaseLocalEntity> regEquipmentBaseLocalsById) {
        this.regEquipmentBaseLocalsById = regEquipmentBaseLocalsById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<RegOrganizationConsumableEntity> getRegOrganizationConsumablesById() {
        return regOrganizationConsumablesById;
    }

    public void setRegOrganizationConsumablesById(Collection<RegOrganizationConsumableEntity> regOrganizationConsumablesById) {
        this.regOrganizationConsumablesById = regOrganizationConsumablesById;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
public Collection<RegOrganizationEquipmentEntity> getRegOrganizationEquipmentsById() {
        return regOrganizationEquipmentsById;
    }

    public void setRegOrganizationEquipmentsById(Collection<RegOrganizationEquipmentEntity> regOrganizationEquipmentsById) {
        this.regOrganizationEquipmentsById = regOrganizationEquipmentsById;
    }
}
