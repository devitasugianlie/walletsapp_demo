package org.bsim.intern.walletsapp_demo.io.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "walletsTBL")
@SequenceGenerator(name = "seqwallets", initialValue=100, allocationSize = 10)
public class WalletsEntity implements Serializable {
    private static final long serialVersionUID = -1015232492142105410L; //random alt enter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqwallets")
    private long id;

    @Column(nullable = false)
    private String walletid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private long balance;

    @Column(nullable = false)
    private String nohp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private UserEntity user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWalletid() {
        return walletid;
    }

    public void setWalletid(String walletid) {
        this.walletid = walletid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
