package org.bsim.intern.walletsapp_demo.ui.model.response;

//dari request - ke service & impl - dto -
//cotroller minta data ke service (implements, buat ambil data doang) -
// service minta ke dto buat ambilin dat ake entity
//user response ()

//controller - service (nerima req r controller, ambil data dr entity jg) -
//dto (terima data dr yg si service sm entity) - response ()-

public class WalletResponse {
    private String walletId;
    private String name; //wallet name
    private long balance; //balance
    private String noHP; //noHP

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
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

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }
}
