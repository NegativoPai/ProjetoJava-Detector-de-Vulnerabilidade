package controllers;

public class Usuario{
    private int id;
    private String nome;
    private String email;
    private String senha;
    
    //Nosso construtor padrão
    public Usuario(){
    }
       
    //Contrutorzera massa
    public Usuario(int Id, String Nome, String Email, String Senha){
        this.id = Id;
        this.nome = Nome;
        this.email = Email;
        this.senha = Senha;
}
//GETTERSZERA E SETERSZERAS HEHEHEHE
public int getId() {
    return id;
}

public void setId(int Id){
    this.id = Id;
}

public String getNome(){
    return nome;
}

public void setNome(String Nome){
    this.nome = Nome;
}

public String getEmail(){
    return email;
}

public void setEmail(String Email){
    this.email = Email;
}

public String getSenha(){
    return senha;
}

public void setSenha(String Senha){
    this.senha = Senha;
}
}