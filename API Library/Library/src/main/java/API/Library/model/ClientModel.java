package API.Library.model;

import javax.persistence.*;

@Entity(name = "clients")
public class ClientModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 20)
    private String cpf;

    @Column(nullable = false, length = 500)
    private String name;


    public int getId() {
        return id;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
