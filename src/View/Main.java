package View;

import Controller.PessoasThread;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaforo= new Semaphore(1);


        for (int i=1; i<=4; i++){
            PessoasThread pessoa= new PessoasThread(semaforo);
            pessoa.start();
        }
    }
}
