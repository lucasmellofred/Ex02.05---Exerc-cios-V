import java.util.ArrayList;

public class FrameNRU {

    public static void Main(String args[]) throws InterruptedException{

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


        System.out.println("\n========= Iniciando modelo NRU =========");

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



        //Declarando variáveis.
        int indiceMelhorReferencia = 0;
        int indicePrimeiroEncontrado = 0;
        int idMelhorReferencia = 0;
        boolean brMelhorReferencia = true;
        boolean bmMelhorReferencia = true;

        int idValorAtual;
        boolean brValorAtual;
        boolean bmValorAtual;

        int quantRemovido = 0;

        //Aqui mostra o array por completo.
        System.out.println("\n================ARRAY================");
        System.out.println(arrayMyFrames);
        System.out.println("====================================\n");

        //Aqui é mostrado o valor que interessa para a priorização do sistema.
        System.out.print("================ Array de referências ================");
            for(int count = 0; count < arrayMyFrames.size(); count++){

                TheFrame parametroMeuObjeto = arrayMyFrames.get(count);

                if(count == 0){
                    
                    System.out.print("{ "+ count +" (BR: " + parametroMeuObjeto.getBm() + ") - (BM: " + parametroMeuObjeto.getBr() + ")");

                }else{

                    System.out.print(", (BR: " + parametroMeuObjeto.getBm() + ") - (BM: " + parametroMeuObjeto.getBr() + ")");

                }

            }
            System.out.println(" }");
        System.out.println("====================================\n");





        //Iniciando busca da melhor referência.
        int quantidadeDeFrames = arrayMyFrames.size();

        for(int x = 0; x < quantidadeDeFrames; x++){

            boolean isExistePrimeiroEncontrado = false;
            int idPrimeiroEncontrado = 0;

            for(int y = 0; y < arrayMyFrames.size(); y++){

                TheFrame parametroMeuObjeto = arrayMyFrames.get(y);

                idValorAtual = parametroMeuObjeto.getIdFrame();
                brValorAtual = parametroMeuObjeto.getBr();
                bmValorAtual = parametroMeuObjeto.getBm();
                
                
                //Se BR e BM forem falsos.
                if(!brValorAtual && !bmValorAtual){

                    indiceMelhorReferencia = y;
                    idMelhorReferencia = parametroMeuObjeto.getIdFrame();
                    brMelhorReferencia = parametroMeuObjeto.getBr();
                    bmMelhorReferencia = parametroMeuObjeto.getBm();

                    System.out.println("-----------------X: "+x+" Y: "+y+"-----------------");
                        System.out.println("1. A melhor referência é a do frame id: " + idMelhorReferencia);
                        System.out.println("Referência utilizada: (BR: "+brMelhorReferencia+") - (BM: "+bmMelhorReferencia+")");

                        arrayMyFrames.remove(indiceMelhorReferencia);
                        quantRemovido += 1;

                        System.out.println("Índice de remoção: "+quantRemovido);

                        System.out.println("Quantidade de frames restantes: " + arrayMyFrames.size());  

                        System.out.print("Array restante: ");

                        for(int count = 0; count < arrayMyFrames.size(); count++){

                            TheFrame parametroMeuObjetoInterno = arrayMyFrames.get(count);
            
                            if(count == 0){
                                
                                System.out.print("{ (ID: "+ parametroMeuObjetoInterno.getIdFrame() +" | BR: " + parametroMeuObjetoInterno.getBm() + " - BM: " + parametroMeuObjetoInterno.getBr() + ")");
            
                            }else{
            
                                System.out.print(", (ID: "+ parametroMeuObjetoInterno.getIdFrame() +" | BR: " + parametroMeuObjetoInterno.getBm() + " - BM: " + parametroMeuObjetoInterno.getBr() + ")");
            
                            }
            
                        }
                        System.out.print(" }\n");
                    System.out.println("-------------------------------------------\n");

                    break;

                
                //Verifica se uma das condições ou as duas são falsas.
                }else if(!brValorAtual || !bmValorAtual){

                    //Se nenhuma referência 'true/false' foi encontrado, ele atribui como encontrado.
                    if(!isExistePrimeiroEncontrado){

                        isExistePrimeiroEncontrado = true;
                        idPrimeiroEncontrado = parametroMeuObjeto.getIdFrame();
                        indicePrimeiroEncontrado = y;
                        brMelhorReferencia = brValorAtual;
                        bmMelhorReferencia = bmValorAtual;

                        //Verifica se é a última volta.
                        if(y == (arrayMyFrames.size() - 1)){
 
                            idMelhorReferencia = parametroMeuObjeto.getIdFrame();
                            

                            System.out.println("-----------------X: "+x+" Y: "+y+"-----------------");
                                System.out.println("2. A melhor referência é a do frame id: " + idMelhorReferencia);
                                System.out.println("Referência utilizada: (BR: "+brMelhorReferencia+") - (BM: "+bmMelhorReferencia+")");

                                arrayMyFrames.remove(y);
                                quantRemovido += 1;

                                System.out.println("Índice de remoção: "+quantRemovido);

                                System.out.println("Quantidade de frames restantes: " + arrayMyFrames.size());  

                                System.out.print("Array restante: ");

                                for(int count = 0; count < arrayMyFrames.size(); count++){

                                    TheFrame parametroMeuObjetoInterno = arrayMyFrames.get(count);
                    
                                    if(count == 0){
                                        
                                        System.out.print("{ (ID: "+ parametroMeuObjetoInterno.getIdFrame() +" | BR: " + parametroMeuObjetoInterno.getBm() + " - BM: " + parametroMeuObjetoInterno.getBr() + ")");
                    
                                    }else{
                    
                                        System.out.print(", (ID: "+ parametroMeuObjetoInterno.getIdFrame() +" | BR: " + parametroMeuObjetoInterno.getBm() + " - BM: " + parametroMeuObjetoInterno.getBr() + ")");
                    
                                    }
                    
                                }
                                System.out.print(" }\n");
                            System.out.println("-------------------------------------------\n");

                            isExistePrimeiroEncontrado = false;

                            break;

                        }

                    }else{

                        //Verifica se é a última volta. Se for, vai remover o primeira melhor referência que encontrou.
                        if(y == (arrayMyFrames.size() - 1)){

                            System.out.println("-----------------X: "+x+" Y: "+y+"-----------------");
                                System.out.println("3. A melhor referência é a do frame id: " + idPrimeiroEncontrado);
                                System.out.println("Referência utilizada: (BR: "+brMelhorReferencia+") - (BM: "+bmMelhorReferencia+")");

                                arrayMyFrames.remove(indicePrimeiroEncontrado);
                                quantRemovido += 1;

                                System.out.println("Índice de remoção: "+quantRemovido);

                                System.out.println("Quantidade de frames restantes: " + arrayMyFrames.size());  

                                System.out.print("Array restante: ");

                                for(int count = 0; count < arrayMyFrames.size(); count++){

                                    TheFrame parametroMeuObjetoInterno = arrayMyFrames.get(count);
                    
                                    if(count == 0){
                                        
                                        System.out.print("{ (ID: "+ parametroMeuObjetoInterno.getIdFrame() +" | BR: " + parametroMeuObjetoInterno.getBm() + " - BM: " + parametroMeuObjetoInterno.getBr() + ")");
                    
                                    }else{
                    
                                        System.out.print(", (ID: "+ parametroMeuObjetoInterno.getIdFrame() +" | BR: " + parametroMeuObjetoInterno.getBm() + " - BM: " + parametroMeuObjetoInterno.getBr() + ")");
                    
                                    }
                    
                                }
                                System.out.print(" }\n");
                            System.out.println("-------------------------------------------\n");

                            isExistePrimeiroEncontrado = false;

                            break;

                        }

                    }


                //Se BR e BM forem true.
                }else if(brValorAtual && bmValorAtual){
                    
                    
                
                //Verifica se chegou no final do de todas as possibilidades.
                }else if(x == (quantidadeDeFrames -1 ) && arrayMyFrames.size() == 1){

                    indiceMelhorReferencia = y;
                    idMelhorReferencia = parametroMeuObjeto.getIdFrame();
                    brMelhorReferencia = brValorAtual;
                    bmMelhorReferencia = bmValorAtual;

                    System.out.println("-----------------X: "+x+" Y: "+y+"-----------------");
                        System.out.println("4. A referência restante possível a ser utilizada é a do frame id: " + idMelhorReferencia);
                        System.out.println("Referência utilizada: (BR: "+brMelhorReferencia+") - (BM: "+bmMelhorReferencia+")");

                        arrayMyFrames.remove(indiceMelhorReferencia);
                        quantRemovido += 1;

                        System.out.println("Índice de remoção: "+quantRemovido);

                        System.out.println("Quantidade de frames restantes: " + arrayMyFrames.size());  

                        System.out.print("Array restante: ");

                        for(int count = 0; count < arrayMyFrames.size(); count++){

                            TheFrame parametroMeuObjetoInterno = arrayMyFrames.get(count);
            
                            if(count == 0){
                                
                                System.out.print("{ (ID: "+ parametroMeuObjetoInterno.getIdFrame() +" | BR: " + parametroMeuObjetoInterno.getBm() + " - BM: " + parametroMeuObjetoInterno.getBr() + ")");
            
                            }else{
            
                                System.out.print(", (ID: "+ parametroMeuObjetoInterno.getIdFrame() +" | BR: " + parametroMeuObjetoInterno.getBm() + " - BM: " + parametroMeuObjetoInterno.getBr() + ")");
            
                            }
            
                        }
                        System.out.print(" }\n");
                    System.out.println("-------------------------------------------\n");   
                    
                    break;

                }else{

                    System.out.println("-----------------X: "+x+" Y: "+y+"-----------------");
                        System.out.println("5. Não foi encontrada uma melhor referência no ID: "+idValorAtual);
                        System.out.println("{ (BR: " + parametroMeuObjeto.getBm() + " - BM: " + parametroMeuObjeto.getBr() + ")");
                        System.out.println("Quantidade de frames restantes: " + arrayMyFrames.size());  

                        System.out.print("Array restante: ");

                        for(int count = 0; count < arrayMyFrames.size(); count++){

                            TheFrame parametroMeuObjetoInterno = arrayMyFrames.get(count);
            
                            if(count == 0){
                                
                                System.out.print("{ (ID: "+ parametroMeuObjetoInterno.getIdFrame() +" | BR: " + parametroMeuObjetoInterno.getBm() + " - BM: " + parametroMeuObjetoInterno.getBr() + ")");
            
                            }else{
            
                                System.out.print(", (ID: "+ parametroMeuObjetoInterno.getIdFrame() +" | BR: " + parametroMeuObjetoInterno.getBm() + " - BM: " + parametroMeuObjetoInterno.getBr() + ")");
            
                            }
            
                        }
                        System.out.print(" }\n");
                    System.out.println("-------------------------------------------\n");


                }
            }
        }
    }
}
