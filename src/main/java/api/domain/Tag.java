package api.domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

/**
 * Created by lucaslemos on 8/1/16.
 */
@Entity
@SequenceGenerator(name = "TAG_SEQ", sequenceName = "TAG_SEQ")
public class Tag implements Serializable {

    @Id
    @GeneratedValue(generator = "TAG_SEQ")
    private Integer id;

    @NaturalId
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
