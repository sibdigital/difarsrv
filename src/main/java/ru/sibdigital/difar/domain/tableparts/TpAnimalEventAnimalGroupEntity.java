package ru.sibdigital.difar.domain.tableparts;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.sibdigital.difar.domain.document.DocAnimalEventEntity;
import ru.sibdigital.difar.domain.register.RegAnimalGroupEntity;

import javax.persistence.*;

@Entity
@Table(name = "tp_animal_event_animal_group", schema = "breed")
@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
public class TpAnimalEventAnimalGroupEntity {
    private long idUserCreator;
    private Boolean isDeleted;
    private long number;
    private long id;
    private long idAnimalEvent;
    private long idAnimalGroup1;
    private long idAnimalGroup2;
    private JsonNode listValues1;
    private JsonNode listValues2;
    private DocAnimalEventEntity docAnimalEventByIdAnimalEvent;
    private RegAnimalGroupEntity regAnimalGroupByIdAnimalGroup1;
    private RegAnimalGroupEntity regAnimalGroupByIdAnimalGroup2;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public void setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
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
    @Column(name = "number", nullable = false)
    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
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
    @Column(name = "id_animal_event", nullable = false)
    public long getIdAnimalEvent() {
        return idAnimalEvent;
    }

    public void setIdAnimalEvent(long idAnimalEvent) {
        this.idAnimalEvent = idAnimalEvent;
    }

    @Basic
    @Column(name = "id_animal_group1", nullable = false)
    public long getIdAnimalGroup1() {
        return idAnimalGroup1;
    }

    public void setIdAnimalGroup1(long idAnimalGroup1) {
        this.idAnimalGroup1 = idAnimalGroup1;
    }

    @Basic
    @Column(name = "id_animal_group2", nullable = false)
    public long getIdAnimalGroup2() {
        return idAnimalGroup2;
    }

    public void setIdAnimalGroup2(long idAnimalGroup2) {
        this.idAnimalGroup2 = idAnimalGroup2;
    }

    @Type(type = "jsonb-node")
    @Column(name = "list_values1", nullable = true)
    public JsonNode getListValues1() {
        return listValues1;
    }

    public void setListValues1(JsonNode listValues1) {
        this.listValues1 = listValues1;
    }

    @Type(type = "jsonb-node")
    @Column(name = "list_values2", nullable = true)
    public JsonNode getListValues2() {
        return listValues2;
    }

    public void setListValues2(JsonNode listValues2) {
        this.listValues2 = listValues2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TpAnimalEventAnimalGroupEntity that = (TpAnimalEventAnimalGroupEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (number != that.number) return false;
        if (id != that.id) return false;
        if (idAnimalEvent != that.idAnimalEvent) return false;
        if (idAnimalGroup1 != that.idAnimalGroup1) return false;
        if (idAnimalGroup2 != that.idAnimalGroup2) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (listValues1 != null ? !listValues1.equals(that.listValues1) : that.listValues1 != null) return false;
        return listValues2 != null ? listValues2.equals(that.listValues2) : that.listValues2 == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (int) (number ^ (number >>> 32));
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idAnimalEvent ^ (idAnimalEvent >>> 32));
        result = 31 * result + (int) (idAnimalGroup1 ^ (idAnimalGroup1 >>> 32));
        result = 31 * result + (int) (idAnimalGroup2 ^ (idAnimalGroup2 >>> 32));
        result = 31 * result + (listValues1 != null ? listValues1.hashCode() : 0);
        result = 31 * result + (listValues2 != null ? listValues2.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_animal_event", referencedColumnName = "id", nullable = false)
    public DocAnimalEventEntity getDocAnimalEventByIdAnimalEvent() {
        return docAnimalEventByIdAnimalEvent;
    }

    public void setDocAnimalEventByIdAnimalEvent(DocAnimalEventEntity docAnimalEventByIdAnimalEvent) {
        this.docAnimalEventByIdAnimalEvent = docAnimalEventByIdAnimalEvent;
    }

    @ManyToOne
    @JoinColumn(name = "id_animal_group1", referencedColumnName = "id", nullable = false)
    public RegAnimalGroupEntity getRegAnimalGroupByIdAnimalGroup1() {
        return regAnimalGroupByIdAnimalGroup1;
    }

    public void setRegAnimalGroupByIdAnimalGroup1(RegAnimalGroupEntity regAnimalGroupByIdAnimalGroup1) {
        this.regAnimalGroupByIdAnimalGroup1 = regAnimalGroupByIdAnimalGroup1;
    }

    @ManyToOne
    @JoinColumn(name = "id_animal_group2", referencedColumnName = "id", nullable = false)
    public RegAnimalGroupEntity getRegAnimalGroupByIdAnimalGroup2() {
        return regAnimalGroupByIdAnimalGroup2;
    }

    public void setRegAnimalGroupByIdAnimalGroup2(RegAnimalGroupEntity regAnimalGroupByIdAnimalGroup2) {
        this.regAnimalGroupByIdAnimalGroup2 = regAnimalGroupByIdAnimalGroup2;
    }
}
