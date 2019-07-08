package thread;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {
    class CallImpl<V> implements Callable<V> {
        @Override
        public V call() throws Exception {
            return (V)"hello";
        }
    }

    public void testCall () {
        Callable<String> callable = new CallImpl<>();
        FutureTask<String> futureTask = new FutureTask<String>(callable) {
            @Override
            protected void done() {
                super.done();
                try {
                    String result = get();
                    System.out.println(result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(futureTask);
        thread.start();
    }
}
