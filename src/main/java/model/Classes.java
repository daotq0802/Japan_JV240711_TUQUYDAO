package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "classes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Classes {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "class_id")
   private int id;
   @NotEmpty(message = "Dữ liệu không được để trống")
   @Column(name = "class_name", nullable = false, unique = true, columnDefinition = "varchar(100)")
   private String name;
   @NotEmpty(message = "Dữ liệu không được để trống")
   @Column(name = "class_majors", nullable = false, columnDefinition = "varchar(100)")
   private String majors;
//   @OneToMany(mappedBy = "classes", cascade = CascadeType.ALL, orphanRemoval = true)
//   private List<Students> students;
}
