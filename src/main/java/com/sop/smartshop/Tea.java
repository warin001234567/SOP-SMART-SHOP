package com.sop.smartshop;

public class Tea {
    private String tea;

    private static final String[] All_Tea = new String[]{
            "Original Tea",
      "Milk Tea",
      "Thai Tea",
      "Green Tea",
            "Black Tea",
            "Oolong Tea",
            "Rose Tea",
            "Mali Tea",

    };

    public Tea(int tea){
        this.setTea(tea);
    }

    public void setTea(int tea){
        if (tea < 0 || tea >= Tea.All_Tea.length){
            this.tea = getTeaName(0);
        } else {
            this.tea = getTeaName(tea);
        }
    }

    public String getTea() {
        return tea;
    }

    public String getTeaName(int tea) {
        return Tea.All_Tea[tea];
    }
}
