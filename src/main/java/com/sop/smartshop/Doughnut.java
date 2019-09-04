package com.sop.smartshop;

public class Doughnut {

    private String doughnuts;

    private static final String[] All_Doughnuts = new String[]{
            "Original Glazed",
            "Green Tea Nuts",
            "Green Tea Cookie",
            "Caramel Cookies",
            "Chocolate Fudge",
            "Butter Cheese",
            "Strawberry Glamour Glazed",
            "Sugar",
            "Cookies & Cream",
            "Chocolate Iced Glazed",
            "Chocoholic Dream",
            "Cappuccino Franco",
            "Peanut Butter Stripes"
    };

    public Doughnut(int doughnuts){
        this.doughnuts = getDoughnutName(doughnuts);
    }

    public void setDoughnuts(int doughnuts) {
        if (doughnuts < 0 || doughnuts >= Doughnut.All_Doughnuts.length) {
            this.doughnuts = getDoughnutName(0);
        } else {
            this.doughnuts = getDoughnutName(doughnuts);
        }
    }

    public String getDoughnuts() {
        return doughnuts;
    }

    public String getDoughnutName(int doughnuts){
        return Doughnut.All_Doughnuts[doughnuts];
    }
}
