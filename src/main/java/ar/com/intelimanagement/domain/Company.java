package ar.com.intelimanagement.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Company.
 */
@Entity
@Table(name = "company")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "actived", nullable = false)
    private String actived;

    @Column(name = "img")
    private String img;

    @OneToOne
    @JoinColumn(unique = true)
    private Address address;

    @OneToMany(mappedBy = "company")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<User> users = new HashSet<>();

    @OneToMany(mappedBy = "company")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Booking> bookings = new HashSet<>();

    @OneToMany(mappedBy = "company")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Provider> providers = new HashSet<>();

    @OneToMany(mappedBy = "company")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Product> products = new HashSet<>();
    
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Company name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public Company email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActived() {
        return actived;
    }

    public Company actived(String actived) {
        this.actived = actived;
        return this;
    }

    public void setActived(String actived) {
        this.actived = actived;
    }

    public String getImg() {
        return img;
    }

    public Company img(String img) {
        this.img = img;
        return this;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Address getAddress() {
        return address;
    }

    public Company address(Address address) {
        this.address = address;
        return this;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Company users(Set<User> u) {
        this.users = u;
        return this;
    }

    public Company addUser(User u) {
        this.users.add(u);
        u.setCompany(this);
        return this;
    }

    public Company removeUser(User u) {
        this.users.remove(u);
        u.setCompany(null);
        return this;
    }

    public void setUsers(Set<User> u) {
        this.users = u;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public Company bookings(Set<Booking> bookings) {
        this.bookings = bookings;
        return this;
    }

    public Company addBookings(Booking booking) {
        this.bookings.add(booking);
        booking.setCompany(this);
        return this;
    }

    public Company removeBookings(Booking booking) {
        this.bookings.remove(booking);
        booking.setCompany(null);
        return this;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public Set<Provider> getProviders() {
        return providers;
    }

    public Company providers(Set<Provider> providers) {
        this.providers = providers;
        return this;
    }

    public Company addProviders(Provider provider) {
        this.providers.add(provider);
        provider.setCompany(this);
        return this;
    }

    public Company removeProviders(Provider provider) {
        this.providers.remove(provider);
        provider.setCompany(null);
        return this;
    }

    public void setProviders(Set<Provider> providers) {
        this.providers = providers;
    }
    
    
    
    public Set<Provider> getProducts() {
        return providers;
    }

    public Company products(Set<Product> products) {
        this.products = products;
        return this;
    }

    public Company addProducts(Product product) {
        this.products.add(product);
        product.setCompany(this);
        return this;
    }

    public Company removeProducts(Product product) {
        this.products.remove(product);
        product.setCompany(null);
        return this;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
    
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Company company = (Company) o;
        if (company.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), company.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Company{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", actived='" + getActived() + "'" +
            ", img='" + getImg() + "'" +
            "}";
    }
}
