import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Heap {

    List<Process> listProcess;
    private Random random = new Random();

    public Heap(){
        this.listProcess =  new ArrayList<Process>();
    }

    // metodo auxiliar
    public int piso(double numPiso) {
        return (int) numPiso;
    }

    // subir elementos
    public void rise(int i) {

        int indexFather; // índice do pai de i
        Process temp;

        indexFather = piso((i - 1) / 2);

        if (indexFather >= 0 && this.listProcess.get(i).getTimeExecution() < this.listProcess.get(indexFather).getTimeExecution()) {

            // troca de posição
            temp = this.listProcess.get(i);
            this.listProcess.set(i, this.listProcess.get(indexFather));
            this.listProcess.set(indexFather, temp);

            // verificar se o valor de IndexFather sobe recursivamente
            rise(indexFather);

        } else if (indexFather >= 0 && this.listProcess.get(i).getTimeExecution() == this.listProcess.get(indexFather).getTimeExecution()) {

            // 0 ou 1
            int test = random.nextInt(2);

            if (test == 0) {

                temp = this.listProcess.get(i);
                this.listProcess.set(i, this.listProcess.get(indexFather));
                this.listProcess.set(indexFather, temp);

                // verificar se o valor de IndexFather sobe recursivamente
                rise(indexFather);
            }

        }

    }

    // descer elementos
    public void descend(int i, int tamHeap) {

        int indexSon; // índice do filho de i
        Process temp;

        // define um numero aleatorio 0 ou 1
        int test = random.nextInt(2);

        indexSon = (2 * i + 1);

        if (indexSon < tamHeap) {

            if (indexSon < tamHeap - 1) {

                if (this.listProcess.get(indexSon).getTimeExecution() > this.listProcess.get(indexSon + 1).getTimeExecution()) {
                    indexSon++;
                } else if (this.listProcess.get(indexSon).getTimeExecution() == this.listProcess.get(indexSon + 1)
                        .getTimeExecution()) {

                    if (test == 0) {
                        indexSon++;
                    }

                }
            }

            // caso o filho seja menor que o pai, troca posiçoes
            if (this.listProcess.get(indexSon).getTimeExecution() < this.listProcess.get(i).getTimeExecution()) {

                temp = this.listProcess.get(i);
                this.listProcess.set(i, this.listProcess.get(indexSon));
                this.listProcess.set(indexSon, temp);

                descend(indexSon, tamHeap);

            // caso o filho seja igual ao pai
            } else if (this.listProcess.get(indexSon).getTimeExecution() == this.listProcess.get(i).getTimeExecution()) {

                if (test == 0) {

                    temp = this.listProcess.get(i);
                    this.listProcess.set(i, this.listProcess.get(indexSon));
                    this.listProcess.set(indexSon, temp);
                }

            }

        }

    }

    public void insert(Process element) {

        int tamHeap = this.listProcess.size(); 

        if (tamHeap == 0) {
            this.listProcess.add(element);
        } else {

            listProcess.add(element);
            rise(tamHeap - 1);
        }

    }

    public Process remove() {
        
        Process deleted = listProcess.get(0);
        int tamHeap = this.listProcess.size();

        if (listProcess.size() != 0) {

            this.listProcess.set(0, this.listProcess.get(tamHeap - 1));
            this.listProcess.remove(tamHeap - 1);

            descend(0, --tamHeap);

            return deleted;
        }

        return null;
    }

    // algoritmo dos nos internos
    public void build() {

        int tamHeap = this.listProcess.size();

        for (int i = ((tamHeap - 1) / 2); i >= 0; i--) {
            descend(i, tamHeap);
        }

    }

    public void showProcess(){

        for (int i = 0; i < listProcess.size(); i++) {
            System.out.println(listProcess.get(i));
        }

    }

    public void showProcessExecute(Process priority ){
        System.out.println("Estou sendo processado | Menssagem: " + priority.getMessage() + "\n");
    }

    public List<Process> getListProcess() {
        return listProcess;
    }

    public void setListProcess(List<Process> listProcess) {
        this.listProcess = listProcess;
    }

}
