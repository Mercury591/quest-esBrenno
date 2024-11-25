import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        // Adicionar questões ao quiz
        quiz.adicionarQuestao(new Questao("Qual a capital do Brasil?", "A) Brasília", "B) Rio de Janeiro", "C) São Paulo", "D) Salvador", "E) Belo Horizonte", "A"));
        quiz.executar();
    }

    static class Questao {
        private String pergunta;
        private String opcaoA;
        private String opcaoB;
        private String opcaoC;
        private String opcaoD;
        private String opcaoE;
        private String correta;

        public Questao(String pergunta, String opcaoA, String opcaoB, String opcaoC, String opcaoD, String opcaoE, String correta) {
            this.pergunta = pergunta;
            this.opcaoA = opcaoA;
            this.opcaoB = opcaoB;
            this.opcaoC = opcaoC;
            this.opcaoD = opcaoD;
            this.opcaoE = opcaoE;
            this.correta = correta;
        }

        public void escrevaQuestao() {
            System.out.println(this.pergunta);
            System.out.println(this.opcaoA);
            System.out.println(this.opcaoB);
            System.out.println(this.opcaoC);
            System.out.println(this.opcaoD);
            System.out.println(this.opcaoE);
            System.out.println();
        }

        public String leiaResposta() {
            Scanner ler = new Scanner(System.in);
            String resp;
            do {
                System.out.println("Digite a resposta: ");
                resp = ler.next();
            } while (!respostaValida(resp));
            return resp;
        }

        private boolean respostaValida(String resp) {
            if (resp.equalsIgnoreCase("A") ||
                    resp.equalsIgnoreCase("B") ||
                    resp.equalsIgnoreCase("C") ||
                    resp.equalsIgnoreCase("D") ||
                    resp.equalsIgnoreCase("E")) {
                return true;
            }
            System.out.println("Resposta inválida! digite opção A,B,C,D ou E.");
            System.out.println();
            return false;
        }

        public boolean isCorreta(String resposta) {
            if (resposta.equalsIgnoreCase(this.correta)) {
                System.out.println("Parabéns resposta correta! - Letra: " + this.correta);
                System.out.println();
                return true;
            } else {
                System.out.println("Resposta errada!");
                System.out.println("A resposta correta é: " + this.correta);
                System.out.println();
                return false;
            }
        }
    }
}

class Quiz {

    private List<Main.Questao> questoes;

    public Quiz() {
        questoes = new ArrayList<>();
    }

    public void adicionarQuestao(Main.Questao questao) {
        questoes.add(questao);
    }

    public void executar() {
        for (Main.Questao questao : questoes) {
            questao.escrevaQuestao();
            String resposta = questao.leiaResposta();
            questao.isCorreta(resposta);
        }
    }
}
