package api.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by lucaslemos on 8/1/16.
 */
@Entity
@SequenceGenerator(name = "PRODUCT_SEQ", sequenceName = "PRODUCT_SEQ")
public class Product implements Serializable{

    @Id
    @GeneratedValue(generator = "PRODUCT_SEQ")
    private Integer id;

    @Column(nullable = false)
    @NaturalId
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToMany
    @JoinTable(name = "product_tag", joinColumns = @JoinColumn(name = "productid"), inverseJoinColumns = @JoinColumn(name = "tagid"))
    private List<Tag> tags;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Column(nullable = true)
    @JsonManagedReference
    private List<PricePoint> pricePoints;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<PricePoint> getPricePoints() {
        return pricePoints;
    }

    public void setPricePoints(List<PricePoint> pricePoints) {
        this.pricePoints = pricePoints;
    }
}
