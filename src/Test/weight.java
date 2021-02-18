package Test;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Random;

/**
 * @Author: jesse
 * @Date: 2020/7/24
 * @Time: 5:45 PM
 */
public class weight {

    public static void main(String[] args){
        Item[] items = new Item[]{new Item("A", 0.1),
                new Item("B", 0.2),
                new Item("C", 0.65),
                new Item("D", 0.05),};

        WeightRandom weightRandom = new WeightRandom(items);
        for(int i = 0; i < 10; i++){
            System.out.println(MessageFormat.format("员工{0}的绩效得分：{1}",
                    (i + 1),weightRandom.nextItem()));
        }
    }


    /**
     * 带权重的随机选择
     */
    static class WeightRandom{
        /**
         * 选项数组
         */
        private Item[] options;

        /**
         * 权重的临界值
         */
        private BigDecimal[] criticalWeight;

        private Random rnd;

        public WeightRandom(Item[] options) {
            if(options == null || options.length < 1){
                throw new IllegalArgumentException("选项数组存在异常！");
            }
            this.options = options;
            this.rnd = new Random();
            //初始化
            this.init();
        }

        /**
         * 随机函数
         */
        public String nextItem(){
            double randomValue = this.rnd.nextDouble();
            //查找随机值所在区间
            int index = this.searchIndex(randomValue);

            return this.options[index].getName();
        }

        /**
         * 查找随机值所在区间
         */
        private int searchIndex(double randomValue){
            BigDecimal rndValue = new BigDecimal(randomValue);
            int high = this.criticalWeight.length - 1;
            int low = 0;
            int median = (high + low) / 2;

            BigDecimal medianValue = null;
            while (median != low && median != high){
                medianValue = this.criticalWeight[median];

                if(rndValue.compareTo(medianValue) == 0){
                    return median;
                }else if(rndValue.compareTo(medianValue) > 0){
                    low = median;
                    median = (high + low) / 2;
                }else{
                    high = median;
                    median = (high + low) / 2;
                }
            }

            return median;
        }

        /**
         * 初始化
         */
        private void init(){
            //总权重
            BigDecimal sumWeights = BigDecimal.ZERO;
            //权重的临界值
            this.criticalWeight = new BigDecimal[this.options.length + 1];

            //1. 计算总权重
            for(Item item : this.options){
                sumWeights = sumWeights.add(new BigDecimal(item.getWeight()));
            }

            //2. 计算每个选项的临界值
            BigDecimal tmpSum = BigDecimal.ZERO;
            this.criticalWeight[0] = tmpSum;
            for(int i = 0; i < this.options.length; i++){
                tmpSum = tmpSum.add(new BigDecimal(this.options[i].getWeight()));
                this.criticalWeight[i + 1] = tmpSum.divide(sumWeights, 2, BigDecimal.ROUND_HALF_UP);
            }
        }
    }

    /**
     * 需要随机的item
     */
    static class Item{
        /**
         * 名称
         */
        private String name;
        /**
         * 权重
         */
        private double weight;

        public Item(String name, double weight) {
            this.name = name;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public double getWeight() {
            return weight;
        }
    }

}
