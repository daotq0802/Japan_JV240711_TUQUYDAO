package model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "students")
public class Students {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   @NotBlank(message = "Dữ liệu không được để trống")
   @Column(name = "student_name", nullable = false,unique = true,columnDefinition = "varchar(100)")
   private String name;
   @Column(name = "phone_number", columnDefinition = "varchar(11)", nullable = false,unique = true)
   @NotBlank(message = "Dữ liệu không được để trống")
   private String phone;
   @Column(name = "email", columnDefinition = "varchar(100)", nullable = false,unique = true)
   @NotBlank(message = "Dữ liệu không được để trống")
   @Email(message = "Email không đúng định dạng")
   private String email;
   @Column(name = "address", nullable = false, columnDefinition = "varchar(150)")
   @NotBlank(message = "Dữ liệu không được để trống")
   private String address;
   @Column(name = "sex", columnDefinition = "bit")
   private boolean sex;
   @ManyToOne
   @JoinColumn(name = "class_id")
   private Classes class_id;
   @Column(name = "imag_url", columnDefinition = "varchar(255)")
   private String imageURL;
   @Column(name = "status", columnDefinition = "tinyint")
   private int status = 1;
}
