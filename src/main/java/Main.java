import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        // CRIANDO UMA PESSOA
        /*
        Object obj = new JSONParser().parse(new FileReader("src/main/resources/pessoa.json"));

        JSONObject jo = (JSONObject) obj;
        Pessoa pessoa1 = new Pessoa(
                (String) jo.get("nome"),
                (String) jo.get("cpf"),
                (String) jo.get("dataNascimento")
        );

        System.out.println("A pessoa 1 se chama " + pessoa1.getNome() + " tem o cpf " + pessoa1.getCpf() + " e a data de nascimento " + pessoa1.getDataNascimento());

        // ESCREVENDO O JSON
        JSONObject pessoa_json = new JSONObject();
        pessoa_json.put("nome", pessoa1.getNome());
        pessoa_json.put("cpf", pessoa1.getCpf());
        pessoa_json.put("dataNascimento", pessoa1.getDataNascimento());

        PrintWriter pw = new PrintWriter("src/main/resources/pessoaInstanciada.json");
        ObjectMapper mapper = new ObjectMapper();
        pw.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pessoa_json));
        pw.flush();
        pw.close();
        */
        //CRIANDO MÚLTIPLAS PESSOAS
        Object obj = new JSONParser().parse(new FileReader("src/main/resources/pessoas.json"));

        JSONArray ja = (JSONArray) obj;
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        for (Object pessoaObj : ja) {
            JSONObject pessoa = (JSONObject) pessoaObj;
            Pessoa p = new Pessoa(
                    (String) pessoa.get("nome"),
                    (String) pessoa.get("cpf"),
                    (String) pessoa.get("dataNascimento")
            );
            pessoas.add(p);
        }

        for (Pessoa pessoa : pessoas){
            System.out.println("A pessoa se chama " + pessoa.getNome() + " tem o cpf " + pessoa.getCpf() + " e a data de nascimento " + pessoa.getDataNascimento());
            System.out.println("\n");
        }
        // ESCREVENDO A LISTA DE PESSOAS EM UM JSON

        JSONArray pessoas_json = new JSONArray();
        for (Pessoa pessoa: pessoas){
            JSONObject jo = new JSONObject();
            jo.put("nome", pessoa.getNome());
            jo.put("cpf", pessoa.getCpf());
            jo.put("dataNascimento", pessoa.getDataNascimento());

            pessoas_json.add(jo);
        }

        PrintWriter pw = new PrintWriter("src/main/resources/pessoasInstanciadas.json");
        ObjectMapper mapper = new ObjectMapper();
        pw.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pessoas_json));

        pw.flush();
        pw.close();
    }
}
