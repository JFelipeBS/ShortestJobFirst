
public class Scheduler {

    static int timerSchedule = 3;

    public void execute() {

        Heap heap = new Heap();

        for (int i = 0; i < 4; i++) {
            heap.insert(new Process());
        }
        heap.build();

        // verifica se ja passaram 10 e 20 segundos
        boolean check10 = true;
        boolean check20 = true;

        // conta os segundos totais
        int contTimeAll = 0;

        while (!heap.getListProcess().isEmpty()) {

            heap.showProcess();

            int cont = 0;
            boolean check = true;

            Process priority = heap.remove();

            System.out.println(); // espaço
            heap.showProcessExecute(priority);
            while (check) {

                try {
                    Thread.sleep(1000);
                    priority.setTimeExecution(priority.getTimeExecution() - 1);
                    cont++;
                    contTimeAll++;
                    System.out.println(contTimeAll + " segundos");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (cont == 3) {
                    check = false;
                }

                if (priority.getTimeExecution() == 0) {
                    check = false;
                }
            }

            if (priority.getTimeExecution() > 0) {
                heap.insert(priority);
                heap.build();
                System.out.println();
                System.out
                        .println("Processo inserido novamente na heap | Tempo restante " + priority.getTimeExecution());

            } else {
                System.out.println(
                        "***************************************************************************************");
                System.out.println("Processo concluido");
                System.out.println(
                        "***************************************************************************************");

                System.out.println(); // espaço
            }

            if (contTimeAll > 10 && check10) {
                for (int i = 0; i < 8; i++) {
                    heap.insert(new Process());
                    heap.build();

                }

                check10 = false;

                System.out.println();
                System.out.println("------ 8 PROCESSOS INSERIDOS ------");

            }

            if (contTimeAll > 20 && check20) {
                for (int i = 0; i < 16; i++) {
                    heap.insert(new Process());
                    heap.build();
                }

                check20 = false;

                System.out.println();
                System.out.println("------ 16 PROCESSOS INSERIDOS ------");
            }

            System.out.println(); // espaço

        }

    }

}
