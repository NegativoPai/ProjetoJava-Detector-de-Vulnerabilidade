package main.java.com.example;

import java.util.List;
import java.util.Scanner;

    public class App {
        public static void main(String[]args) {
            System.out.println("=== Detector de Vulnerabilidades ===");
            System.out.println("Digite uma URL ou IP para análise: ");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input.startsWith("http://") || input.startsWith("https://")){

                System.out.println("Verificando vulnerabilidades na URL com OWASP ZAP.....");
                List<String> vulnerabilities = VulnerabilityScanner.scanwithOWASPZAP(input);

                if (vulnerabilities.isEmpty()){
                    System.out.println("Nenhum vulnerabilidade encontrada aqui:");

                    vulnerabilities.forEach(System.out::println);
                }
            } else {

                System.out.println("Entrada inválida. Forneça uma URL ou IP válida.");
        }

        scanner.close();
    }
}