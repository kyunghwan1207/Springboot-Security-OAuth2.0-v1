package team_project.beer_community.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter //setter는 개발 단계동안 열어놓는다.
@NoArgsConstructor(access = AccessLevel.PROTECTED)  //Spring data jpa 사용시 필요
//@ToString(of = {"id", "username"})
@ToString(of = {"id", "username", "password", "email", "birthday", "imageUrl"})
@Table(name = "user")
public class User extends BaseTimeEntity{

    @Id @GeneratedValue
    private int id;

    @NotNull
//    private String userEmail;
    private String email;

    @NotNull
//    private String userPw;
    private String password;

    @NotNull
//    private String userName;
    private String username;

//    @NotNull
    private LocalDate birthday;

    private String imageUrl;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<LikeBeer> likeBeers = new ArrayList<>();

    public User(String userEmail, String userPw, String userName) {
//        this.userEmail = userEmail;
//        this.userPw = userPw;
//        this.userName = userName;
        this.email = userEmail;
        this.password = userPw;
        this.username = userName;
    }

    //==연관관계 편의 메소드==//
    public void addLikeBeer(LikeBeer likeBeer){
        likeBeers.add(likeBeer);
        likeBeer.setUser(this);
    }

    public void addComment(Comment comment){
        comments.add(comment);
        comment.setUser(this);
    }
}
