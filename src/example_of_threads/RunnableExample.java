package example_of_threads;

public class RunnableExample implements Runnable
{
    Thread thread0;
    Thread thread1;
    public void creatingThread()
    {
        thread0 = new Thread(new RunnableExample());
        thread1 = new Thread(new RunnableExample());
        System.out.println("Starting Thread 0");
        thread0.start();
        joinThread();
        System.out.println("Waited enough! Starting Thread 1 now");
        thread1.start();
    }

    public void sleepThread()
    {
        try
        {
            for (int i = 0; i < 5; i++)
            {
                //Pause for 2 seconds
                Thread.sleep(500);
                //Print a message
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
        catch(InterruptedException e){
            System.out.println("main thread interrupted");
        }
    }

    public void joinThread()
    {
        System.out.println("Waiting for Thread 0 to complete");
        try
        {
            thread0.join(2000);
        }
        catch (InterruptedException e)
        {
            throw new IllegalStateException(e);
        }

    }
    @Override
    public void run()
    {
        System.out.println("Inside : " + Thread.currentThread().getName());
        sleepThread();
    }
}
