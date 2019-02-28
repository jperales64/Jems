package com.example.jems.materials;

//test commit

public interface MaterialType {

    String groupName();
    String label();

    enum Lumber implements MaterialType{

        APPEARANCE_BOARD("APPEARANCE BOARD"),
        JOISTS("JOISTS"),
        LATTICE("LATTICE"),
        PARTICLEBOARD("PARTICLEBOARD"),
        SHIMS("SHIMS"),
        TREATED("TREATED"),
        DIMENSIONAL("DIMENSIONAL"),
        PLYWOOD("PLYWOOD"),
        STUD("STUD"),
        VENEER("VENEER"),
        FURRINGSTRIPS("FURRINGSTRIPS"),
        LATH("LATH"),
        OSB("OSB"),
        OTHER("OTHER");

        private final String label;

        Lumber(String label) {
            this.label = label;
        }

        @Override
        public String groupName(){
            return "Lumber";
        }

        @Override
        public String label(){
            return label;
        }
    }

    enum Siding implements MaterialType{

        BRICK("BRICK"),
        METAL("METAL"),
        SKIRTING("SKIRTING"),
        VINYL("VINYL"),
        WOOD("WOOD"),
        FIBER("FIBER"),
        TOOL("TOOL"),
        OTHER("OTHER");

        private final String label;

        Siding(String label) {
            this.label = label;
        }

        @Override
        public String groupName(){
            return "Siding";
        }

        @Override
        public String label(){
            return label;
        }
    }

    enum Insulation implements MaterialType{

        BATT("BATT"),
        HOUSEWRAP("HOUSEWRAP"),
        ROLL("ROLL"),
        BLOWN("BLOWN"),
        SPRAYFOAM("SPRAYFOAM"),
        FOAMBOARD("FOAMBOARD"),
        SHEETING("SHEETING"),
        OTHER("OTHER");

        private final String label;

        Insulation(String label) {
            this.label = label;
        }

        @Override
        public String groupName(){
            return "Insulation";
        }

        @Override
        public String label(){
            return label;
        }
    }

    enum Moulding implements MaterialType{

        BASEBOARD("BASEBOARD"),
        ROUND("ROUND"),
        SQUARE("SQUARE"),
        WINDOW_DOOR("WINDOW_DOOR"),
        ACCENT("ACCENT"),
        CORNER("CORNER"),
        OTHER("OTHER");

        private final String label;

        Moulding(String label) {
            this.label = label;
        }

        @Override
        public String groupName(){
            return "Moulding";
        }

        @Override
        public String label(){
            return label;
        }
    }

    enum Flooring implements MaterialType{

        TILE("TILE"),
        LAMINATE("LAMINATE"),
        HARDWOOD("HARDWOOD"),
        BAMBOO("BAMBOO"),
        VINYL("VINYL"),
        CARPET("CARPET"),
        GARAGE("GARAGE"),
        WALL_BASE("WALL_BASE"),
        GROUT("GROUT"),
        MORTAR("MORTAR"),
        UNDERLAYMENT("UNDERLAYMENT"),
        PREPARATION("PREPARATION"),
        ACCESSORY("ACCESSORY"),
        OTHER("OTHER");

        private final String label;

        Flooring(String label) {
            this.label = label;
        }

        @Override
        public String groupName(){
            return "Flooring";
        }

        @Override
        public String label(){
            return label;
        }
    }

    enum Ceiling implements MaterialType{

        TILE("TILE"),
        GRID("GRID"),
        TRIM("TRIM"),
        LIGHT_PANEL("LIGHT_PANEL"),
        TOOL("TOOL"),
        ACCESSORY("ACCESSORY"),
        OTHER("OTHER");

        private final String label;

        Ceiling(String label) {
            this.label = label;
        }

        @Override
        public String groupName(){
            return "Ceiling";
        }

        @Override
        public String label(){
            return label;
        }
    }


    enum Drywall implements MaterialType{

        PANEL("PANEL"),
        FRAMING("FRAMING"),
        TAPE("TAPE"),
        REPAIR("REPAIR"),
        TOOL("TOOL"),
        COMPOUND("COMPOUND"),
        OTHER("OTHER");

        private final String label;

        Drywall(String label) {
            this.label = label;
        }

        @Override
        public String groupName(){
            return "Drywall";
        }

        @Override
        public String label(){
            return label;
        }
    }

    enum Masonry implements MaterialType{

        BRICK("BRICK"),
        CONCRETE("CONCRETE"),
        CEMENT("CEMENT"),
        STUCCO("STUCCO"),
        REBAR("REBAR"),
        BLOCK("BLOCK"),
        LINTEL("LINTEL"),
        REPAIR("REPAIR"),
        FOUNDATION_PAD("FOUNDATION_PAD"),
        TOOL("TOOL"),
        OTHER("OTHER");

        private final String label;

        Masonry(String label) {
            this.label = label;
        }

        @Override
        public String groupName(){
            return "Masonry";
        }

        @Override
        public String label(){
            return label;
        }
    }

    enum Decking implements MaterialType{

        CABLE("CABLE"),
        BALUSTER("BALUSTER"),       //the bars of a railing
        POST_CAP("POST_CAP"),
        RAILING("RAILING"),
        DECK_BOARD("DECK_BOARD"),
        STAIR("STAIR"),
        ACCENT("ACCENT"),
        CONNECTOR("CONNECTOR"),
        POST("POST"),
        TILE("TILE"),
        POST_SLEEVE("POST_SLEEVE"),
        ACCESSORY("ACCESSORY"),
        OTHER("OTHER");

        private final String label;

        Decking(String label) {
            this.label = label;
        }

        @Override
        public String groupName(){
            return "Decking";
        }

        @Override
        public String label(){
            return label;
        }
    }

    enum Fencing implements MaterialType{

        DRIVEWAY_GATE("DRIVEWAY_GATE"),
        FENCE_GATE("FENCE_GATE"),
        PICKET("PICKET"),
        POST("POST"),
        POST_CAP("POST_CAP"),
        RAIL("RAIL"),
        ROLLED("ROLLED"),
        PANEL("PANEL"),
        POST_SLEEVE("POST_SLEEVE"),
        SCREEN("SCREEN"),
        TOOL("TOOL"),
        ACCESSORY("ACCESSORY"),
        OTHER("OTHER");

        private final String label;

        Fencing(String label) {
            this.label = label;
        }

        @Override
        public String groupName(){
            return "Fencing";
        }

        @Override
        public String label(){
            return label;
        }
    }

    enum Misc implements MaterialType{

        FASTENER("FASTENER"),
        TOOL("TOOL"),
        ACCESSORY("ACCESSORY"),
        OTHER("OTHER"),
        EMPTY("NO TYPE SELECTED");

        private final String label;

        Misc(String label) {
            this.label = label;
        }

        @Override
        public String groupName(){
            return "Miscellaneous";
        }

        @Override
        public String label(){
            return label;
        }
    }


}
