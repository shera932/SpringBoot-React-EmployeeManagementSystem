package net.origins.ems_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter         // It generates getter methods for all fields
@Setter         // It generates setter methods for all fields
@NoArgsConstructor  // It generates a no-argument constructor
@AllArgsConstructor // It generates a constructor with parameters for all fields
@Entity        // It marks the class as a JPA entity
@Table(name="employees") // It specifies the name of the database table as "employees"
public class Employee {

    @Id  // It marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // The database will automatically generate the primary key
    private Long id;

    @Column(name="first_Name") //generate the column in database with name firstName
    private String firstName;

    @Column(name="last_Name")
    private String lastName;

    @Column(name="email" , nullable = false , unique = true)
    private String email;
}
