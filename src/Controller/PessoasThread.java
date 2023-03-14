package Controller;

import java.util.concurrent.Semaphore;

public class PessoasThread extends Thread {

    private Semaphore semaforo;

    public PessoasThread(Semaphore semaforo){
        this.semaforo= semaforo;
    }

    @Override
    public void run() {
        pessoaandando();
        try {
            semaforo.acquire();
            pessoaabrindo();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            semaforo.release();
        }
    }

    private void pessoaandando() {
        int corredor= 200;
        int andar;
        int pessoa= 0;

        while (pessoa<corredor){
            andar= (int) (Math.random()* 5)+ 2;
            pessoa+= andar;
        }
    }

    private void pessoaabrindo() {
        System.out.println("A pessoa "+ getId() + " chegou a porta e começou a abri-lá");
        int tempo= (int) (Math.random()* 1001)+ 1000;
        try {
            sleep(tempo);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("A pessoa "+ getId() +" entrou na sala");

    }
}
