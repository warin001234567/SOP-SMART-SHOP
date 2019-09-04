package com.sop.smartshop;

public class DoughnutCafeMenuFactory {
  public static final DoughnutCafeMenu[] CAFE_MENUS = new DoughnutCafeMenu[] {
          new DoughnutCafeMenu("Promotion A", "original doughnut and free tea", new Doughnut[] {
                  new Doughnut(0)
          },new Tea[] {new Tea(0)}, 89),
          new DoughnutCafeMenu("Promotion B", "Mix and Macth and Free 2 tea", new Doughnut[] {
                  new Doughnut(0),
                  new Doughnut(1),
                  new Doughnut(2),
                  new Doughnut(3),
                  new Doughnut(4),
                  new Doughnut(5),
                  new Doughnut(6),
          }, new Tea[] {new Tea(0),new Tea(1)}, 189),
          new DoughnutCafeMenu("Promotion C", "Mix and Macth and Free 3 tea", new Doughnut[] {
                  new Doughnut(3),
                  new Doughnut(4),
                  new Doughnut(5),
                  new Doughnut(6),
                  new Doughnut(7),
                  new Doughnut(8),
                  new Doughnut(9),
                  new Doughnut(10),
          }, new Tea[] {new Tea(0),new Tea(1),new Tea(3)}, 289),
          new DoughnutCafeMenu("Promotion D", "Mix and Macth and Free 4 tea", new Doughnut[] {
                  new Doughnut(0),
                  new Doughnut(1),
                  new Doughnut(2),
                  new Doughnut(3),
                  new Doughnut(4),
                  new Doughnut(5),
                  new Doughnut(6),
                  new Doughnut(7),
                  new Doughnut(8),
                  new Doughnut(9),
                  new Doughnut(10),
                  new Doughnut(11),
                  new Doughnut(12),
          }, new Tea[] {new Tea(0),new Tea(1), new Tea(2), new Tea(3)}, 489),
  };
  public static DoughnutCafeMenu getMenu(int promotion){
      return CAFE_MENUS[promotion];
  }
    public static DoughnutCafeMenu[] getMenulist(){
        return CAFE_MENUS;
    }

}
