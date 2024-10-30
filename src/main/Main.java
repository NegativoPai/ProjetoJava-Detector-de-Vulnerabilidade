package main;

import controllers.UsuarioController;
import controllers.Usuario;
import java.util.Scanner;
import Scanners.VulnerabilityScanner;
import Scanners.ScanResult;

public class Main{
    public static void main(String[] args){
        UsuarioController controller = new UsuarioController();
        controller.criarTabela();
        
        controller.adicionarUsuario("João", "joao@exemplo.com", "senha123");
        controller.adicionarUsuario("Pedro", "pedro@example.com", "senh456");
        
        System.out.println("Usuários cadastrados:");
        for (String usuario : controller.listarUsuarios()){
            System.out.println(usuario);
        }
        Usuario usuarioAtualizado = new Usuario();
        usuarioAtualizado.setId(1);
        usuarioAtualizado.setNome("Novo Nome");
        usuarioAtualizado.setEmail("novoemail@exemplo.com");
        usuarioAtualizado.setSenha("novasenha123");
        
        controller.atualizarUsuario(usuarioAtualizado);

        
        controller.deletarUsuario(2);
        
        System.out.println("\nUsuários após deletação:");
        for (String usuario : controller.listarUsuarios()){
            System.out.println(usuario);
        }
        Scanner scanner = new Scanner(System.in);
        
        VulnerabilityScanner vulnerabilityScanner = new VulnerabilityScanner("localhost", 8080, "sua_api_key");

        System.out.print("Digite a URL ou IP para escanear: ");
        String target = scanner.nextLine();

        ScanResult result = vulnerabilityScanner.scan(target);

        System.out.println("Mensagem: " + result.getMessage());
        System.out.println("Código de Status: " + result.getStatusCode());
        System.out.println("Informação Adicional: " + result.getAdditionalInfo());

        scanner.close();
    }
    {
            VulnerabilityScanner scanner = new VulnerabilityScanner("localhost", 8080, "api_key");
            
            scanner.scan("http://exemplo.com");
            
            System.out.println("Resultado dos Escaneamentos:");
            for (String resultado : scanner.listarResultados()){
                System.out.println(resultado);
        }
            
            Scanner input = new Scanner(System.in);
            
            VulnerabilityScanner scanner2 = new VulnerabilityScanner("localhost", 8080, "api_key");
                   
            System.out.println("Escolha uma opção:");
            System.out.println("1. Escanear um novo alvo");
            System.out.println("2. Listar Resultados");
            System.out.println("3. Listar resultados por alvo especifico");
            int opcao = input.nextInt();
            input.nextLine();
            
            switch(opcao){
                case 1:
                    System.out.print("Digite o alvo para escanear (URL ou IP): ");
                    String alvo = input.nextLine();
                    scanner.scan(alvo);
                    System.out.println("Escaneamento concluído para o alvo: " + alvo);
                    break;
                    
                case 2:
                    System.out.println("Resultado dos Escaneamentos");
                    for (String resultado : scanner.listarResultados()){
                        System.out.println(resultado);
                    }
                    break;
                    
                case 3:
                    System.out.print("Digite o alvo para buscar os resultados: ");
                    String alvoBusca = input.nextLine();
                    System.out.println("Resultados para o alvo " + alvoBusca + ":");
                    for (String resultado : scanner.listarResultadosPorAlvo(alvoBusca)){
                        System.out.println(resultado);
                    }
                    break;
                    
                default:
                    System.out.println("Opção inválida.");
                    break;
        }
            
        input.close();
    }
}

