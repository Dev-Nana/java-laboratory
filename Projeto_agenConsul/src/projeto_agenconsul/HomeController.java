/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package projeto_agenconsul;

import Dao.ConsultaDao;
import Dao.PacienteDao;
import Dao.MedicoDao;
import Model.Consulta;
import Model.Medico;
import Model.Paciente;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author aaron
 */
public class HomeController implements Initializable {

    static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        HomeController.stage = stage;
    }
    //botao de cadastro paciente
    @FXML
    private Button button;  


    @FXML
    private TextField tf_MDid;
    @FXML
    private TextField tf_cpfMD;
    @FXML
    private TextField tf_espcMD;
    @FXML
    private TextField tf_nmMD;
        //tabela do paciente 
    @FXML
    private TableView<Paciente> tb_paciente;
    @FXML
    private TableColumn<Paciente, String> cl_pcid;
    @FXML
    private TableColumn<Paciente, String> cl_cpf;
    @FXML
    private TableColumn<Paciente, String> cl_nome;
    @FXML
    private TableColumn<Paciente, String> cl_tell;
    //inputs de preenchimento do paciente 
    @FXML
    private TextField tf_cpfP;
    @FXML
    private TextField tf_nomeP;
    @FXML
    private TextField tf_tellP;
    //inputs de preenchimento do medico
    @FXML
    private TextField tf_cpfmed;
    @FXML
    private TextField tf_espmed;
    @FXML
    private TextField tf_nomemed;
    //botao de cadastrar medico
    @FXML
    private Button btn_med;
    //tabela do medico 
    @FXML
    private TableColumn<Medico, String> cl_cpfme;
    @FXML
    private TableColumn<Medico, String> cl_espm;
    @FXML
    private TableColumn<Medico, String> cl_nomeme;
    @FXML
    private TableColumn<Medico, String> cl_idmd;
    @FXML
    private TableView<Medico> tb_medico;
    //botao de agendamento
    @FXML
    private Button bt_cad;
    //tabela medico consulta
    @FXML
    private TableColumn<Medico, String> cl_idmedico;
    @FXML
    private TableColumn<Medico, String> cl_nomemedico;
    @FXML
    private TableView<Medico> tb_cmedico;
    //tabela paciente consulta
    @FXML
    private TableColumn<Paciente, String> cl_idpaciente;
    @FXML
    private TableColumn<Paciente, String> cl_nomepaciente;
    @FXML
    private TableView<Paciente> tb_cpaciente;
    //inpunts preenchimento da consulta
    @FXML
    private TextField tf_data;
    @FXML
    private TextField tf_hora;
    @FXML
    private TextField tf_idm;
    @FXML
    private TextField tf_idp;
    //tabela consultas
    @FXML
    private TableColumn<Consulta, String> cl_dta;
    @FXML
    private TableColumn<Consulta, String> cl_horac;
    @FXML
    private TableColumn<Consulta, String> cl_idconsu;
    @FXML
    private TableColumn<Consulta, String> cl_idmedc;
    @FXML
    private TableColumn<Consulta, String> cl_idpacic;
    @FXML
    private TableView<Consulta> tb_consultas;
    //buscar na tabela paciente
    @FXML
    private TextField tf_cpfbc;
    @FXML
    private TextField tf_pcid;
    @FXML
    private TextField tf_nmp;
    @FXML
    private TextField tf_cpfpc;
    @FXML
    private TextField tf_telp;
    //botao de excluir e att
    @FXML
    private Button btn_at;
    @FXML
    private Button btn_ex;

    //inicialiazando as colunas 
    public void inicializar_colm() {    //coluna do medico
        //colunas do medico
        cl_idmd.setCellValueFactory(new PropertyValueFactory<>("Idmedic"));     //acho que especifica como preencher as células da tabela
        cl_nomeme.setCellValueFactory(new PropertyValueFactory<>("Nome_m"));
        cl_cpfme.setCellValueFactory(new PropertyValueFactory<>("Cpf_m"));
        cl_espm.setCellValueFactory(new PropertyValueFactory<>("Espe_m"));
    }

    public void inicializar_colp() {    //coluna do paciente
        //colunas do paciente 
        cl_pcid.setCellValueFactory(new PropertyValueFactory<>("Id_paci"));
        cl_nome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        cl_cpf.setCellValueFactory(new PropertyValueFactory<>("Cpf"));
        cl_tell.setCellValueFactory(new PropertyValueFactory<>("Tell"));
    }

    public void inicializar_colc() {    //coluna do consulta
        //colunas da consulta
        cl_idmedico.setCellValueFactory(new PropertyValueFactory<>("Idmedic"));
        cl_idpaciente.setCellValueFactory(new PropertyValueFactory<>("id_paci"));
        cl_nomemedico.setCellValueFactory(new PropertyValueFactory<>("Nome_m"));
        cl_nomepaciente.setCellValueFactory(new PropertyValueFactory<>("Nome"));
    }

    public void inicializar_cola() {
        cl_dta.setCellValueFactory(new PropertyValueFactory<>("Data"));
        cl_horac.setCellValueFactory(new PropertyValueFactory<>("Hora"));
        cl_idconsu.setCellValueFactory(new PropertyValueFactory<>("id_consulta"));
        cl_idmedc.setCellValueFactory(new PropertyValueFactory<>("id_medico"));
        cl_idpacic.setCellValueFactory(new PropertyValueFactory<>("id_paciente"));
    }
    //chamando e inicializando as listas
    List<Paciente> lista_paciente;
    List<Medico> lista_medico;
    List<Medico> list_medicocons;
    List<Paciente> list_pacientecons;
    List<Consulta> listar_consultas;

    //preenchendo as tabelas 
    public void preencherTabp() throws SQLException {   
        //preenchendo Tabela Paciente
        PacienteDao dao = new PacienteDao();
        lista_paciente = dao.lista_paciente();
        tb_paciente.setItems(FXCollections.observableArrayList(lista_paciente));

    }

    public void preencherTabm() throws SQLException {
        //preenchendo Tabela Medico
        MedicoDao mdao = new MedicoDao();
        lista_medico = mdao.lista_medico();
        tb_medico.setItems(FXCollections.observableArrayList(lista_medico));
    }

    public void preencherTabc() throws SQLException {
        //preenchendo tabelas da consultas
        ConsultaDao Cdao = new ConsultaDao();
        listar_consultas = Cdao.listar_consultas();
        tb_consultas.setItems(FXCollections.observableArrayList(listar_consultas));
    }

    public void preencherTabac() throws SQLException {
        ConsultaDao dao = new ConsultaDao();
        list_medicocons = dao.list_medicocons();
        tb_cmedico.setItems(FXCollections.observableArrayList(list_medicocons));
    }

    public void preencherTabagc() throws SQLException {
        ConsultaDao dao = new ConsultaDao();
        list_pacientecons = dao.list_pacientecons();
        tb_cpaciente.setItems(FXCollections.observableArrayList(list_pacientecons));
    }

    //inserindo na tabela paciente1 
    @FXML
    void inserirButton(ActionEvent event) throws Exception {
        PacienteDao pd = new PacienteDao();
        Paciente p = new Paciente();
        p.setNome(tf_nomeP.getText());
        p.setCpf(tf_cpfP.getText());
        p.setTell(tf_tellP.getText());
        if (pd.inserir(p)) {
            tb_paciente.setItems(FXCollections.observableArrayList(lista_paciente));
            preencherTabp();
        }

        preencherTabp();
    }

    //inserindo na tabela Medico
    @FXML
    void inserir_medico(ActionEvent event) throws Exception {
        MedicoDao md = new MedicoDao();
        Medico m = new Medico();

        m.setNome_m(tf_nomemed.getText());
        m.setCpf_m(tf_cpfmed.getText());
        m.setEspe_m(tf_espmed.getText());

        if (md.inserirm(m)) {
            JOptionPane.showMessageDialog(null, "Dados enviados com sucesso!");
            tb_medico.setItems(FXCollections.observableArrayList(lista_medico));

            inicializar_colm();
            preencherTabm();
        }

        preencherTabm();
    }

    //Inserindo na tabela consultas
    @FXML
    void agendar_consulta(ActionEvent event) throws SQLException {
        ConsultaDao ConDao = new ConsultaDao();
        Consulta c = new Consulta();
        c.setData(tf_data.getText());
        c.setHora(tf_hora.getText());
        c.setId_medico(Integer.parseInt(tf_idm.getText()));
        c.setId_paciente(Integer.parseInt(tf_idp.getText()));
        if (ConDao.agendar(c)) {
            JOptionPane.showMessageDialog(null, "Dados enviados com sucesso!");
            inicializar_colp();
            preencherTabc();
        }
        preencherTabc();
    }

    @FXML
    void busca_paciente(ActionEvent event) throws SQLException {
        PacienteDao Dao = new PacienteDao();
        Paciente pc = new Paciente();
        int id_pac = Integer.parseInt(tf_pcid.getText());
        pc = Dao.consultar(id_pac);

        tf_nmp.setText(pc.getNome());
        tf_cpfpc.setText(pc.getCpf());
        tf_telp.setText(pc.getTell());

    }

    @FXML
    void atualiza_paciente(ActionEvent event) throws SQLException {
        PacienteDao pdao = new PacienteDao();
        Paciente paci = new Paciente();
        paci.setId_paci(Integer.parseInt(tf_pcid.getText()));
        paci.setNome(tf_nmp.getText());
        paci.setCpf(tf_cpfpc.getText());
        paci.setTell(tf_telp.getText());
        if (pdao.atualizar(paci)) {
            JOptionPane.showMessageDialog(null, "Dados com sucesso!");

            preencherTabp();
        }

    }

    @FXML
    void excluir_paciente(ActionEvent event) throws SQLException {
        PacienteDao Dao = new PacienteDao();
        Paciente pc = new Paciente();
        pc.setId_paci(Integer.parseInt(tf_pcid.getText()));
        Dao.exlcuir(pc.getId_paci());
        preencherTabp();
    }

    @FXML
    void busca_Medico(ActionEvent event) throws SQLException {
        MedicoDao Dao = new MedicoDao();
        Medico mc = new Medico();
        int Idmedic = Integer.parseInt(tf_MDid.getText());
        mc = Dao.consultar(Idmedic);

        tf_nmMD.setText(mc.getNome_m());
        tf_cpfMD.setText(mc.getCpf_m());
        tf_espcMD.setText(mc.getEspe_m());
    }

    @FXML
    void atualizar_medico(ActionEvent event) throws SQLException {
        MedicoDao mdao = new MedicoDao();
        Medico med = new Medico();
        med.setIdmedic(Integer.parseInt(tf_MDid.getText()));
        med.setNome_m(tf_nmMD.getText());
        med.setCpf_m(tf_cpfMD.getText());
        med.setEspe_m(tf_espcMD.getText());
        if (mdao.atualizar(med)) {
            JOptionPane.showMessageDialog(null, "Dados com sucesso!");
            preencherTabm();
        }
    }

    @FXML
    void excluir_medico(ActionEvent event) throws SQLException {
        MedicoDao Dao = new MedicoDao();
        Medico md = new Medico();
        md.setIdmedic(Integer.parseInt(tf_MDid.getText()));
        Dao.excluir(md.getIdmedic());
        preencherTabm();
    }

    //inicalizando os metodos 
    public void initialize(URL url, ResourceBundle rb) {
        inicializar_colp();
        inicializar_colm();
        inicializar_colc();
        inicializar_cola();

        try {
            preencherTabp();
            preencherTabm();
            preencherTabc();
            preencherTabac();
            preencherTabagc();
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //chamando e declarando as telas 
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene = new Scene(root);
        setStage(stage);
        stage.setScene(scene);
        stage.show();
    }
}
