package learn.house.ui;

public enum MainMenuOption {

    EXIT(0, "Exit", false),
    VIEW_RESERVATIONS_BY_HOST(1, "View Reservations By Host", false),
    MAKE_NEW_RESERVATION(2, "Make New Reservation", false);
//    EDIT_A_RESERVATION(3, "Edit a Reservation", false),
//    CANCEL_A_RESERVATION(4, "Cancel a Reservation", false);
//    ADD_HOST(5, "Add a Host", false),
//    ADD_GUEST(6, "Add a Guest", false),
//    EDIT_HOST(7, "Edit a Host", false),
//    EDIT_GUEST(8, "Edit a Guest", false),
//    REMOVE_HOST(9, "Remove a Host", false),
//    REMOVE_GUEST(9, "Remove a Host", false);

    private int value;
    private String message;
    private boolean hidden;

    private MainMenuOption(int value, String message, boolean hidden) {
        this.value = value;
        this.message = message;
        this.hidden = hidden;
    }

    public static MainMenuOption fromValue(int value) {
        for (MainMenuOption option : MainMenuOption.values()) {
            if (option.getValue() == value) {
                return option;
            }
        }
        return EXIT;
    }

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public boolean isHidden() {
        return hidden;
    }
}
