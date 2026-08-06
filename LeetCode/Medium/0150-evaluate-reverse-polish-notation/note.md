## ✅ [SUCCESS] 정답/모범답안 로직
### 🧠 내 코드
```java
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            
            if (!operators.contains(token)) {
                stack.push(Integer.parseInt(token));                
            } else if (stack.size() >= 2) {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                char operator = token.charAt(0);
                int result = operateRPN(operand1, operand2, operator);
                
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private int operateRPN(int operand1, int operand2, char operator) {
        int answer = 0;
        switch (operator) {
            case '+' :
                answer = operand1 + operand2;
                break;
            case '-' :
                answer = operand2 - operand1;
                break;
            case '*' :
                answer = operand1 * operand2;
                break;
            case '/' :
                answer = operand2 / operand1;
                break;
        }
        return answer;
    }
}

```

### ✨ 모범답안 코드
```java
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            // 연산자인 경우 (길이가 1이고 연산자 문자인 경우)
            if (token.length() == 1 && "+-*/".indexOf(token.charAt(0)) != -1) {
                int b = stack.pop(); // 나중에 들어온 값 (오른쪽 피연산자)
                int a = stack.pop(); // 먼저 들어온 값 (왼쪽 피연산자)
                
                switch (token.charAt(0)) {
                    case '+' -> stack.push(a + b);
                    case '-' -> stack.push(a - b);
                    case '*' -> stack.push(a * b);
                    case '/' -> stack.push(a / b);
                }
            } else {
                // 숫자 피연산자인 경우
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}

```
### 🤔 모범답안과 차이점:
* HashSet Heap Memory 속 객체 생성 비용을 아꼈다!


## 🛠️ 내 코드에서 놓친 디테일
### 🚨 엣지 케이스:
* 분기 처리를 제대로 못했다는 걸 뒤늦게 깨닫고 수정했다. 연산자 뿐만 아니라, 음수 역시 isDigit으로 제대로 구별할 수 없었다!

---

## 🎯 한 줄 본질
* 이 문제는 `Reverse Polish Notation`을 `Stack`으로 구현하는 문제이다.

---

## 💡 핵심 인사이트
### 💥 아차! 포인트 (내가 막히거나 오판했던 점):
* `Stack` 자체는 연상하긴 했지만, 피연산자만 `Stack`에 넣는다는 발상까지는 제때 하지 못했다!

### 🧠 개념의 확장 (이 문제를 통해 다르게 보게 된 것):
* 굳이 HashSet을 쓰지 않고 String에 대해 indexOf를 통해 검사하는 방식으로 char를 필터링할 수 있구나!  
`(token.length() == 1 && "+-*/".indexOf(token.charAt(0)) != -1))`

---

## 🚀 앞으로의 행동 지침
### ⚡ 다음에 이 유형을 만나면 확인할 체크리스트:
* [ ] *HashSet의 contains을 이용하지 않고, String을 parsing하는것으로 대체할 수 있을까?*
* [ ] *경우의 수가 2가지 이상으로 분기처리해야 한다면, switch-statement를 사용할 수 있을까?*

