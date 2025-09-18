package com.senai.rastreadorpet.models;

import com.senai.rastreadorpet.models.enums.ClienteRole;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private int id;

    @Column(name = "cliente_nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(name = "cliente_email", unique = true, nullable = false)
    private String email;

    @Column(name = "cliente_senha", nullable = false)
    private String senha;

    @Column(name = "cliente_telefone")
    private String telefone;

    @Column(name = "cliente_cep")
    private String cep;

    @Column(name = "cliente_rua")
    private String rua;

    @Column(name = "cliente_numero")
    private String numero;

    @Column(name = "cliente_complemento")
    private String complemento;

    @Column(name = "cliente_bairro")
    private String bairro;

    @Column(name = "cliente_cidade")
    private String cidade;

    @Column(name = "cliente_estado")
    private String estado;

    @Column(name = "cliente_data_cadastro")
    private LocalDateTime dataCadastro;

    @Enumerated(EnumType.STRING)
    @Column(name = "cliente_role", nullable = false)
    private ClienteRole role;

    @Column(name = "cliente_data_consentimento_privacidade")
    private LocalDateTime dataConsentimentoPrivacidade;

    @Column(name = "cliente_preferencias", columnDefinition = "json")
    private String preferencias;

    // Getters e Setters

    public int getId() {
        return id;
    }
    
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public ClienteRole getRole() {
        return role;
    }

    public void setRole(ClienteRole role) {
        this.role = role;
    }

    public LocalDateTime getDataConsentimentoPrivacidade() {
        return dataConsentimentoPrivacidade;
    }

    public void setDataConsentimentoPrivacidade(LocalDateTime dataConsentimentoPrivacidade) {
        this.dataConsentimentoPrivacidade = dataConsentimentoPrivacidade;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }
}
