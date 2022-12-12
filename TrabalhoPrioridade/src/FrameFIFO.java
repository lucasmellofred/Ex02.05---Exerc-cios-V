import java.util.ArrayList;

public class FrameFIFO {

    public static void Main(String args[]) throws InterruptedException{

        // Criando objeto.
        TheFrame frames[] = new TheFrame[6];
        
        //Adicionando informação aos atributos e criando os frames. Você pode colocar quantas quiser.
        frames[0] = new TheFrame(1, 10, 20, true, true);
        frames[1] = new TheFrame(2, 1, 12, false, false);
        frames[2] = new TheFrame(3, 2, 21, true, false);
        frames[3] = new TheFrame(4, 10, 20, true, true);
        frames[4] = new TheFrame(5, 1, 12, false, false);
        frames[5] = new TheFrame(6, 2, 21, true, false);
        
        // Mostrando quantidade de objetos.
        System.out.println("\n\nQuantidade de frames: " + frames.length);        

        //Criando o objeto lista de frames.
        ArrayList<TheFrame> arrayMyFrames = new ArrayList<TheFrame>();

        //Adicionando frames na lista e mostrando a lista criada.
        for(int count = 0; count < frames.length; count++){

            arrayMyFrames.add(frames[count]);

        }

        
        System.out.println("========= Iniciando modelo FIFO =========");

        for(int count = 1; count <= 3; count++){

            if(count == 3){

                System.out.println(count+".");
                Thread.sleep(1500);

            }else{

                System.out.print(count+", ");
                Thread.sleep(1000);

            }

        }


        //Limpando console
        for(int count = 0; count < 80; count++){

            System.out.println();

        }   

        //Aqui é mostrado o valor que interessa para a priorização do sistema.
        System.out.print("================ Array de referências ================\n");
            for(int count = 0; count < arrayMyFrames.size(); count++){

                if(count == 0){
                    
                    System.out.print("{ "+ count +" (Index: " + arrayMyFrames.get(count));

                }else{

                    System.out.print(", "+ count +" (Index: " + arrayMyFrames.get(count));

                }

            }
            System.out.println(" }");
        System.out.println("====================================\n");


//Inicio--------------------------------------------------------------------------------------

        int valorAtual; 
        int quantidadeDeFrames = arrayMyFrames.size();
        
        //Voltas na lista de frames até que reste apenas 1 frames.
        for(int x = 0; x < quantidadeDeFrames; x++){
            
            //Volta na lista de frames para fazer todas as comparações.
            for(int i = 0; i < arrayMyFrames.size(); i++){

                if(i == 0){

                    TheFrame theValorAtual = arrayMyFrames.get(i);

                    valorAtual = theValorAtual.getIdFrame();

                    arrayMyFrames.remove(i);


                    System.out.print("\n["+(x + 1)+"°]==============================\n");
                    System.out.println("ID da referência utilizada: " + valorAtual);
                    System.out.println("Quantidade de frames restantes: " + arrayMyFrames.size());  
                    
                    //Aqui é mostrado o valor que interessa para a priorização do sistema.
                    System.out.print("Lista de referências: ");

                        for(int count = 0; count < arrayMyFrames.size(); count++){

                            if(count == 0){
                                
                                System.out.print("{ " + arrayMyFrames.get(count));

                            }else{

                                System.out.print(", " + arrayMyFrames.get(count));

                            }

                        }
                    
                    System.out.print(" }\n");        
                    System.out.println("====================================\n");

                    break;

                }else{


                }

            }
        }

    }
    
}
