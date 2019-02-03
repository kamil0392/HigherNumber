package HigherNumber;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trx", schema = "myapp")
public class Trx {
    @Id
    @Column(name = "abc")
    private int abc;

    public Trx(){}

    public void setAbc(int abc) {
        this.abc = abc;
    }

    public int getAbc() {
        return abc;
    }
}
