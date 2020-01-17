package ru.sibdigital.difar.domain.classifier.dict;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.classifier.accs.ClsUserEntity;
import ru.sibdigital.difar.domain.classifier.agrc.ClsFieldEntity;
import ru.sibdigital.difar.domain.classifier.agrc.ClsGpsModuleEntity;
import ru.sibdigital.difar.domain.classifier.agrc.ClsWeatherStationEntity;
import ru.sibdigital.difar.domain.classifier.base.ClsBaseEntity;
import ru.sibdigital.difar.domain.classifier.org.*;
import ru.sibdigital.difar.domain.document.*;
import ru.sibdigital.difar.domain.register.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_organization", schema = "dict")
public class ClsOrganizationEntity extends ClsBaseEntity {
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

    public ClsOrganizationEntity setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public ClsOrganizationEntity setName(String name) {
        this.name = name;
        return this;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public ClsOrganizationEntity setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public ClsOrganizationEntity setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public ClsOrganizationEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "cls_organization_id_seq", schema = "dict")
    public long getId() {
        return id;
    }

    public ClsOrganizationEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "inn", nullable = true, length = 10)
    public String getInn() {
        return inn;
    }

    public ClsOrganizationEntity setInn(String inn) {
        this.inn = inn;
        return this;
    }

    @Basic
    @Column(name = "id_legal_entity", nullable = false, insertable = false, updatable = false)
    public long getIdLegalEntity() {
        return idLegalEntity;
    }

    public ClsOrganizationEntity setIdLegalEntity(long idLegalEntity) {
        this.idLegalEntity = idLegalEntity;
        return this;
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

    public ClsOrganizationEntity setClsUsersById(Collection<ClsUserEntity> clsUsersById) {
        this.clsUsersById = clsUsersById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<ClsFieldEntity> getClsFieldsById() {
        return clsFieldsById;
    }

    public ClsOrganizationEntity setClsFieldsById(Collection<ClsFieldEntity> clsFieldsById) {
        this.clsFieldsById = clsFieldsById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<ClsGpsModuleEntity> getClsGpsModulesById() {
        return clsGpsModulesById;
    }

    public ClsOrganizationEntity setClsGpsModulesById(Collection<ClsGpsModuleEntity> clsGpsModulesById) {
        this.clsGpsModulesById = clsGpsModulesById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<ClsWeatherStationEntity> getClsWeatherStationsById() {
        return clsWeatherStationsById;
    }

    public ClsOrganizationEntity setClsWeatherStationsById(Collection<ClsWeatherStationEntity> clsWeatherStationsById) {
        this.clsWeatherStationsById = clsWeatherStationsById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<DocActualYieldEntity> getDocActualYieldsById() {
        return docActualYieldsById;
    }

    public ClsOrganizationEntity setDocActualYieldsById(Collection<DocActualYieldEntity> docActualYieldsById) {
        this.docActualYieldsById = docActualYieldsById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<DocRoutingEntity> getDocRoutingsById() {
        return docRoutingsById;
    }

    public ClsOrganizationEntity setDocRoutingsById(Collection<DocRoutingEntity> docRoutingsById) {
        this.docRoutingsById = docRoutingsById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<RegGpsModuleOrganizationEquipmentEntity> getRegGpsModuleOrganizationEquipmentsById() {
        return regGpsModuleOrganizationEquipmentsById;
    }

    public ClsOrganizationEntity setRegGpsModuleOrganizationEquipmentsById(Collection<RegGpsModuleOrganizationEquipmentEntity> regGpsModuleOrganizationEquipmentsById) {
        this.regGpsModuleOrganizationEquipmentsById = regGpsModuleOrganizationEquipmentsById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<RegGpsModuleReadingEntity> getRegGpsModuleReadingsById() {
        return regGpsModuleReadingsById;
    }

    public ClsOrganizationEntity setRegGpsModuleReadingsById(Collection<RegGpsModuleReadingEntity> regGpsModuleReadingsById) {
        this.regGpsModuleReadingsById = regGpsModuleReadingsById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<RegOrganizationFertilizerEntity> getRegOrganizationFertilizersById() {
        return regOrganizationFertilizersById;
    }

    public ClsOrganizationEntity setRegOrganizationFertilizersById(Collection<RegOrganizationFertilizerEntity> regOrganizationFertilizersById) {
        this.regOrganizationFertilizersById = regOrganizationFertilizersById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<RegOrganizationProtectionEquipmentEntity> getRegOrganizationProtectionEquipmentsById() {
        return regOrganizationProtectionEquipmentsById;
    }

    public ClsOrganizationEntity setRegOrganizationProtectionEquipmentsById(Collection<RegOrganizationProtectionEquipmentEntity> regOrganizationProtectionEquipmentsById) {
        this.regOrganizationProtectionEquipmentsById = regOrganizationProtectionEquipmentsById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<RegWeatherStationReadingEntity> getRegWeatherStationReadingsById() {
        return regWeatherStationReadingsById;
    }

    public ClsOrganizationEntity setRegWeatherStationReadingsById(Collection<RegWeatherStationReadingEntity> regWeatherStationReadingsById) {
        this.regWeatherStationReadingsById = regWeatherStationReadingsById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<DocAnimalAppraisalEntity> getDocAnimalAppraisalsById() {
        return docAnimalAppraisalsById;
    }

    public ClsOrganizationEntity setDocAnimalAppraisalsById(Collection<DocAnimalAppraisalEntity> docAnimalAppraisalsById) {
        this.docAnimalAppraisalsById = docAnimalAppraisalsById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<DocAnimalBeatingEntity> getDocAnimalBeatingsById() {
        return docAnimalBeatingsById;
    }

    public ClsOrganizationEntity setDocAnimalBeatingsById(Collection<DocAnimalBeatingEntity> docAnimalBeatingsById) {
        this.docAnimalBeatingsById = docAnimalBeatingsById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<DocAnimalCalvingEntity> getDocAnimalCalvingsById() {
        return docAnimalCalvingsById;
    }

    public ClsOrganizationEntity setDocAnimalCalvingsById(Collection<DocAnimalCalvingEntity> docAnimalCalvingsById) {
        this.docAnimalCalvingsById = docAnimalCalvingsById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<DocAnimalCopulationEntity> getDocAnimalCopulationsById() {
        return docAnimalCopulationsById;
    }

    public ClsOrganizationEntity setDocAnimalCopulationsById(Collection<DocAnimalCopulationEntity> docAnimalCopulationsById) {
        this.docAnimalCopulationsById = docAnimalCopulationsById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<DocAnimalEventEntity> getDocAnimalEventsById() {
        return docAnimalEventsById;
    }

    public ClsOrganizationEntity setDocAnimalEventsById(Collection<DocAnimalEventEntity> docAnimalEventsById) {
        this.docAnimalEventsById = docAnimalEventsById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<DocAnimalRetirementEntity> getDocAnimalRetirementsById() {
        return docAnimalRetirementsById;
    }

    public ClsOrganizationEntity setDocAnimalRetirementsById(Collection<DocAnimalRetirementEntity> docAnimalRetirementsById) {
        this.docAnimalRetirementsById = docAnimalRetirementsById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<DocAnimalTransferEntity> getDocAnimalTransfersById() {
        return docAnimalTransfersById;
    }

    public ClsOrganizationEntity setDocAnimalTransfersById(Collection<DocAnimalTransferEntity> docAnimalTransfersById) {
        this.docAnimalTransfersById = docAnimalTransfersById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<RegAnimalEntity> getRegAnimalsById() {
        return regAnimalsById;
    }

    public ClsOrganizationEntity setRegAnimalsById(Collection<RegAnimalEntity> regAnimalsById) {
        this.regAnimalsById = regAnimalsById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<RegAnimalGroupEntity> getRegAnimalGroupsById() {
        return regAnimalGroupsById;
    }

    public ClsOrganizationEntity setRegAnimalGroupsById(Collection<RegAnimalGroupEntity> regAnimalGroupsById) {
        this.regAnimalGroupsById = regAnimalGroupsById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<RegAnimalLocalEntity> getRegAnimalLocalsById() {
        return regAnimalLocalsById;
    }

    public ClsOrganizationEntity setRegAnimalLocalsById(Collection<RegAnimalLocalEntity> regAnimalLocalsById) {
        this.regAnimalLocalsById = regAnimalLocalsById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<RegAnimalParamEntity> getRegAnimalParamsById() {
        return regAnimalParamsById;
    }

    public ClsOrganizationEntity setRegAnimalParamsById(Collection<RegAnimalParamEntity> regAnimalParamsById) {
        this.regAnimalParamsById = regAnimalParamsById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<RegAnimalStateEntity> getRegAnimalStatesById() {
        return regAnimalStatesById;
    }

    public ClsOrganizationEntity setRegAnimalStatesById(Collection<RegAnimalStateEntity> regAnimalStatesById) {
        this.regAnimalStatesById = regAnimalStatesById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<RegExternalAnimalEntity> getRegExternalAnimalsById() {
        return regExternalAnimalsById;
    }

    public ClsOrganizationEntity setRegExternalAnimalsById(Collection<RegExternalAnimalEntity> regExternalAnimalsById) {
        this.regExternalAnimalsById = regExternalAnimalsById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<ClsArbitraryPeriodEntity> getClsArbitraryPeriodsById() {
        return ClsArbitraryPeriodsById;
    }

    public ClsOrganizationEntity setClsArbitraryPeriodsById(Collection<ClsArbitraryPeriodEntity> ClsArbitraryPeriodsById) {
        this.ClsArbitraryPeriodsById = ClsArbitraryPeriodsById;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "id_legal_entity", referencedColumnName = "id", nullable = false)
    public ClsLegalEntityEntity getClsLegalEntityByIdLegalEntity() {
        return clsLegalEntityByIdLegalEntity;
    }

    public ClsOrganizationEntity setClsLegalEntityByIdLegalEntity(ClsLegalEntityEntity clsLegalEntityByIdLegalEntity) {
        this.clsLegalEntityByIdLegalEntity = clsLegalEntityByIdLegalEntity;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<RegOrganizationPartnerEntity> getRegOrganizationPartnersById() {
        return regOrganizationPartnersById;
    }

    public ClsOrganizationEntity setRegOrganizationPartnersById(Collection<RegOrganizationPartnerEntity> regOrganizationPartnersById) {
        this.regOrganizationPartnersById = regOrganizationPartnersById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<ClsDepartEntity> getClsDepartsById() {
        return clsDepartsById;
    }

    public ClsOrganizationEntity setClsDepartsById(Collection<ClsDepartEntity> clsDepartsById) {
        this.clsDepartsById = clsDepartsById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<ClsEmployeeEntity> getClsEmployeesById() {
        return clsEmployeesById;
    }

    public ClsOrganizationEntity setClsEmployeesById(Collection<ClsEmployeeEntity> clsEmployeesById) {
        this.clsEmployeesById = clsEmployeesById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<ClsEquipmentBaseEntity> getClsEquipmentBasesById() {
        return clsEquipmentBasesById;
    }

    public ClsOrganizationEntity setClsEquipmentBasesById(Collection<ClsEquipmentBaseEntity> clsEquipmentBasesById) {
        this.clsEquipmentBasesById = clsEquipmentBasesById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<ClsPositionEntity> getClsPositionsById() {
        return clsPositionsById;
    }

    public ClsOrganizationEntity setClsPositionsById(Collection<ClsPositionEntity> clsPositionsById) {
        this.clsPositionsById = clsPositionsById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<ClsRanchEntity> getClsRanchesById() {
        return clsRanchesById;
    }

    public ClsOrganizationEntity setClsRanchesById(Collection<ClsRanchEntity> clsRanchesById) {
        this.clsRanchesById = clsRanchesById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<RegEquipmentBaseLocalEntity> getRegEquipmentBaseLocalsById() {
        return regEquipmentBaseLocalsById;
    }

    public ClsOrganizationEntity setRegEquipmentBaseLocalsById(Collection<RegEquipmentBaseLocalEntity> regEquipmentBaseLocalsById) {
        this.regEquipmentBaseLocalsById = regEquipmentBaseLocalsById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<RegOrganizationConsumableEntity> getRegOrganizationConsumablesById() {
        return regOrganizationConsumablesById;
    }

    public ClsOrganizationEntity setRegOrganizationConsumablesById(Collection<RegOrganizationConsumableEntity> regOrganizationConsumablesById) {
        this.regOrganizationConsumablesById = regOrganizationConsumablesById;
        return this;
    }

    @OneToMany(mappedBy = "clsOrganizationByIdOrganization")
    @JsonIgnore
    public Collection<RegOrganizationEquipmentEntity> getRegOrganizationEquipmentsById() {
        return regOrganizationEquipmentsById;
    }

    public ClsOrganizationEntity setRegOrganizationEquipmentsById(Collection<RegOrganizationEquipmentEntity> regOrganizationEquipmentsById) {
        this.regOrganizationEquipmentsById = regOrganizationEquipmentsById;
        return this;
    }
}
