package com.raddadjokes.raddadjokes.models;

import javax.persistence.*;

@Entity
@Table(name = "joke")
public class Joke {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;
    //    @OneToMany
//    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Integer userId;
    @Column(name = "setup")
    private String setup;
    @Column(name = "punchline")
    private String punchline;
    @Column(name="api_id", unique = true)
    private String apiId;
    @Column(name = "nsfw")
    private Boolean nsfw;


    //    NON-MVP Fields:
//    private Integer rating;


    public Joke(){}
    public Joke(Integer userId, String setup, String punchline, String apiId, Boolean nsfw) {
        this.userId = userId;
        this.setup = setup;
        this.punchline = punchline;
        this.apiId = apiId;
        this.nsfw = nsfw;
    }
//    public Joke(Long userId, String setup, String punchline, Boolean nsfw) {
//        this.userId = userId;
//        this.setup = setup;
//        this.punchline = punchline;
//        this.nsfw = nsfw;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

//    public Integer getUserId() {
//        return userId;
//    }

//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public Boolean getNsfw() {
        return nsfw;
    }

    public void setNsfw(Boolean nsfw) {
        this.nsfw = nsfw;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "id=" + id +
                ", user=" + userId +
                ", setup='" + setup + '\'' +
                ", punchline='" + punchline + '\'' +
                ", apiId='" + apiId + '\'' +
                ", nsfw=" + nsfw +
                '}';
    }
}