package ru.sibdigital.difar.domain.tableparts;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.sibdigital.difar.domain.classifier.agrc.ClsCropEntity;
import ru.sibdigital.difar.domain.classifier.agrc.ClsPlantOrganEntity;
import ru.sibdigital.difar.domain.classifier.agrc.ClsPlantPestEntity;

import javax.persistence.*;

@Entity
@Table(name = "tp_plant_pest_plant_organ", schema = "agrc")
@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
public class TpPlantPestPlantOrganEntity {
    private long idUserCreator;
    private Boolean isDeleted;
    private long number;
    private long id;
    private long idCrop;
    private long idPlantPest;
    private long idPlantOrgan;
    private JsonNode description;
    private ClsCropEntity clsCropByIdCrop;
    private ClsPlantPestEntity clsPlantPestByIdPlantPest;
    private ClsPlantOrganEntity clsPlantOrganByIdPlantOrgan;

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
    @Column(name = "id_crop", nullable = false, insertable = false, updatable = false)
    public long getIdCrop() {
        return idCrop;
    }

    public void setIdCrop(long idCrop) {
        this.idCrop = idCrop;
    }

    @Basic
    @Column(name = "id_plant_pest", nullable = false, insertable = false, updatable = false)
    public long getIdPlantPest() {
        return idPlantPest;
    }

    public void setIdPlantPest(long idPlantPest) {
        this.idPlantPest = idPlantPest;
    }

    @Basic
    @Column(name = "id_plant_organ", nullable = false, insertable = false, updatable = false)
    public long getIdPlantOrgan() {
        return idPlantOrgan;
    }

    public void setIdPlantOrgan(long idPlantOrgan) {
        this.idPlantOrgan = idPlantOrgan;
    }

    @Type(type = "jsonb-node")
    @Column(name = "description", nullable = true)
    public JsonNode getDescription() {
        return description;
    }

    public void setDescription(JsonNode description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TpPlantPestPlantOrganEntity that = (TpPlantPestPlantOrganEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (number != that.number) return false;
        if (id != that.id) return false;
        if (idCrop != that.idCrop) return false;
        if (idPlantPest != that.idPlantPest) return false;
        if (idPlantOrgan != that.idPlantOrgan) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (int) (number ^ (number >>> 32));
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idCrop ^ (idCrop >>> 32));
        result = 31 * result + (int) (idPlantPest ^ (idPlantPest >>> 32));
        result = 31 * result + (int) (idPlantOrgan ^ (idPlantOrgan >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
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
    @JoinColumn(name = "id_plant_pest", referencedColumnName = "id", nullable = false)
    public ClsPlantPestEntity getClsPlantPestByIdPlantPest() {
        return clsPlantPestByIdPlantPest;
    }

    public void setClsPlantPestByIdPlantPest(ClsPlantPestEntity clsPlantPestByIdPlantPest) {
        this.clsPlantPestByIdPlantPest = clsPlantPestByIdPlantPest;
    }

    @ManyToOne
    @JoinColumn(name = "id_plant_organ", referencedColumnName = "id", nullable = false)
    public ClsPlantOrganEntity getClsPlantOrganByIdPlantOrgan() {
        return clsPlantOrganByIdPlantOrgan;
    }

    public void setClsPlantOrganByIdPlantOrgan(ClsPlantOrganEntity clsPlantOrganByIdPlantOrgan) {
        this.clsPlantOrganByIdPlantOrgan = clsPlantOrganByIdPlantOrgan;
    }
}
