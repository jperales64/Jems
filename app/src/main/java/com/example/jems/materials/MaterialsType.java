package com.example.jems.materials;

public enum MaterialsType {
    HARDWARE_RENTAL, PREMADE_SET, ACCESSORY, MISC;
    public enum Lumber{
        APPEARANCE_BOARD,
        JOISTS,
        LATTICE,
        PARTICLEBOARD,
        SHIMS,
        TREATED,
        DIMENSIONAL,
        PLYWOOD,
        STUD,
        VENEER,
        FURRINGSTRIPS,
        LATH,
        OSB,
        OTHER
    }
    public enum Siding {
        BRICK,
        METAL,
        SKIRTING,
        VINYL,
        WOOD,
        FIBER,
        TOOL,
        OTHER
    }
    public enum Insulatio{
        BATT,
        HOUSEWRAP,
        ROLL,
        BLOWN,
        SPRAYFOAM,
        FOAMBOARD,
        SHEETING,
        OTHER
    }
    public enum Moulding{
        BASEBOARD,
        ROUND,
        SQUARE,
        WINDOW_DOOR,
        ACCENT,
        CORNER,
        OTHER
    }

    public enum Flooring{
        TILE,
        LAMINATE,
        HARDWOOD,
        BAMBOO,
        VINYL,
        CARPET,
        GARAGE,
        WALL_BASE,
        GROUT,
        MORTAR,
        UNDERLAYMENT,
        PREPARATION,
        ACCESSORY,
        OTHER
    }

    public enum Ceiling{
        TILE,
        GRID,
        TRIM,
        LIGHT_PANEL,
        TOOL,
        ACCESSORY,
        OTHER
    }

    public enum Drywall{
        PANEL,
        FRAMING,
        TAPE,
        REPAIR,
        TOOL,
        COMPOUND,
        OTHER
    }

    public enum Masonry{
        BRICK,
        CONCRETE,
        CEMENT,
        STUCCO,
        REBAR,
        BLOCK,
        lINTEL,
        REPAIR,
        FOUNDATION_PAD,
        TOOL,
        OTHER
    }
    public enum Decking{
        CABLE,
        BALUSTER,       //the bars of a railing
        POST_CAP,
        RAILING,
        DECK_BOARD,
        STAIR,
        ACCENT,
        CONNECTOR,
        POST,
        TILE,
        POST_SLEEVE,
        ACCESSORY,
        OTHER
    }
    public enum Fencing{
        DRIVEWAY_GATE,
        FENCE_GATE,
        PICKET,
        POST,
        POST_CAP,
        RAIL,
        ROLLED,
        PANEL,
        POST_SLEEVE,
        SCREEN,
        TOOL,
        ACCESSORY,
        OTHER
    }
}
