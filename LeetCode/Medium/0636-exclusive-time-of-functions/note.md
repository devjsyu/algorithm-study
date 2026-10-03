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

## 🎯 한 줄 본질
* ***짝짓기 문제*** : 무작정 스택에 무차별적으로 넣지 않고, 여는 괄호 유형일 때만 스택에 푸시하고, 닫는 괄호 유형일 때만 스택에 팝한다.


## 💡 핵심 인사이트
### 🧠 개념의 확장 (이 문제를 통해 다르게 보게 된 것):
* 짝짓기 유형이 Stack과 잘 어울린다. 여는 괄호, 닫는 괄호를 무차별적으로 Stack에 집어넣는 게 아니라, 여는 괄호일 때만 Stack에 push 하고, 닫는 괄호라면 기존 Stack에서 pop하는 방식이 그대로 쓰였다.
* 선형 순회를 했다면 관리해야 하는 변수가 많아서 복잡했을 텐데, Stack 자료구조를 통해 간단하게 문제해결 할 수 있다.
