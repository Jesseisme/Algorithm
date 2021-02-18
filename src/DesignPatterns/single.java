package DesignPatterns;

/**
 * @Author: jesse
 * @Date: 2018/10/16
 * @Time: 下午11:12
 */
public class single {
    private static volatile Instance instance;
    public static Instance getInstance(){
        if(instance==null){
            synchronized (Instance.class){
                if(instance==null){
                    instance = new Instance();
                }
            }
        }
       return instance;
    }



}
