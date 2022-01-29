package web.model;

import javax.persistence.*;

@Entity
@Table (name = "mvc_users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "username")
    private String name;
    @Column (name = "email")
    private String email;
    @Column (name = "age")
    private int age;

    public User() {
    }

    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
//<td <a th:href = "@{/{id}/update(id=${user.getId()})}"></a>update</td>
//        <td th:href="/delete/${user.getId()}">delete</td>