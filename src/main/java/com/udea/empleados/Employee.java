
package com.udea.empleados;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@ApiModel(description = "All details about the Employee. ")
public class Employee {
@ApiModelProperty(notes = "The database generated employee ID")
@Id
private String id;
@ApiModelProperty(notes = "The personal email id")
private @NonNull String email;
@ApiModelProperty(notes = "The employee full name")
private @NonNull String fullName;
@ApiModelProperty(notes = "The employee email id")
private @NonNull String managerEmail;
@ApiModelProperty(notes = "The employee salary")
private @NonNull Double salary;
@ApiModelProperty(notes = "The employee role")
private @NonNull String role;
@ApiModelProperty(notes = "The employee address")
private @NonNull String address;
@ApiModelProperty(notes = "The employee office")
private @NonNull String office;
@ApiModelProperty(notes = "The employee dependency")
private @NonNull String dependency;
}

