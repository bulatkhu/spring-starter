package startproject.demo.entity;

import javax.persistence.*;

@Entity
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Boolean complieted;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public TodoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getComplieted() {
        return complieted;
    }

    public void setComplieted(Boolean complieted) {
        this.complieted = complieted;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
