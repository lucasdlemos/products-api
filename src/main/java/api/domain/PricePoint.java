package api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by lucaslemos on 8/1/16.
 */

@Entity
@Table(name = "PRICE_POINT")
@SequenceGenerator(name = "PRICEPOINT_SEQ", sequenceName = "PRICEPOINT_SEQ")
public class PricePoint implements Serializable {

    @Id
    @GeneratedValue(generator = "PRICEPOINT_SEQ")
    private Integer id;

    @NaturalId
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="productid")
    @JsonBackReference
    private Product product;

    @NaturalId
    @ManyToOne
    @JoinColumn(name = "currencyid")
    private Currency currency;

    @Column(name = "productvalue")
    private BigDecimal productValue;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getProductValue() {
        return productValue;
    }

    public void setProductValue(BigDecimal productValue) {
        this.productValue = productValue;
    }
}
