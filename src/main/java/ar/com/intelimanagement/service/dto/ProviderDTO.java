package ar.com.intelimanagement.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Provider entity.
 */
public class ProviderDTO implements Serializable {

    private Long id;

    private String name;

    private Long companyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProviderDTO providerDTO = (ProviderDTO) o;
        if (providerDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), providerDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProviderDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", company=" + getCompanyId() +
            "}";
    }
}
