package ru.sibdigital.difar.domain.catalog;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.sibdigital.difar.domain.document.*;
import ru.sibdigital.difar.domain.register.RegAnimalStateEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_type_animal_event", schema = "breed")
@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
public class ClsTypeAnimalEventEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private long id;
    private JsonNode listParams;
    private JsonNode listParamsTabPartAnimal;
    private JsonNode listParamsTabPartAnimalGroup;
    private Collection<DocAnimalAppraisalEntity> docAnimalAppraisalsById;
    private Collection<DocAnimalBeatingEntity> docAnimalBeatingsById;
    private Collection<DocAnimalCalvingEntity> docAnimalCalvingsById;
    private Collection<DocAnimalCopulationEntity> docAnimalCopulationsById;
    private Collection<DocAnimalEventEntity> docAnimalEventsById;
    private Collection<DocAnimalRetirementEntity> docAnimalRetirementsById;
    private Collection<DocAnimalSaleEntity> docAnimalSalesById;
    private Collection<DocAnimalTransferEntity> docAnimalTransfersById;
    private Collection<RegAnimalStateEntity> regAnimalStatesById;

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

    @Type(type = "jsonb-node")
    @Column(name = "list_params", nullable = true)
    public JsonNode getListParams() {
        return listParams;
    }

    public void setListParams(JsonNode listParams) {
        this.listParams = listParams;
    }

    @Type(type = "jsonb-node")
    @Column(name = "list_params_tab_part_animal", nullable = true)
    public JsonNode getListParamsTabPartAnimal() {
        return listParamsTabPartAnimal;
    }

    public void setListParamsTabPartAnimal(JsonNode listParamsTabPartAnimal) {
        this.listParamsTabPartAnimal = listParamsTabPartAnimal;
    }

    @Type(type = "jsonb-node")
    @Column(name = "list_params_tab_part_animal_group", nullable = true)
    public JsonNode getListParamsTabPartAnimalGroup() {
        return listParamsTabPartAnimalGroup;
    }

    public void setListParamsTabPartAnimalGroup(JsonNode listParamsTabPartAnimalGroup) {
        this.listParamsTabPartAnimalGroup = listParamsTabPartAnimalGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsTypeAnimalEventEntity that = (ClsTypeAnimalEventEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (listParams != null ? !listParams.equals(that.listParams) : that.listParams != null) return false;
        if (listParamsTabPartAnimal != null ? !listParamsTabPartAnimal.equals(that.listParamsTabPartAnimal) : that.listParamsTabPartAnimal != null)
            return false;
        return listParamsTabPartAnimalGroup != null ? listParamsTabPartAnimalGroup.equals(that.listParamsTabPartAnimalGroup) : that.listParamsTabPartAnimalGroup == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (listParams != null ? listParams.hashCode() : 0);
        result = 31 * result + (listParamsTabPartAnimal != null ? listParamsTabPartAnimal.hashCode() : 0);
        result = 31 * result + (listParamsTabPartAnimalGroup != null ? listParamsTabPartAnimalGroup.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "clsTypeAnimalEventByIdTypeAnimalEvent")
    @JsonIgnore
    public Collection<DocAnimalAppraisalEntity> getDocAnimalAppraisalsById() {
        return docAnimalAppraisalsById;
    }

    public void setDocAnimalAppraisalsById(Collection<DocAnimalAppraisalEntity> docAnimalAppraisalsById) {
        this.docAnimalAppraisalsById = docAnimalAppraisalsById;
    }

    @OneToMany(mappedBy = "clsTypeAnimalEventByIdTypeAnimalEvent")
    @JsonIgnore
    public Collection<DocAnimalBeatingEntity> getDocAnimalBeatingsById() {
        return docAnimalBeatingsById;
    }

    public void setDocAnimalBeatingsById(Collection<DocAnimalBeatingEntity> docAnimalBeatingsById) {
        this.docAnimalBeatingsById = docAnimalBeatingsById;
    }

    @OneToMany(mappedBy = "clsTypeAnimalEventByIdTypeAnimalEvent")
    @JsonIgnore
    public Collection<DocAnimalCalvingEntity> getDocAnimalCalvingsById() {
        return docAnimalCalvingsById;
    }

    public void setDocAnimalCalvingsById(Collection<DocAnimalCalvingEntity> docAnimalCalvingsById) {
        this.docAnimalCalvingsById = docAnimalCalvingsById;
    }

    @OneToMany(mappedBy = "clsTypeAnimalEventByIdTypeAnimalEvent")
    @JsonIgnore
    public Collection<DocAnimalCopulationEntity> getDocAnimalCopulationsById() {
        return docAnimalCopulationsById;
    }

    public void setDocAnimalCopulationsById(Collection<DocAnimalCopulationEntity> docAnimalCopulationsById) {
        this.docAnimalCopulationsById = docAnimalCopulationsById;
    }

    @OneToMany(mappedBy = "clsTypeAnimalEventByIdTypeAnimalEvent")
    @JsonIgnore
    public Collection<DocAnimalEventEntity> getDocAnimalEventsById() {
        return docAnimalEventsById;
    }

    public void setDocAnimalEventsById(Collection<DocAnimalEventEntity> docAnimalEventsById) {
        this.docAnimalEventsById = docAnimalEventsById;
    }

    @OneToMany(mappedBy = "clsTypeAnimalEventByIdTypeAnimalEvent")
    @JsonIgnore
    public Collection<DocAnimalRetirementEntity> getDocAnimalRetirementsById() {
        return docAnimalRetirementsById;
    }

    public void setDocAnimalRetirementsById(Collection<DocAnimalRetirementEntity> docAnimalRetirementsById) {
        this.docAnimalRetirementsById = docAnimalRetirementsById;
    }

    @OneToMany(mappedBy = "clsTypeAnimalEventByIdTypeAnimalEvent")
    @JsonIgnore
    public Collection<DocAnimalSaleEntity> getDocAnimalSalesById() {
        return docAnimalSalesById;
    }

    public void setDocAnimalSalesById(Collection<DocAnimalSaleEntity> docAnimalSalesById) {
        this.docAnimalSalesById = docAnimalSalesById;
    }

    @OneToMany(mappedBy = "clsTypeAnimalEventByIdTypeAnimalEvent")
    @JsonIgnore
    public Collection<DocAnimalTransferEntity> getDocAnimalTransfersById() {
        return docAnimalTransfersById;
    }

    public void setDocAnimalTransfersById(Collection<DocAnimalTransferEntity> docAnimalTransfersById) {
        this.docAnimalTransfersById = docAnimalTransfersById;
    }

    @OneToMany(mappedBy = "clsTypeAnimalEventByIdTypeAnimalEvent")
    @JsonIgnore
    public Collection<RegAnimalStateEntity> getRegAnimalStatesById() {
        return regAnimalStatesById;
    }

    public void setRegAnimalStatesById(Collection<RegAnimalStateEntity> regAnimalStatesById) {
        this.regAnimalStatesById = regAnimalStatesById;
    }
}
