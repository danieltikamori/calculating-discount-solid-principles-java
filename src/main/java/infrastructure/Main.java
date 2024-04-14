package infrastructure;

import java.util.Scanner;

// Classe base para descontos (aberto para extensões)
abstract class Discount {
  public abstract double calculateDiscount(double originalValue);
}

// Classe derivada para desconto de estudante (10%).
final class StudentDiscount extends Discount {
  @Override
  public double calculateDiscount(double originalValue) {
    return originalValue * 0.9;
  }
}

// Classe derivada para desconto de afiliado (15%).
final class MembershipDiscount extends Discount {
  @Override
  public double calculateDiscount(double originalValue) {
    return originalValue * 0.85;
  }
}

public class Main {
  public static void main(String[] args) {
    try(Scanner scanner = new Scanner(System.in)) {
      String discountType = scanner.next();
      double originalValue = scanner.nextDouble();

      // Aplicação OCP: Criando uma instância com base no tipo de desconto fornecido
      Discount discount = null;
      if ("student".equals(discountType)) {
        discount = new StudentDiscount();
      } else if ("membership".equals(discountType)) {
        discount = new MembershipDiscount();
      } else {
        throw new IllegalArgumentException("Invalid discount type.");
      }

      // Cálculo do desconto
      double discountValue = discount.calculateDiscount(originalValue);
      System.out.printf("%.2f", discountValue);
    }
  }
}