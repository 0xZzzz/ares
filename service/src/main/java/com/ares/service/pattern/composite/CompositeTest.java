package com.ares.service.pattern.composite;

/**
 * composite test class
 *
 * @author fansheng
 * @date 2020/11/12
 */
public class CompositeTest {

    public static void main(String[] args) {
        long warehouseId = 1L;
        long itemId = 1000L;
        BaseHu iphoneA = new ItemHu(1001L, warehouseId, 200L, itemId, "6936983800001");
        BaseHu iphoneB = new ItemHu(1002L, warehouseId, 200L, itemId, "6936983800002");
        BaseHu iphoneC = new ItemHu(1003L, warehouseId, 200L, itemId, "6936983800003");
        BaseHu iphoneD = new ItemHu(1004L, warehouseId, 200L, itemId, "6936983800004");
        BaseHu iphoneE = new ItemHu(1005L, warehouseId, 200L, itemId, "6936983800005");

        BaseHu boxA = new ContainerHu(2001L, warehouseId, 100L);
        boxA.add(iphoneA);
        boxA.add(iphoneB);
        System.out.println("boxA total weight: " + boxA.calculateTotalWeight() + "g");
        System.out.println(boxA);

        BaseHu boxB = new ContainerHu(2002L, warehouseId, 150L);
        boxB.add(iphoneC);
        boxB.add(iphoneD);
        boxB.add(iphoneE);
        System.out.println("boxB total weight: " + boxB.calculateTotalWeight() + "g");
        System.out.println(boxB);

        // 将 iphoneB 从 boxA 中拿出来放到 boxB 中
        boxB.add(boxA.takeOut(iphoneB.id));
        System.out.println("boxA total weight: " + boxA.calculateTotalWeight() + "g");
        System.out.println(boxA);
        System.out.println("boxB total weight: " + boxB.calculateTotalWeight() + "g");
        System.out.println(boxB);

        BaseHu palletA = new ContainerHu(3001L, warehouseId, 500L);
        palletA.add(boxA);
        palletA.add(boxB);

        System.out.println("palletA total weight: " + palletA.calculateTotalWeight() + "g");
        System.out.println(palletA);
    }

}
