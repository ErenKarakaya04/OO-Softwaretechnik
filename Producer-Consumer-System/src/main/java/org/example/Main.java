package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Buffer b  = new Buffer();
        String[] producerNames = {"Eren", "Amy", "Oliver" };
        String[] consumerNames = {"Paul", "Logan", "Tarik"};
        new Viewer(b).start();
        for (int i = 0; i < producerNames.length; i++) {
            new Producer(producerNames[i], b).start();
            new Consumer(consumerNames[i], b).start();
        }

    }
}
