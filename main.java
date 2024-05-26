/*1) Crie um programa que apresente um menu de opções para o usuário escolher, sendo possível realizar
saques, depósitos, verificar o saldo atual e calcular uma simulação de juros sobre o saldo baseado em
um número de meses fixos que o usuário digitar, também deverá conter uma verificação se o usuário
possui saldo suficiente na hora de sacar. (Cada opção solicitada deverá estar em um método diferente)*/


import java.util.Scanner;

public class main {
    public static void main(String[] args) {

 
        Scanner input = new Scanner(System.in);

        int sair = 0;

        double saldo_atual_dep = 0;
        double entrada_total = 0;
        double saque_total = 0;

        double saldo_atual = 3000.00;
        double saldo_deposito_atual = 0;
        double saldo_saque_atual = 0;

        int meses;


        while (sair == 0){

            System.out.println(" ");
            System.out.println("=======================================");
            System.out.println("=================BANCO=================");
            System.out.println("=======================================");
            System.out.println(" ");
            System.out.println(" Opções ");
            System.out.println(" ");
            System.out.println(" 1 - Saldo Atual ");
            System.out.println(" 2 - Deposito ");
            System.out.println(" 3 - Saque ");
            System.out.println(" 4 - Calculo de juros");
            System.out.println(" 5 - Sair ");
            System.out.println(" ");
            System.out.printf(" -> ");
            int esco = input.nextInt();

            if (saldo_deposito_atual != 0){
                saldo_atual = saldo_deposito_atual;
            }
            else if (saldo_saque_atual != 0) {

                saldo_atual = saldo_saque_atual;
            }

            switch (esco){

                case 1:

                    saldo_atual = valor_saldo (saldo_atual);

                    break;

                case 2:

                    System.out.printf(" Valor a ser depositado: ");
                    entrada_total = input.nextDouble();

                    saldo_deposito_atual = valor_deposito(entrada_total,saldo_atual);



                    System.out.printf("Saldo final: %.2f %n",saldo_deposito_atual);

                    break;

                case 3:

                    System.out.printf( "Valor de saque:");
                    saque_total = input.nextDouble();

                    if (saque_total > saldo_atual) {
                        System.out.println("Saldo insuficiente");
                        System.out.println("Favor digitar um valor valido");
                        saque_total = input.nextDouble();
                    }

                    saldo_saque_atual = valor_saque(saque_total,saldo_atual);

                    System.out.printf("Saldo final: %.2f %n",saldo_saque_atual);

                    break;

                case 4:

                    System.out.println("=======================================");
                    System.out.println("Calculo de juros sobre o saldo atual");
                    System.out.println("=======================================");
                    System.out.println(" ");
                    System.out.println("Quantos meses deseja calcular o juros fixos");
                    meses = input.nextInt();

                    double saldo_juros_mes;


                    saldo_juros_mes= valor_juros (meses,saldo_atual);

                    double juros_totais = saldo_juros_mes - saldo_atual;

                    System.out.printf("Após %d meses o saldo da conta será R$ %.2f %n ", meses,saldo_juros_mes);
                    System.out.printf("Saldo de juros de %f %n", juros_totais);

                    break;

                case 5:

                    sair = 1;

            }

        }
    }

    public static double valor_saldo ( double totalizador){

        System.out.printf(" Saldo da sua conta é %.2f %n",totalizador);

        return totalizador;

    }
    public static double valor_deposito (double entrada, double saldo_atual_dep){

        saldo_atual_dep = saldo_atual_dep + entrada;

        return saldo_atual_dep;

    }

    public static double valor_saque (double saida, double saldo_atual_saq){

        saldo_atual_saq = saldo_atual_saq - saida;

        return saldo_atual_saq;

    }

    public static double valor_juros (int mesito, double saldo_atual_juros ){

        double resultado_atual_juros = saldo_atual_juros;

        for (int i = 1; i <= mesito ; i++ ){

            resultado_atual_juros = resultado_atual_juros * 1.005;

        }
        return resultado_atual_juros;

    }

}