import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pessoa {
    String nome;
    String cpf;
    String dataNascimento;

    public Pessoa(String nome, String cpf, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }
}

