package business;

import com.google.gson.*;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;
import model.EnderecoMD;
/**
 *
 * @author nilton.brito
 */
public class IntegracaoApiBS {
    
        public static EnderecoMD buscarCep(String cep) throws IOException, Exception {

        try {
            URI url = new URI("https://viacep.com.br/ws/" + cep + "/json/");
            HttpURLConnection conexao = (HttpURLConnection) url.toURL().openConnection();
            conexao.setRequestMethod("GET");
            conexao.setDoInput(true);
            String convertJsonString = new String(conexao.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            Gson gson = new Gson();
            EnderecoMD endereco = gson.fromJson(convertJsonString, EnderecoMD.class);
            if (convertJsonString.length() == 18) {
               // endereco.setLblStatusCep(new javax.swing.ImageIcon("src/image/unconfirm.png"));
                JOptionPane.showMessageDialog(null, "CEP não encontrado na base de Dados");
                endereco.setCep("");
            } else {
               // endereco.setLblStatusCep(new javax.swing.ImageIcon("src/image/confirm.png"));
                return endereco;
            }
        } catch (JsonSyntaxException | IOException msgErro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão- status Code " + msgErro.toString());
        }
        return null;
    }
//        public void consultaCpf(){
//         HttpResponse response = Unirest.get("https://www.sintegraws.com.br/api/v1/execute-api.php")
//            .queryString("token", "XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX")
//            .queryString("cpf", "00000000000")
//            .queryString("data-nascimento", "01051986")
//            .queryString("plugin", "CPF")
//            .asString();
//            
//        }
}
