package Demo02;

import sun.awt.geom.AreaOp;

import java.util.*;

/**
 * 猫狗队列 【题目】 宠物、狗和猫的类如下：
 public class Pet { private String type;
 public Pet(String type) { this.type = type; }
 public String getPetType() { return this.type; }
 }
 public class Dog extends Pet { public Dog() { super("dog"); } }
 public class Cat extends Pet { public Cat() { super("cat"); } }
 实现一种狗猫队列的结构，要求如下： 用户可以调用add方法将cat类或dog类的
 实例放入队列中； 用户可以调用pollAll方法，将队列中所有的实例按照进队列
 的先后顺序依次弹出； 用户可以调用pollDog方法，将队列中dog类的实例按照
 进队列的先后顺序依次弹出； 用户可以调用pollCat方法，将队列中cat类的实
 例按照进队列的先后顺序依次弹出； 用户可以调用isEmpty方法，检查队列中是
 否还有dog或cat的实例； 用户可以调用isDogEmpty方法，检查队列中是否有dog
 类的实例； 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
 * @author WilsonSong
 * @date 2018/9/6/006
 */
public class DogCatQueue {
    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    public static class PetEnterQueue{
        private Pet pet;
        private long count;

        public PetEnterQueue(Pet pet, long count){
            this.pet = pet;
            this.count = count;
        }

        public long getCount() {
            return count;
        }

        public Pet getPet() {
            return this.pet;
        }

        public String getEnterType(){
            return pet.getPetType();
        }
    }

    public static class DogAndCatQueue{
        Queue<PetEnterQueue> DogQueue;
        Queue<PetEnterQueue> CatQueue;
        private long count;

        public DogAndCatQueue(){
            this.DogQueue = new LinkedList<>();
            this.CatQueue = new LinkedList<>();
            this.count = 0;
        }

        public void add(Pet pet){
            if (pet.getPetType().equals("dog")){
                DogQueue.add(new PetEnterQueue(pet, this.count++));
            }else if (pet.getPetType().equals("cat")){
                CatQueue.add(new PetEnterQueue(pet, this.count++));
            }else {
                throw new  IllegalArgumentException("Error");
            }
        }

        public Pet pollAll(){
            if (!DogQueue.isEmpty() && !CatQueue.isEmpty()){
                if (DogQueue.peek().getCount() > CatQueue.peek().getCount()){
                    return CatQueue.poll().getPet();
                }
                else {
                    return DogQueue.poll().getPet();
                }
            }else if (!DogQueue.isEmpty()){
                return DogQueue.poll().getPet();
            }else if (!CatQueue.isEmpty()){
                return CatQueue.poll().getPet();
            }else {
                throw new IllegalArgumentException("Error");
            }
        }

        public Pet pollCat(){
            if (!CatQueue.isEmpty()){
                return CatQueue.poll().getPet();
            }else {
                throw new IllegalArgumentException("Error");
            }
        }

        public Pet pollDog(){
            if (!DogQueue.isEmpty()){
                return DogQueue.poll().getPet();
            }else{
                throw new IllegalArgumentException("Error");
            }
        }

        public boolean isEmpty(){
            return DogQueue.isEmpty() && CatQueue.isEmpty();
        }

        public boolean isDogEmpty(){
            return DogQueue.isEmpty() ;
        }

        public boolean isCatEmpty(){
            return  CatQueue.isEmpty();
        }
    }
}
