import java.util.Scanner;

public class TrabalhoSistema {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // vetor tem q ser inicializado com um valor fixo
        String turmas [] = new String[2];
        String [] professores = new String[2];
        String alunos[][] = new String[2][2];

        // depois vão ser expandidos
        int contadorItens = 0;
        int maxItens = 2;

        while (true) { 
                
            System.out.println("""
                Informe a funcionalidade desejada:
                1. Adicionar nova turma
                2. Adicionar alunos a uma turma
                3. Buscar turmas por nome do professor
                4. Listar alunos de uma turma
                5. Transferir aluno entre turmas
                6. Fechar""");
            int opcao = in.nextInt();

            if (opcao == 1) {
                System.out.println("Digite o nome da turma");
                String nomeTurma = in.next();
            
                System.out.println("Digite o nome do professor responsável:");
                String nomeProfessor = in.next();
            
                if (contadorItens >= turmas.length) {  // verifica se é necessário aumentar o tamanho do array
                    String[] copiaTurmas = new String[turmas.length];
                    String[] copiaProfessores = new String[professores.length];
                    String[][] copiaAlunos = new String[alunos.length][];

                    // p uma correta expansão, foram criados arrays copia, assim mantendo os dados para a mesma
            
                    for (int i = 0; i < turmas.length; i++) {
                        copiaTurmas[i] = turmas[i];
                    }
            
                    for (int i = 0; i < professores.length; i++) {
                        copiaProfessores[i] = professores[i];
                    }
            
                    for (int i = 0; i < alunos.length; i++) {
                        copiaAlunos[i] = alunos[i];
                    }

                    // cada for acima -- copia dos dados para os novos arrays
            
                    turmas = new String[turmas.length + 1];
                    professores = new String[professores.length + 1];
                    alunos = new String[alunos.length + 1][2]; 
                    // expansão dos arrays, turmas/professores ganham um elemento a mais, alunos ganham uma linha; 
            
                    for (int i = 0; i < copiaTurmas.length; i++) {
                        turmas[i] = copiaTurmas[i];
                    }
            
                    for (int i = 0; i < copiaProfessores.length; i++) {
                        professores[i] = copiaProfessores[i];
                    }
            
                    for (int i = 0; i < copiaAlunos.length; i++) {
                        alunos[i] = copiaAlunos[i];
                    }

                    // dados dos arrays copia = copiados de volta para os arrays originais (agora expandidos);
            
                    turmas[contadorItens] = nomeTurma;
                    professores[contadorItens] = nomeProfessor;
                    alunos[contadorItens] = new String[2];  // criação de novo espaço para alunos
            
                    maxItens += 1;
                } else if (turmas[contadorItens] == null) {
                    // caso a posição contadorItens esteja vazia

                    turmas[contadorItens] = nomeTurma;
                    professores[contadorItens] = nomeProfessor;
                    alunos[contadorItens] = new String[2];
                    // nova linha criada na posição [contadorItens] do array alunos
                }
            
                contadorItens += 1;

                // mensagens e vetores printados, a fim de exibir os resultados totais das turmas, professor e alunos 
                System.out.println("Turma e professor adicionados com sucesso!");
                System.out.println();
            
                System.out.println("Turmas:");
                for (int i = 0; i < turmas.length; i++) {
                    if (turmas[i] != null) {
                        System.out.print(turmas[i] + " ");
                    }
                }
                System.out.println();
                
                System.out.println("Professores: ");
                for (int i = 0; i < professores.length; i++) {
                    if (professores[i] != null) {
                    System.out.print(professores[i] + " ");
                    }
                }
                System.out.println();

                for (int i = 0; i < alunos.length; i++) {
                    
                }

                System.out.println("Alunos:");
                
                for (int i = 0; i < alunos.length; i++) {
                    for (int j = 0; j < alunos[i].length; j++) {
                        if (alunos[i][j] != null) {
                            System.out.print(alunos[i][j] + " ");
                        }
                    }
                    System.out.println();
                }
                
            }
            
            if (opcao == 2) {

                // achar o indice do vetor da turma escolhida
                // ao achar a turma, armazenar o indice numa variavel
                // em alunos, acessar alunos[indiceDaTurma] e inserir o aluno lá
                // caso o vetor esteja cheio, expandi-lo
                // se não, apenas acrescentar.
                
            
                System.out.println("Insira a turma desejada para adicionar o aluno: ");
                String nomeTurma = in.next();
        
                System.out.println("Insira o nome do aluno a ser adicionado: ");
                String nomeAluno = in.next();
            
                int indiceDaTurma = -1;
            
                // busca do indice da turma escolhida
                for (int i = 0; i < turmas.length; i++) {
                    if (turmas[i] != null && nomeTurma.equals(turmas[i])) {
                        indiceDaTurma = i;
                        break;
                    }
                }

                // caso não seja encontrada
                if (indiceDaTurma == -1) { 
                    System.out.println("Turma não encontrada!");
                    continue;
                }
        
                boolean cheio = true;
                // se for falso, não será necessário aumentar
            
                // verifica espaço no array de alunos e adiciona, caso o espaço na posição esteja vazio, nomeAluno é atribuido no vetor;
                for (int i = 0; i < alunos[indiceDaTurma].length; i++) {
                    if (alunos[indiceDaTurma][i] == null) {
                        alunos[indiceDaTurma][i] = nomeAluno;
                        cheio = false;
                        break;
                    }
                }
                
                // expansão do vetor, caso esteja cheio
                if (cheio) { 
                    String[] newArray = new String[alunos[indiceDaTurma].length + 1];
        
                    for (int i = 0; i < alunos[indiceDaTurma].length; i++) {
                        newArray[i] = alunos[indiceDaTurma][i];
                    }
    
                    newArray[alunos[indiceDaTurma].length] = nomeAluno;
                    alunos[indiceDaTurma] = newArray;
                }
        
                System.out.println("Aluno adicionado com sucesso!");
                System.out.println("Alunos da turma " + turmas[indiceDaTurma] + ":");
            
                // loop for-each onde percorre todos os elementos de alunos[indiceDaTurma] p cada posição do array
                // p cada aluno no array, o valor de aluno será o nome desse aluno
                for (String aluno : alunos[indiceDaTurma]) {
                    if (aluno != null) {
                        System.out.println(aluno);
                    }
                }

            }

            if (opcao == 3) {
                // receber o nome do professor e armazenar numa variável
                // achar o indice do professor, ao achar, armazenar o indice em uma variavel
                // printar o nome da turma em turma[indiceProfessor]
                // printar os alunos em alunos[indiceProfessor]

                System.out.println("Digite o nome do professor responsável:");
                String nomeProfessor = in.next();
            
                int indiceDoProfessor = -1;
            
                // busca o índice do professor
                for (int i = 0; i < professores.length; i++) {
                    if (professores[i] != null && nomeProfessor.equals(professores[i])) {
                        indiceDoProfessor = i;
                        break;
                    }
                }
            
                // se o professor não for encontrado
                if (indiceDoProfessor == -1) {
                    System.out.println("Professor não encontrado.");
                    continue;
                }
            
                // exibe o nome da turma e a lista de alunos
                System.out.println("Turma: " + turmas[indiceDoProfessor]);
                System.out.println("Alunos: ");
            
                // eariável para contar os alunos da turma do professor
                int contadorAlunos = 0;
                
                // conta os alunos não nulos na turma do professor para exibir corretamente a mensagem 
                for (int i = 0; i < alunos[indiceDoProfessor].length; i++) {
                    if (alunos[indiceDoProfessor][i] != null) {
                        contadorAlunos++;
                    }
                }
            
                // exibe a mensagem caso não haja alunos
                if (contadorAlunos == 0) {
                    System.out.println("Nenhum aluno adicionado ainda.");
                } else {
                    // exibe os alunos da turma se não forem nulos
                    for (int i = 0; i < alunos[indiceDoProfessor].length; i++) {
                        if (alunos[indiceDoProfessor][i] != null) {
                            System.out.println(alunos[indiceDoProfessor][i] + " ");
                        }
                    }
                }
                System.out.println();
            }

            if (opcao == 4) {
                // receber o nome da turma ou do professor e armazenar numa variavel
                // buscar o valor recebido em turmas e se não achar, buscar em professores
                // ao achar o indice de um dos dois, printar os alunos daquela turma/ daquele professor

                System.out.println("Insira o nome da turma ou do professor para a listagem de alunos:");
                String turmaOuProfessor = in.next();
                int indiceTurmaOuProfessor = -1;
                // inicialização do índice com valor negativo

                // busca pela turma no array turmas, se encontrado é armazenado no indiceTurmaOuProfessor
                for (int i = 0; i < turmas.length; i++) {
                    if (turmaOuProfessor.equals(turmas[i])) {
                        indiceTurmaOuProfessor = i;
                    }
                }

                // se na busca anterior a turma não for encontrada, verificação no array professores
                // se encontrado no professores, indiceTurmaOuProfessor armazena o indice equivalente
                if (indiceTurmaOuProfessor == -1) {
                    for (int i = 0; i < professores.length; i++) {
                        if (turmaOuProfessor.equals(professores[i])) {
                            indiceTurmaOuProfessor = i;
                        }
                    }
                }
            
                if (indiceTurmaOuProfessor == -1) {
                    System.err.println("Turma ou professor não encontrados.");
                    continue;
                }

                // verificação da quantia de alunos
                int contadorAlunos = 0;
                for (int i = 0; i < alunos[indiceTurmaOuProfessor].length; i++) {
                    if (alunos[indiceTurmaOuProfessor][i] != null) {
                        contadorAlunos++;
                    }
                }

                System.out.println("Alunos encontrados: ");
                // se a quantia de alunos == 0, a mensagem de erro é exibida
                if (contadorAlunos == 0) {
                    System.out.println("Nenhum aluno encontrado.");
                } else {
                // senão, imprime os alunos
                    for (int i = 0; i < alunos[indiceTurmaOuProfessor].length; i++) {
                        if (alunos[indiceTurmaOuProfessor][i] != null) {
                            // se o aluno em determinado indice de alunos for nulo, exibe somente os valores não nulos
                            // excluindo os valores nulos da exibição
                            System.out.println(alunos[indiceTurmaOuProfessor][i]);
                        }
                    }
                }
                
                System.out.println();
            }

            if (opcao == 5) {

                // receber e armazenar o nome do aluno numa variavel
                // receber e armazenar o nome da turma de origem numa variavel
                // receber e armazenar o nome da turma de destino numa variavel
                // buscar o indice da turma de origem e armazenar numa variavel
                // buscar o indice da turma de destino e armazenar numa variavel
                // dentro da turma de origem, buscar o indice do aluno e armazenar numa variavel
                // percorrer o array da turma de destino e, caso tenha um espaço vazio, inserir o aluno.
                // definir turmaDeOrigem[indiceDoAluno] = null.
            
                int indiceTurmaOrigem = -1;
                int indiceTurmaDestino = -1;
                int indiceAluno = -1;
                // inicialização negativa das variaveis de indice, pois 0 é um indice!!
            
                System.out.println("Insira o nome do aluno a ser transferido: ");
                String nomeAluno = in.next();
            
                System.out.println("Insira a turma de origem do aluno " + nomeAluno + ": ");
                String turmaOrigem = in.next();
            
                System.out.println("Insira a turma de destino do aluno " + nomeAluno + ": ");
                String turmaDestino = in.next();
            
                // busca a turma de origem
                for (int i = 0; i < turmas.length; i++) {
                    if (turmas[i] != null && turmas[i].equalsIgnoreCase(turmaOrigem)) {
                        indiceTurmaOrigem = i;
                        break;
                    }
                }
            
                // mensagem de erro caso a turma de origem não exista
                if (indiceTurmaOrigem == -1) {
                    System.out.println("Turma de origem inexistente.");
                    continue;
                }
            
                // busca a turma de destino
                for (int i = 0; i < turmas.length; i++) {
                    if (turmas[i] != null && turmas[i].equalsIgnoreCase(turmaDestino)) {
                        indiceTurmaDestino = i;
                        break;
                    }
                }
            
                // mensagem de erro caso a turma de destino não exista
                if (indiceTurmaDestino == -1) {
                    System.out.println("Turma de destino inexistente.");
                    continue;
                }
            
                // busca o aluno na turma de origem, 
                for (int i = 0; i < alunos[indiceTurmaOrigem].length; i++) {
                    // verificação se o elemento não é nulo e se o nome do aluno na posiçaõ i (da turma de origem) é igual ao nome do aluno informado pelo usuario
                    if (alunos[indiceTurmaOrigem][i] != null && alunos[indiceTurmaOrigem][i].equalsIgnoreCase(nomeAluno)) {
                        indiceAluno = i;
                        break;
                    }
                }
            
                // verifica se o aluno foi encontrado
                if (indiceAluno == -1) {
                    System.out.println("Aluno não encontrado na turma de origem.");
                    continue;
                }
            
                // Adiciona o aluno na turma de destino
                boolean cheio = true;
                for (int i = 0; i < alunos[indiceTurmaDestino].length; i++) {
                    if (alunos[indiceTurmaDestino][i] == null) {
                        // se n for nulo, 
                        alunos[indiceTurmaDestino][i] = nomeAluno; // aluno adicionado com sucesso
                        alunos[indiceTurmaOrigem][indiceAluno] = null; // remove o aluno da turma de origem
                        cheio = false; 
                        break;
                    }
                }
            
                // expande o array se necessário
                if (cheio) {
                    // novo array criado com uma posição a mais q a atual
                    String[] newArray = new String[alunos[indiceTurmaDestino].length + 1];
            
                    // copia os alunos existentes para o novo array
                    for (int i = 0; i < alunos[indiceTurmaDestino].length; i++) {
                        newArray[i] = alunos[indiceTurmaDestino][i];
                    }
              
                    // novo array armazena o nome do aluno
                    newArray[alunos[indiceTurmaDestino].length] = nomeAluno;
                    alunos[indiceTurmaDestino] = newArray;
                    // array atualizado para o novo array
            
                    alunos[indiceTurmaOrigem][indiceAluno] = null;
                    // aluno removido da turma de origem, definindo a posição como null
                }
            
                System.out.println("Aluno " + nomeAluno + " transferido com sucesso para a turma " + turmaDestino + "!");
            }

            if (opcao == 6) {
                break;
            }
        }
    }
}
