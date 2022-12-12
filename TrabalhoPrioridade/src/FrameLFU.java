import java.util.ArrayList;

public class FrameLFU {

    public static void Main(String args[]) throws InterruptedException{
        

        // Criando objeto.
        TheFrame frames[] = new TheFrame[3];
        
        //Adicionando informação aos atributos e criando os frames. Você pode colocar quantas quiser.
        frames[0] = new TheFrame(1, 10, 20, true, true);
        frames[1] = new TheFrame(2, 1, 12, false, false);
        frames[2] = new TheFrame(3, 2, 21, true, false);

        
        // Mostrando quantidade de objetos.
        System.out.println("\n\nQuantidade de frames: " + frames.length + "\n");        

        //Criando o objeto lista de frames.
        ArrayList<TheFrame> arrayMyFrames = new ArrayList<TheFrame>();

        //Adicionando frames na lista e mostrando a lista criada.
        for(int count = 0; count < frames.length; count++){

            arrayMyFrames.add(frames[count]);

        }

        
        System.out.println("\n========= Iniciando modelo LFU =========\n");

        for(int count = 1; count <= 3; count++){

            if(count == 3){

                System.out.println(count+".");
                Thread.sleep(2200);

            }else{

                System.out.print(count+", ");
                Thread.sleep(1000);

            }

        }


        //Limpando console
        for(int count = 0; count < 80; count++){

            System.out.println();

        }   


        
        int referenciaMenor; // Serve para armazenar o menor valor de uma lista, ele é iniciado com um valor alto para que o primeiro valor encontrado já seja atribuído a esta variável.
        int valorAnterior;
        int idValorAnterior;
        int indiceValorMenor;
        int valorAtual; 

        int valorMenor; // A fim de facilitar a compreensão do código no momento das comparações de valores foi criado essa variável para armazenar o valor menor.
        int valorMaior; // A fim de facilitar a compreensão do código no momento das comparações de valores foi criado essa variável para armazenar o valor maior.

        int auxiliarIdAnterior; //Serve para auxiliar a busca do Id anterior, como está sendo feito de forma dinâmica onde o contador irá trazer o índice do list, essa variável serve para pegar o índice anterior.


        
        //Aqui mostra o array por completo.
        System.out.println("\n================ARRAY================");
        System.out.println(arrayMyFrames);
        System.out.println("====================================\n");

        //Aqui é mostrado o valor que interessa para a priorização do sistema.
        System.out.print("\n================ Array quantidade de referências ================\n");
            for(int count = 0; count < arrayMyFrames.size(); count++){

                TheFrame quantReferenciaParaArray = arrayMyFrames.get(count);

                if(count == 0){
                    
                    System.out.print("{ " + quantReferenciaParaArray.getQuantReferencias());

                }else{

                    System.out.print(", " + quantReferenciaParaArray.getQuantReferencias());

                }

            }
            System.out.print(" }\n");
        System.out.println("====================================\n");


        int quantidadeDeFrames = arrayMyFrames.size();


        //Voltas na lista de frames até que reste apenas 1 frames.
        for(int x = 0; x < quantidadeDeFrames; x++){

            referenciaMenor = 1000000;
            idValorAnterior = 0;
            valorAnterior = 0;
            indiceValorMenor = 0;

            //Volta na lista de frames para fazer todas as comparações.
            for(int i = 0; i < arrayMyFrames.size(); i++){

                TheFrame theValorAtual = arrayMyFrames.get(i);

                valorAtual = theValorAtual.getQuantReferencias();



                //Verifica se valor atual é menor que o anterior para armazenar o menor valor para a remoção quando chegar ao fim da lista.
                if(valorAtual < valorAnterior){

                    valorMenor = valorAtual;
                    valorMaior = valorAnterior;

                    //Verifica se é a primeira volta para que o ID do valor anterior seja zerado, se não atribuirá o ID do valor anterior da lista.
                    if(i == 0){

                        idValorAnterior = 0;

                    }else{

                        auxiliarIdAnterior = i - 1;
                        idValorAnterior = (frames[auxiliarIdAnterior].getIdFrame());

                    }

                    //Verifica se a referencia menor encontrada é menor que o valor menor comparado anteriormente.
                    if(referenciaMenor < valorMenor){

                        

                    }else{

                        indiceValorMenor = i;
                        referenciaMenor = valorAtual; //Atribui a menor quantidade referencia para fazer a configuração.

                    }

            
                    //Verifica se é a última volta no list para remover e mostrar o valor que será removido.
                    if(i == (arrayMyFrames.size() - 1)){

                        arrayMyFrames.remove(indiceValorMenor);

                        System.out.print("\n["+(x + 1)+"°]==============================\n");
                        System.out.println("Menor quantidade de referência utilizada:" + referenciaMenor);
                        System.out.println("Quantidade de frames restantes: " + arrayMyFrames.size());  
                        
                        System.out.print("Lista de referências: ");

                            for(int count = 0; count < arrayMyFrames.size(); count++){

                                TheFrame quantReferenciaParaArray = arrayMyFrames.get(count);

                                if(count == 0){
                                    
                                    System.out.print("{ " + quantReferenciaParaArray.getQuantReferencias());

                                }else{

                                    System.out.print(", " + quantReferenciaParaArray.getQuantReferencias());

                                }

                            }
                            System.out.print(" }\n");
                        
                           
                        System.out.println("====================================\n");


                    }


                }else{

                    valorMenor = valorAnterior; 
                    valorMaior = valorAtual;

                    
                    if(i == 0){

                        idValorAnterior = 0;

                    }else{

                        auxiliarIdAnterior = i - 1;
                        idValorAnterior = (frames[auxiliarIdAnterior].getIdFrame());

                    }

                    


                    if(referenciaMenor < valorMaior){

                        

                    }else{

                        indiceValorMenor = i;
                        referenciaMenor = valorAtual; //Atribui a menor quantidade referencia para fazer a configuração.

                    }

                    if(i == (arrayMyFrames.size() - 1)){

                        arrayMyFrames.remove(indiceValorMenor);

                        System.out.print("\n["+(x + 1)+"°]================ Menor quantidade de referência utilizada: " + referenciaMenor + " ================\n");
                        System.out.println("Quantidade de frames restantes: " + arrayMyFrames.size());  
                        
                        System.out.print("Lista de referências: ");

                            for(int count = 0; count < arrayMyFrames.size(); count++){

                                TheFrame quantReferenciaParaArray = arrayMyFrames.get(count);

                                if(count == 0){
                                    
                                    System.out.print("{ " + quantReferenciaParaArray.getQuantReferencias());

                                }else{

                                    System.out.print(", " + quantReferenciaParaArray.getQuantReferencias());

                                }

                            }
                            System.out.print(" }\n");
                        
                           
                        System.out.println("====================================\n");               

                    }

                }

                //Atualiza o valor anterior.
                valorAnterior = valorAtual;

            }
    
            
        }


        System.out.println("\n========= Finalizando modelo LFU (50s) =========\n");

        for(int count = 1; count <= 50; count++){

            if(count == 50){

                System.out.println(count+".");
                Thread.sleep(2200);

            }else{

                System.out.print(count+", ");
                Thread.sleep(1000);

            }

            

        }

        for(int count = 0; count < 80; count++){

            System.out.println();

        }   


    }
    
}
