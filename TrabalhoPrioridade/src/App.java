import java.util.ArrayList; 
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {


        Scanner leitorTeclado = new Scanner(System.in);

        System.out.println("=========== Faça sua escolha ===========");
        System.out.println("1. FIFO \n2. LFU \n3. LRU \n4. NRU");
        System.out.print("\nDigite o número correspondente a sua escolha: ");

        int escolhaUsuario = leitorTeclado.nextInt();

        
        switch(escolhaUsuario) {

            case 1:

                FrameFIFO frameFIFO = new FrameFIFO();

                FrameFIFO.Main(args);                

                break;

            case 2:

                FrameLFU frameLFU = new FrameLFU();

                FrameLFU.Main(args);

                break;

            case 3:
 
                FrameLRU frameLRU = new FrameLRU();

                FrameLRU.Main(args);
                
                break;

            case 4:

                FrameNRU frameNRU = new FrameNRU();

                FrameNRU.Main(args);

                break;

            default:


                System.out.println("Usuário escolheu nenhuma das escolhas válidas");

          }

    }



}
