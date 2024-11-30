package main.java.com.example;

import java.util.Scanner;
import java.util.List;
import java.net.URL;
import java.util.ArrayList;

public class App {
    public static void
main(String[] args) {

System.out.println("Bem-vindo ao Detector de Vulnerabilidades!");
System.out.println("Digite uma URL ou IP para análise:");

Scanner scanner = new Scanner(System.in);
String input = scanner.nextLine();

String parseResult = Parser.parseInput(input);

System.out.println("Resultado da análise inicial: " + parseResult);

if (parseResult.equals("URL válida")){

System.out.println("Verificando vulnerabilidades de segurança...");
List<String> vulnerabilities = VulnerabilityScanner.scanHttpHeaders(input);

if (vulnerabilities.isEmpty()){

    System.out.println("Nenhuma vulnerabilidade encontrada nos headers de segurança.");
    } else {

System.out.println("Vulnerabilidades encontradas:");

vulnerabilities.forEach(System.out::println);
    }

    } else if (parseResult.equals("IP válido")){

 System.out.println("Verificando ports abertas...");
    List<Integer> openPorts = VulnerabilityScanner.scanOpenPorts(input);

    if (openPorts.isEmpty()); {
    }

System.out.println("Nenhuma port aberta encontrada.");
    } else {
System.out.println("Portas abertas encontradas:");
openPorts.forEach(port -> System.out.println("Port: " + port));
    } else {
    System.out.println("Entrada inválida. Encerrando.");
    }

        scanner.close();
    }
}