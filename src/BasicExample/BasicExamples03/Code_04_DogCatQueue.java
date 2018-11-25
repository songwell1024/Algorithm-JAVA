package BasicExample.BasicExamples03;

import java.util.LinkedList;

/**
 * 实现一种狗猫队列的结构，要求如下： 用户可以调用add方法将cat类或dog类的
 实例放入队列中； 用户可以调用pollAll方法，将队列中所有的实例按照进队列
 的先后顺序依次弹出； 用户可以调用pollDog方法，将队列中dog类的实例按照
 进队列的先后顺序依次弹出； 用户可以调用pollCat方法，将队列中cat类的实
 例按照进队列的先后顺序依次弹出； 用户可以调用isEmpty方法，检查队列中是
 否还有dog或cat的实例； 用户可以调用isDogEmpty方法，检查队列中是否有dog
 类的实例； 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
 * @author WilsonSong
 * @date 2018/11/25/025
 */
public class Code_04_DogCatQueue {

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

    public class PetEnterCount{
        private Pet pet;
        private int count;

        public PetEnterCount(Pet pet, int count){
            this.pet = pet;
            this.count = count;
        }
        public int getCount(){
            return this.count;
        }

        public String getType(){
            return pet.getPetType();
        }
        public Pet getPet(){
            return this.pet;
        }
    }

    public class DogCatQueue{
        private LinkedList<PetEnterCount> dogQueue;
        private LinkedList<PetEnterCount> catQueue;
        private int count;

        public DogCatQueue(){
            this.catQueue = new LinkedList<>();
            this.dogQueue = new LinkedList<>();
            this.count = 0;
        }

        public void add(Pet pet){
            if (pet.getPetType().equals("cat")){
                catQueue.push(new PetEnterCount(pet,count));
                count++;
            }
            if (pet.getPetType().equals("dog")){
                dogQueue.push(new PetEnterCount(pet, count));
                count++;
            }
        }

        public Pet pollAll(){
            if (!dogQueue.isEmpty() && !catQueue.isEmpty()){
                if (dogQueue.peek().getCount() < catQueue.peek().getCount()){
                    return dogQueue.poll().getPet();
                }else {
                    return catQueue.poll().getPet();
                }
            }else if (!dogQueue.isEmpty()){
                return  dogQueue.poll().getPet();
            }else if (!catQueue.isEmpty()){
                return catQueue.poll().getPet();
            }else {
                throw new IllegalArgumentException("Error");
            }
        }

        public Pet pollDog(){
            if (!dogQueue.isEmpty()){
                return dogQueue.poll().getPet();
            }else {
                throw new IllegalArgumentException("Error");
            }
        }

        public Pet pollCat(){
            if (!catQueue.isEmpty()){
                return catQueue.poll().getPet();
            }else {
                throw new IllegalArgumentException("Error");
            }
        }

        public boolean isDogEmpty(){
            return dogQueue.isEmpty();
        }

        public boolean isCatEmpty(){
            return catQueue.isEmpty();
        }

        public boolean isEmpty(){
            return !dogQueue.isEmpty() || !catQueue.isEmpty();
        }
    }


}
