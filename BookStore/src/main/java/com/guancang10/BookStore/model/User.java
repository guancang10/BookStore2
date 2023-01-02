package com.guancang10.BookStore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Order(Ordered.HIGHEST_PRECEDENCE)
public class User {
    @Id
    @JsonProperty("username")
    private String Username;

    @NotBlank(message = "Password cannot be null")
    @Size(min = 8,max = 20,message = "Password must more then equal 8 and less then equal 20")
    @JsonProperty("password")
    private String Password;

    @NotBlank(message = "First name cannot be null")
    @Size(min = 2,max = 30,message = "First name must more then equal 2 and less then equal 30")
    @JsonProperty("first_name")
    private String FirstName;

    @Size(max = 30,message = "Last name must less then equal 30")
    @JsonProperty("last_name")
    private String LastName;

    @NotNull(message = "DOB cannot be null")
    @JsonProperty("dob")
    private Date DOB;

    @NotNull(message = "Role Id cannot be null")
    @Min(value = 1,message = "Role Id not valid")
    @JsonProperty("role_id")
    private int RoleId;

}
