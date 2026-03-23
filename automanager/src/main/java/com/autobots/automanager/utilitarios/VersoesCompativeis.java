//Compatibilidade de versões entre Java, Spring Boot e Lombok

package com.autobots.automanager.utilitarios;

public class VersoesCompativeis {

    record Row(int java, String springBoot, String lombok) {}

    public static void main(String[] args) {
        Row[] table = {
            new Row(17, "2.6.x / 3.0.x", "1.18.24+"),
            new Row(21, "3.2.x+",         "1.18.30+"),
            new Row(25, "3.5.x+",         "1.18.38+")
        };

        System.out.printf("%-8s %-18s %s%n", "Java", "Spring Boot", "Lombok");
        System.out.println("-".repeat(38));
        for (Row r : table) {
            System.out.printf("%-8d %-18s %s%n", r.java(), r.springBoot(), r.lombok());
        }
    }
}

