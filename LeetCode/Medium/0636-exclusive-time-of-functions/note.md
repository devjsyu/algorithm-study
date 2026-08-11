## ❌ [FAIL / SO-SO] 최초 접근 로직
### 🤔 생각한 흐름:
* `Stack` 문제라는 건 스포일러 때문에 알겠지만 왜 `Stack`이지?
* 각 메서드별 실행 시간을 누적해서 더해야겠구나
* 로그가 `start`, `end`일 때 각각 시간을 포함하고 포함하지 않는구나.
*

### 🧠 내 코드 (비효율적/실패)
```java
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] arr = new int[n];

        Deque<Job> jobs = new ArrayDeque<>();

        for (String log : logs) {
            String[] parts = log.split(":");
            int index = Integer.valueOf(parts[0]);
            int time = Integer.valueOf(parts[2]);

            jobs.push(new Job(index, time));
        }

        Job secondJob = null;
        while (jobs.size() > 1) {
            Job currentJob = jobs.pop();
            Job pastJob = jobs.peek();
            arr[currentJob.index] += currentJob.time - pastJob.time;

            if (jobs.size() == 1) {
                secondJob = pastJob; 
            }
        }
        Job job = jobs.pop();
        arr[job.index] += secondJob.time - job.time;

        return arr;
    }

    public record Job(int index, int time) {}
}

```


### ⚠️ 왜 비효율적/실패했는가?:
* 로그가 `start`, `end`일 때 각각 시간을 포함하고 포함하지 않는 걸 반영하지 못했다.

## ✅ [SUCCESS] 정답/모범답안 로직

### ✨ 모범답안 코드
```java
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Log> stack = new ArrayDeque<>();

        int[] result = new int[n];

        for (String content : logs) {
            Log log = new Log(content);
            if (log.isStart) {
                stack.push(log);
            } else {
                Log top = stack.pop();
                result[top.id] += (log.time - top.time + 1);
                if (!stack.isEmpty()) {
                    result[stack.peek().id] -= (log.time - top.time + 1);
                }
            }
        }

        return result;
    }

    public static class Log {
        public int id;
        public boolean isStart;
        public int time;

        public Log(String content) {
            String[] strs = content.split(":");
            id = Integer.valueOf(strs[0]);
            isStart = strs[1].equals("start");
            time = Integer.valueOf(strs[2]);
        }
    }
}

```
### 🤔 모범답안과 차이점:
* 나는 isStart 필드를 누락하였다.
* start인 경우에만 Stack에 push 하고, end일 경우, pop 했다.
* 메서드 실행 기간을 구하고, 해당 실행 기간을 해당 메서드를 호출한 메서드의 실행 시간 몫에서 그만큼 차감했다.

---

## 🎯 한 줄 본질
* ***짝짓기 문제*** : 무작정 스택에 무차별적으로 넣지 않고, 여는 괄호 유형일 때만 스택에 푸시하고, 닫는 괄호 유형일 때만 스택에 팝한다.


## 💡 핵심 인사이트
### 🧠 개념의 확장 (이 문제를 통해 다르게 보게 된 것):
* 짝짓기 유형이 Stack과 잘 어울린다. 여는 괄호, 닫는 괄호를 무차별적으로 Stack에 집어넣는 게 아니라, 여는 괄호일 때만 Stack에 push 하고, 닫는 괄호라면 기존 Stack에서 pop하는 방식이 그대로 쓰였다.
* 선형 순회를 했다면 관리해야 하는 변수가 많아서 복잡했을 텐데, Stack 자료구조를 통해 간단하게 문제해결 할 수 있다.
