package ru.sibdigital.difar.domain.register;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.sibdigital.difar.domain.catalog.*;
import ru.sibdigital.difar.domain.tableparts.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "reg_animal", schema = "breed")
@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
public class RegAnimalEntity {
    private long idUserCreator;
    private Timestamp dateCreate;
    private Timestamp dateBegin;
    private Timestamp dateEnd;
    private long id;
    private long idOrganization;
    private long idPartner;
    private long idKindAnimal;
    private long idBreed;
    private long idRegion;
    private long idDistrict;
    private long idArea;
    private long idMother;
    private long idFather;
    private long idGroupMother;
    private long idGroupFather;
    private long idExternalMother;
    private long idExternalFather;
    private Timestamp dateBirth;
    private Timestamp dateRetirement;
    private Integer sex;
    private String chipIdent;
    private JsonNode ident;
    private String nick;
//    private Object motherPath;
//    private Object fatherPath;
    private ClsOrganizationEntity clsOrganizationByIdOrganization;
    private ClsPartnerEntity clsPartnerByIdPartner;
    private ClsKindAnimalEntity clsKindAnimalByIdKindAnimal;
    private ClsBreedEntity clsBreedByIdBreed;
    private ClsRegionEntity clsRegionByIdRegion;
    private ClsDistrictEntity clsDistrictByIdDistrict;
    private ClsAreaEntity clsAreaByIdArea;
    private RegAnimalGroupEntity regAnimalGroupByIdGroupMother;
    private RegAnimalGroupEntity regAnimalGroupByIdGroupFather;
    private Collection<RegAnimalGroupEntity> regAnimalGroupsById;
    private Collection<RegAnimalLocalEntity> regAnimalLocalsById;
    private Collection<RegAnimalParamEntity> regAnimalParamsById;
    private Collection<RegAnimalStateEntity> regAnimalStatesById;
    private Collection<TpAnimalAppraisalAnimalEntity> tpAnimalAppraisalAnimalsById;
    private Collection<TpAnimalBeatingAnimalEntity> tpAnimalBeatingAnimalsById;
    private Collection<TpAnimalBeatingAnimalEntity> tpAnimalBeatingAnimalsById_0;
    private Collection<TpAnimalBeatingAnimalGroupEntity> tpAnimalBeatingAnimalGroupsById;
    private Collection<TpAnimalCalvingAnimalEntity> tpAnimalCalvingAnimalsById;
    private Collection<TpAnimalCalvingAnimalEntity> tpAnimalCalvingAnimalsById_0;
    private Collection<TpAnimalCalvingAnimalEntity> tpAnimalCalvingAnimalsById_1;
    private Collection<TpAnimalCalvingAnimalGroupEntity> tpAnimalCalvingAnimalGroupsById;
    private Collection<TpAnimalCopulationAnimalEntity> tpAnimalCopulationAnimalsById;
    private Collection<TpAnimalCopulationAnimalEntity> tpAnimalCopulationAnimalsById_0;
    private Collection<TpAnimalEventAnimalEntity> tpAnimalEventAnimalsById;
    private Collection<TpAnimalEventAnimalEntity> tpAnimalEventAnimalsById_0;
    private Collection<TpAnimalRetirementAnimalEntity> tpAnimalRetirementAnimalsById;
    private Collection<TpAnimalSaleAnimalEntity> tpAnimalSaleAnimalsById;
    private Collection<TpAnimalTransferAnimalEntity> tpAnimalTransferAnimalsById;

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
    @Column(name = "id_organization", nullable = false, insertable = false, updatable = false)
    public long getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(long idOrganization) {
        this.idOrganization = idOrganization;
    }

    @Basic
    @Column(name = "id_partner", nullable = false, insertable = false, updatable = false)
    public long getIdPartner() {
        return idPartner;
    }

    public void setIdPartner(long idPartner) {
        this.idPartner = idPartner;
    }

    @Basic
    @Column(name = "id_kind_animal", nullable = false, insertable = false, updatable = false)
    public long getIdKindAnimal() {
        return idKindAnimal;
    }

    public void setIdKindAnimal(long idKindAnimal) {
        this.idKindAnimal = idKindAnimal;
    }

    @Basic
    @Column(name = "id_breed", nullable = false, insertable = false, updatable = false)
    public long getIdBreed() {
        return idBreed;
    }

    public void setIdBreed(long idBreed) {
        this.idBreed = idBreed;
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
    @Column(name = "id_mother", nullable = false, insertable = false, updatable = false)
    public long getIdMother() {
        return idMother;
    }

    public void setIdMother(long idMother) {
        this.idMother = idMother;
    }

    @Basic
    @Column(name = "id_father", nullable = false, insertable = false, updatable = false)
    public long getIdFather() {
        return idFather;
    }

    public void setIdFather(long idFather) {
        this.idFather = idFather;
    }

    @Basic
    @Column(name = "id_group_mother", nullable = false, insertable = false, updatable = false)
    public long getIdGroupMother() {
        return idGroupMother;
    }

    public void setIdGroupMother(long idGroupMother) {
        this.idGroupMother = idGroupMother;
    }

    @Basic
    @Column(name = "id_group_father", nullable = false, insertable = false, updatable = false)
    public long getIdGroupFather() {
        return idGroupFather;
    }

    public void setIdGroupFather(long idGroupFather) {
        this.idGroupFather = idGroupFather;
    }

    @Basic
    @Column(name = "id_external_mother", nullable = false, insertable = false, updatable = false)
    public long getIdExternalMother() {
        return idExternalMother;
    }

    public void setIdExternalMother(long idExternalMother) {
        this.idExternalMother = idExternalMother;
    }

    @Basic
    @Column(name = "id_external_father", nullable = false, insertable = false, updatable = false)
    public long getIdExternalFather() {
        return idExternalFather;
    }

    public void setIdExternalFather(long idExternalFather) {
        this.idExternalFather = idExternalFather;
    }

    @Basic
    @Column(name = "date_birth", nullable = true)
    public Timestamp getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Timestamp dateBirth) {
        this.dateBirth = dateBirth;
    }

    @Basic
    @Column(name = "date_retirement", nullable = true)
    public Timestamp getDateRetirement() {
        return dateRetirement;
    }

    public void setDateRetirement(Timestamp dateRetirement) {
        this.dateRetirement = dateRetirement;
    }

    @Basic
    @Column(name = "sex", nullable = true)
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "chip_ident", nullable = true, length = -1)
    public String getChipIdent() {
        return chipIdent;
    }

    public void setChipIdent(String chipIdent) {
        this.chipIdent = chipIdent;
    }

    @Type(type = "jsonb-node")
    @Column(name = "ident", nullable = true)
    public JsonNode getIdent() {
        return ident;
    }

    public void setIdent(JsonNode ident) {
        this.ident = ident;
    }

    @Basic
    @Column(name = "nick", nullable = true, length = -1)
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

//    @Basic
//    @Column(name = "mother_path", nullable = true)
//    public Object getMotherPath() {
//        return motherPath;
//    }
//
//    public void setMotherPath(Object motherPath) {
//        this.motherPath = motherPath;
//    }
//
//    @Basic
//    @Column(name = "father_path", nullable = true)
//    public Object getFatherPath() {
//        return fatherPath;
//    }
//
//    public void setFatherPath(Object fatherPath) {
//        this.fatherPath = fatherPath;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        RegAnimalEntity that = (RegAnimalEntity) o;
//
//        if (idUserCreator != that.idUserCreator) return false;
//        if (id != that.id) return false;
//        if (idOrganization != that.idOrganization) return false;
//        if (idPartner != that.idPartner) return false;
//        if (idKindAnimal != that.idKindAnimal) return false;
//        if (idBreed != that.idBreed) return false;
//        if (idRegion != that.idRegion) return false;
//        if (idDistrict != that.idDistrict) return false;
//        if (idArea != that.idArea) return false;
//        if (idMother != that.idMother) return false;
//        if (idFather != that.idFather) return false;
//        if (idGroupMother != that.idGroupMother) return false;
//        if (idGroupFather != that.idGroupFather) return false;
//        if (idExternalMother != that.idExternalMother) return false;
//        if (idExternalFather != that.idExternalFather) return false;
//        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
//        if (dateBegin != null ? !dateBegin.equals(that.dateBegin) : that.dateBegin != null) return false;
//        if (dateEnd != null ? !dateEnd.equals(that.dateEnd) : that.dateEnd != null) return false;
//        if (dateBirth != null ? !dateBirth.equals(that.dateBirth) : that.dateBirth != null) return false;
//        if (dateRetirement != null ? !dateRetirement.equals(that.dateRetirement) : that.dateRetirement != null)
//            return false;
//        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
//        if (chipIdent != null ? !chipIdent.equals(that.chipIdent) : that.chipIdent != null) return false;
//        if (ident != null ? !ident.equals(that.ident) : that.ident != null) return false;
//        if (nick != null ? !nick.equals(that.nick) : that.nick != null) return false;
//        if (motherPath != null ? !motherPath.equals(that.motherPath) : that.motherPath != null) return false;
//        return fatherPath != null ? fatherPath.equals(that.fatherPath) : that.fatherPath == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
//        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
//        result = 31 * result + (dateBegin != null ? dateBegin.hashCode() : 0);
//        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
//        result = 31 * result + (int) (id ^ (id >>> 32));
//        result = 31 * result + (int) (idOrganization ^ (idOrganization >>> 32));
//        result = 31 * result + (int) (idPartner ^ (idPartner >>> 32));
//        result = 31 * result + (int) (idKindAnimal ^ (idKindAnimal >>> 32));
//        result = 31 * result + (int) (idBreed ^ (idBreed >>> 32));
//        result = 31 * result + (int) (idRegion ^ (idRegion >>> 32));
//        result = 31 * result + (int) (idDistrict ^ (idDistrict >>> 32));
//        result = 31 * result + (int) (idArea ^ (idArea >>> 32));
//        result = 31 * result + (int) (idMother ^ (idMother >>> 32));
//        result = 31 * result + (int) (idFather ^ (idFather >>> 32));
//        result = 31 * result + (int) (idGroupMother ^ (idGroupMother >>> 32));
//        result = 31 * result + (int) (idGroupFather ^ (idGroupFather >>> 32));
//        result = 31 * result + (int) (idExternalMother ^ (idExternalMother >>> 32));
//        result = 31 * result + (int) (idExternalFather ^ (idExternalFather >>> 32));
//        result = 31 * result + (dateBirth != null ? dateBirth.hashCode() : 0);
//        result = 31 * result + (dateRetirement != null ? dateRetirement.hashCode() : 0);
//        result = 31 * result + (sex != null ? sex.hashCode() : 0);
//        result = 31 * result + (chipIdent != null ? chipIdent.hashCode() : 0);
//        result = 31 * result + (ident != null ? ident.hashCode() : 0);
//        result = 31 * result + (nick != null ? nick.hashCode() : 0);
//        result = 31 * result + (motherPath != null ? motherPath.hashCode() : 0);
//        result = 31 * result + (fatherPath != null ? fatherPath.hashCode() : 0);
//        return result;
//    }

    @ManyToOne
    @JoinColumn(name = "id_organization", referencedColumnName = "id", nullable = false)
    public ClsOrganizationEntity getClsOrganizationByIdOrganization() {
        return clsOrganizationByIdOrganization;
    }

    public void setClsOrganizationByIdOrganization(ClsOrganizationEntity clsOrganizationByIdOrganization) {
        this.clsOrganizationByIdOrganization = clsOrganizationByIdOrganization;
    }

    @ManyToOne
    @JoinColumn(name = "id_partner", referencedColumnName = "id", nullable = false)
    public ClsPartnerEntity getClsPartnerByIdPartner() {
        return clsPartnerByIdPartner;
    }

    public void setClsPartnerByIdPartner(ClsPartnerEntity clsPartnerByIdPartner) {
        this.clsPartnerByIdPartner = clsPartnerByIdPartner;
    }

    @ManyToOne
    @JoinColumn(name = "id_kind_animal", referencedColumnName = "id", nullable = false)
    public ClsKindAnimalEntity getClsKindAnimalByIdKindAnimal() {
        return clsKindAnimalByIdKindAnimal;
    }

    public void setClsKindAnimalByIdKindAnimal(ClsKindAnimalEntity clsKindAnimalByIdKindAnimal) {
        this.clsKindAnimalByIdKindAnimal = clsKindAnimalByIdKindAnimal;
    }

    @ManyToOne
    @JoinColumn(name = "id_breed", referencedColumnName = "id", nullable = false)
    public ClsBreedEntity getClsBreedByIdBreed() {
        return clsBreedByIdBreed;
    }

    public void setClsBreedByIdBreed(ClsBreedEntity clsBreedByIdBreed) {
        this.clsBreedByIdBreed = clsBreedByIdBreed;
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
    @JoinColumn(name = "id_group_mother", referencedColumnName = "id", nullable = false)
    public RegAnimalGroupEntity getRegAnimalGroupByIdGroupMother() {
        return regAnimalGroupByIdGroupMother;
    }

    public void setRegAnimalGroupByIdGroupMother(RegAnimalGroupEntity regAnimalGroupByIdGroupMother) {
        this.regAnimalGroupByIdGroupMother = regAnimalGroupByIdGroupMother;
    }

    @ManyToOne
    @JoinColumn(name = "id_group_father", referencedColumnName = "id", nullable = false)
    public RegAnimalGroupEntity getRegAnimalGroupByIdGroupFather() {
        return regAnimalGroupByIdGroupFather;
    }

    public void setRegAnimalGroupByIdGroupFather(RegAnimalGroupEntity regAnimalGroupByIdGroupFather) {
        this.regAnimalGroupByIdGroupFather = regAnimalGroupByIdGroupFather;
    }

    @OneToMany(mappedBy = "regAnimalByIdAnimal")
    @JsonIgnore
public Collection<RegAnimalGroupEntity> getRegAnimalGroupsById() {
        return regAnimalGroupsById;
    }

    public void setRegAnimalGroupsById(Collection<RegAnimalGroupEntity> regAnimalGroupsById) {
        this.regAnimalGroupsById = regAnimalGroupsById;
    }

    @OneToMany(mappedBy = "regAnimalByIdAnimal")
    @JsonIgnore
public Collection<RegAnimalLocalEntity> getRegAnimalLocalsById() {
        return regAnimalLocalsById;
    }

    public void setRegAnimalLocalsById(Collection<RegAnimalLocalEntity> regAnimalLocalsById) {
        this.regAnimalLocalsById = regAnimalLocalsById;
    }

    @OneToMany(mappedBy = "regAnimalByIdAnimal")
    @JsonIgnore
public Collection<RegAnimalParamEntity> getRegAnimalParamsById() {
        return regAnimalParamsById;
    }

    public void setRegAnimalParamsById(Collection<RegAnimalParamEntity> regAnimalParamsById) {
        this.regAnimalParamsById = regAnimalParamsById;
    }

    @OneToMany(mappedBy = "regAnimalByIdAnimal")
    @JsonIgnore
public Collection<RegAnimalStateEntity> getRegAnimalStatesById() {
        return regAnimalStatesById;
    }

    public void setRegAnimalStatesById(Collection<RegAnimalStateEntity> regAnimalStatesById) {
        this.regAnimalStatesById = regAnimalStatesById;
    }

    @OneToMany(mappedBy = "regAnimalByIdAnimal")
    @JsonIgnore
public Collection<TpAnimalAppraisalAnimalEntity> getTpAnimalAppraisalAnimalsById() {
        return tpAnimalAppraisalAnimalsById;
    }

    public void setTpAnimalAppraisalAnimalsById(Collection<TpAnimalAppraisalAnimalEntity> tpAnimalAppraisalAnimalsById) {
        this.tpAnimalAppraisalAnimalsById = tpAnimalAppraisalAnimalsById;
    }

    @OneToMany(mappedBy = "regAnimalByIdAnimalMother")
    @JsonIgnore
public Collection<TpAnimalBeatingAnimalEntity> getTpAnimalBeatingAnimalsById() {
        return tpAnimalBeatingAnimalsById;
    }

    public void setTpAnimalBeatingAnimalsById(Collection<TpAnimalBeatingAnimalEntity> tpAnimalBeatingAnimalsById) {
        this.tpAnimalBeatingAnimalsById = tpAnimalBeatingAnimalsById;
    }

    @OneToMany(mappedBy = "regAnimalByIdAnimalChild")
    @JsonIgnore
public Collection<TpAnimalBeatingAnimalEntity> getTpAnimalBeatingAnimalsById_0() {
        return tpAnimalBeatingAnimalsById_0;
    }

    public void setTpAnimalBeatingAnimalsById_0(Collection<TpAnimalBeatingAnimalEntity> tpAnimalBeatingAnimalsById_0) {
        this.tpAnimalBeatingAnimalsById_0 = tpAnimalBeatingAnimalsById_0;
    }

    @OneToMany(mappedBy = "regAnimalByIdAnimalChild")
    @JsonIgnore
public Collection<TpAnimalBeatingAnimalGroupEntity> getTpAnimalBeatingAnimalGroupsById() {
        return tpAnimalBeatingAnimalGroupsById;
    }

    public void setTpAnimalBeatingAnimalGroupsById(Collection<TpAnimalBeatingAnimalGroupEntity> tpAnimalBeatingAnimalGroupsById) {
        this.tpAnimalBeatingAnimalGroupsById = tpAnimalBeatingAnimalGroupsById;
    }

    @OneToMany(mappedBy = "regAnimalByIdAnimalMother")
    @JsonIgnore
public Collection<TpAnimalCalvingAnimalEntity> getTpAnimalCalvingAnimalsById() {
        return tpAnimalCalvingAnimalsById;
    }

    public void setTpAnimalCalvingAnimalsById(Collection<TpAnimalCalvingAnimalEntity> tpAnimalCalvingAnimalsById) {
        this.tpAnimalCalvingAnimalsById = tpAnimalCalvingAnimalsById;
    }

    @OneToMany(mappedBy = "regAnimalByIdAnimalFather")
    @JsonIgnore
public Collection<TpAnimalCalvingAnimalEntity> getTpAnimalCalvingAnimalsById_0() {
        return tpAnimalCalvingAnimalsById_0;
    }

    public void setTpAnimalCalvingAnimalsById_0(Collection<TpAnimalCalvingAnimalEntity> tpAnimalCalvingAnimalsById_0) {
        this.tpAnimalCalvingAnimalsById_0 = tpAnimalCalvingAnimalsById_0;
    }

    @OneToMany(mappedBy = "regAnimalByIdAnimalChild")
    @JsonIgnore
public Collection<TpAnimalCalvingAnimalEntity> getTpAnimalCalvingAnimalsById_1() {
        return tpAnimalCalvingAnimalsById_1;
    }

    public void setTpAnimalCalvingAnimalsById_1(Collection<TpAnimalCalvingAnimalEntity> tpAnimalCalvingAnimalsById_1) {
        this.tpAnimalCalvingAnimalsById_1 = tpAnimalCalvingAnimalsById_1;
    }

    @OneToMany(mappedBy = "regAnimalByIdAnimalChild")
    @JsonIgnore
public Collection<TpAnimalCalvingAnimalGroupEntity> getTpAnimalCalvingAnimalGroupsById() {
        return tpAnimalCalvingAnimalGroupsById;
    }

    public void setTpAnimalCalvingAnimalGroupsById(Collection<TpAnimalCalvingAnimalGroupEntity> tpAnimalCalvingAnimalGroupsById) {
        this.tpAnimalCalvingAnimalGroupsById = tpAnimalCalvingAnimalGroupsById;
    }

    @OneToMany(mappedBy = "regAnimalByIdAnimalFemale")
    @JsonIgnore
public Collection<TpAnimalCopulationAnimalEntity> getTpAnimalCopulationAnimalsById() {
        return tpAnimalCopulationAnimalsById;
    }

    public void setTpAnimalCopulationAnimalsById(Collection<TpAnimalCopulationAnimalEntity> tpAnimalCopulationAnimalsById) {
        this.tpAnimalCopulationAnimalsById = tpAnimalCopulationAnimalsById;
    }

    @OneToMany(mappedBy = "regAnimalByIdAnimalMale")
    @JsonIgnore
public Collection<TpAnimalCopulationAnimalEntity> getTpAnimalCopulationAnimalsById_0() {
        return tpAnimalCopulationAnimalsById_0;
    }

    public void setTpAnimalCopulationAnimalsById_0(Collection<TpAnimalCopulationAnimalEntity> tpAnimalCopulationAnimalsById_0) {
        this.tpAnimalCopulationAnimalsById_0 = tpAnimalCopulationAnimalsById_0;
    }

    @OneToMany(mappedBy = "regAnimalByIdAnimal1")
    @JsonIgnore
public Collection<TpAnimalEventAnimalEntity> getTpAnimalEventAnimalsById() {
        return tpAnimalEventAnimalsById;
    }

    public void setTpAnimalEventAnimalsById(Collection<TpAnimalEventAnimalEntity> tpAnimalEventAnimalsById) {
        this.tpAnimalEventAnimalsById = tpAnimalEventAnimalsById;
    }

    @OneToMany(mappedBy = "regAnimalByIdAnimal2")
    @JsonIgnore
public Collection<TpAnimalEventAnimalEntity> getTpAnimalEventAnimalsById_0() {
        return tpAnimalEventAnimalsById_0;
    }

    public void setTpAnimalEventAnimalsById_0(Collection<TpAnimalEventAnimalEntity> tpAnimalEventAnimalsById_0) {
        this.tpAnimalEventAnimalsById_0 = tpAnimalEventAnimalsById_0;
    }

    @OneToMany(mappedBy = "regAnimalByIdAnimal")
    @JsonIgnore
public Collection<TpAnimalRetirementAnimalEntity> getTpAnimalRetirementAnimalsById() {
        return tpAnimalRetirementAnimalsById;
    }

    public void setTpAnimalRetirementAnimalsById(Collection<TpAnimalRetirementAnimalEntity> tpAnimalRetirementAnimalsById) {
        this.tpAnimalRetirementAnimalsById = tpAnimalRetirementAnimalsById;
    }

    @OneToMany(mappedBy = "regAnimalByIdAnimal")
    @JsonIgnore
public Collection<TpAnimalSaleAnimalEntity> getTpAnimalSaleAnimalsById() {
        return tpAnimalSaleAnimalsById;
    }

    public void setTpAnimalSaleAnimalsById(Collection<TpAnimalSaleAnimalEntity> tpAnimalSaleAnimalsById) {
        this.tpAnimalSaleAnimalsById = tpAnimalSaleAnimalsById;
    }

    @OneToMany(mappedBy = "regAnimalByIdAnimal")
    @JsonIgnore
public Collection<TpAnimalTransferAnimalEntity> getTpAnimalTransferAnimalsById() {
        return tpAnimalTransferAnimalsById;
    }

    public void setTpAnimalTransferAnimalsById(Collection<TpAnimalTransferAnimalEntity> tpAnimalTransferAnimalsById) {
        this.tpAnimalTransferAnimalsById = tpAnimalTransferAnimalsById;
    }
}
