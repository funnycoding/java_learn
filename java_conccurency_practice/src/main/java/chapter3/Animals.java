package chapter3;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/3/25 10:10 下午
 */

// 一个动物类，封装了具体的物种，性别，以及一个 动物的容器 ark
// Animal.java
public class Animals {
    Ark ark;
    Species species;
    Gender gender;

    // 把传入集合中的种族相同 性别不同的动物存入 ark 中 并统计其数量
    public int loadTheArk(Collection<Animal> candidates) {
        SortedSet<Animal> animals;
        int numPairs = 0;
        Animal candidate = null;

        // animal confined to method, don't let them escape! 不要被封闭在方法中的动物们给跑了
        animals = new TreeSet<>(new SpeciesGenerComparator());
        animals.addAll(candidates);
        for (Animal a : animals) {
            if (candidate == null || !candidate.isPotentiaMate(a)) {
                candidate = a;
            } else {
                ark.load(new AnimalPair(candidate, a));
                ++numPairs;
                candidate = null;
            }
        }
        return numPairs;
    }

    class Animal {
        Species species;
        Gender gender;

        // 判断 Animal 是否种族相同且性别不同
        public boolean isPotentiaMate(Animal other) {
            return species == other.species && gender != other.gender;
        }
    }

    // 动物的种类
    enum Species {
        AARDVARK, BENGAL_TIGER, CARIBOU, DINGO, ELEPHANT, FROG, GNU, HYENA,
        IGUANA, JAGUAR, KIWI, LEOPARD, MASTADON, NEWT, OCTOPUS,
        PIRANHA, QUETZAL, RHINOCEROS, SALAMANDER, THREE_TOED_SLOTH,
        UNICORN, VIPER, WEREWOLF, XANTHUS_HUMMINBIRD, YAK, ZEBRA
    }

    // 动物的性别
    enum Gender {
        MALE, FEMALE
    }

    class AnimalPair {
        private final Animal one, two;

        public AnimalPair(Animal one, Animal two) {
            this.one = one;
            this.two = two;
        }
    }

    // 实现一个比较器 用来比较2个 AnimalPair 是否相同
    class SpeciesGenerComparator implements Comparator<Animal> {

        @Override
        public int compare(Animal one, Animal two) {
            // 如果是0则说明物种相同
            int speciesCompare = one.species.compareTo(two.species);
            // 如果不等于0 说明这俩物种不同 则直接返回，如果等于0 则返回 性别的比较结果
            return (speciesCompare != 0) ? speciesCompare : one.gender.compareTo(two.gender);
        }
    }

    class Ark {
        private final Set<AnimalPair> loadedAnimals = new HashSet<>();

        public void load(AnimalPair pair) {
            loadedAnimals.add(pair);
        }
    }
}
