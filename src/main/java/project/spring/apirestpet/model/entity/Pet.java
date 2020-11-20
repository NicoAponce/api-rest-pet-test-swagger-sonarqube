package project.spring.apirestpet.model.entity;import lombok.*;import javax.persistence.*;@Getter@Setter@NoArgsConstructor@AllArgsConstructor@Builder@Entity@Table(name = "pets")public class Pet {    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)    @Column(name = "id")    private Long id;    @Column(name = "name")    private String name;    @Column(name = "age")    private Integer age;    @Column(name = "species")    private String species;    @Column(name = "breed")    private String breed;}