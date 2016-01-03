package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: huyansheng
 * Date: 15-12-20
 * Time: 上午10:51
 * To change this template use File | Settings | File Templates.
 */

enum Shrubbery{GROUND,CRAWLING,HANGING}
public class EnumClass {
    public static void main(String[] args){
        for (Shrubbery s:Shrubbery.values()){
            System.out.println(s.getDeclaringClass());

        }
    }
}
