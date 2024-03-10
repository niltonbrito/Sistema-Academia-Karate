package swing;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
import static view.FrmAtleta.*;
import static view.FrmExames.*;
import static view.FrmPesquisa.*;
import static view.FrmUsuarios.*;

/**
 *
 * @author nilto
 */
public class SwingFrm {

    //INICIALIZAÇÃO DOS COMPONENTES FORMULARIO USUARIO
    public void setComboBoxFrmUsuario() {

        cmbSexoUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "MASCULINO", "FEMININO"}));

        cmbSexoUsuario.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                if (cmbSexoUsuario.getSelectedItem().equals("MASCULINO")) {
                    lbSexoUsuario.setIcon(new ImageIcon(getClass().getResource("/imagens/usuarios/sexoM.png")));
                } else if (cmbSexoUsuario.getSelectedItem().equals("FEMININO")) {
                    lbSexoUsuario.setIcon(new ImageIcon(getClass().getResource("/imagens/usuarios/sexoF.png")));
                } else {
                    lbSexoUsuario.setIcon(new ImageIcon(getClass().getResource("/imagens/usuarios/sexo.png")));
                }
            }
        });

        cmbPerfil.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie
            ) {
                if (cmbPerfil.getSelectedItem().equals("ADMINISTRADOR")) {
                    lbPerfil.setIcon(new ImageIcon(getClass().getResource("/imagens/usuarios/perfilADM.png")));
                } else if (cmbPerfil.getSelectedItem().equals("GERENTE")) {
                    lbPerfil.setIcon(new ImageIcon(getClass().getResource("/imagens/usuarios/perfilGER.png")));
                } else if (cmbPerfil.getSelectedItem().equals("PROFESSOR")) {
                    lbPerfil.setIcon(new ImageIcon(getClass().getResource("/imagens/usuarios/perfilPRO.png")));
                } else if (cmbPerfil.getSelectedItem().equals("USUARIO")) {
                    lbPerfil.setIcon(new ImageIcon(getClass().getResource("/imagens/usuarios/perfilUSU.png")));
                } else {
                    lbPerfil.setIcon(new ImageIcon(getClass().getResource("/imagens/usuarios/perfil.png")));
                }
            }
        }
        );

        cmbStatus.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie
            ) {
                if (cmbStatus.getSelectedItem().equals("ATIVO")) {
                    lbStatus.setIcon(new ImageIcon(getClass().getResource("/imagens/usuarios/statusATV.png")));
                } else if (cmbStatus.getSelectedItem().equals("INATIVO")) {
                    lbStatus.setIcon(new ImageIcon(getClass().getResource("/imagens/usuarios/statusINA.png")));
                } else {
                    lbStatus.setIcon(new ImageIcon(getClass().getResource("")));
                }
            }
        }
        );
    }

    //INICIALIZAÇÃO DOS COMPONENTES FORMULARIO ATLETA
    public void setComboBoxFrmAtleta() {

        cmbSexoAtleta.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "MASCULINO", "FEMININO"}));
        cmbSexoAtleta.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                if (cmbSexoAtleta.getSelectedItem().equals("MASCULINO")) {
                    lbSexoAtleta.setIcon(new ImageIcon(getClass().getResource("/imagens/usuarios/sexoM.png")));
                } else if (cmbSexoAtleta.getSelectedItem().equals("FEMININO")) {
                    lbSexoAtleta.setIcon(new ImageIcon(getClass().getResource("/imagens/usuarios/sexoF.png")));
                } else {
                    lbSexoAtleta.setIcon(new ImageIcon(getClass().getResource("/imagens/usuarios/sexo.png")));
                }
            }
        });

        cmbEstadoAtleta.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "DO ACRE", "DE ALAGOAS", "DO AMAPÁ", "DO AMAZONAS", "DA BAHIA", "DO CEARÁ", "DO DISTRITO FEDERAL", "DO ESPIRITO SANTO", "DE GOIÁS", "DO MARANHÃO", "DO MATO GROSSO", "DO MATO GROSSO DO SUL", "DE MINAS GERAIS", "DO PARÁ", "DA PARAÍBA", "DO PARANÁ", "DE PERNAMBUCO", "DO PIAUÍ", "DO RIO DE JANEIRO", "DO RIO GRANDE DO NORTE", "DO RIO GRANDE DO SUL", "DE RONDÔNIA", "DE RORAIMA", "DE SANTA CATARINA", "DE SÃO PAULO", "DE SERGIPE", "DO TOCANTINS"
        }));

        cmbClubeAtleta.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "A. BONFIM K.C", "ACADEMIA EQUILIBRIO", "ACADEMIA GARRA DE TIGRE KARATÊ - MG", "ADKM", "ÁGUIA BRANCA", "AKCJ", "AKJ", "AKPC", "AKR", "AKRC", "AMDK", "ASBOKAN", "ASFOK", "ASKAB", "ASKABON", "ASKAC", "ASKAN", "ASKAT", "ASKIPI", "BANZAY", "BEN-DÔ-KAN", "BUDOKAI", "CEIFAR", "CONTATO", "DANGAY", "DKC", "DKM", "DOBY FIGHT", "DOJO MEIKYO", "DRAGÃO GUERREIRO", "DRAGON", "EL SHADDAI DIAS", "ESCOLA DE KARATE SHOTOKAN", "EVOLUÇÃO", "GUERREIROS DO RIO SENA", "HORIZONTE", "JIRIBATUBA", "JM", "KAJ", "KIHON", "KOBUDÔ", "KUNG FU", "LIONS", "Mª RAIMUNDA", "MACAUBENSE", "MEIKYÔ", "MORRENSE", "PANTERA NEGRA", "PINDORAMA", "POWER FITNESS", "PROINEP", "REGISKAN", "SANTA LUZ", "SENSHI", "SHALOM", "SHIHAN", "UNIMUSASHI", "YAMABUCHI", "YUDANSHA", "ZAN-SHIN"}));
    }

    public void setCmbFaixaAtleta() {

        if (jRadioBtnDangayAtleta.isSelected()) {
            cmbFaixaAtleta.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "AMARELA", "VERMELHA", "LARANJA", "VERDE", "VERDE I", "VERDE II", "VERDE III", "ROXA", "MARROM",}));
        } else {
            cmbFaixaAtleta.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "PRETA", "1º DAN", "2º DAN", "3º DAN", "4º DAN", "5º DAN", "6º DAN", "7º DAN", "8º DAN", "9º DAN", "10º DAN"}));
        }
    }

    //INICIALIZAÇÃO DOS COMPONENTES FORMULARIO EXAME
    public void setCmbFaixaExame() {
        if (jRadioBtnDangayExame.isSelected()) {
            cmbFaixaExame.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "AMARELA", "VERMELHA", "LARANJA", "VERDE", "VERDE I", "VERDE II", "VERDE III", "ROXA", "MARROM",}));
        } else {
            cmbFaixaExame.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "PRETA", "1º DAN", "2º DAN", "3º DAN", "4º DAN", "5º DAN", "6º DAN", "7º DAN", "8º DAN", "9º DAN", "10º DAN"}));
        }
    }

    public void setCmbClubeExame() {
        if (jRadioBtnCBKSCExame.isSelected()) {
            cmbClubeExame.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "DO ACRE", "DE ALAGOAS", "DO AMAPÁ", "DO AMAZONAS", "DA BAHIA", "DO CEARÁ", "DO DISTRITO FEDERAL", "DO ESPIRITO SANTO", "DE GOIÁS", "DO MARANHÃO", "DO MATO GROSSO", "DO MATO GROSSO DO SUL", "DE MINAS GERAIS", "DO PARÁ", "DA PARAÍBA", "DO PARANÁ", "DE PERNAMBUCO", "DO PIAUÍ", "DO RIO DE JANEIRO", "DO RIO GRANDE DO NORTE", "DO RIO GRANDE DO SUL", "DE RONDÔNIA", "DE RORAIMA", "DE SANTA CATARINA", "DE SÃO PAULO", "DE SERGIPE", "DO TOCANTINS"
            }));
        } else {
            cmbClubeExame.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "A. BONFIM K.C", "ACADEMIA EQUILIBRIO", "ACADEMIA GARRA DE TIGRE KARATÊ - MG", "ADKM", "ÁGUIA BRANCA", "AKCJ", "AKJ", "AKPC", "AKR", "AKRC", "AMDK", "ASBOKAN", "ASFOK", "ASKAB", "ASKABON", "ASKAC", "ASKAN", "ASKAT", "ASKIPI", "BANZAY", "BEN-DÔ-KAN", "BUDOKAI", "CEIFAR", "CONTATO", "DANGAY", "DKC", "DKM", "DOBY FIGHT", "DOJO MEIKYO", "DRAGÃO GUERREIRO", "DRAGON", "EL SHADDAI DIAS", "ESCOLA DE KARATE SHOTOKAN", "EVOLUÇÃO", "GUERREIROS DO RIO SENA", "HORIZONTE", "JIRIBATUBA", "JM", "KAJ", "KIHON", "KOBUDÔ", "KUNG FU", "LIONS", "Mª RAIMUNDA", "MACAUBENSE", "MEIKYÔ", "MORRENSE", "PANTERA NEGRA", "PINDORAMA", "POWER FITNESS", "PROINEP", "REGISKAN", "SANTA LUZ", "SENSHI", "SHALOM", "SHIHAN", "UNIMUSASHI", "YAMABUCHI", "YUDANSHA", "ZAN-SHIN"}));
        }
    }

    //INICIALIZAÇÃO DOS COMPONENTES FORMULARIO PESQUISA ATLETA
    public void setFrmPesquisaAtleta() {
        cmbClubePesquisaAtleta.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "A. BONFIM K.C", "ACADEMIA EQUILIBRIO", "ACADEMIA GARRA DE TIGRE KARATÊ - MG", "ADKM", "ÁGUIA BRANCA", "AKCJ", "AKJ", "AKPC", "AKR", "AKRC", "AMDK", "ASBOKAN", "ASFOK", "ASKAB", "ASKABON", "ASKAC", "ASKAN", "ASKAT", "ASKIPI", "BANZAY", "BEN-DÔ-KAN", "BUDOKAI", "CEIFAR", "CONTATO", "DANGAY", "DKC", "DKM", "DOBY FIGHT", "DOJO MEIKYO", "DRAGÃO GUERREIRO", "DRAGON", "EL SHADDAI DIAS", "ESCOLA DE KARATE SHOTOKAN", "EVOLUÇÃO", "GUERREIROS DO RIO SENA", "HORIZONTE", "JIRIBATUBA", "JM", "KAJ", "KIHON", "KOBUDÔ", "KUNG FU", "LIONS", "Mª RAIMUNDA", "MACAUBENSE", "MEIKYÔ", "MORRENSE", "PANTERA NEGRA", "PINDORAMA", "POWER FITNESS", "PROINEP", "REGISKAN", "SANTA LUZ", "SENSHI", "SHALOM", "SHIHAN", "UNIMUSASHI", "YAMABUCHI", "YUDANSHA", "ZAN-SHIN"}));
    }
}
