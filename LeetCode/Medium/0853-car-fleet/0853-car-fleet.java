import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            cars.add(new Car(position[i], speed[i]));
        }
        Collections.sort(cars, Comparator.comparingInt(Car::position));

        Deque<Double> stack = new ArrayDeque<>();

        for (Car car : cars) {
            double time = (double) (target - car.position()) / car.speed();
            while (!stack.isEmpty() && stack.peek() <= time) {
                stack.pop();
            }
            stack.push(time);
        }

        return stack.size();
    }

    public record Car(int position, int speed) {}
}