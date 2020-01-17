package ru.sibdigital.difar.domain.classifier.breed;

import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.classifier.base.ClsBaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cls_age_sex_group", schema = "breed")
public class ClsAgeSexGroupEntity extends ClsBaseEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private String code;
    private long id;
    private Integer sex;
    private Integer beginAge;
    private Integer endAge;

    public ClsAgeSexGroupEntity() {
        setDeleted(false);
    }

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public ClsAgeSexGroupEntity setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public ClsAgeSexGroupEntity setName(String name) {
        this.name = name;
        return this;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public ClsAgeSexGroupEntity setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public ClsAgeSexGroupEntity setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public ClsAgeSexGroupEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    @Basic
    @Column(name = "code", nullable = false, length = 64)
    public String getCode() {
        return code;
    }

    public ClsAgeSexGroupEntity setCode(String code) {
        this.code = code;
        return this;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "cls_age_sex_group_id_seq", schema = "breed")
    public long getId() {
        return id;
    }

    public ClsAgeSexGroupEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "sex", nullable = true)
    public Integer getSex() {
        return sex;
    }

    public ClsAgeSexGroupEntity setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    @Basic
    @Column(name = "begin_age", nullable = true)
    public Integer getBeginAge() {
        return beginAge;
    }

    public ClsAgeSexGroupEntity setBeginAge(Integer beginAge) {
        this.beginAge = beginAge;
        return this;
    }

    @Basic
    @Column(name = "end_age", nullable = true)
    public Integer getEndAge() {
        return endAge;
    }

    public ClsAgeSexGroupEntity setEndAge(Integer endAge) {
        this.endAge = endAge;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsAgeSexGroupEntity that = (ClsAgeSexGroupEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (beginAge != null ? !beginAge.equals(that.beginAge) : that.beginAge != null) return false;
        return endAge != null ? endAge.equals(that.endAge) : that.endAge == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (beginAge != null ? beginAge.hashCode() : 0);
        result = 31 * result + (endAge != null ? endAge.hashCode() : 0);
        return result;
    }
}
