package com.at.wangxu.Thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {

    public static void main(String[] args) {

        String[] fc = {"hello world", "hello me", "hello fork", "hello join", "fork join in world"};
        //创建ForkJoin线程池
        ForkJoinPool fjp = new ForkJoinPool(3);
        //创建任务
        MR mr = new MR(fc, 0, fc.length);
        //启动任务

        Map<String, Long> result = fjp.invoke(mr);
        result.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    static class MR extends RecursiveTask<Map<String, Long>> {

        private final String[] fc;
        private final int start;
        private final int end;

        public MR(String[] fc, int start, int end) {
            this.fc = fc;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Map<String, Long> compute() {
            if (end - start == 1) {
                return calc(fc[start]);
            } else {
                int mid = (start + end) / 2;
                MR mr1 = new MR(fc, start, mid);
                mr1.fork();

                MR mr2 = new MR(fc, mid, end);

                return merge(mr2.compute(), mr1.join());
            }
        }

        private Map<String, Long> merge(Map<String, Long> r1, Map<String, Long> r2) {
            Map<String, Long> result = new HashMap<>(r1);
            r2.forEach((k, v) -> result.merge(k, v, Long::sum));
            return result;
        }


        //统计单词的数量
        private Map<String, Long> calc(String line) {
            Map<String, Long> result = new HashMap<>();
            String[] words = line.split("\\s+");

            for (String word : words) {
                Long v = result.get(word);
                if (v != null)
                    result.put(word, v + 1);
                else
                    result.put(word, 1L);
            }
            return result;
        }
    }

    static class Fibonacci extends RecursiveTask<Integer> {

        final int n;

        public Fibonacci(int n) {
            this.n = n;
        }

        @Override
        protected Integer compute() {
            if (n <= 1)
                return n;
            Fibonacci f1 = new Fibonacci(n - 1);
            f1.fork();
            Fibonacci f2 = new Fibonacci(n - 2);
            return f2.compute() + f1.join();
        }
    }
}
