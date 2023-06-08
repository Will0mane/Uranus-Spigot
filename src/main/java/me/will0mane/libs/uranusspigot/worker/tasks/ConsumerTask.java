package me.will0mane.libs.uranusspigot.worker.tasks;

import me.will0mane.libs.uranusspigot.worker.Worker;

import java.util.function.Consumer;

@SuppressWarnings("unused")
public class ConsumerTask extends WorkerTask{

    private final Consumer<Worker<?>> consumer;

    public ConsumerTask(Worker<?> worker, Consumer<Worker<?>> consumer){
        super(worker);
        this.consumer = consumer;
    }

    public ConsumerTask(Worker<?> worker, Consumer<Worker<?>> consumer, int taskID){
        super(worker, taskID);
        this.consumer = consumer;
    }

    @Override
    public void run() {
        if(consumer == null) return;

        consumer.accept(super.getWorker());
    }
}
