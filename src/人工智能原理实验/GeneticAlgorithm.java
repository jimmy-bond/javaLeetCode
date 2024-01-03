package 人工智能原理实验;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// 城市类，包含城市的标签、横坐标和纵坐标
class City {
    int label;
    int x;
    int y;

    public City(int label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }
}

// 遗传算法类
public class GeneticAlgorithm {

    // 常量定义
    private static final int cityNum = 10; // 城市数量
    private static final int idvNum = 100; // 种群中个体数量
    private static final double pc = 0.4; // 交叉概率
    private static final double pm = 0.2; // 变异概率
    private static final int genMax = 2000; // 最大迭代次数

    private static double[][] dis = new double[cityNum][cityNum]; // 城市间距离矩阵
    private static List<List<City>> group = new ArrayList<>(); // 种群

    public static void main(String[] args) {
        init(); // 初始化
        for (int i = 0; i < genMax; ++i) {
            System.out.println("迭代次数" + (i + 1));
            select(); // 选择
            crossover(); // 交叉
            mutation(); // 变异
        }
    }

    // 计算两个城市之间的距离
    private static double distance(City city1, City city2) {
        return Math.sqrt(Math.pow((city1.x - city2.x), 2) + Math.pow((city1.y - city2.y), 2));
    }

    // 计算路径的总距离
    private static double getSum(List<City> vec) {
        double sum = 0;
        int size = vec.size();
        for (int i = 1; i < size; ++i)
            sum += dis[vec.get(i).label][vec.get(i - 1).label];
        sum += dis[vec.get(size - 1).label][vec.get(0).label];
        return sum;
    }

    // 初始化种群和城市间距离矩阵
    private static void init() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\86147\\Desktop\\city.txt"))) {
            List<City> city = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(" ");
                int label = Integer.parseInt(tokens[0]);
                int x = Integer.parseInt(tokens[1]);
                int y = Integer.parseInt(tokens[2]);
                city.add(new City(label, x, y));
            }

            // 初始化城市间距离矩阵
            for (int i = 0; i < cityNum; ++i)
                for (int j = 0; j < cityNum; ++j)
                    dis[i][j] = dis[j][i] = distance(city.get(i), city.get(j));

            // 随机生成初始种群
            Random rand = new Random();
            for (int i = 0; i < idvNum; ++i) {
                List<City> temp = new ArrayList<>(city);
                for (int j = 0; j < cityNum; ++j)
                    Collections.swap(temp, j, rand.nextInt(cityNum));
                group.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 显示路径
    private static void showPath(List<City> city) {
        System.out.print("路径: ");
        for (City c : city)
            System.out.print(c.label + " ");
        System.out.println(city.get(0).label + "\n");
    }

    // 选择操作
    private static void select() {
        List<List<City>> temp = new ArrayList<>();
        Map<Double, Integer> bigMap = new HashMap<>();

        // 计算每个个体的适应度
        for (int i = 0; i < idvNum; ++i)
            bigMap.put(getSum(group.get(i)), i);

        int betterFit = bigMap.entrySet().iterator().next().getValue();
        int worseFit = bigMap.entrySet().iterator().next().getValue();
        double sum = bigMap.entrySet().iterator().next().getKey();

        // 选择适应度较好的个体
        for (Map.Entry<Double, Integer> entry : bigMap.entrySet()) {
            double fitness = entry.getKey();
            int index = entry.getValue();
            if (fitness < sum) {
                sum = fitness;
                betterFit = index;
            }
            worseFit = index;
        }

        System.out.println("总距离: " + sum);
        showPath(group.get(betterFit));
        temp.add(group.get(betterFit));
        temp.add(group.get(betterFit));

        int M = 3;
        Random rand = new Random();
        for (int i = 0; i < idvNum - 2; ++i) {
            int fit = Integer.MAX_VALUE;
            int loc = 0;
            for (int j = 0; j < M; ++j) {
                int pos = rand.nextInt(idvNum);
                while (pos == betterFit || pos == worseFit)
                    pos = rand.nextInt(idvNum);
                if (getSum(group.get(pos)) < fit) {
                    fit = (int) getSum(group.get(pos));
                    loc = pos;
                }
            }
            temp.add(group.get(loc));
        }

        group = temp;
    }

    // 交叉操作
    private static void crossover() {
        List<City> temp1 = new ArrayList<>();
        List<City> temp2 = new ArrayList<>();
        int pos = 7;
        Random rand = new Random();
        for (int i = 0; i < 48; ++i) {
            double randRate = rand.nextDouble();
            if (randRate < pc) {
                temp1 = new ArrayList<>(group.get(i + 2));
                temp1.set(pos, group.get(99 - i).get(pos));
                temp1.set(pos + 1, group.get(99 - i).get(pos + 1));
                temp1.set(pos + 2, group.get(99 - i).get(pos + 2));
                int z = 0;
                for (int j = 0; j < pos; ++j) {
                    while (group.get(i + 2).get(z).label == temp1.get(pos).label ||
                            group.get(i + 2).get(z).label == temp1.get(pos + 1).label ||
                            group.get(i + 2).get(z).label == temp1.get(pos + 2).label)
                        ++z;
                    temp1.set(j, group.get(i + 2).get(z));
                    ++z;
                }

                temp2 = new ArrayList<>(group.get(99 - i));
                temp2.set(pos, group.get(i + 2).get(pos));
                temp2.set(pos + 1, group.get(i + 2).get(pos + 1));
                temp2.set(pos + 2, group.get(i + 2).get(pos + 2));
                z = 0;
                for (int j = 0; j < pos; ++j) {
                    while (group.get(99 - i).get(z).label == temp2.get(pos).label ||
                            group.get(99 - i).get(z).label == temp2.get(pos + 1).label ||
                            group.get(99 - i).get(z).label == temp2.get(pos + 2).label)
                        ++z;
                    temp2.set(j, group.get(99 - i).get(z));
                    ++z;
                }

                group.set(i + 2, temp1);
                group.set(99 - i, temp2);
            }
        }
    }

    // 变异操作
    private static void mutation() {
        Random rand = new Random();
        for (int i = 2; i < idvNum; ++i) {
            double randRate = rand.nextDouble();
            if (randRate < pm) {
                for (int j = 0; j < 5; ++j) {
                    int pos1 = rand.nextInt(cityNum);
                    int pos2 = rand.nextInt(cityNum);
                    Collections.swap(group.get(i), pos1, pos2);
                }
            }
        }
    }
}
